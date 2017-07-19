package com.cpt.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.MessageConstants;
import com.cpt.common.util.DateUtils;
import com.cpt.common.util.ImageOSSUtil;

@Controller
@RequestMapping("file")
public class FileController   {
	private final Logger logger = LoggerFactory.getLogger(FileController.class);
	@Resource
	private  ImageOSSUtil imageOSSUtil;
	@Value("${image.url}")
	private String imageurl ; 
	
	@Value("${server.imagepath}")
	private String imagepath ; 
	
	@Value("${server.imagepath.attachment}")
	public  String attachment ; 
	
	@Value("${oss.path.file}")
	public String ossPathFile;
	
	@Value("${oss.web.url}")
	public String ossWebUrl;
	
	@RequestMapping(value = "upload" , method = { RequestMethod.POST } , produces =  "application/json;charset=UTF-8")
	@ResponseBody
	public Result<String> upload( MultipartFile attachment ){
		try {
			//保存图片
			if(null == attachment){
				return new Result<String>(ResultCode.C500.getCode(),MessageConstants.PRARM_EMPTY);
			}
			if(attachment.getBytes().length>10*1024*1024){
				return new Result<String>(ResultCode.C500.getCode(),MessageConstants.FILE_SIZE_LARAGE);
			}
			
			String imageName=  DateUtils.getCurrentDay(DateUtils.YYYY_MM_DD)+"_"+attachment.getOriginalFilename();
			String targetFile = ossPathFile+"/"+imageName;
			try {
				imageOSSUtil.upload(targetFile,attachment.getInputStream());
			} catch (IOException e) {
				return new Result<String>(ResultCode.C500.getCode(),MessageConstants.FILE_SAVE_ERROR);
			}
			return Result.newResult(targetFile);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return new Result<String>(ResultCode.C500.getCode(),MessageConstants.FILE_SAVE_ERROR);
		}
		
	}
	
}
