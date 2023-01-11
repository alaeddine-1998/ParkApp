package com.example.park.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration 
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer { 

    private static final String[] ALLOWED_ORIGINS = {"https://localhost:4200", 
    "https://localhost:8080"}; 
 
    @SuppressWarnings("deprecation")
	@Bean 
    public WebMvcConfigurer corsConfigurer() {
    	
        return new WebMvcConfigurerAdapter() { 
            @Override 
            public void addCorsMappings(CorsRegistry registry) { 
                registry.addMapping("/*").allowedOrigins(ALLOWED_ORIGINS); 
            } 
          }; 
       } 
    } 
