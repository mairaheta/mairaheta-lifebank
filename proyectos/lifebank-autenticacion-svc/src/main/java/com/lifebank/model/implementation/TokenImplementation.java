package com.lifebank.model.implementation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lifebank.model.repository.TokenRepository;
import com.lifebank.utility.JWT;


@Service
public class TokenImplementation implements TokenRepository 
{
	private Environment env;
	
	@Autowired
	public TokenImplementation(Environment env) 
	{
		this.env = env;
	}

	@Override
	public String getJWTToken(String idClient, String ip) 
	{

		String tkn;
		Map<String, Object> mapJWT = new HashMap<String, Object>();
		
		String secret = env.getProperty("service.jwt.claim.secret");
		String subject = env.getProperty("service.jwt.claim.subject");
		String issuer = env.getProperty("service.jwt.claim.issuer");
		Long expTime = Long.parseLong(env.getProperty("service.jwt.claim.expiration-time"));
		String prefix = env.getProperty("service.jwt.prefix");
		
		mapJWT.put("idclient", idClient);
		mapJWT.put("ip", ip);
		mapJWT.put("expdate", new Date(System.currentTimeMillis() + expTime));
		
		JWT jwt = new JWT(mapJWT,secret,subject,issuer,expTime); 

		tkn = prefix + " " + jwt.generate();

		return tkn;
	}

	
}
