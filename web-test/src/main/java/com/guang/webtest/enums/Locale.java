package com.guang.webtest.enums;

/**
 * @comment 语言枚举
 * @author zhouchenguang
 * @date 2017年4月26日下午2:25:18
 * @version 1.0.0
 */
public enum Locale {
	/**
	 * 英文
	 */
	en("en"),
	/**
	 * 中文
	 */
	zh("zh");
	private String code;
	Locale(String code){
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	
}
