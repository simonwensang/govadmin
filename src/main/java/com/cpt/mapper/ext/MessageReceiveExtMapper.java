package com.cpt.mapper.ext;

import com.cpt.model.MessageReceive;
import com.cpt.model.MessageReceiveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageReceiveExtMapper {

    int insertList(List<MessageReceive> list);

    int updateStatus(MessageReceive  messageReceive);
}