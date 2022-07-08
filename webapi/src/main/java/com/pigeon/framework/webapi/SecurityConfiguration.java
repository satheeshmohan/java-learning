package com.pigeon.framework.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	// Create Users and assign role to user
	// saan/saan
	// sathya/sathya

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("saan").password("{noop}saan").roles("USER", "ADMIN");
		auth.inMemoryAuthentication().withUser("sathya").password("{noop}sathya").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/login").permitAll()
			.antMatchers("/", "/*todo*/**", "/*myprofile*/**").access("hasRole('USER')").and()
			.formLogin();
	}
	
    //protected void configure(HttpSecurity http) throws Exception {
    //    http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll()
    //            .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
    //            .formLogin();
        
    //    http.csrf().disable();
    //    http.headers().frameOptions().disable();
    //}
	// Create a login form
}
