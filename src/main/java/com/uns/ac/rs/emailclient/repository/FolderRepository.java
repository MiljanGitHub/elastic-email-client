package com.uns.ac.rs.emailclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uns.ac.rs.emailclient.model.Account;
import com.uns.ac.rs.emailclient.model.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer>{
	
	Folder findByAccountAndName(Account account, String name);
	

}
