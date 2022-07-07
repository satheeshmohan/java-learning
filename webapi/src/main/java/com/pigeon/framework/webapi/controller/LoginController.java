package com.pigeon.framework.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pigeon.framework.webapi.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String showLogoutPage() {
		return "redirect:/login";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String showHomePage() {
		return "welcome";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValidUser = service.validateUser(name, password);
		//return "welcome";
		if(!isValidUser) {
			model.put("validationMessage", "Invalid username or password");
			return "error";
		}
		else {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
	}
	/*
	@RequestMapping(value="/error", method = RequestMethod.GET)
	public String errorPage() {
		return "error";
	}
	
	@RequestMapping("/welcome1")
	@ResponseBody
	public String welcomeMessage() {
		return "Welcome to Java Sprint";
	}*/
	
}
