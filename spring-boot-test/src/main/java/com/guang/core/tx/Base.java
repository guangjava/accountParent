package com.guang.core.tx;

import org.springframework.transaction.annotation.Transactional;

public class Base {
	@Transactional(value="transactionManager1")
	public void save() {
		
	}
}
