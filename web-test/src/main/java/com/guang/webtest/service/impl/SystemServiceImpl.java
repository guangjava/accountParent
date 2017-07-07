package com.guang.webtest.service.impl;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.guang.webtest.service.SubService;
import com.guang.webtest.service.SystemService;

public class SystemServiceImpl implements SystemService{
	@Autowired
	private Properties configBean;
	@Autowired
	protected SubService subService;
	
	public void printSubService() {
		subService.printOK();
	}

	/**
	 * 获取Key加载信息
	 */
	public boolean printKeyLoadMessage(){
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n===================================================\r\n");
		sb.append("\r\n   欢迎使用 "+configBean.getProperty("productName")+" \r\n");
		sb.append("\r\n===================================================\r\n");
		System.out.println(sb.toString());
		return true;
		
	}

	@Override
	public int getHp() {
		return subService.getHp();
	}

	@Override
	public void replaceMethod(String a,int b) {
		System.out.println("not replace");
	}

	@Override
	public void replaceMethod2() {
		System.out.println("not replace");
	}
}
