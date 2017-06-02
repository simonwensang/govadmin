package com.cpt.req;

import java.util.Date;

import com.cpt.common.PageParam;

import lombok.Data;

@Data
public class MessageReq extends PageParam{
    private Long id;

    private String title;

    private String subject;

    private String content;

    private Long replyId;

    private String user;

    private Long userId;

    private Date createTime;

    private Byte isRead;

    private Boolean isDeleted;

}