package com.uns.ac.rs.emailclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uns.ac.rs.emailclient.controller.impl.UserControllerImpl;
import com.uns.ac.rs.emailclient.dto.LoginRequest;
import com.uns.ac.rs.emailclient.dto.LoginResponse;

@RestController
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserControllerImpl userControllerImpl;
	
	public LoginResponse login(LoginRequest request) {
		
		LoginResponse response = userControllerImpl.login(request);
		
		return response;
	}

}
