package com.uns.ac.rs.emailclient.service.impl;


import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import com.uns.ac.rs.emailclient.service.MinIOService;

import io.minio.BucketExistsArgs;
import io.minio.DownloadObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;


public class MinIOServiceImpl {

    final static String endPoint = "http://127.0.0.1:9000";
    final static String accessKey = "myaccesskey";
    final static String secretKey = "mysecretkey";
    final static String bucketName = "mybucket";
    final static String localFileFolder = "C:\\test\\files\\";
    
   // private final MinioClient minioClient;
    
//    public MinIOServiceImpl() {
////    	this.minioClient = MinioClient.builder()
////				.endpoint("http://26.192.233.126:9000/minio/")
////                .credentials("puletic1!123", "puletic1!123")
////                .build();
//    }

//    @Override
//    public void WriteToMinIO(String fileName, String tempResourcefilePath, String bucketName) throws InvalidKeyException, IllegalArgumentException, NoSuchAlgorithmException, IOException {
//        try {
//        	
//        	
////        	MinioClient minioClient = MinioClient.builder().endpoint(endPoint)
////                    .credentials(accessKey, secretKey).build();
//
//            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
//            if (!bucketExists) {
//                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
//            }
//
//           // String fileToUpload = localFileFolder + fileName;
//            UploadObjectArgs args = UploadObjectArgs.builder().bucket(bucketName).object(fileName)
//                    .filename(tempResourcefilePath).build();
//            minioClient.uploadObject(args);
//            
////            MinioClient minioClient = MinioClient.builder().endpoint(endPoint)
////                    .credentials(accessKey, secretKey).build();
////
////            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
////            if (!bucketExists) {
////                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
////            }
////
////            String fileToUpload = localFileFolder + fileName;
////            UploadObjectArgs args = UploadObjectArgs.builder().bucket(bucketName).object(fileName)
////                    .filename(fileToUpload).build();
////            minioClient.uploadObject(args);
//
//
//        } catch (MinioException e) {
//            System.out.println("Error occurred: " + e);
//        }
//    }
//    
//    @Override
//    public void ReadFromMinIO(String fileName) throws InvalidKeyException, IllegalArgumentException, NoSuchAlgorithmException, IOException {
//        try {
//            MinioClient minioClient = MinioClient.builder().endpoint(endPoint)
//                    .credentials(accessKey, secretKey).build();
//            String downloadedFile = localFileFolder + "D_" + fileName;
//            DownloadObjectArgs args = DownloadObjectArgs.builder().bucket(bucketName).object(fileName)
//                    .filename(downloadedFile).build();
//            minioClient.downloadObject(args);
//
//            System.out.println("Downloaded file to ");
//            System.out.println(" " + downloadedFile);
//            System.out.println();
//        } catch (MinioException e) {
//            System.out.println("Error occurred: " + e);
//        }
//    }
    
}
