package com.guang.core.batch;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class Application {
	@Autowired
	private JobBuilderFactory jobs;
	@Autowired
	private StepBuilderFactory steps;
	public void write(List<? extends String> list) {
		
	}
}
