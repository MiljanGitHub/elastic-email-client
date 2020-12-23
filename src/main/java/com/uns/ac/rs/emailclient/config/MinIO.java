package com.uns.ac.rs.emailclient.config;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.UploadObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;

//@Service
public class MinIO {
	
	
	 private MinioClient minioClient;
	
	 public MinIO(MinioClient minioClient) {
		 this.minioClient = minioClient;
	 }
	 
//	 public boolean bucketExists(String bucketName) {
//	
//		 try {
//			 //minioClient.makeBucket(MakeBucketArgs.builder().bucket("asiatrip").build());
//			return false; //minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
//		} catch (InvalidKeyException | ErrorResponseException | InsufficientDataException | InternalException
//				| InvalidResponseException | NoSuchAlgorithmException | ServerException | XmlParserException
//				| IllegalArgumentException | IOException e) {
//			e.printStackTrace();
//			return false;
//		}
//	 }
	 
	 
//	public void makeBucket(String bucketName) {
//		
//		
//		try {
//			minioClient.makeBucket(MakeBucketArgs.builder().bucket("asiatrip").build());
//		} catch (InvalidKeyException | ErrorResponseException | InsufficientDataException | InternalException
//				| InvalidResponseException | NoSuchAlgorithmException | ServerException | XmlParserException
//				| IllegalArgumentException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
//	public void uploadObject(String bucketName, String objectName, String path) {
//	      try {
//			ObjectWriteResponse res = minioClient.uploadObject(
//			          UploadObjectArgs.builder()
//			              .bucket(bucketName)
//			              .object(objectName)
//			              .filename(path)
//			              .build());
//			
//			
//		} catch (InvalidKeyException | ErrorResponseException | InsufficientDataException | InternalException
//				| InvalidResponseException | NoSuchAlgorithmException | ServerException | XmlParserException
//				| IllegalArgumentException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		      System.out.println(
////		          "'/home/user/Photos/asiaphotos.zip' is successfully uploaded as "
////		              + "object 'asiaphotos-2015.zip' to bucket 'asiatrip'.");
//	}
	
	
//	  try {
//	      // Create a minioClient with the MinIO server playground, its access key and secret key.
//	      MinioClient minioClient =
//	          MinioClient.builder()
//	              .endpoint("https://play.min.io")
//	              .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
//	              .build();
//
//	      // Make 'asiatrip' bucket if not exist.
//	      boolean found =
//	          minioClient.bucketExists(BucketExistsArgs.builder().bucket("asiatrip").build());
//	      if (!found) {
//	        // Make a new bucket called 'asiatrip'.
//	        minioClient.makeBucket(MakeBucketArgs.builder().bucket("asiatrip").build());
//	      } else {
//	        System.out.println("Bucket 'asiatrip' already exists.");
//	      }
//
//	      // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
//	      // 'asiatrip'.
//	      minioClient.uploadObject(
//	          UploadObjectArgs.builder()
//	              .bucket("asiatrip")
//	              .object("asiaphotos-2015.zip")
//	              .filename("/home/user/Photos/asiaphotos.zip")
//	              .build());
//	      System.out.println(
//	          "'/home/user/Photos/asiaphotos.zip' is successfully uploaded as "
//	              + "object 'asiaphotos-2015.zip' to bucket 'asiatrip'.");
//	    } catch (MinioException e) {
//	      System.out.println("Error occurred: " + e);
//	    }
//	  }
	
	
}
