package com.cpt.common.constant;

public enum Grade {
	COMMON((byte)1,"一般"),
	SERIOUS((byte)2,"严重"),
	MAJOR((byte)3,"重大") ;
	private Byte  key;
	private String value;
	
	private Grade(Byte key, String value) {
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
		for (Grade e : Grade.values()) {  
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}
	


}
