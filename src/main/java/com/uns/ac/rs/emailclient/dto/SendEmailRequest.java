package com.uns.ac.rs.emailclient.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class SendEmailRequest {
	
	//private List<MultipartFile> attachments;
	private String from, cc, bcc, body;
	private int accountId;
	
	
}