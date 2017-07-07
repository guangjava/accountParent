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

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = -1326154349497416478L;
	private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	@Autowired
	private AccountService accountService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id").trim();
		String password = req.getParameter("password").trim();
		if (id==null||id.equals("")||password==null||password.equals("")) {
			resp.sendError( 400, "No activation key provided." );
            return;
		}
		try {
			accountService.login(id, password);
			resp.getWriter().print( "Login Successful!" );
		} catch (AccountServiceException e) {
			logger.error("", e);
			resp.sendError(404, e.getMessage());
		}
	}
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

}
