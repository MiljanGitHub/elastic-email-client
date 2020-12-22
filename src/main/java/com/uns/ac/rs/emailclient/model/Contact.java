package com.uns.ac.rs.emailclient.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Getter
@Setter
public class Contact {
	
	    @Id
	    @GeneratedValue(strategy = IDENTITY)
	    @Column(name = "contact_id", unique = true, nullable = false)
	    private Integer id;

	    @Column(name = "firstname", unique = false, nullable = false)
	    private String firstName;

	    @Column(name = "lastname", unique = false, nullable = false)
	    private String lastName;

	    @Column(name = "display_name", unique = false, nullable = false)
	    private String displayName;

	    @Column(name = "email", unique = false, nullable = false)
	    private String email;

	    @Column(name = "note", unique = false, nullable = false)
	    private String note;

	    @ManyToOne()
	    @JsonIgnore
	    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	    private User user;
	    
	    public Contact() {
	    	
	    }

}
