package com.cpt.req;

import java.util.Date;

import lombok.Data;

import com.cpt.common.PageParam;

@Data
public class StatisticsReq extends PageParam{

	private String startTime;
	
	private String endTime;
	
	private Integer style;//1day 2week 3month 4 season 5year
	
}
