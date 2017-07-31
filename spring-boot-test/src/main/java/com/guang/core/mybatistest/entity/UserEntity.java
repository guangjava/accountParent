package com.guang.core.mybatistest.entity;

public class UserEntity {
	private UserSexEnum userSex;
	private String nickName;
	private Long id;
	public UserEntity(String string, String string2, UserSexEnum man) {
		this.nickName = string;
		this.userSex = man;
	}
	public UserSexEnum getUserSex() {
		return userSex;
	}
	public void setUserSex(UserSexEnum userSex) {
		this.userSex = userSex;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
