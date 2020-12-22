package com.uns.ac.rs.emailclient.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uns.ac.rs.emailclient.controller.impl.UserControllerImpl;
import com.uns.ac.rs.emailclient.dto.LoginRequest;
import com.uns.ac.rs.emailclient.dto.LoginResponse;
import com.uns.ac.rs.emailclient.dto.SendEmailRequest;
import com.uns.ac.rs.emailclient.dto.StringResponse;
import com.uns.ac.rs.emailclient.helper.MessageHelper;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserControllerImpl userControllerImpl;
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponse login(LoginRequest request) {
		
		LoginResponse response = userControllerImpl.login(request);
		
		return response;
	}
	
	//@ApiParam(allowMultiple=true) , @RequestBody SendEmailRequest request
	@RequestMapping(value = "/send/email", consumes = {"multipart/form-data"}, method = RequestMethod.POST) 
	public StringResponse sendEmail(@RequestParam("attachments") MultipartFile attachment, @ModelAttribute SendEmailRequest request) throws IOException {
		
		
		StringResponse response = userControllerImpl.sendEmail(attachment, request);
		
		return response;
	}
	
	@RequestMapping(value = "/send/test", consumes = {"multipart/form-data"}, method = RequestMethod.POST) //
	public StringResponse test() {
		
		
		return new StringResponse();
		
	}

}
