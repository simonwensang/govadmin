package com.cpt.req;

import java.util.Date;

import lombok.Data;

@Data
public class StatisticsReq {

	private Date startTime;
	
	private Date endTime;
	
	private Integer style;//1day 2week 3month 4 season 5year
	
}
