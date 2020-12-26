package com.uns.ac.rs.emailclient.service.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import org.springframework.web.multipart.MultipartFile;

import com.uns.ac.rs.emailclient.model.Attachment;

import io.minio.BucketExistsArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import io.minio.http.Method;

public class MinIOClient {
	
	public boolean writeToMinIO(Attachment attachment, MultipartFile mpf, String bucketName) {
		String projectDirectory = System.getProperty("user.dir");
		String systemSepartor = System.getProperty("file.separator");

		try {

			MinioClient minioClient = MinioClient.builder().endpoint("http://26.192.233.126:9000")
                .credentials("minioadmin", "minioadmin").build();
  		
			boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
			if (!bucketExists) {
				minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
			}
		
  			
  			//create temporary file where project is located
			Path projectPath = FileSystems.getDefault().getPath(projectDirectory + systemSepartor);
			Path tempFile = Files.createTempFile(projectPath, "temp_"+ String.valueOf(System.currentTimeMillis()), ".pdf");
  			mpf.transferTo(tempFile.toFile());
  			
			
			InputStream targetStream = new FileInputStream(tempFile.toFile());


			minioClient.putObject(
					PutObjectArgs.builder().bucket(bucketName).object(attachment.getCreated()+"-"+attachment.getName()).stream(
 		    	    		targetStream, -1, 10485760)
 		    	        .contentType("application/pdf") //for now only PDF documents
 		    	        .build());

			//close stream so that temp file can be deleted
			targetStream.close();
			
			//delete temp file from project directory
			Files.delete(tempFile);

 		    //get download URL of Attachment
			String url =
             	    minioClient.getPresignedObjectUrl(
             	        GetPresignedObjectUrlArgs.builder()
             	            .method(Method.GET)
             	            .bucket(bucketName)
             	            .object(attachment.getCreated()+"-"+attachment.getName())
             	            .expiry(7, TimeUnit.DAYS)
             	            .build());
            
			if (url == null) return false;
             
			attachment.setUrl(url);
  		
		} catch (InvalidKeyException | ErrorResponseException | IllegalArgumentException | InsufficientDataException
				| InternalException | InvalidBucketNameException | InvalidResponseException | NoSuchAlgorithmException
				| ServerException | XmlParserException | IOException  e ) {
			
			e.printStackTrace();
			return false;
		
		} catch (Exception e) {
         	e.printStackTrace();
         	return false;

 		}

		return true;
    }
	
	

}
