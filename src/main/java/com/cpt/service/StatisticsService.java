package com.cpt.service;

import java.util.List;

import com.cpt.req.StatisticsReq;
import com.cpt.vo.EchartVo;

public interface StatisticsService {

	public List<EchartVo>  getStatistics(StatisticsReq statisticsReq) ;
	
}
