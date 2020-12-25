package com.uns.ac.rs.emailclient;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

//import io.minio.MinioClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.uns.ac.rs.emailclient")
@EnableJpaRepositories(basePackages = { "com.uns.ac.rs.emailclient" })
public class EmailClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailClientApplication.class, args);
		 //File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
		
		//System.out.println(dirPodaci.getAbsolutePath());
		
	}
	





}
