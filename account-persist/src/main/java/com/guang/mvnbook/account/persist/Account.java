package com.guang.mvnbook.account.persist;

/**
 * 
 * @comment �˻���ģ��
 * @author admin
 * @date 2016��4��8������3:22:51
 * @version 1.0.0
 */
public class Account {
	/**
	 * �˻�ID
	 */
	private String id;
	/**
	 * �˻���
	 */
	private String name;
	/**
	 * �˻�����
	 */
	private String email;
	/**
	 * �˻�����
	 */
	private String password;
	/**
	 * �Ƿ񼤻�
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
