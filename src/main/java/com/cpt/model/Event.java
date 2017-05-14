package com.cpt.model;

import java.util.Date;
import java.util.List;

import com.cpt.vo.EventHandleLogVo;

public class Event {
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

    private String description;

    private String attachment;

    private String commitUser;

    private Integer commitUserId;

    private Date commitTime;

    private String auditor;

    private Integer auditorId;

    private Date auditorTime;

    private String respDepartment;

    private Integer respDepartmentId;

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

    private Byte isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community == null ? null : community.trim();
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window == null ? null : window.trim();
    }

    public Integer getWindowId() {
        return windowId;
    }

    public void setWindowId(Integer windowId) {
        this.windowId = windowId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAppellant() {
        return appellant;
    }

    public void setAppellant(String appellant) {
        this.appellant = appellant == null ? null : appellant.trim();
    }

    public String getAppellantTel() {
        return appellantTel;
    }

    public void setAppellantTel(String appellantTel) {
        this.appellantTel = appellantTel == null ? null : appellantTel.trim();
    }

    public String getEventNo() {
        return eventNo;
    }

    public void setEventNo(String eventNo) {
        this.eventNo = eventNo == null ? null : eventNo.trim();
    }

    public Byte getEventType() {
        return eventType;
    }

    public void setEventType(Byte eventType) {
        this.eventType = eventType;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime == null ? null : reportTime.trim();
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser == null ? null : commitUser.trim();
    }

    public Integer getCommitUserId() {
        return commitUserId;
    }

    public void setCommitUserId(Integer commitUserId) {
        this.commitUserId = commitUserId;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Integer getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Integer auditorId) {
        this.auditorId = auditorId;
    }

    public Date getAuditorTime() {
        return auditorTime;
    }

    public void setAuditorTime(Date auditorTime) {
        this.auditorTime = auditorTime;
    }

    public String getRespDepartment() {
        return respDepartment;
    }

    public void setRespDepartment(String respDepartment) {
        this.respDepartment = respDepartment == null ? null : respDepartment.trim();
    }

    public Integer getRespDepartmentId() {
        return respDepartmentId;
    }

    public void setRespDepartmentId(Integer respDepartmentId) {
        this.respDepartmentId = respDepartmentId;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate == null ? null : expiryDate.trim();
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark == null ? null : auditRemark.trim();
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler == null ? null : handler.trim();
    }

    public Integer getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(Integer handlerId) {
        this.handlerId = handlerId;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime == null ? null : handleTime.trim();
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult == null ? null : handleResult.trim();
    }

    public String getHandleRemark() {
        return handleRemark;
    }

    public void setHandleRemark(String handleRemark) {
        this.handleRemark = handleRemark == null ? null : handleRemark.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(Byte eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getCcUser() {
        return ccUser;
    }

    public void setCcUser(String ccUser) {
        this.ccUser = ccUser == null ? null : ccUser.trim();
    }

    public Integer getCcUserId() {
        return ccUserId;
    }

    public void setCcUserId(Integer ccUserId) {
        this.ccUserId = ccUserId;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    //---------------
    private List<EventHandleLog> eventHandleLogList;
    
    private List<WorkFlow> workFlows;
    
	public List<EventHandleLog> getEventHandleLogList() {
		return eventHandleLogList;
	}

	public void setEventHandleLogList(List<EventHandleLog> eventHandleLogList) {
		this.eventHandleLogList = eventHandleLogList;
	}
  
	public List<WorkFlow> getWorkFlows() {
		return workFlows;
	}

	public void setWorkFlows(List<WorkFlow> workFlows) {
		this.workFlows = workFlows;
	}
    private List<Byte> authority;

	public List<Byte> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Byte> authority) {
		this.authority = authority;
	}
    
}