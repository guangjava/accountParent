package com.account.spring.security.dao;

import java.util.HashMap;
import java.util.Map;

import com.account.spring.security.entity.Admin;

public class IAdminDao {
	private static Map<String, Admin> table;
	/**
	 * 
	 */
	public IAdminDao() {
		init();
	}
	private void init() {
		table = new HashMap<>();
		table.put("admin", new Admin("admin", "df56923c28375df945e6c8a61d3e952c"));
	}
	public Admin findById(String username) {
		return table.get(username);
	}
}
