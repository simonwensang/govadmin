package com.cpt.model;

import java.util.Date;

public class EventResponse {
    private Long id;

    private Integer eventId;

    private String respDepartment;

    private Long respDepartmentId;

    private String responsible;

    private Long responsibleId;

    private Date createTime;

    private Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getRespDepartment() {
        return respDepartment;
    }

    public void setRespDepartment(String respDepartment) {
        this.respDepartment = respDepartment == null ? null : respDepartment.trim();
    }

    public Long getRespDepartmentId() {
        return respDepartmentId;
    }

    public void setRespDepartmentId(Long respDepartmentId) {
        this.respDepartmentId = respDepartmentId;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible == null ? null : responsible.trim();
    }

    public Long getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(Long responsibleId) {
        this.responsibleId = responsibleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}