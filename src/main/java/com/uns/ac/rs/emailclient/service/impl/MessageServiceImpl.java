package com.uns.ac.rs.emailclient.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uns.ac.rs.emailclient.model.Message;
import com.uns.ac.rs.emailclient.repository.MessageRepository;
import com.uns.ac.rs.emailclient.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	private MessageRepository repository;
	
	@Inject
	public MessageServiceImpl(MessageRepository repository) {
		this.repository = repository;
	}

	@Override
	public Message save(Message message) {
		// TODO Auto-generated method stub
		return repository.save(message);
	}

	@Override
	public Message findById(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	@Override
	public void delete(Message message) {
		// TODO Auto-generated method stub
		repository.delete(message);
		
	}

}
