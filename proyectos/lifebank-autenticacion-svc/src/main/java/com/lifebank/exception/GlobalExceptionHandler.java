package com.lifebank.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lifebank.model.repository.StatusHandlingRepository;
import com.lifebank.model.service.StatusCode;
import com.lifebank.pojo.response.WrapperHeaderResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler 
{
	private Environment env;
	private StatusHandlingRepository statusRepo;
	
	@Autowired
	public GlobalExceptionHandler(Environment env,StatusHandlingRepository statusRepo) 
	{
		this.env = env;
		this.statusRepo = statusRepo;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public WrapperHeaderResponse handleException(HttpServletRequest req, Exception ex)
	{
		WrapperHeaderResponse response = new WrapperHeaderResponse();
		StatusCode respStatus;
		
		respStatus = statusRepo.getStatus(ex.getMessage());
		
		response.setCode(respStatus.getCode());
		response.setMessage(respStatus.getMessage());
		
		
		return response;
		
	}
}
