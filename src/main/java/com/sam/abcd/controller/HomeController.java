package com.sam.abcd.controller;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sam.abcd.data.repository.CustomerRepository;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	
	 @Autowired
	 private 	CustomerRepository userProvider;
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		
		model.put("time", new Date());
		model.put("message", this.message);
		return "home";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String home( Model model) {
		
		return "user_list";
	}
	
}
