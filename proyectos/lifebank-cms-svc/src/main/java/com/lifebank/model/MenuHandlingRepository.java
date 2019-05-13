package com.lifebank.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.lifebank.configuration.MenuConfig;
import com.lifebank.model.MenuOptions;


public interface MenuHandlingRepository 
{
	
	List<MenuOptions> getMenuOptions(); 
	
}
