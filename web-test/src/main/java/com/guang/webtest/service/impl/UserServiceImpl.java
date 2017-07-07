package com.guang.webtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.guang.webtest.dao.UserDao;
import com.guang.webtest.domain.User;
import com.guang.webtest.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public int countAll() {
		return userDao.countAll();
	}
	@Transactional
	@Override
	public void addUser(User user) {
		userDao.add(user);
	}

}
