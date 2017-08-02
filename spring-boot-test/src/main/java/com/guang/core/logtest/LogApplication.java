package com.guang.core.logtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LogApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(LogApplication.class, args);
		SimpleService simpleService = (SimpleService) ctx.getBean("simpleService");
		simpleService.test(1);
		simpleService.core(2);
		simpleService.work(3);
	}
}
