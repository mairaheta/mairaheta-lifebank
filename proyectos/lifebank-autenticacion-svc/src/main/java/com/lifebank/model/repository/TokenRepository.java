package com.lifebank.model.repository;

public interface TokenRepository 
{
	public String getJWTToken(String idClient,String ip);
}
