package com.example.demo.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	
	@Autowired
	private AuthenticationInAuthorizationFilter authenticationInAuthorizationFilter;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		 http.csrf().disable()
				.authorizeHttpRequests().requestMatchers("/api/auth/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(authenticationInAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
				
		return http.build();
	}
	
//	 @Bean
//	    CorsConfigurationSource corsConfigurationSource() {
//	        CorsConfiguration configuration = new CorsConfiguration();
//
//	        configuration.setAllowedOrigins(List.of("http://192.168.1.42:8080"));
//	        configuration.setAllowedMethods(List.of("GET","POST"));
//	        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));
//
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//	        source.registerCorsConfiguration("/**",configuration);
//
//	        return source;
//	    }

}
