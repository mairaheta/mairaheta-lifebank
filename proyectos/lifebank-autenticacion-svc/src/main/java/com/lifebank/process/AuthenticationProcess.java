package com.lifebank.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lifebank.model.entity.User;
import com.lifebank.model.repository.TokenRepository;
import com.lifebank.model.repository.UserRepository;
import com.lifebank.model.service.Properties.error;
import com.lifebank.model.service.Properties.serviceStatus;
import com.lifebank.model.service.Properties.userStatus;
import com.lifebank.pojo.authentication.AuthRequest;
import com.lifebank.pojo.authentication.AuthResponse;
import com.lifebank.utility.ServiceUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticationProcess 
{
	
	private Environment env;
	private UserRepository repo;
	private TokenRepository repoToken;
	
	@Autowired
	public AuthenticationProcess(Environment env,UserRepository repo,TokenRepository repoToken) 
	{
		this.env = env;
		this.repo = repo;
		this.repoToken = repoToken;
	}
	
	public AuthResponse process (AuthRequest input, String ipAddress) throws Exception
	{
		
		AuthResponse response = new AuthResponse();
		
		try 
		{
			User data = repo.findByUserAndPassword(input.getUsuario(),input.getPassword());
			
			log.error("Response: " + ServiceUtils.objToString(data));
			
			if (data == null)
			{
				throw new Exception(serviceStatus.getInvalid());
			} 
			else if (!(userStatus.getActive().equalsIgnoreCase(data.getStatus())))
			{
				throw new Exception(serviceStatus.getBlocked());
			}
			else
			{
				
				String token = repoToken.getJWTToken(data.getId_client().toString(),ipAddress);
				response.setToken(token);
			}
			
		} 
		catch (Exception e) 
		{
			for (StackTraceElement element : e.getStackTrace())
			{
				if (element.getClassName().equalsIgnoreCase(this.getClass().getName()))
				{
					log.error(error.getErrorMsj(),element.getFileName(),element.getMethodName(),element.getLineNumber(),e.getMessage());
				}
			}
			throw e;
		}
		
		return response;
	}
}
