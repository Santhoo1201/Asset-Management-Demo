//package com.project.demo.WebConfiguration;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
////import jakarta.servlet.http.HttpServletResponse;
//
//@Configuration(proxyBeanMethods = false)
//@ComponentScan
//@EnableWebMvc
//public class WebConfiguration implements WebMvcConfigurer{
//	 
//	     @Override
//	   public void addCorsMappings(CorsRegistry registry ) {
//	  
////	    	 HttpServletResponse httpResponse = (HttpServletResponse) res;
//	    	// registry.addMapping("/**").allowedOrigins("http://localhost:4200");
//	   registry.addMapping("/**").allowedMethods("PUT", "GET", "DELETE", "OPTIONS", "PATCH", "POST");
//	   
////	   ((CorsRegistry) registry).setHeader("Access-Control-Allow-Headers", "x-requested-with x-uw-act-as");
//	    }
//	}
