package com.doublecheck;

public class Foo2 {
	private volatile Helper helper;

	public Helper getHelper() {
		if (helper == null) {
			synchronized (helper) {
				if (helper == null) {
					helper = new Helper();
				}
			}
		}
		return helper;
	}
	
}
