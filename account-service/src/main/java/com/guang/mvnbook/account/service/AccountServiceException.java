package com.guang.mvnbook.account.service;

public class AccountServiceException extends Exception{

	private static final long serialVersionUID = 8473986879183235155L;
	public AccountServiceException(String msg){
		super(msg);
	}
	
	public AccountServiceException(String msg,Throwable e){
		super(msg, e);
	}

}
