package com.uns.ac.rs.emailclient.controller.impl;

import java.util.Locale;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.uns.ac.rs.emailclient.dto.LoginRequest;
import com.uns.ac.rs.emailclient.dto.LoginResponse;
import com.uns.ac.rs.emailclient.dto.StringResponse;
import com.uns.ac.rs.emailclient.model.User;
import com.uns.ac.rs.emailclient.service.UserService;

@Service
public class UserControllerImpl {
	
	private static final Logger logger = (Logger) LoggerFactory.logger(UserControllerImpl.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserService userService;
	
	
	public LoginResponse login(LoginRequest request) {
		
		logger.debug("login() : {}");
		
		LoginResponse response = new LoginResponse();
		
		User user = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
		
		if (user != null) {
			
			response.setUserId(user.getId());
			
			response.setStringResponse(new StringResponse(200, false, messageSource.getMessage("good.credentials", null, new Locale("en"))));
			
		} else {
			response.setUserId(-1);
			
			response.setStringResponse(new StringResponse(200, true, messageSource.getMessage("bad.credentials", null, new Locale("en"))));

		}
		
		return response;

	}
	
	
	
	
	
	
	
	
	
	
	
	
}
