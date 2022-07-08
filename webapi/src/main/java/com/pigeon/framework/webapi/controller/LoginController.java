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
	public String showLoginPage(ModelMap model) {
		model.put("name", "saan");
		return "welcome";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String showLogoutPage() {
		return "redirect:/login";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String showHomePage() {
		return "welcome";
	}
}
