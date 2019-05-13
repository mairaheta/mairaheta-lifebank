package com.lifebank.model.implementation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lifebank.configuration.StatusConfig;
import com.lifebank.model.repository.StatusHandlingRepository;

import com.lifebank.model.service.StatusCode;


@Service
public class StatusHandlingImplementation implements StatusHandlingRepository 
{

	
	private StatusCode state;
	
	private List<StatusCode> status;
	
	
	@Autowired
	public StatusHandlingImplementation(StatusConfig configStatus) 
	{
		init(configStatus);
	}
	
	private void init(StatusConfig configs) 
	{
		
		this.status = configs.getStatus();
	}
	
	@Override
	public StatusCode getStatus(String statusName) 
	{
		for(StatusCode temp : status)
		{
			if (statusName.equalsIgnoreCase(temp.getName()))
			{
				this.state = temp;
				break;
			}
		}
		
		return state;
	}

}
