package com.lifebank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifebank.model.repository.StatusHandlingRepository;
import com.lifebank.model.service.Properties.serviceStatus;
import com.lifebank.model.service.StatusCode;
import com.lifebank.pojo.authentication.AuthRequest;
import com.lifebank.pojo.authentication.AuthResponse;
import com.lifebank.pojo.response.WrapperResponse;
import com.lifebank.process.AuthenticationProcess;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@PropertySource("classpath:application.yml")
@RequestMapping("${service.url.root-path}")
@RestController
public class AuthenticationController
{
	private Environment env;
	private AuthenticationProcess authProcces;
	private StatusHandlingRepository repoStatus;
	
	
	@Autowired
	public AuthenticationController(Environment env,AuthenticationProcess authProcces,StatusHandlingRepository repoStatus) 
	{
		this.env = env;
		this.authProcces = authProcces;
		this.repoStatus = repoStatus;
		
	}
	
	@PostMapping("${service.url.login}")
	public WrapperResponse<AuthResponse> login(@RequestBody AuthRequest usrrequest,HttpServletRequest request) throws Exception
	{
		
		AuthResponse authResponse = null;
		WrapperResponse<AuthResponse> response = new WrapperResponse<>();
		StatusCode respStatus = new StatusCode();
		try 
		{
			
			authResponse = authProcces.process(usrrequest,request.getHeader("X-Forwarded-For"));
			
			respStatus = repoStatus.getStatus(serviceStatus.getSuccess());
			
			response.getHeader().setCode(respStatus.getCode());
			response.getHeader().setMessage(respStatus.getMessage());
			response.setBody(authResponse);
			
		} 
		catch (Exception e) 
		{

			if (e.getMessage().isEmpty()) 
			{
				throw new Exception(serviceStatus.getError());
			}else 
			{
				throw e;
			}
			
		}

		return response;
		
	}


	
}