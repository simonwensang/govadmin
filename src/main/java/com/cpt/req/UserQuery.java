package com.cpt.req;

import lombok.Data;

import com.cpt.common.PageParam;

@Data
public class UserQuery extends PageParam {

	private Long id;
	
	private String account;
	
	private String name;
	
	private String mobile;
	
	private Integer roleId;
	
	private Integer lessRoleId;
	
	private Byte isDeleted;
	
	private Long sefId;
}
