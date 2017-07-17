package com.jvm;

public class InternCase {

	public static void main(String[] args) {
		
		String s1 = new String("11");
		String s2 = "11";
		s1.intern();
		
		System.out.println(s1.intern()==s2);
		System.out.println(s1.intern()=="11");

	}

}
