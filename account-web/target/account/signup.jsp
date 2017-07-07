<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.guang.mvnbook.account.service.*,
	org.springframework.context.ApplicationContext,
	org.springframework.web.context.support.WebApplicationContextUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Accont</title>
<link type="text/css" rel="stylesheet" href="css/text.css" />
</head>
<body>
	<%
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		AccountService accountService = (AccountService) ctx.getBean("accountService");
		String key = accountService.generateCaptchaKey();
	%>

	<div class="text-field">
		<h2>注册新账号</h2>
		<form action="signup" method="post">
			<label>账户id</label><input name="id" /><br /> <label>Email</label><input
				name="email" /><br /> <label>显示名称</label><input name="name" /><br />
			<label>密码</label><input name="password" type="password" /><br /> <label>确认密码</label><input
				name="confirm_password" type="password" /><br /> <label>验证码</label><input
				name="captcha_value" /><br /> <input type="hidden"
				name="captcha_key" value="<%=key%>" /> <img
				src="<%=request.getContextPath()%>/captcha_image?key=<%=key%>"
				alt="" onclick="" /><br />
			<button>确认并提交</button>
		</form>
	</div>
</body>
</html>