package com.cpt.req;

import lombok.Data;

/**
 * Created by souibun on 2017/10/26.
 */
@Data
public class MessageReceiveReq {
    private Long id;

    private Long messageId;

    private Long receiveId;

    private Byte status;

    private Byte isDeleted;
}
