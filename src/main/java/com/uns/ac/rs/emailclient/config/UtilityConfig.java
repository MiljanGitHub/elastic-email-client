package com.uns.ac.rs.emailclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uns.ac.rs.emailclient.service.helper.MinIOClient;

@Configuration
public class UtilityConfig {
	
	//credentials environment variables later
    
	@Bean
	public MinIOClient createMinIOClient() {
		return new MinIOClient();
	}
	
	


}


