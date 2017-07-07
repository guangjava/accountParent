package com.guang.webtest.service;

public abstract class LookupService {
	protected abstract SubService getSubService(); 
	
	public void sayHello() {
		getSubService().printOK();
	}

}
