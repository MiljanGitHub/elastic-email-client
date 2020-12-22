package com.uns.ac.rs.emailclient.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class LoginRequest {
	
	private String username, password;
}
