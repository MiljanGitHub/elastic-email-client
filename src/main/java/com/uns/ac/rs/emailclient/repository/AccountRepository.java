package com.uns.ac.rs.emailclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uns.ac.rs.emailclient.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
