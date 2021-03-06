package com.sam.abcd.controller;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sam.abcd.data.repository.CustomerRepository;
import com.sam.abcd.data.service.UserService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	
	 @Autowired
	 private UserService userServicetory;
	
	 private CustomerRepository userProvider;

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		
		model.put("time", new Date());
		model.put("message", this.message);
		return "home";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String home( Model model) {
		
		return "user_list";
	}
	
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	
	/***
	@RequestMapping( value="/login" ,method=RequestMethod.POST)
	public String doLogin(){
		
		return "login";
	}
	
	@RequestMapping("/loginSuccess.html")
	public String loginSuccess(){
		
		return "success";
	}
	***/
	@RequestMapping("/access")
	public String access(){
		
		return "access";
	}
}
