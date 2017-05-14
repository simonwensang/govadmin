package com.cpt.service;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.req.EventReq;
import com.cpt.vo.EventVo;

public interface EventService {

	PageResult<EventVo> allReport(EventReq eventReq);
	
	PageResult<EventVo> pageList(PageParam pageParam,EventReq eventReq);
	 
	EventVo detail(Integer id);
	
	Result<Integer> addOrEdit(EventReq eventReq);
	
	Result<Integer> delete(Integer id);
	
	public Result<Integer> sendHandler(EventReq eventReq);
	
	public Result<Integer> higherUp(EventReq eventReq);
	
	public Result<Integer> handle(EventReq eventReq);
	
}