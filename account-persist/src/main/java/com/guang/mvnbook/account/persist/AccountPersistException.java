package com.guang.mvnbook.account.persist;

/**
 * 
 * @comment 封装的持久化异常
 * @author admin
 * @date 2016年4月8日下午3:31:28
 * @version 1.0.0
 */
public class AccountPersistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7890085505615119678L;
	
	public AccountPersistException(String msg){
		super(msg);
	}
	
	public AccountPersistException(String msg,Throwable throwable){
		super(msg,throwable);
	}

}
