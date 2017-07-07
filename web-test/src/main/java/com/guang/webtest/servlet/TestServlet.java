package com.guang.webtest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.guang.webtest.service.SystemService;

public class TestServlet extends HttpServlet{

	private static final long serialVersionUID = -7933044470608861147L;
	@Autowired
	@Qualifier("systemService")
	private SystemService systemService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		systemService.printKeyLoadMessage();
		systemService.printSubService();
	}
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

}
