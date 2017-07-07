package com.guang.core.tx;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
	@Bean
	public PlatformTransactionManager transactionManager1(EntityManagerFactory entityManagerFactory){
		return new JpaTransactionManager(entityManagerFactory);
	}
	@Bean
	public PlatformTransactionManager transactionManager2(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
