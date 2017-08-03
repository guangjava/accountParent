package com.jvm;

public class VolaLong {
	 boolean booleanV, booleanV2;  
     byte byteV;  
     int intV;  
     long longV;  
     double doubleV;  
     Object ref;  
     Object [] arr;  
	public static void main(String[] args) throws Exception {
		args = new String[]{"internals","-cp",".","com.jvm.VolaLong"};
		org.openjdk.jol.Main.main(args);
	}
}
