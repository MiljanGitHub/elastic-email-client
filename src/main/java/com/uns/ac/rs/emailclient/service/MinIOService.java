package com.uns.ac.rs.emailclient.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface MinIOService {
	
	 void WriteToMinIO(String fileName, String tempResourcefilePath, String bucketName) throws InvalidKeyException, IllegalArgumentException, NoSuchAlgorithmException, IOException;
	 void ReadFromMinIO(String fileName) throws InvalidKeyException, IllegalArgumentException, NoSuchAlgorithmException, IOException;
}
