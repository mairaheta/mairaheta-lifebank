package com.lifebank.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@EnableResourceServer
@EnableWebSecurity
@Configuration
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter
{
	private Environment env;
	
	public SecurityTokenConfig(Environment env) 
	{
		this.env = env;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()                
			.antMatchers(HttpMethod.POST, env.getProperty("service.zuul.routes.auth-service.path")).permitAll()
			.anyRequest().authenticated();
	}
}
