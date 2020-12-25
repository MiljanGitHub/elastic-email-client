package com.uns.ac.rs.emailclient.helper;

import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.ByteArrayDataSource;
import com.sun.mail.util.MailSSLSocketFactory;
import com.uns.ac.rs.emailclient.dto.SendEmailRequest;
import com.uns.ac.rs.emailclient.model.Account;
import com.uns.ac.rs.emailclient.model.Attachment;
import com.uns.ac.rs.emailclient.model.Folder;
import com.uns.ac.rs.emailclient.model.Message;
import com.uns.ac.rs.emailclient.model.User;
import com.uns.ac.rs.emailclient.service.FolderService;
import com.uns.ac.rs.emailclient.service.MessageService;
import com.uns.ac.rs.emailclient.service.helper.MinIOClient;

@Component
public class MessageHelper {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private FolderService folderService;
	
	@Autowired
	private AttachmentHelper attachmentHelper;
	
	
	
	public Message generateMessage( List<MultipartFile> multiPartFiles, SendEmailRequest request, Account account, User user) {
		
		Message newMessage = new Message();
		
		newMessage.setFrom(account.getUsername());
		newMessage.setAccount(account);
		
		Folder inbox = folderService.findByAccountAndName(account, "INBOX");
		
		if (inbox == null) return null;
		
		newMessage.setFolder(inbox); //by default all outgoing messages are place to INBOX folder for the User, with the Account he/she is using to send an email
		
		newMessage.setUnread(false);
		
		newMessage.setFrom(account.getUsername());
		
		newMessage.setTo(request.getTo());
		newMessage.setBcc(request.getBcc());
		newMessage.setCc(request.getCc());
		newMessage.setContent(request.getContent());
		newMessage.setSubject(request.getSubject());
		
		newMessage = messageService.save(newMessage);
		
		if (newMessage == null) return null;
		
		List<Attachment> attachments =  attachmentHelper.generateAttachments(multiPartFiles, newMessage);
		
		//boolean successfullySentToS3ObjectStorage = minioClient.writeToMinIO(attachments, account.getBucket());
		
		newMessage.setAttachments(attachments);
		
		return newMessage;
		
	}
	
	public boolean sendEmail(Message newMessage, Account acc) {
		
		System.out.println("mail: " + acc.getUsername());
		System.out.println("pass: " + acc.getPassword());
		
		boolean messageSent = true;

        boolean isAuthenticationRequired = acc.isAuthentication();

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            
        Properties props = new Properties();

        mailSender.setHost(acc.getSmtpAddress());
        mailSender.setPort(acc.getSmtpPort()); //465 ... //587

        mailSender.setUsername(acc.getUsername());
        mailSender.setPassword(acc.getPassword());

        messageSent = setPropertiesBasedOnSMTPPort(props, acc, messageSent);

        if (!messageSent) return false;


        if (isAuthenticationRequired) {
            props.put("mail.smtp.auth", "true");
        } else {

        }
        mailSender.setJavaMailProperties(props);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        boolean hasAttachments = false;
        if (newMessage.getAttachments() != null && newMessage.getAttachments().size() > 0) hasAttachments = true;
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, hasAttachments);
            if (hasAttachments){
                for (Attachment att : newMessage.getAttachments()){
                    byte[] bb=Base64.getDecoder().decode(att.getData().getBytes());
                    helper.addAttachment(att.getName(), new ByteArrayDataSource(bb, createMimeType(att)));
                    att.setMessage(newMessage);

                }
            }

            helper.setFrom(newMessage.getFrom());
            if (newMessage.getTo() != null) helper.setTo(newMessage.getTo().stream().toArray(String[]::new));
            else  helper.setTo(new String[] {});
            
            if (newMessage.getCc() != null) helper.setCc(newMessage.getCc().stream().toArray(String[]::new));
            else helper.setCc(new String[] {});
            
            if (newMessage.getBcc() != null) helper.setBcc(newMessage.getBcc().stream().toArray(String[]::new));
            else helper.setBcc(new String[] {});
            
            helper.setSubject(newMessage.getSubject());
            helper.setText(newMessage.getContent());

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
            messageSent = false;

        } catch (Exception e) {
            e.printStackTrace();
            messageSent = false;
        }

        return messageSent;

		
	}
	
	 private String createMimeType(Attachment att){

	       return URLConnection.guessContentTypeFromName(att.getName()+"."+att.getMime_type());
	 }

	
    private boolean setPropertiesBasedOnSMTPPort(Properties props, Account acc, boolean messageSent)  {
        boolean messageSentChanged = messageSent;
        switch (String.valueOf(acc.getSmtpPort())){

            case "25":
            case "587":
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.debug", "true");
                props.put("mail.smtp.ssl.trust", acc.getSmtpAddress());
                break;
            case "465":
                MailSSLSocketFactory sf = null;
                try {
                    sf =  new MailSSLSocketFactory();
                    sf.setTrustAllHosts(true);
                } catch (GeneralSecurityException e){
                    e.printStackTrace();
                    messageSentChanged = !messageSent;
                } catch (Exception e){
                    e.printStackTrace();
                    messageSentChanged = !messageSent;
                }

                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.ssl.enable", "true");
                props.put("mail.smtp.ssl.socketFactory", sf);
                props.put("mail.debug", "true");
                break;
            default: return messageSentChanged;

        }
        return messageSentChanged;
    }

}
