package com.guang.mvnbook.account.email;

/**
 * 
 * @comment ��װ��Email�쳣
 * @author admin
 * @date 2016��3��30������4:15:01
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
