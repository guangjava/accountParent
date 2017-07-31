package com.guang.core.conditiononbean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.bind.PropertySourcesPropertyValues;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

@Configuration
public class MyAutoConfig {
	@Bean
	@ConditionalOnBean(annotation={MyAnnotation.class})
	public String abc(){
		return "abc";
	}
	public MyProperties buildMyProperties(ConfigurableEnvironment environment) {
		MyProperties myProperties = new MyProperties();
		if (environment != null) {
			MutablePropertySources propertySources = environment.getPropertySources();
			new RelaxedDataBinder(myProperties, "spring.my").bind(new PropertySourcesPropertyValues(propertySources));
		}
		return myProperties;
	}
}
