package com.guang;

import org.springframework.boot.SpringApplication;

import com.guang.core.batch.Application;

public class Main {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run();

	}

}
