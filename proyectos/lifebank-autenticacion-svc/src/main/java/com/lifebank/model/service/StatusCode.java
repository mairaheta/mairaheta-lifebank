package com.lifebank.model.service;

import java.util.Map;

public class StatusCode 
{
	private String name;
	private String code;
	private String message;
	
	public String getCode() 
	{
		return code;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}
	
	
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

//	private Map<String, String> tokens;
//	
//	public Map<String, String> getTokens()
//	{
//		return tokens;
//	}
//
//	public void setTokens(Map<String, String> tokens)
//	{
//		this.tokens = tokens;
//	}	
	
}
