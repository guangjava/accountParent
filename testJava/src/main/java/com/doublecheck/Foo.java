package com.doublecheck;

public class Foo {
	 /** If perThreadInstance.get() returns a non-null value, this thread
    has done synchronization needed to see initialization
    of helper */
	private final ThreadLocal<String> perThreadInstance = new ThreadLocal<>();
	private Helper helper;
	public Helper getHelper() {
		if (perThreadInstance.get()==null) {
			createHelper();
		}
		return helper;
	}
	private void createHelper() {
		synchronized (this) {
			if (helper == null) {
				helper = new Helper();
			}
		}
		 // Any non-null value would do as the argument here
		perThreadInstance.set("done");
	}
	
}
