package com.guang.webtest.service;

public interface SystemService extends BaseService{
	
	public void printSubService() ;

	/**
	 * 获取Key加载信息
	 */
	public boolean printKeyLoadMessage();
	public int getHp();
	public void replaceMethod(String a,int b);
	public void replaceMethod2();
}
