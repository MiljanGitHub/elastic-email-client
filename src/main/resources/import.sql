INSERT INTO email_project.user ( firstname, lastname, username, password) VALUES ( 'a','a','a','a');

--INSERT INTO email_project.user_tab (first_name, last_name, user_name, pass_word, roles) VALUES ( 'b','b','b','b', 'ROLE_USER');


--INSERT INTO email_project.contact (active, first_name, last_name, display_name, email, photo_path, note, user_id) VALUES (1, 'a', 'a','a','a','a','a', 1);
--INSERT INTO email_project.contact (active, first_name, last_name, display_name, email, photo_path, note, user_id) VALUES (0, 'a', 'a','a','a','a','a', 1);


--inServerType -> 1 for imap; 0 for pop3
--INSERT INTO email_project.account (smtp_Address, smtp_Port, inServer_Address, user_id) VALUES ('smtp.gmail.com', 567, 'aaaa', 1);


--INSERT INTO email_project.account (active, smtp_address, smtp_port, inserver_type, inserver_address, inserver_port, authentication, username_col, password_col, display_name, user_id) VALUES (1, 'smtp.mail.yahoo.com', 465, 1, 'imap.mail.yahoo.com', 993, 1, 's.curkovic@yahoo.com', 'cqdcxhbbfljnbtkx', 'Yahoo account', 1);
--INSERT INTO email_project.account (active, smtp_address, smtp_port, inserver_type, inserver_address, inserver_port, authentication, username_col, password_col, display_name, user_id) VALUES (1, 'smtp.gmail.com', 587, 1, 'imap.gmail.com', 993, 1, 'testingjavamailsend@gmail.com', 'testsend123', 'Gmail account', 1);
--INSERT INTO email_project.account (active, smtp_address, smtp_port, inserver_type, inserver_address, inserver_port, authentication, username_col, password_col, display_name, user_id) VALUES (1, 'smtp.uns.ac.rs', 587, 1, 'imap.uns.ac.rs', 993, 0, 'miljan.puletic@uns.ac.rs', 'futog2016', 'UNS account', 1);
INSERT INTO email_project.account ( smtp_address, smtp_port, inserver_type, inserver_address, inserver_port, authentication, username, password, display_name, user_id) VALUES ('smtp.gmail.com', 587, 1, 'imap.gmail.com', 993, 1, 'testingjavamailsend@gmail.com', 'testsend123', 'Gmail account', 1);

--INSERT INTO email_project.account (active, smtp_address, smtp_port, inserver_type, inserver_address, inserver_port, authentication, username_col, password_col, display_name, user_id) VALUES (1, 'smtp.gmail.com', 587, 1, 'imap.gmail.com', 993, 1, 'marko.marictest@gmail.com', 'markotest123', 'gmail account', 1);


INSERT INTO email_project.folder (folder_id, name, account_id, parent_folder_id) VALUES (1,  'INBOX',  1, null);
--INSERT INTO folders (folder_id, active, name, account_id, parent_folder_id) VALUES (2, 1, 'Sent',  1, null);
--INSERT INTO folders (folder_id, active, name, account_id, parent_folder_id) VALUES (3, 1, 'Drafts', 1, null);
--INSERT INTO folders (folder_id, active, name, account_id, parent_folder_id) VALUES (4, 1, 'Trash', 1, null);
--INSERT INTO folders (folder_id, active, name, account_id, parent_folder_id) VALUES (5, 1, 'Favorites', 1, null);
--INSERT INTO folders (folder_id, active, name, account_id, parent_folder_id) VALUES (6, 1, 'TestFolder', 1, 1);

--INSERT INTO tag(tag_id,name,user_id,active)VALUES(1,"tag1",1,1);
--INSERT INTO tag(tag_id,name,user_id,active)VALUES(2,"tag2",1,1);
--INSERT INTO email_project.account (active, smtp_address, smtp_port, inserver_type, inserver_address, inserver_port, authentication, username_col, password_col, display_name, user_id) VALUES (1, 'smtp.gmail.com', 465, 1, 'imap.gmail.com', 993, 1, 'testingjavamailsend1@gmail.com', 'testsend123', 'Gmail account', 1);
--INSERT INTO email_project.account (active, smtp_address, smtp_port, inserver_type, inserver_address, inserver_port, authentication, username_col, password_col, display_name, user_id) VALUES (1, 'smtp.gmail.com', 465, 1, 'imap.gmail.com', 993, 1, 'testingjavamailsend2@gmail.com', 'testsend123', 'Gmail account', 1);




--INSERT INTO email_project.folders (folder_id, name, account_id, parent_folder_id) VALUES (1, 'Sent',  1, null);
--INSERT INTO email_project.folders (folder_id, name, account_id, parent_folder_id) VALUES (2, 'Drafts', 1, null);
--INSERT INTO email_project.folders (folder_id, name, account_id, parent_folder_id) VALUES (3, 'Trash', 1, null);
--INSERT INTO email_project.folders (folder_id, name, account_id, parent_folder_id) VALUES (4, 'Favorites', 1, null);
--INSERT INTO email_project.folders (folder_id, name, account_id, parent_folder_id) VALUES (5, 'TestFolder', 1, 1);

--INSERT INTO email_project.folders (folder_id, name, account_id, parent_folder_id) VALUES (6, 'Child',  1, 1);

--INSERT INTO message(message_id,active,content,date_time,from_col,subject,unread,account_id)VALUES(1,true,"content",null,"from aa","subject",true,2);

--INSERT INTO tag(tag_id,name,user_id)VALUES(1,"tag1",2);

--INSERT INTO tag(tag_id,name,user_id)VALUES(2,"tag2",1);
--INSERT INTO tag(tag_id,name,user_id)VALUES(3,"tag3",1);

--INSERT INTO tag(tag_id,name,user_id)VALUES(2,"tag2",1);
--INSERT INTO tag(tag_id,name,user_id)VALUES(3,"tag3",2);

--INSERT INTO tags_messages VALUES(1,1);
--INSERT INTO recipient_to VALUES(1,'to aa');
--INSERT INTO recipient_cc VALUES(1,'to cc');
--INSERT INTO recipient_bcc VALUES(1,'to bcc');
--
--INSERT INTO folders_messages VALUES(1,1);



--INSERT INTO email_project.rules (rule_id, condition_, operation_) VALUES (1, 0, 0);


--INSERT INTO email_project.folders (folder_id, name, account_id, parent_folder_id) VALUES (1, 'Sent',  1, null);

