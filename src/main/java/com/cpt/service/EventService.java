package com.cpt.service;

import com.cpt.common.PageParam;
import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.req.EventReq;
import com.cpt.vo.EventVo;
import com.cpt.vo.WorkFlowVo;

public interface EventService {

	PageResult<EventVo> allReport(EventReq eventReq);
	
	PageResult<EventVo> pageList(PageParam pageParam,EventReq eventReq);
	
	 Result<EventVo>  approval(Integer id); 
	
	EventVo detail(Integer id);
	
	Result<Integer> addOrEdit(EventReq eventReq);

	Result<Integer> commit(EventReq eventReq);

	Result<Integer> delete(Integer id);
	
	public Result<Integer> sendHandler(EventReq eventReq);
	
	public Result<Integer> higherUp(EventReq eventReq);
	
	public Result<Integer> handle(EventReq eventReq);
	
	public Result<WorkFlowVo> getWorkFlow();
	
	public Integer updateWorkFlow(Long refId,Long appointUser);

}