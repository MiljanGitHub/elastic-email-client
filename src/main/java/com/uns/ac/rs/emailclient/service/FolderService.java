package com.uns.ac.rs.emailclient.service;

import com.uns.ac.rs.emailclient.model.Account;
import com.uns.ac.rs.emailclient.model.Folder;

public interface FolderService {
	
	Folder findByAccountAndName(Account account, String nName);
	Folder save(Folder folder);
	Folder findById(int id);
	
}
