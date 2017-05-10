package com.cpt.common.constant;

public enum HandleType {

	COMMIT((byte)1,"提报"),
	AUDITE((byte)2,"审核"),
	HANDLE((byte)3,"派遣");

	private Byte  key;
	private String value;
	
	private HandleType(Byte key, String value) {
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
