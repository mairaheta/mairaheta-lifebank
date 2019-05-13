package com.lifebank.pojo.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequest 
{
	@JsonProperty("usuario")
	private String usuario;
	
	@JsonProperty("password")
	private String password;

	
	
	@JsonProperty("usuario")
	public String getUsuario() 
	{
		return usuario;
	}

	@JsonProperty("usuario")
	public void setUsuario(String usuario) 
	{
		this.usuario = usuario;
	}

	@JsonProperty("password")
	public String getPassword() 
	{
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) 
	{
		this.password = password;
	}
}
