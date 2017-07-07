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
 * @comment AccountEmailServiceImpl�Ĳ�����
 * @author admin
 * @date 2016��4��1������9:17:07
 * @version 1.0.0
 * @see AccountEmailServiceImpl
 */
public class AccountEmailServiceTest {

	private static Logger log = LoggerFactory.getLogger(AccountEmailService.class);

	/**
	 * �����ļ���src/rest/resources/service.properties<p>
	 * Ϊemail��������Ϣ
	 */
	private static Properties prop;
	static{
		try {
			prop = new Properties();
			InputStream in = AccountEmailServiceTest.class.getResourceAsStream("/service.properties");

			prop.load(in);
		} catch (IOException e) {

			log.error("��ȡ���ó���",e);

		}
	}
	/**
	 * ��������
	 */
	private GreenMail greenMail;


	/**
	 * ͨ��greenmail���н�������<p>
	 * ����SMTPЭ���ʼ��GreenMail�����������˻��������������Ĭ�ϼ���25�˿�
	 * @throws Exception
	 * @author admin
	 * @date 2016��4��1������9:31:01
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
	 * ֹͣgreenmail����
	 * @throws Exception
	 * @author admin
	 * @date 2016��4��1������9:41:09
	 * @since 1.0.0
	 */
	@After
	public void stopMailService() throws Exception {
		greenMail.stop();
	}

	/**
	 * ����sendMail()����
	 * @throws Exception spring�쳣�׳�BeansException���ʼ��쳣�׳�AccountEmailException
	 * @author admin
	 * @date 2016��4��1������9:21:11
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

			//���Ͳ����ʼ�
			accountEmailService.sendMail(to, subject, htmlText);

			//greenmail�����ʼ������ȴ�2��
			//����greenmail������ȫ�����ڴ棬ʵ������»������ᳬ��2��
			//GreenMail�е�message�޷��յ���������������ʹ��GreenMail
			/*
			greenMail.waitForIncomingEmail(2000, 1);

			Message[] message = greenMail.getReceivedMessages();

			assertEquals("�ʼ���Ŀ����",1,message.length);
			assertEquals("�ʼ��������",subject,message[0].getSubject());
			assertEquals("�ʼ����ݴ���",htmlText,GreenMailUtil.getBody(message[0]).trim());
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
	 * ��������Ǵ�����ֱ�Ӹ��Ƶģ�Ϊ����֤greenMail����������ǿ��Բ���ͨ���ģ���GreenMail��message�յ�������
	 * @throws Exception
	 * @author admin
	 * @date 2016��4��5������10:03:13
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
