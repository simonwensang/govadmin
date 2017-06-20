package com.cpt.common.constant;

public enum RoleCode {

	SUPERUSER( "superuser","系统管理员"),
	ADMIN("admin" ,"普通管理员"),
	TOWN_SENIOR("town_senior" ,"镇级高级网格管理员"),
	TOWN( "town","镇级网格管理员"),
	VILLAGE( "village","村级网格人员") ;
	
	private String  key;
	private String value;
	
	private RoleCode(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static String getValueByKey(Byte key){
		for (RoleCode e : RoleCode.values()) {  
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}
	


}
