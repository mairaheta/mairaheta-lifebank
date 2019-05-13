package com.lifebank.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.lifebank.model.MenuOptions;


@EnableConfigurationProperties
@PropertySource("classpath:application.yml")
@ConfigurationProperties("menu")
@Configuration
public class MenuConfig 
{
	private List<MenuOptions> options = new ArrayList<MenuOptions>();

	public List<MenuOptions> getOptions() 
	{
		return options;
	}

	public void setOptions(List<MenuOptions> status) 
	{
		this.options = status;
	}
	
}
