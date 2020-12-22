package com.uns.ac.rs.emailclient.service;

import com.uns.ac.rs.emailclient.model.Account;

public interface AccountService {
	
	Account findById(int accountId);
}
