package com.cpt.common.util;

public class CodeFactory {

	public static final String GOV ="PACJ";
	
	public static String getCode(){
		return CodeFactory.GOV+DateUtils.getCurrentDay(DateUtils.dateTimeLongString)+(int)(1000+Math.random()*900);
	}
	public static void main(String[] args) {
		System.out.println(CodeFactory.getCode());
	}
}
