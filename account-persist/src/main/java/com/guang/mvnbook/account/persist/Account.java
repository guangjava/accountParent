package com.guang.mvnbook.account.persist;

/**
 * 
 * @comment 账户简单模型
 * @author admin
 * @date 2016年4月8日下午3:22:51
 * @version 1.0.0
 */
public class Account {
	/**
	 * 账户ID
	 */
	private String id;
	/**
	 * 账户名
	 */
	private String name;
	/**
	 * 账户邮箱
	 */
	private String email;
	/**
	 * 账户密码
	 */
	private String password;
	/**
	 * 是否激活
	 */
	private String activated;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActivated() {
		return activated;
	}
	public void setActivated(String activated) {
		this.activated = activated;
	}

}
