package com.generic;

import java.util.HashMap;
import java.util.Map;

public class Context {
	private final Map<Class<?>, Object> values = new HashMap<>();
	public <T> void put(Class<T> key,Object object) {
		values.put(key, object);
	}
	public <T> T get(Class<T> key) {
		return key.cast(values.get(key));
	}
}
