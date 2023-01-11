//package com.example.park.configuration;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.example.park.Service.UserService;
//import com.example.park.entities.User;
//import com.example.park.filter.CustomAuthenticationFilter;
//import com.example.park.filter.JwtAuthorizationFilter;
//
//
//@SuppressWarnings("deprecation")
//@Configuration
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	 @Autowired
//	private javax.sql.DataSource datasouce;
//	 
//	 
//	@Autowired
//	 private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	@Autowired
//	private UserService accoutService;
//	 
//	 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		System.out.println(bCryptPasswordEncoder.encode("123"));
//		
//		
//		//****Using authentification form memory
////		auth.inMemoryAuthentication().withUser("jikla").password(pass.encode("123")).roles("ADMIN");
////		auth.inMemoryAuthentication().withUser("samy").password(pass.encode("123")).roles("USER");
////		auth.inMemoryAuthentication().withUser("kaabi").password(pass.encode("123")).roles("VISITER");
//	
//		
//		//****Using jdbc for authentification
////		auth
////		.jdbcAuthentication()
////		.dataSource(datasouce)
////		.usersByUsernameQuery("SELECT name ,  username as principal , password as credentials  from user where username=?")
////		.authoritiesByUsernameQuery("select user_id as principal , roles_id as role from user_roles where user_id = ?");
////		.passwordEncoder(pass);
//		
//		
////		auth.userDetailsService(new UserDetailsService() {
////			
////			@Override
////			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////				User user = accoutService.loadUserByUsername(username);
////				Collection<GrantedAuthority> authorities = new ArrayList<>();
////				user.getRoles().forEach(r->{
////					authorities.add(new SimpleGrantedAuthority(r.getName()));
////				});
////				return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
////			}
////		}).passwordEncoder(bCryptPasswordEncoder);
//	
//	}
//	
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.cors().disable();
////		http.formLogin();
////		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//////		http.authorizeRequests().antMatchers(HttpMethod.POST, "/**").permitAll().and().csrf().disable();
////		http.authorizeRequests().antMatchers("/refreshTOKEN/**").permitAll();
////		http.authorizeRequests().anyRequest().authenticated();
////		http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
////		http.addFilterBefore(new JwtAuthorizationFilter() , UsernamePasswordAuthenticationFilter.class);
////		http.csrf().disable();
////		http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/**").hasAuthority("ADMIN");
////		http.authorizeRequests().antMatchers(HttpMethod.GET,"/GetAll").hasAnyAuthority("USER");
////		http.formLogin().loginPage("/login");
////		http.authorizeRequests().anyRequest().permitAll();
////		http.authorizeRequests().antMatchers("/FilteredPersonne","/AddPersonne").hasAnyRole("ADMIN");
////		http.authorizeRequests().antMatchers("/api/**").permitAll();
////		http.exceptionHandling().accessDeniedPage("/notAuthorized");
//	}
//	
//	      
//	
//	 @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//	   @Override
//	   public AuthenticationManager authenticationManagerBean() throws Exception {
//	       return super.authenticationManagerBean();
//	   }
//	
//
//}
//
//
//
