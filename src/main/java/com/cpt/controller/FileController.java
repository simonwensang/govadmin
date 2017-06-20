package com.cpt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cpt.common.Result;

@Controller
@RequestMapping("file")
public class FileController   {
	private final Logger logger = LoggerFactory.getLogger(FileController.class);
	 
	@RequestMapping(value = "upload" , method = { RequestMethod.POST })
	@ResponseBody
	public Result<String> upload( MultipartFile multFile ){
		return Result.newResult("/oos/image.jpg");
		/*if(null == multFile){
			result.setErrorCode(MmcResultCode.FIELD_NOT_ALLOWED_EMPTY,"文件");
			return result;
		}
		
		UserVo userVo = getUser(result);
		try {
			if(multFile.getBytes().length>10*1024*1024){
				result.setErrorCode(MmcResultCode.FIELD_LENGTH_MUST_LESS,"文件","10M");
				return result;
			}
			String datas = fastDFS.fastDFS(multFile.getInputStream(), multFile.getBytes().length, multFile.getOriginalFilename(), restTemplate,userVo.getUserOpenId());
			result.setDataMap(FastDFS.jsonManage(datas, "fileUrl"));
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			result.setErrorCode(MmcResultCode.SYS_ERROR);
		}
		
		return result;*/
	}
	
}
