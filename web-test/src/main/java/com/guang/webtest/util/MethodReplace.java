package com.guang.webtest.util;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class MethodReplace implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("replace ok");
		System.out.println(":arg0:"+args[0]+",arg1:"+args[1]);
		return null;
	}

}
