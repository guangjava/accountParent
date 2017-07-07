package com.guang.mvnbook.account.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.guang.mvnbook.account.service.AccountService;
import com.guang.mvnbook.account.service.AccountServiceException;

public class ActivateServlet extends HttpServlet{

	private static final long serialVersionUID = -6345019581226719161L;
	private static Logger logger = LoggerFactory.getLogger(ActivateServlet.class);
	@Autowired
	private AccountService accountService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key").trim();
		if (key==null || key.equals("")) {
			resp.sendError(400, "No activation key provided.");
			return;
		}
		try {
			accountService.activate(key);
			resp.getWriter().write( "Account is activated, now you can login." );
		} catch (AccountServiceException e) {
			logger.error("", e);
			resp.sendError(404, "Unable to activate account");
		}
	}
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

}
