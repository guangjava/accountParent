package com.guang.webtest.bean.impl;

import com.guang.webtest.bean.BaseBean;

public class DemoBean implements BaseBean{

	@Override
	public void printOk() {
		System.out.println("Run");
	}

}
