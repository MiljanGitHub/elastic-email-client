package com.uns.ac.rs.emailclient.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.uns.ac.rs.emailclient.model.Attachment;
import com.uns.ac.rs.emailclient.model.Message;
import com.uns.ac.rs.emailclient.service.AttachmentService;

@Component
public class AttachmentHelper {
	
	@Autowired
	private AttachmentService attachmentService;
	
	public List<Attachment> generateAttachments(List<MultipartFile> multiPartFiles, Message message){
		
		//generate and save attachments to database
		
		List<Attachment> attachments = multiPartFiles.stream()
							                         .map(mpf -> Attachment.generateAttachment(mpf, message))
							                         .collect(Collectors.toList());
		
		if (attachments != null && attachments.size() > 0) attachments = attachmentService.saveAll(attachments);
		
		return attachments;
		
	}
	
//	InputStream inputStream = part.getInputStream();
//    byte[] attArray = new byte[inputStream.available()];
//    inputStream.read(attArray);
//    String base64Att = Base64.getEncoder().encodeToString(attArray);
//    System.out.println(base64Att);
//    mime_type=part.getContentType().split(";")[0] ;
//    att_name=part.getFileName();
//    data=base64Att;
//    Attachment attachment=new Attachment();
//    attachment.setData(data);
//    attachment.setName(att_name);
//    attachment.setMime_type(mime_type.split("/")[1]);
//    atts.add(attachment);
}
