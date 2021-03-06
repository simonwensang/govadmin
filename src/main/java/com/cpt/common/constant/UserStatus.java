package com.cpt.common.constant;

public enum UserStatus {

	// 0用户1报价人2费用录入人
	AUDIT((byte)0,"待审核"),
	AVAILABLE((byte)1,"启用"),
	FORBIDDEN((byte)2,"禁止") ;

	private Byte  key;
	private String value;
	
	private UserStatus(Byte key, String value) {
		this.key = key;
		this.value = value;
	}

	public Byte getKey() {
		return key;
	}

	public void setKey(Byte key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
