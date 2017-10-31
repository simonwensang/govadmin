package com.cpt.service;

import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.Message;
import com.cpt.model.MessageReceive;
import com.cpt.req.MessageReceiveReq;
import com.cpt.req.MessageReq;
import com.cpt.vo.MessageJsonVo;

import java.util.List;

public interface MessageService {
	
	public PageResult<Message> querySendMessage(MessageReq messageReq);

	public PageResult<Message> queryReceiveMessage(MessageReq messageReq);
	
	public Result<Message> get(Long id);

	public Result<MessageJsonVo> getReceiveList(Long id);
	
	public Result<Integer> addOrEdit(Message message);
	
	public Result<Integer> read(MessageReceiveReq messageReceiveReq);
	
	public Result<Integer> delete(Long id);
	
}
