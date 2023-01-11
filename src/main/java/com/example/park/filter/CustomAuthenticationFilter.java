//package com.example.park.filter;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//	
//	private AuthenticationManager authenticationManager;
//	
//	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
//		this.authenticationManager = authenticationManager;
//	}
//	
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		UsernamePasswordAuthenticationToken authentificationToken = new UsernamePasswordAuthenticationToken(username, password);
//		return authenticationManager.authenticate(authentificationToken);
//	}
//	
//	
//	@Override
//	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//			Authentication authentication) throws IOException, ServletException {
//		System.out.println("successful Connection");
//		User user =(User) authentication.getPrincipal();
//		Algorithm algo = Algorithm.HMAC256("secret".getBytes());
//		String access_Token = JWT.create()
//				.withSubject(user.getUsername())
//				.withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
//				.withIssuer(request.getRequestURL().toString())
//				.withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
//				.sign(algo);
//		
//		String refresh_token = JWT.create()
//				.withSubject(user.getUsername())
//				.withExpiresAt(new Date(System.currentTimeMillis()+30*60*1000))
//				.withIssuer(request.getRequestURL().toString())
//				.sign(algo);
//		
//		Map<String,String> idToken = new HashMap<>();
//		idToken.put("access_Token", access_Token);
//		idToken.put("refresh_Token", refresh_token);
//		response.setContentType("application/json");
//		new ObjectMapper().writeValue(response.getOutputStream(), idToken);
//	
//	}
//	
//
//}
