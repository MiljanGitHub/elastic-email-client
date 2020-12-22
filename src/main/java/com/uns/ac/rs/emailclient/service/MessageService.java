package com.uns.ac.rs.emailclient.service;

import com.uns.ac.rs.emailclient.model.Message;

public interface MessageService {
	
	Message save(Message message);
	Message findById(int id);
	void delete(Message message);
	
}
