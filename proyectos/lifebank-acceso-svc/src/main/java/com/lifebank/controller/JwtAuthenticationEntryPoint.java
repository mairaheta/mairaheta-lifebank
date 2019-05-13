package com.lifebank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@PropertySource("classpath:application.yml")
@RequestMapping("${service.url.root-path}")
@RestController
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint 
{
	    @Override
	    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, 
	    		AuthenticationException e) throws IOException, ServletException 
	    {
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED");
	        
	        
	        String json = String.format("{\"message\": \"%s\"}", e.getMessage());
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(json);       
	    }

}