package com.pigeon.framework.webapi.service;

//import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	public boolean validateUser(String name, String password) {
		// Preconditions.checkNotNull(name);
		// Preconditions.checkNotNull(password);
		return name.equalsIgnoreCase("saan") && password.equalsIgnoreCase("saan");
	}
}
