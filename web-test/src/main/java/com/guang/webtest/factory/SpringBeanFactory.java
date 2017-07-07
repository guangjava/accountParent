package com.guang.webtest.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

import com.guang.webtest.bean.BaseBean;
import com.guang.webtest.bean.impl.BaseBeanImpl1;
import com.guang.webtest.bean.impl.BaseBeanImpl2;

public class SpringBeanFactory implements FactoryBean<BaseBean>{
	private String name;
	private Map<String, BaseBean> map;
	
	
	public SpringBeanFactory() {
		super();
		map = new HashMap<>();
		map.put("base1", new BaseBeanImpl1());
		map.put("base2", new BaseBeanImpl2());
	}

	@Override
	public BaseBean getObject() throws Exception {
		return map.get(name);
	}

	@Override
	public Class<?> getObjectType() {
		return BaseBean.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
