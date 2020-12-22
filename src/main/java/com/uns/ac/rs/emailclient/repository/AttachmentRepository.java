package com.uns.ac.rs.emailclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uns.ac.rs.emailclient.model.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer>{
	
	

}
