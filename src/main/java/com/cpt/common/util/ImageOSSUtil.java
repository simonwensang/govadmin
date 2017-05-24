package com.cpt.common.util;

import java.io.File;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aliyun.oss.OSSClient;

@Component
public class ImageOSSUtil {
	
	 	private Logger logger = Logger.getLogger(ImageOSSUtil.class);
 
	 	@Value("${oss.endpoint}")
	    private   String endpoint   ;
	 	@Value("${oss.accessKeyId}")
	    private   String accessKeyId  ;
	 	@Value("${oss.accessKeySecret}")
	    private   String accessKeySecret  ;
	 	@Value("${oss.bucketName}")
	    private   String bucketName  ;
 
	    public void upload(String  targetFile,String sourceFile){
	    	 OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	    	 ossClient.putObject(bucketName, targetFile, new File(sourceFile));
	    	 ossClient.shutdown();
	    }
	    
	    public void upload(String  targetFile,InputStream input){
	    	 OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	    	 ossClient.putObject(bucketName, targetFile, input);
	    	 ossClient.shutdown();
	    }
	    
}
