package com.cpt.service;

import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.Message;
import com.cpt.req.MessageReq;

public interface MessageService {
	
	public PageResult<Message> pageList(MessageReq messageReq);
	
	public Result<Message> get(Long id);
	
	public Result<Integer> addOrEdit(Message message);
	
	public Result<Integer> read(Long id);
	
	public Result<Integer> delete(Long id);
	
}
