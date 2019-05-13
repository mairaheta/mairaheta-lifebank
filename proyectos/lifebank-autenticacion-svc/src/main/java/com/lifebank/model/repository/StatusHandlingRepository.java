package com.lifebank.model.repository;

import com.lifebank.model.service.StatusCode;

public interface StatusHandlingRepository 
{
	public StatusCode getStatus(String statusName);
}
