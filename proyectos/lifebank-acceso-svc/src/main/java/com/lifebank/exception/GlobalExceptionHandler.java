package com.lifebank.exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@PropertySource("classpath:application.yml")
@ControllerAdvice
public class GlobalExceptionHandler 
{
	private Environment env;
	
	
	@Autowired
	public GlobalExceptionHandler(Environment env) 
	{
		this.env = env;
		
	}
	

	@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason="${service.status.invalid.message}")
	public class InvalidException extends RuntimeException 
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="${service.status.blocked.message}")
	public class BlockedException extends RuntimeException 
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		
	}
	
}
