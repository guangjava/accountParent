package com.guang.mvnbook.account.email;

/**
 * 
 * @comment 封装的Email异常
 * @author admin
 * @date 2016年3月30日下午4:15:01
 * @version 1.0.0
 */
public class AccountEmailException extends Exception{

	private static final long serialVersionUID = -6390474576548145347L;
	
	public AccountEmailException(String msg){
		super(msg);
	}
	
	public AccountEmailException(String msg,Throwable throwable){
		super(msg,throwable);
	}

}
