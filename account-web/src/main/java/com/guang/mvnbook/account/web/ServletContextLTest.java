package com.guang.mvnbook.account.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ServletContextLTest implements ServletContextListener{

	private Logger log = LoggerFactory.getLogger(ServletContextLTest.class);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sct=sce.getServletContext();   
		sct.setAttribute("ab", "att");
		log.info("======listener test is beginning=========");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
//		log.info("this is last destroyeed"); 
		ServletContext sct = sce.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sct);
	}

}
