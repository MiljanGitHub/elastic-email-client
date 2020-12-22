package com.uns.ac.rs.emailclient.service.impl;

import javax.inject.Inject;

import org.hibernate.service.spi.InjectService;

import com.uns.ac.rs.emailclient.model.User;
import com.uns.ac.rs.emailclient.repository.UserRepository;
import com.uns.ac.rs.emailclient.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserRepository repository;
	
	@Inject
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
