package com.uns.ac.rs.emailclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.uns.ac.rs.emailclient")
@EnableJpaRepositories(basePackages = { "com.uns.ac.rs.emailclient" })
public class EmailClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailClientApplication.class, args);
	}
	


}
