package com.example.park.Controllers;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.park.Service.UserService;
import com.example.park.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private  UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUser() {
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
//	@PostMapping("/user/save")
//	public ResponseEntity<User> saveUser(@RequestBody User user) {
//		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
//		return ResponseEntity.created(uri).body(userService.saveUser(user));
//	}
//	
//	@PostMapping("/role/save")
//	public ResponseEntity<User> saveRole(@RequestBody User user) {
//		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
//		return ResponseEntity.created(uri).body(userService.saveUser(user));
//	}
	
	@PostMapping("/role/addToUser")
	public ResponseEntity<User> addToUser(@RequestBody RoleToUserForm form) {
		userService.addRoleToUser(form.getUserName(), form.getRoleName());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/refreshTOKEN")
	public void refreshToken(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException  {
		String authToken = request.getHeader("Authorization");
		if(authToken != null && authToken.startsWith("Bearer ")) {
			try {
				String refresh_token = authToken.substring(7);
				Algorithm algo = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier jwtVerif = JWT.require(algo).build();
				DecodedJWT decodeJWT =  jwtVerif.verify(refresh_token);
				String username = decodeJWT.getSubject();
				User user = userService.loadUserByUsername(username);
				//Creation de l'access token 
				String access_Token = JWT.create()
						.withSubject(user.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
						.withIssuer(request.getRequestURL().toString())
						.withClaim("roles", user.getRoles().stream().map(r->r.getName()).collect(Collectors.toList()))
						.sign(algo);
				//L'envoi de nouveau access et refresh token 
				Map<String,String> idToken = new HashMap<>();
				idToken.put("access_Token", access_Token);
				idToken.put("refresh_Token", refresh_token);
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(), idToken);
				
				
			}
			catch( Exception e) {
				response.setHeader("error-message", e.getMessage());
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
			}
			
		}
		else {
			throw new RuntimeException("Refresh token required !");
		}
		
	}
	

}

class RoleToUserForm{
	private String userName;
	private String roleName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
