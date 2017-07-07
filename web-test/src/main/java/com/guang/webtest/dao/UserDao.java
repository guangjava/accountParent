package com.guang.webtest.dao;

import org.springframework.stereotype.Repository;

import com.guang.webtest.domain.User;

@Repository
public interface UserDao {
	public int countAll(); 
	public void add(User user); 
}
