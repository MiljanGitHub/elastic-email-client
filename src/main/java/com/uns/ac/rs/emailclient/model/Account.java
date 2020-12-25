package com.uns.ac.rs.emailclient.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter 
public class Account {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", unique = true, nullable = false)
    private int id;


    @Column(name = "smtp_address", unique = false, nullable = false)
    private String smtpAddress;

    @Column(name = "smtp_port", unique = false, nullable = false)
    private int smtpPort;

    @Column(name = "inserver_type", unique = false, nullable = false)
    private int inServerType;

    @Column(name = "inserver_address", unique = false, nullable = false)
    private String inServerAddress;

    @Column(name = "inserver_port", unique = false, nullable = false)
    private int inServerPort;

    @Column(name = "authentication", unique = false, nullable = false)
    private boolean authentication;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", unique = false, nullable = false)
    private String password;

    @Column(name = "display_name", unique = false, nullable = false)
    private String displayName;
    
    @Column(name = "bucket", unique = true, nullable = true)
    private String bucket;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Folder> folders;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Message> messages = new HashSet<Message>();

}
