package com.uns.ac.rs.emailclient.controller.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uns.ac.rs.emailclient.dto.LoginRequest;
import com.uns.ac.rs.emailclient.dto.LoginResponse;
import com.uns.ac.rs.emailclient.dto.SendEmailRequest;
import com.uns.ac.rs.emailclient.dto.StringResponse;
import com.uns.ac.rs.emailclient.helper.MessageHelper;
import com.uns.ac.rs.emailclient.model.Account;
import com.uns.ac.rs.emailclient.model.Message;
import com.uns.ac.rs.emailclient.model.User;
import com.uns.ac.rs.emailclient.service.AccountService;
import com.uns.ac.rs.emailclient.service.UserService;

@Service
public class UserControllerImpl {
	
	//private static final Logger logger = (Logger) LoggerFactory.logger(UserControllerImpl.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageHelper messageHelper;
	
	@Autowired 
	private AccountService accountService;
	
	
	public LoginResponse login(LoginRequest request) {
		
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
	
	
	public StringResponse sendEmail(MultipartFile attachment, SendEmailRequest request) {
		
		/*
		 * When sending new email/message, they will be placed in INBOX folder;
		 * Every user will get INBOX, DRAFT, SENT and DELETE folder once gets registers to with the system;
		 */
		
		Account account = accountService.findById(request.getAccountId());
		User user = userService.findById(request.getUserId());
		
		StringResponse response = new StringResponse();
		
		boolean sent = false;
		
		if (account == null) return new StringResponse(200, true, messageSource.getMessage("bad.account", null, new Locale("en")));
			
		
		
		if (user == null) return new StringResponse(200, true, messageSource.getMessage("bad.user", null, new Locale("en")));
		
		
		//it will be easier to work with list down the road rather with single element
		List<MultipartFile> multiPartFiles = new ArrayList<MultipartFile>(Arrays.asList(new MultipartFile[] {attachment}));
		
		//create model from DTO
		Message message = messageHelper.generateMessage(multiPartFiles ,request, account, user);
		
		if (message == null) return new StringResponse(200, true, messageSource.getMessage("error.message", null, new Locale("en")));
		
		//send email
		sent = messageHelper.sendEmail(message, account);
		if (!sent) return new StringResponse(200, true, messageSource.getMessage("error.email", null, new Locale("en")));
		
		//place attachments if any to MinIO
		
		//save to database
		
		//save to index Elastic repository
		
		response.setCode(200);
		response.setError(false);
		response.setMessage(messageSource.getMessage("sent.email", null, new Locale("en")));
		
		
		return response;
		
		
	}
	
	
	
	
	
	
	
	
	
}
