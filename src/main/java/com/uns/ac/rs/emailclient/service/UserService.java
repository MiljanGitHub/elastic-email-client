package com.uns.ac.rs.emailclient.service;

import com.uns.ac.rs.emailclient.model.User;

public interface UserService {
	
	User save(User user);
	User delete(User user);
	User deleteById(int userId);
	User getById(int userId);
	
	
}
