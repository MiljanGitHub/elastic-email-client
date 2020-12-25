package com.uns.ac.rs.emailclient.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

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
    
    @Column(name = "url", unique = false, nullable = true, columnDefinition = "varchar(500)")
    private String url;
    
    @Column(name = "created",  unique = false, nullable = true)
    private String created;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "id_message", referencedColumnName = "message_id", nullable = true)
    private  Message message;

    public Attachment(){}

    
    public static Attachment generateAttachment(MultipartFile multiPart, Message message) {
    	
    	InputStream inputStream;
    	Attachment attachment = null;
		try {
			inputStream = multiPart.getInputStream();
			byte[] attArray = new byte[inputStream.available()];
			inputStream.read(attArray);
			String base64Att = Base64.getEncoder().encodeToString(attArray);
			String mime_type=multiPart.getContentType().split(";")[0] ;
			String att_name=multiPart.getResource().getFilename();
			
		    attachment=new Attachment();
		    attachment.setData(base64Att);
		    attachment.setName(att_name);
		    attachment.setMime_type(mime_type.split("/")[1]);
		    attachment.setCreated(String.valueOf(System.currentTimeMillis()));
		    attachment.setMessage(message);
		  
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return attachment;
    	
    }
    
   
}
