package com.uns.ac.rs.emailclient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;



@Table(name = "attachments")
@Entity
@Getter
@Setter
public class Attachment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id", unique = true, nullable = false)
    private int id;


    @Lob
    @Column(name = "base_64_data", columnDefinition="LONGBLOB")
    private String  data;

    @Column(name = "mime_type", unique = false, nullable = false)
    private String mime_type;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "id_message", referencedColumnName = "message_id", nullable = true)
    private  Message message;

    public Attachment(){}

   
}
