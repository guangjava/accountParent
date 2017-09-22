package com.reflect;

import java.lang.reflect.Constructor;
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
	
	public static <T> T create(ReflectCase reflectCase) {
		Object object = null;
		try {
			Class<T> clz = (Class<T>) Class.forName("com.reflect.ReflectCase");
			Constructor<T> constructor = clz.getConstructor(ReflectCase.class);
			object = constructor.newInstance(reflectCase);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return (T) object;
	}
}
