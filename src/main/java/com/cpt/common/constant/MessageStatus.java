package com.cpt.common.constant;

public enum MessageStatus {

	INIT((byte)0,"未读"),
	READ((byte)1,"已读"),
	HANDLE((byte)2,"已处理") ;
	private Byte  key;
	private String value;

	private MessageStatus(Byte key, String value) {
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
	
	public static String getValueByKey(Byte key){
		for (MessageStatus e : MessageStatus.values()) {
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}
	
	public  Boolean equal(Byte key){
		return key== null ? false : this.getKey()== key.byteValue();
	}
}
