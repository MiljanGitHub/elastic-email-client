package com.uns.ac.rs.emailclient.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.uns.ac.rs.emailclient.model.Attachment;
import com.uns.ac.rs.emailclient.model.Message;
import com.uns.ac.rs.emailclient.service.helper.MinIOClient;

@Component
public class AttachmentHelper {
	
	@Autowired	
	private MinIOClient minioClient;
	
	public List<Attachment> generateAttachments(List<MultipartFile> multiPartFiles, Message message){
		
		//generate and save attachments to database
		
		List<Attachment> attachments = multiPartFiles.stream()
							                         .map(mpf -> {
							                        	 Attachment att = Attachment.generateAttachment(mpf, message);
							                        	 boolean successfullySentToS3ObjectStorage = minioClient.writeToMinIO(att, mpf, message.getAccount().getBucket());
							                        	 if (successfullySentToS3ObjectStorage) return att;
							                        	 else return null;
							                         })
							                         .collect(Collectors.toList());
		
		if (attachments != null && attachments.size() > 0 ) {
			
			
			if (attachments.contains(null)) return null;
			
			//attachments = attachmentService.saveAll(attachments);
			
		}
		
		return attachments;
		
	}
	

}
