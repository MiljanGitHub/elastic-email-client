package com.uns.ac.rs.emailclient;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication
@ComponentScan(basePackages = "com.uns.ac.rs.emailclient")
@EnableJpaRepositories(basePackages = { "com.uns.ac.rs.emailclient" })
public class EmailClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailClientApplication.class, args);
	}
	
	 @Bean
	 public MultipartConfigElement multipartConfigElement() {
	     MultipartConfigFactory factory = new MultipartConfigFactory();
	     factory.setMaxFileSize(DataSize.ofBytes(104857600L));
	     return factory.createMultipartConfig();
	 }
	
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
	    return new StandardServletMultipartResolver();
	}

}
