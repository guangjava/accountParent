package com.guang;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Random;
public class Test {
	 // No throws clause here
	public static void main(String[] args) {
		doThrow(new SQLException());
		Test test = new Test();
		test.a();

	}

	private static void doThrow(Exception e) {
		Test.<RuntimeException>doThrow0(e);
		
	}

	@SuppressWarnings("unchecked")
	private static <E extends Exception> void doThrow0(Exception e) throws E {
		throw(E)e;
		
	}
	
	int[][] a(){return new int[0][];}
	int[] b()[]{return new int[0][];}
	int c()[][]{return new int[0][];}
	@org.junit.Test
	//在确有必要的情况下，条件表达式会升级数字类型
	public void testCondition(){
		Object o1 = true ? new Integer(1) : new Double(2);
		Object o2;
		if (true) {
			o2 = new Integer(1);
		}else {
			o2 = new Double(2);
		}
		System.out.println(o1);
		System.out.println(o2);
	}
	@org.junit.Test
	public void testCondition2(){
		Integer i = new Integer(1);
		if (i.equals(1)) {
			i = null;
		}
		Object o = true ? i : new Double(2); // NullPointerException!
		System.out.println(o);
	}
	@org.junit.Test
	public void testOp(){
		byte a = 10;
		System.out.println(a);
		a *= 1.1;
		System.out.println(a);
		byte b = 100;
		System.out.println(b);
		b /= 2.5;
		System.out.println(b);
		char c = '0';
		c *= 1.1;
		System.out.println(c);
		char d = 'A';
		d *= 1.5;
		System.out.println(d);
	}
	@org.junit.Test
	public void testRandom() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Class<?> clazz = Class.forName("java.lang.Integer$IntegerCache");
		Field field = clazz.getDeclaredField("cache");
		field.setAccessible(true);
		Integer[] cache = (Integer[]) field.get(clazz);
		for (int i = 0; i < cache.length; i++) {
			cache[i] = new Random().nextInt(cache.length);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println((Integer)i);
		}
	}
}
