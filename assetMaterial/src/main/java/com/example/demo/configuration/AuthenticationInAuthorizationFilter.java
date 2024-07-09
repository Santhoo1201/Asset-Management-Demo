package com.example.demo.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.model.TechnicalStaffs;
import com.example.demo.service.TechnicalStaffsService;
import com.example.demo.serviceImpl.JwtLoadItems;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInAuthorizationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtLoadItems jwtLoadItems;
	
	@Autowired
	private TechnicalStaffsService technicalStaffsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String getAuthtoken =request.getHeader("Authorization");
		
		if(getAuthtoken == null || !getAuthtoken.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return ;
		}
		
		String getToken = getAuthtoken.substring(7);
		String getExactEmail = jwtLoadItems.exactUserEmail(getToken);
		Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
		
		
		if(getToken != null && !jwtLoadItems.isTokenLogOut(getToken) ) {
			
			if(getExactEmail != null && authenticate == null) {
				
				TechnicalStaffs technicalStaffs = technicalStaffsService.getTechnicalStaffsByEmailId(getExactEmail);
				if(jwtLoadItems.isValidToken(getToken, technicalStaffs)) {
					
					UsernamePasswordAuthenticationToken setStaffsdetails = new UsernamePasswordAuthenticationToken(technicalStaffs,null,technicalStaffs.getAuthorities());
					
					setStaffsdetails.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(setStaffsdetails);
					
				}
			}
			filterChain.doFilter(request, response);
		}else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	
	}

}
