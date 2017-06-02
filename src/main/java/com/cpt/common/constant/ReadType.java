package com.cpt.common.constant;

public enum ReadType {

	UNREAD((byte)0,"初始状态"),
	READ((byte)1,"已处理") ;
	
	private Byte  key;
	private String value;
	
	private ReadType(Byte key, String value) {
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
		for (ReadType e : ReadType.values()) {  
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}
	


}
