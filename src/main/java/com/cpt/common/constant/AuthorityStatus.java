package com.cpt.common.constant;

public enum AuthorityStatus {

	COMMIT_USER((byte)1,"提报人"),
	AUDITOR((byte)2,"审核人"),
	HANDLER((byte)3,"派遣人"),
	CC_USER((byte)4,"抄送人"),
	RESPONSE((byte)5,"责任人");

	private Byte  key;
	private String value;
	
	private AuthorityStatus(Byte key, String value) {
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
