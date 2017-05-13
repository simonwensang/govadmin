package com.cpt.req;

import lombok.Data;

import com.cpt.common.PageParam;

@Data
public class UserQuery extends PageParam {

	private Long orgId;
	
	private String name;
	
}
