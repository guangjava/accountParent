package com.guang.mvnbook.account.persist;

/**
 * 
 * @comment ��װ�ĳ־û��쳣
 * @author admin
 * @date 2016��4��8������3:31:28
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
