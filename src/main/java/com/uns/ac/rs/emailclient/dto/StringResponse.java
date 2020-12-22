package com.uns.ac.rs.emailclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StringResponse {
	
	private int code;
	private boolean error;
	private String message;
}
