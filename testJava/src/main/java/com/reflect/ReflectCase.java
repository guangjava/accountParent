package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectCase {
	public static void main(String[] args) {
		try {
			Proxy proxy = new Proxy();
			Method m = Proxy.class.getMethod("run");
			m.invoke(proxy);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	static class Proxy{
		public void run() {
			System.out.println("run");
		}
	}
}
