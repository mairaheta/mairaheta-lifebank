package com.lifebank.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.lifebank.model.service.StatusCode;

@EnableConfigurationProperties
@PropertySource("classpath:application.yml")
@ConfigurationProperties("config")
@Configuration
public class StatusConfig 
{
	
		private List<StatusCode> status = new ArrayList<StatusCode>();

		public List<StatusCode> getStatus() 
		{
			return status;
		}

		public void setStatus(List<StatusCode> status) 
		{
			this.status = status;
		}

}
