package com.guang.webtest.domain;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import com.guang.webtest.bean.BaseBean;
@Configuration
@EnableSpringConfigured
public class User implements Serializable{
	private static final long serialVersionUID = -7635036683047734770L;
	private BaseBean baseBean;
	private Integer id;
	private String name;
	private char sex;
	public void printOk() {
		baseBean.printOk();
	}

	public BaseBean getBaseBean() {
		return baseBean;
	}

	@Autowired
	@Qualifier("factory")
	public void setBaseBean(BaseBean baseBean) {
		this.baseBean = baseBean;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}
	
	
}
