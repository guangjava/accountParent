package com.guang.webtest.factory;

import java.util.HashMap;
import java.util.Map;

import com.guang.webtest.bean.BaseBean;
import com.guang.webtest.bean.impl.BaseBeanImpl1;
import com.guang.webtest.bean.impl.BaseBeanImpl2;

public class InstanceBeanFactory {
	private Map<String, BaseBean> map;

	public InstanceBeanFactory() {
		super();
		map = new HashMap<>();
		map.put("base1", new BaseBeanImpl1());
		map.put("base2", new BaseBeanImpl2());
	}
	
	public BaseBean getBean(String name) {
		return map.get(name);
	}
	
}
