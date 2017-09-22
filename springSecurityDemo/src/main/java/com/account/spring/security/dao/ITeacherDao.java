package com.account.spring.security.dao;

import java.util.HashMap;
import java.util.Map;

import com.account.spring.security.entity.Teacher;

public class ITeacherDao {
	private static Map<String, Teacher> table;
	/**
	 * 
	 */
	public ITeacherDao() {
		init();
	}
	private void init() {
		table = new HashMap<>();
		table.put("zhou", new Teacher("zhou", "df56923c28375df945e6c8a61d3e952c")); 
	}
	public Teacher findById(String username) {
		return table.get(username);
	}
}
