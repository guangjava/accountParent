package com.guang.core.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class Application {
	@Autowired
	private JobBuilderFactory jobs;
	@Autowired
	private StepBuilderFactory steps;
	public void name() {
		ItemReader<String> reader = null;
		ItemWriter<String> writer = new UserWriter();
		steps.get("test-step").chunk(2).reader(reader).faultTolerant().skipLimit(Integer.MAX_VALUE).skip(Exception.class).retryLimit(3).retry(Exception.class).build();
	}
}
