package com.uns.ac.rs.emailclient.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;



@Table(name = "message")
@Entity
@Getter
@Setter
public class Message {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id", unique = true, nullable = false)
    private int id;

    @Column(name = "from_email", unique = false, nullable = true)
    private String from;

    @ManyToOne()
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    private Account account;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Folder folder;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attachment> attachments;
    
    @ElementCollection
    @CollectionTable(name = "recipient_to", joinColumns  = @JoinColumn(name = "message_id")) //
    @Column(name="recipient_to")
    private List<String> to;

    @ElementCollection
    @CollectionTable(name = "recipient_cc" , joinColumns = @JoinColumn(name = "message_id")) //
    @Column(name = "recipient_cc")   //i to i cc i bccc mogu biti null ali mora se proveriti da bar
    private List<String> cc;                                        // jedan od njih nije kada se salje mail

    @ElementCollection
    @CollectionTable(name = "recipient_bcc", joinColumns = @JoinColumn(name = "message_id")) //
    @Column(name = "recipient_bcc", unique = false, nullable = true)
    private List<String> bcc;

    @Column(name = "subject", unique = false, nullable = true)
    private String subject;

    @Lob
    @Column(name = "content", unique = false, nullable = true)
    private String content;

    @Column(name = "unread", unique = false, nullable = false)
    private boolean unread;
    
    public Message() {
    	
    }
    

    public Message(Account account){
        this.account=account;
        this.cc=new ArrayList<String>();
        this.to=new ArrayList<String>();

    }



}
