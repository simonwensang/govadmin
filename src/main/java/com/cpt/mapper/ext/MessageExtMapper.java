package com.cpt.mapper.ext;

import java.util.List;

import com.cpt.model.Message;
import com.cpt.req.MessageReq;

public interface MessageExtMapper {
	
	 List<Message> pageList(MessageReq messageReq);

	 List<Message>  receiveList(MessageReq messageReq);

	 int insertSelective(Message record);
	 
	 Message get(Long id);
	 
	 int logicalDelete(Long id);
}