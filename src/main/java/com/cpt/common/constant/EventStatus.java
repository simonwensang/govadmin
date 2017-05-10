package com.cpt.common.constant;

public enum EventStatus {

	//项目状态0待制定项目负责人1待指派报价负责人2待指派报价人3报价中4合同已签订5合同不签订
	INIT((byte)0,"初始状态"),
	AUDIT((byte)1,"待审核"),
	HANDLE((byte)2,"待处置"),
	CLOSE((byte)3,"已关闭") ;
	private Byte  key;
	private String value;
	
	private EventStatus(Byte key, String value) {
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
		for (EventStatus e : EventStatus.values()) {  
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}
	

}
