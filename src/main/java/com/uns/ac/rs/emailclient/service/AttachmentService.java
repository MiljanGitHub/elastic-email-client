package com.uns.ac.rs.emailclient.service;

import java.util.List;

import com.uns.ac.rs.emailclient.model.Attachment;

public interface AttachmentService {
	
	Attachment save(Attachment attachment);
	Attachment findById(int id);
	void delete(Attachment attachment);
	List<Attachment> saveAll(List<Attachment> attachments);
	

}
