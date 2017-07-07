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
import com.guang.mvnbook.account.service.SignUpRequest;

public class SignUpServlet extends HttpServlet{

	private static final long serialVersionUID = 976997591870605430L;
	private static Logger logger = LoggerFactory.getLogger(SignUpServlet.class);
	@Autowired
	private AccountService accountService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id").trim();
			String name = req.getParameter("name").trim();
			String email = req.getParameter("email").trim();
			String password = req.getParameter("password").trim();
			String confirmPassword = req.getParameter("confirm_password").trim();
			String captchaKey = req.getParameter("captcha_key").trim();
			String captchaValue = req.getParameter("captcha_value").trim();
			
			if (id==null||id.equals("")||name==null||name.equals("")||email==null||
					email.equals("")||password==null||password.equals("")||confirmPassword==null||
					confirmPassword.equals("")||captchaKey==null||captchaKey.equals("")||captchaValue==null||
					captchaValue.equals("")) {
				resp.sendError(400, "Parameter Incomplete.");
				return;
			}
			SignUpRequest signUpRequest = new SignUpRequest();
			signUpRequest.setId(id);
			signUpRequest.setName(name);
			signUpRequest.setEmail(email);
			signUpRequest.setPassword(password);
			signUpRequest.setConfirmPassword(confirmPassword);
			signUpRequest.setCaptchaKey(captchaKey);
			signUpRequest.setCaptchaValue(captchaValue);
			String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath();
			signUpRequest.setActivateServiceUrl(url+"/activate");
			/*System.out.println("serletContext.getRealPath:"+getServletContext().getRealPath("/"));
			System.out.println("req.getContextPath:"+req.getContextPath());
			System.out.println("req.getRequestURI:"+req.getRequestURI());
			System.out.println("req.getRequestURL:"+req.getRequestURL());
			System.out.println("req.getRemotePort:"+req.getRemotePort());
			System.out.println(req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath());*/
			accountService.signUp(signUpRequest);
			resp.getWriter().println("Account is created, please check your mail box for activation link.");
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
