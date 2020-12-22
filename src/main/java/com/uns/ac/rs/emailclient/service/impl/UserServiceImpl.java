package com.uns.ac.rs.emailclient.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.uns.ac.rs.emailclient.model.User;
import com.uns.ac.rs.emailclient.repository.UserRepository;
import com.uns.ac.rs.emailclient.service.UserService;

@Service
@Validated
public class UserServiceImpl implements UserService{
	
	private final UserRepository repository;
	
	@Inject
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public void delete(User user) {
		repository.delete(user);
	}

	@Override
	public User getById(int userId) {
		// TODO Auto-generated method stub
		return repository.getOne(userId);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return repository.findByUsernameAndPassword(username, password);
	}
	
}
