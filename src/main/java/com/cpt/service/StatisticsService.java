package com.cpt.service;

import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.model.Statistics;
import com.cpt.req.StatisticsReq;
import com.cpt.vo.StatisticsVo;

public interface StatisticsService {

	public StatisticsVo  getStatistics(StatisticsReq statisticsReq) ;
	
	public PageResult<Statistics> pageList(StatisticsReq statisticsReq);
	
	public Result<Integer> addOrEdit(Statistics statistics);
	
	public Result<Integer> delete(Integer id);
}
