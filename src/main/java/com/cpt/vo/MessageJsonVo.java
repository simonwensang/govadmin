package com.cpt.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by souibun on 2017/10/31.
 */
@Data
public class MessageJsonVo {

    private String content;

    private List<MessageNode> msgs;

    @Data
    public static  class MessageNode{
        private String name ;
        private String status;
    }
}
