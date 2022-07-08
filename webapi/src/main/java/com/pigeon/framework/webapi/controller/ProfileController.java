package com.pigeon.framework.webapi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pigeon.framework.model.Profile;
import com.pigeon.framework.webapi.service.ProfileService;

@Controller
@SessionAttributes("name")
public class ProfileController {

	@Autowired
	ProfileService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String myProfile(ModelMap model) {
		String name = (String) model.get("name");
		model.addAttribute("profile", new Profile(name, "", new Date(), "", "", "", 0));
		Profile profileModel = service.getProfile(name);
		model.put("profile", profileModel);
		return "myprofile";
	}
	
	@RequestMapping(value = "myprofile", method = RequestMethod.POST)
	public String saveMyProfile(ModelMap model, @Valid Profile profile, BindingResult results) {
		if(results.hasErrors()) {
			///model.put("error", "Error while updating profile...");
			return "myprofile";
		}
		System.out.println(profile.name);
		//Profile profile = new Profile(name, email, dob, address, city, country, pin); 
		Profile profileModel = service.saveProfile(profile);
		profileModel = service.getProfile(profile.name);
		model.put("profile", profileModel);
		return "myprofile";
	}
	
	/*@RequestMapping(value = "myprofile", method = RequestMethod.POST)
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
	}*/
}
