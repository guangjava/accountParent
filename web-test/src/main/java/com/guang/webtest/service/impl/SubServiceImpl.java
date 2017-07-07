package com.guang.webtest.service.impl;

import com.guang.webtest.service.SubService;

public class SubServiceImpl implements SubService{
	private int count = 0;
	@Override
	public void printOK() {
		System.out.println("counter:"+count++);
	}

	@Override
	public int getHp() {
		return (int) (Math.random()*100);
	}
}
