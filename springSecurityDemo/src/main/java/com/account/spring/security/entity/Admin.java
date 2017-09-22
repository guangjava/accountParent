package com.account.spring.security.entity;

public class Admin {
	private String username;
	private String password;
	/**
	 * @param username
	 * @param password
	 */
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	/**
	 * 返回 #{bare_field_comment}
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 设置 #{bare_field_comment}
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 返回 #{bare_field_comment}
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置 #{bare_field_comment}
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
