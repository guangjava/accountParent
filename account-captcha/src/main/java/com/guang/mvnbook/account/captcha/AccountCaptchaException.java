package com.guang.mvnbook.account.captcha;

/**
 * @comment 封装的CaptchaException异常
 * @author zhouchenguang
 * @date 2016年4月26日下午3:05:58
 * @version 1.0.0
 */
public class AccountCaptchaException extends Exception{

	private static final long serialVersionUID = -4954219118683705271L;
	
	public AccountCaptchaException(String msg){
		super(msg);
	}
	
	public AccountCaptchaException(String msg,Throwable e){
		super(msg,e);
	}

}
