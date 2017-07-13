package com.typeinfo.supperclass;

import java.util.HashMap;

public class TypeCounter extends HashMap<Class<?>,Integer>{
	private Class<?> baseClass;
	private static final long serialVersionUID = 4838210745378842262L;
	public void countType(Class<?> class1) {
		if (baseClass.isAssignableFrom(class1)) {
			throw new IllegalArgumentException("");
		}
		put(class1, get(class1)==null?1:get(class1)+1);
		if (class1.getSimpleName().equals(baseClass.getSimpleName())) {
			return;
		}
		countType(class1.getSuperclass());
	}
	public void setBaseClass(Class<?> baseClass) {
		this.baseClass = baseClass;
	}
}
