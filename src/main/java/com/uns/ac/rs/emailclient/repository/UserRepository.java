package com.uns.ac.rs.emailclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uns.ac.rs.emailclient.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	

}
