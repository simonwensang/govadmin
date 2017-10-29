package com.cpt.req;

import java.util.Date;
import java.util.List;

import lombok.Data;

import org.springframework.web.multipart.MultipartFile;

import com.cpt.common.PageParam;
@Data
public class EventReq extends PageParam{
	  	private Integer id;

	    private String community;

	    private Integer communityId;

	    private String window;

	    private Integer windowId;

	    private String address;

	    private String appellant;

	    private String appellantTel;
	    
	    private String appellantRemark;

	    private String eventNo;

	    private Byte eventType;

	    private String reportTime;

	    private Byte grade;

	    private String attachment;  
	    
	    private MultipartFile multFile;
	    
	    private String commitUser;

	    private Integer commitUserId;

	    private String commitTime;

	    private String auditor;

	    private Integer auditorId;

	    private Date auditorTime;

	    private String respDepartment;

	    private Integer respDepartmentId;

	    private String responsible;

	    private Integer responsibleId;
	    
	    private String expiryDate;

	    private String request;

	    private String auditRemark;

	    private String handler;

	    private Integer handlerId;

	    private String handleTime;

	    private String handleResult;

	    private String handleRemark;

	    private String updateUser;

	    private Integer updateUserId;

	    private Date updateTime;

	    private Byte eventStatus;

	    private String ccUser;

	    private Integer ccUserId;

	    private String description;
	    //------------------------
	    private Integer userId;
	    
	    private List<Byte> eventStatusList;
	    
	    private String reportTimeStart;
	    
	    private String reportTimeEnd;

		private Byte isDeleted;
}
