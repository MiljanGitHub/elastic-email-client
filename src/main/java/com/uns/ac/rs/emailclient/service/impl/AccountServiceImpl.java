package com.uns.ac.rs.emailclient.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uns.ac.rs.emailclient.model.Account;
import com.uns.ac.rs.emailclient.repository.AccountRepository;
import com.uns.ac.rs.emailclient.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	
	private AccountRepository repository;
	
	@Inject
	public AccountServiceImpl(AccountRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public Account findById(int accountId) {
		// TODO Auto-generated method stub
		return repository.getOne(accountId);
	}

}
