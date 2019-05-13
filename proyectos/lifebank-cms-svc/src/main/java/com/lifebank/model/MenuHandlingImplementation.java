package com.lifebank.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lifebank.configuration.MenuConfig;

@Service
public class MenuHandlingImplementation implements MenuHandlingRepository
{
	
	private Environment env;
	private MenuConfig configs;
	
	@Autowired
	public MenuHandlingImplementation(Environment env,MenuConfig configs) 
	{
		this.env = env;
		this.configs = configs;
	}
	
	public List<MenuOptions> getMenuOptions() 
	{
		List<MenuOptions> options;
		options = configs.getOptions();
		
		return options; 
	}
}
