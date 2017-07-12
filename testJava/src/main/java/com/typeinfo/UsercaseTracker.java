package com.typeinfo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.typeinfo.interfacea.UserCase;
import com.typeinfo.packageaccess.PasswordUtils;

public class UsercaseTracker {

	public static void main(String[] args) {
		List<Integer> userList = new ArrayList<>();
		Collections.addAll(userList, 47,48,49,50);
		trackUseCases(userList,PasswordUtils.class);
		

	}

	private static void trackUseCases(List<Integer> userCases, Class<?> cl) {
		Method[] methods = cl.getDeclaredMethods();
		for (Method method : methods) {
			UserCase uc = method.getAnnotation(UserCase.class);
			if (uc != null) {
				 System.out.println("Found Use Case: " + uc.id() + " " + uc.description());
	                userCases.remove(new Integer(uc.id()));
			}
		}
		for(int i:userCases){
			 System.out.println("Warning: Missing use case-" + i);
		}
	}

}
