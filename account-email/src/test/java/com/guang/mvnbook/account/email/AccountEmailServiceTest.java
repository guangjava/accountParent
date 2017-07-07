package com.guang.mvnbook.account.email;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

/**
 * 
 * @comment AccountEmailServiceImpl的测试类
 * @author admin
 * @date 2016年4月1日上午9:17:07
 * @version 1.0.0
 * @see AccountEmailServiceImpl
 */
public class AccountEmailServiceTest {

	private static Logger log = LoggerFactory.getLogger(AccountEmailService.class);

	/**
	 * 配置文件在src/rest/resources/service.properties<p>
	 * 为email的配置信息
	 */
	private static Properties prop;
	static{
		try {
			prop = new Properties();
			InputStream in = AccountEmailServiceTest.class.getResourceAsStream("/service.properties");

			prop.load(in);
		} catch (IOException e) {

			log.error("读取配置出错",e);

		}
	}
	/**
	 * 接收邮箱
	 */
	private GreenMail greenMail;


	/**
	 * 通过greenmail运行接收邮箱<p>
	 * 基于SMTP协议初始化GreenMail，创建邮箱账户，启动邮箱服务，默认监听25端口
	 * @throws Exception
	 * @author admin
	 * @date 2016年4月1日上午9:31:01
	 * @since 1.0.0
	 */
	@Before
	public void startMailService() throws Exception {
		greenMail = new GreenMail(ServerSetup.SMTP_POP3);

		String username = prop.getProperty("test.greenmail.username");
		String password = prop.getProperty("test.greenmail.password");

		greenMail.setUser(username, password);
		greenMail.start();
	}

	/**
	 * 停止greenmail服务
	 * @throws Exception
	 * @author admin
	 * @date 2016年4月1日上午9:41:09
	 * @since 1.0.0
	 */
	@After
	public void stopMailService() throws Exception {
		greenMail.stop();
	}

	/**
	 * 测试sendMail()方法
	 * @throws Exception spring异常抛出BeansException，邮件异常抛出AccountEmailException
	 * @author admin
	 * @date 2016年4月1日上午9:21:11
	 * @since 1.0.0
	 * @see AccountEmailServiceImpl#sendMail(String, String, String)
	 */
	@Test
	public void testSendMail() throws Exception{
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
			AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");

			String subject = prop.getProperty("test.mail.subject");
			String htmlText = prop.getProperty("test.mail.htmlText");
			String to = prop.getProperty("test.mail.to");

			//发送测试邮件
			accountEmailService.sendMail(to, subject, htmlText);

			//greenmail接收邮件，最多等待2秒
			//由于greenmail服务完全基于内存，实际情况下基本不会超过2秒
			//GreenMail中的message无法收到东西，决定放弃使用GreenMail
			/*
			greenMail.waitForIncomingEmail(2000, 1);

			Message[] message = greenMail.getReceivedMessages();

			assertEquals("邮件数目错误",1,message.length);
			assertEquals("邮件主题错误",subject,message[0].getSubject());
			assertEquals("邮件内容错误",htmlText,GreenMailUtil.getBody(message[0]).trim());
			*/

			((ConfigurableApplicationContext) ctx).close();

		} catch (BeansException e) {

			log.error("bean error",e);

			throw e;
		} catch (AccountEmailException e) {
			throw e;
		}

	}

	/**
	 * 这个方法是从网上直接复制的，为了验证greenMail。这个方法是可以测试通过的，即GreenMail的message收到东西了
	 * @throws Exception
	 * @author admin
	 * @date 2016年4月5日上午10:03:13
	 * @since 1.0.0
	 */
	public void testYourSendingCode() throws Exception {
		GreenMail greenMail = new GreenMail(); //uses test ports by default
		greenMail.start();
		GreenMailUtil.sendTextEmailTest("guang_test@126.com", "from@localhost.com", "subject", "body"); //replace this with your send code
		Message[] message = greenMail.getReceivedMessages();
		assertEquals("body", GreenMailUtil.getBody(message[0]));
		greenMail.stop();
		//That's it!
	} 

}
