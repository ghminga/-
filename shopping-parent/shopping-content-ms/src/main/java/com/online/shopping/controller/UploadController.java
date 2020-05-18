package com.online.shopping.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.online.shopping.entity.Result;

@RestController
public class UploadController {

	@Value("${minio.endpoint}")
	private String endpoint;//  http://192.168.1.104:9000 #MinIO服务所在地址
	@Value("${minio.bucketName}")
	private String bucketName;// mall #存储桶名称
	@Value("${minio.accessKey}")
	private String accessKey; //minioadmin #访问的key
	@Value("${minio.secretKey}")
	private String secretKey; //minioadmin #访问的秘钥


	@PostMapping("/uploadFile")
	@CrossOrigin("*") //跨域问题
	public Result uploadFile(MultipartFile file) {

		//先创建minio上传文件客户端
		try {
			MinioClient minioClient = new MinioClient(endpoint,accessKey,secretKey);
			boolean isExist = minioClient.bucketExists(bucketName);
			if(!isExist) {
				minioClient.makeBucket(bucketName);
				minioClient.setBucketPolicy(bucketName,"*.*", PolicyType.READ_ONLY);
			}

			//设置存储对象的名称
			if(file == null){
				System.out.println("文件为空");
			}
			String filename = file.getOriginalFilename();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String objectName = sdf.format(new Date())+"/"+ filename;

			//把存储对象尚存至存储桶中
			minioClient.putObject(bucketName,objectName,file.getInputStream(),file.getContentType());
			System.out.println("上传文件成功");

			String objectUrl = minioClient.getObjectUrl(bucketName,objectName);
			System.out.println(objectUrl);
			return new Result(true,objectUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"上传文件失败");
		}


	}
	

	
}
