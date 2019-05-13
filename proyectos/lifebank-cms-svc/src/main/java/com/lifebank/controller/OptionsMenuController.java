package com.lifebank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifebank.model.MenuHandlingRepository;
import com.lifebank.model.MenuOptions;
import com.lifebank.pojo.menu.OptionsMenuResponse;
import com.lifebank.pojo.menu.Text;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@PropertySource("classpath:application.yml")
@RequestMapping("${service.url.root-path}")
@RestController
public class OptionsMenuController
{
	private Environment env;
	private MenuHandlingRepository repoMenu;
	
	@Autowired
	public OptionsMenuController(Environment env,MenuHandlingRepository repoMenu) 
	{
		this.env = env;
		this.repoMenu = repoMenu;
	}
	
	@RequestMapping("${service.url.menu}")
	public OptionsMenuResponse helloWorld(@RequestParam(value="language", defaultValue="es") String name) 
	{
		
		OptionsMenuResponse response = new  OptionsMenuResponse();
		List<Text> listTexts = new ArrayList<Text>();
		
		
		for (MenuOptions menuOpt : repoMenu.getMenuOptions())
		{
			Text text = new Text();
			text.setId(menuOpt.getId());
			text.setParent(menuOpt.getParentid());
			text.setValue(menuOpt.getText());
			listTexts.add(text);
		}
		
		response.setTexts(listTexts);
		
		return response;
	}
}
