package com.cpt.common.constant;

public enum EventType {
	//1治安防范 2集镇管理 3矛盾纠纷 4基层党建 5民生服务 6其他服务
	PUBLIC_SECURITY((byte)1,"治安防范"),
	TOWN_MANAGEMENT((byte)2,"集镇管理"),
	DISPUTE((byte)3,"矛盾纠纷"),
	PARTY_BASIC_ORGANIZATION((byte)4,"基层党建"),
	LIVELIHOOD_SERVICES((byte)5,"民生服务"),
	OTHER_SERVICES((byte)6,"其他服务");

	private Byte  key;
	private String value;
	
	private EventType(Byte key, String value) {
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
		for (EventType e : EventType.values()) {  
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}
}
