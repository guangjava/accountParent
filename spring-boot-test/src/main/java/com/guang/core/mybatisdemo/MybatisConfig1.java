package com.guang.core.mybatisdemo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig1 {
	@Bean(name="sqlSessionFacotry1")
	public SqlSessionFactory sqlSessionFactory1(DataSource dataSource1) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		sessionFactoryBean.setConfiguration(configuration);
		sessionFactoryBean.setDataSource(dataSource1);
		sessionFactoryBean.setTypeAliasesPackage("com.guang.core.mybatisdemo.domain");
		return sessionFactoryBean.getObject();
	}
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(SqlSessionFactory sqlSessionFactory1) {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory1");
		mapperScannerConfigurer.setBasePackage("com.guang.core.mybatisdemo.mapper");
		return mapperScannerConfigurer;
	}
}
