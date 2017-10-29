package com.cpt.vo;

import java.util.Date;
import java.util.List;

import com.cpt.model.EventHandleLog;
import com.cpt.model.EventResponse;
import com.cpt.model.WorkFlow;

import lombok.Data;
@Data
public class EventVo {

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
    
    private String eventTypeStr;

    private String reportTime;

    private Byte grade;
    
    private String gradeStr;

    private String attachment;

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
    private List<Byte> authority;
    //------------
    private List<EventHandleLog> eventHandleLogList;
    
    private List<WorkFlow> workFlows;
    
    private String attachmentFile ;

    private List<EventResponse> eventResponseList;

    //("是否显示审核")
  	private Boolean showAudit=false;
  	//("是否显示选择处理")
  	private Boolean showManager=false;
  	//("是否显示查看明细")
  	private Boolean showDetail=false;
    //("是否显示查看提报")
    private Boolean showCommit=false;
    //("是否显示删除")
    private Boolean showDelete=false;
    //("是否显示编辑")
    private Boolean showEdit=false;
  	private String eventStatusStr;

    private String handleAttachment;
    
}
