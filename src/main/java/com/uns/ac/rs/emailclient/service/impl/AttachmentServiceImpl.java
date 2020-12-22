package com.uns.ac.rs.emailclient.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uns.ac.rs.emailclient.model.Attachment;
import com.uns.ac.rs.emailclient.repository.AttachmentRepository;
import com.uns.ac.rs.emailclient.service.AttachmentService;
@Service
public class AttachmentServiceImpl implements AttachmentService{
	
	private AttachmentRepository repository;

	@Inject
	public AttachmentServiceImpl(AttachmentRepository repository) {
		this.repository = repository;
	}

	@Override
	public Attachment save(Attachment attachment) {
		// TODO Auto-generated method stub
		return repository.save(attachment);
	}

	@Override
	public Attachment findById(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	@Override
	public void delete(Attachment attachment) {
		repository.delete(attachment);
		
	}

	@Override
	public List<Attachment> saveAll(List<Attachment> attachments) {
		// TODO Auto-generated method stub
		return repository.saveAll(attachments);
	}
	
	
	
	
	
}
