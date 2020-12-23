package com.uns.ac.rs.emailclient;
import io.minio.MinioClient;
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
	}
	
//	@Bean
//	public MinioClient getMinioClient() {
//		return MinioClient.builder()
//				.endpoint("http://26.192.233.126:9000/minio/")
//                .credentials("puletic1!123", "puletic1!123")
//                .build();
//	}




}
