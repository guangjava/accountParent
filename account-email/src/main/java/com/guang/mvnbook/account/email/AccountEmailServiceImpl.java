package com.guang.mvnbook.account.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 
 * @comment 发送邮件服务
 * @author admin
 * @date 2016年3月31日上午10:17:03
 * @version 1.0.0
 * @see AccountEmailService
 */
public class AccountEmailServiceImpl implements AccountEmailService{

	
	private Logger log = LoggerFactory.getLogger(AccountEmailServiceImpl.class);
	
	private JavaMailSender javaMailSender;
	/**
	 * 系统邮箱
	 */
	private String systemEmail;
	
	@Override
	public void sendMail(String to, String subject, String htmlText) throws AccountEmailException {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		
		try {
			helper.setFrom(systemEmail);
			helper.setTo(to);
			helper.setSubject(subject);
			//邮件格式为HTML格式
			helper.setText(htmlText,true);
			
			javaMailSender.send(msg);
		} catch (MessagingException e) {
			
			log.error("Email wrong",e);
			
			throw new AccountEmailException("Failed to send mail",e);
		}
		
	}
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public String getSystemEmail() {
		return systemEmail;
	}
	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}

}
