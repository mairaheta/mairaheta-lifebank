package com.lifebank.pojo.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse 
{
	@JsonProperty("tkn")
	private String token;

	
	@JsonProperty("tkn")
	public String getToken() 
	{
		return token;
	}

	@JsonProperty("tkn")
	public void setToken(String token) 
	{
		this.token = token;
	}
	
	
}
