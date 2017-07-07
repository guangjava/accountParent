package com.guang.webtest.service.impl;

import com.guang.webtest.service.SubService;

public class SubServiceImpl2 implements SubService{

	@Override
	public void printOK() {
		System.out.println("b");
	}

	@Override
	public int getHp() {
		return 0;
	}

}
