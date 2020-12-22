package com.uns.ac.rs.emailclient.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uns.ac.rs.emailclient.model.Account;
import com.uns.ac.rs.emailclient.model.Folder;
import com.uns.ac.rs.emailclient.repository.FolderRepository;
import com.uns.ac.rs.emailclient.service.FolderService;

@Service
public class FolderServiceImpl implements FolderService{
	
	private FolderRepository repository;

	@Inject
	public FolderServiceImpl(FolderRepository repository) {
		this.repository = repository;
	}

	@Override
	public Folder findByAccountAndName(Account account, String name) {
		// TODO Auto-generated method stub
		return repository.findByAccountAndName(account, name);
	}

	@Override
	public Folder save(Folder folder) {
		// TODO Auto-generated method stub
		return repository.save(folder);
	}

	@Override
	public Folder findById(int id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}
	
	
	
	
	

}
