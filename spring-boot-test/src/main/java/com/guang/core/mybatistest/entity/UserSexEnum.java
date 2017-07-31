package com.guang.core.mybatistest.entity;

public enum UserSexEnum {
	MAN(0),
	WOMAN(1);
	private int code;
	private UserSexEnum(int code){
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	
}
