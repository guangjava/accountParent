package com.guang.webtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guang.webtest.service.SystemService;

@Controller
public class TestController {
//	@Autowired
	private SystemService systemService;
	
	@RequestMapping("/test")
	public void a(){
		systemService.printKeyLoadMessage();
		systemService.printSubService();
		PlatformTransactionManager manager;
	}
	
	@RequestMapping("/print")
	public void printOk(){
		systemService.printSubService();
	}
}
