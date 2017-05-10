package com.cpt.vo;

import java.util.Date;
import java.util.List;

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

    private String eventNo;

    private Byte eventType;

    private String reportTime;

    private Byte grade;

    private String attachment;

    private String commitUser;

    private Integer commitUserId;

    private String commitTime;

    private String auditor;

    private Integer auditorId;

    private Date auditorTime;

    private Integer respDepartment;

    private String respDepartmentId;

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

    private List<EventHandleLogVo>  eventHandleLogVoList;
    
}
