package com.uns.ac.rs.emailclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uns.ac.rs.emailclient.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{
	
	
}
