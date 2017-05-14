package com.cpt.common.constant;

public enum RespDepartment {

	ONE((byte)1,"王村一队"),
	TWO((byte)2,"王村二队"),
	THREE((byte)3,"王村三队"),
	FOUR((byte)4,"王村四队") ,
	FIVE((byte)5,"王村五队") ;
	private Byte  key;
	private String value;
	
	private RespDepartment(Byte key, String value) {
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
		for (RespDepartment e : RespDepartment.values()) {  
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}
	

}
