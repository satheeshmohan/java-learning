package com.pigeon.framework.webapi.service;

import org.springframework.stereotype.Component;

//import com.fasterxml.jackson.core.sym.Name;
import com.pigeon.framework.model.Profile;

@Component
public class ProfileService {
	static Profile profile = new Profile("test", "test@test.com", "01-07-2000", "Bangalore south", "Bangalore", "India", "560068");
	public Profile getProfile(String name) {
		return profile;
	}
	
	public Profile saveProfile(Profile _profile) {
		profile=_profile;
		return profile;
	}
}
