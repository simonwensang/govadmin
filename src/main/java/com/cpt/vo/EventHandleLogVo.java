package com.cpt.vo;

import java.util.Date;

public class EventHandleLogVo {
    private Integer id;

    private Byte handleType;

    private String handler;

    private Integer handlerId;

    private Date handleTime;

    private Integer eventId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getHandleType() {
        return handleType;
    }

    public void setHandleType(Byte handleType) {
        this.handleType = handleType;
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

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
}