package com.cpt.vo;

import lombok.Data;

@Data
public class EnumBean {
  private Byte key;
  private String value;
  
  public EnumBean(Byte key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
  
  
}
