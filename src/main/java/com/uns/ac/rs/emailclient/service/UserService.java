package com.uns.ac.rs.emailclient.service;

import com.uns.ac.rs.emailclient.model.User;

public interface UserService {
	
	User save(User user);
	void delete(User user);
	User findById(int userId);
	User findByUsernameAndPassword(String username, String password);
	
}
