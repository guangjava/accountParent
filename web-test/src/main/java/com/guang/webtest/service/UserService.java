package com.guang.webtest.service;

import org.springframework.transaction.annotation.Transactional;

import com.guang.webtest.domain.User;

public interface UserService {
	public int countAll();
	public void addUser(User user);
}
