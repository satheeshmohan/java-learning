package com.pigeon.framework.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pigeon.framework.model.Profile;
import com.pigeon.framework.webapi.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	ProfileService service;
	
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String myProfile(ModelMap model, @RequestParam String username) {
		Profile profileModel = service.getProfile(username);
		model.clear();
		model.put("name", profileModel.name);
		model.put("email", profileModel.email);
		model.put("dob", profileModel.dob);
		model.put("address", profileModel.address);
		model.put("city", profileModel.city);
		model.put("country", profileModel.country);
		model.put("pin", profileModel.pin);
		return "myprofile";
	}
	
	@RequestMapping(value = "myprofile", method = RequestMethod.POST)
	public String saveMyProfile(ModelMap model, 
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String dob,
			@RequestParam String address,
			@RequestParam String city,
			@RequestParam String country,
			@RequestParam String pin
			) {
		System.out.println(name);
		Profile profile = new Profile(name, email, dob, address, city, country, pin); 
		Profile profileModel = service.saveProfile(profile);
		profileModel = service.getProfile(name);
		System.out.println(name);
		model.clear();
		model.put("name", profileModel.name);
		model.put("email", profileModel.email);
		model.put("dob", profileModel.dob);
		model.put("address", profileModel.address);
		model.put("city", profileModel.city);
		model.put("country", profileModel.country);
		model.put("pin", profileModel.pin);
		return "myprofile";
	}
}
