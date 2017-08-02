package com.guang.webtest.aspect;

import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.util.StringUtils;

import com.guang.webtest.annotation.Log;

public class LogAutoConfig extends AbstractPointcutAdvisor{
	private static final long serialVersionUID = 5713470292218872784L;
	private Logger logger = LoggerFactory.getLogger(LogAutoConfig.class);
	private Pointcut pointcut;
	private Advice advice;
	String exclusion;
	String[] exclusionArr;
	public String getExclusion() {
		return exclusion;
	}
	public void setExclusion(String exclusion) {
		this.exclusion = exclusion;
	}
	public String[] getExclusionArr() {
		return exclusionArr;
	}
	public void init() {
		logger.info("init LogAutoConfiguration start");
		exclusionArr = StringUtils.split(exclusion, ",");
		pointcut = new AnnotationMatchingPointcut(null,Log.class);
		advice = new LogMethodInterceptor(exclusionArr);
		logger.info("init LogAutoConfiguration end");
	}
	@Override
	public Pointcut getPointcut() {
		return pointcut;
	}

	@Override
	public Advice getAdvice() {
		return advice;
	}

}
