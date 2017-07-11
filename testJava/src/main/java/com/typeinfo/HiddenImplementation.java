package com.typeinfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.typeinfo.interfacea.A;
import com.typeinfo.packageaccess.HiddenC;

public class HiddenImplementation {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Oops! Reflection still allows us to call g():
		callHiddenMethod(a, "g");
		 // And even methods that are less accessible!
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");
	}
	private static void callHiddenMethod(Object a,String methodName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
}
