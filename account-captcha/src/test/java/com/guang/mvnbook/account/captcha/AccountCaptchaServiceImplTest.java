package com.guang.mvnbook.account.captcha;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountCaptchaServiceImplTest {
	private static Logger log = LoggerFactory.getLogger(AccountCaptchaServiceImplTest.class);
	private ApplicationContext ctx;
	private AccountCaptchaService captchaService;
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("account-captcha.xml");
		captchaService = (AccountCaptchaService) ctx.getBean("accountCaptchaService");
	}

	@Test
	public void testGenerateCaptchaImage() throws AccountCaptchaException {
		String key = captchaService.generateCaptchaKey();
		byte[] image = captchaService.generateCaptchaImage(key);
		
		assertTrue(image.length>0);
		
		File file = null;
		FileOutputStream os = null;
		try {
			file = new File("target/"+key+".jpg");
			os = new FileOutputStream(file);
			
			os.write(image);
			os.flush();
			
			os.close();
		} catch (FileNotFoundException e) {
			log.error("",e);
		} catch (IOException e) {
			log.error("",e);
		}
		assertTrue(file.exists() && file.length()>0);
	}

	@Test
	public void testValidateCaptcha() throws Exception{
		List<String> list = new ArrayList<String>();
		list.add("12345");
		list.add("abcde");
		captchaService.setPreDefinedTexts(list);
		
		String key = captchaService.generateCaptchaKey();
		captchaService.generateCaptchaImage(key);
		assertTrue(captchaService.validateCaptcha(key, "12345"));
		
		key = captchaService.generateCaptchaKey();
		captchaService.generateCaptchaImage(key);
		assertFalse(captchaService.validateCaptcha(key, "12345"));
	}

}
