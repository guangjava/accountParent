package com.guang.mvnbook.account.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.guang.mvnbook.account.service.AccountService;
import com.guang.mvnbook.account.service.AccountServiceException;

public class CaptchaImageServlet extends HttpServlet{

	private static final long serialVersionUID = -2229575335272321921L;
	private static Logger logger = LoggerFactory.getLogger(CaptchaImageServlet.class);
	private AccountService accountService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key").trim();
		if (key==null || key.equals("")) {
			resp.sendError(400, "No Captcha Key Found");
			return;
		}
		try {
			resp.setContentType("image/jpeg");
			OutputStream os = resp.getOutputStream();
			byte[] image = accountService.generateCaptchaImage(key);
			os.write(image);
			os.close();
		} catch (AccountServiceException e) {
			logger.error("",e);
			resp.sendError(404, e.getMessage());
		}
	}
	@Override
	public void init() throws ServletException {
		super.init();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		accountService = (AccountService) ctx.getBean("accountService");
	}

}
