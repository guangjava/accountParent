package com.account.spring.security.dao;

import java.util.HashMap;
import java.util.Map;

import com.account.spring.security.entity.Student;

public class IStudentDao {
	private static Map<String, Student> table;
	/**
	 * 
	 */
	public IStudentDao() {
		init();
	}
	private void init() {
		table = new HashMap<>();
		table.put("guang", new Student("guang", "df56923c28375df945e6c8a61d3e952c"));
	}
	public Student findById(String username) {
		return table.get(username);
	}
}
