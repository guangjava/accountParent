package com.guang.webtest.bean.impl;

import java.util.List;

import com.guang.webtest.bean.BaseBean;

public class ParentBean implements BaseBean{
	private List<String> nameList;
	@Override
	public void printOk() {
		for (String string : nameList) {
			System.out.println(string);
		}
	}
	public List<String> getNameList() {
		return nameList;
	}
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
	
	
	
}
