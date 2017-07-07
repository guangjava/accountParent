package com.guang.mvnbook.account.service;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:account-*.xml"})
public class AccountServiceTest{
	private static Logger logger = LoggerFactory.getLogger(AccountServiceTest.class);
	@Autowired
	private AccountService accountService;
	@Test
	public void testGenerateCaptchaKey(){
		try {
			/*String[] resources = {"account-captcha.xml",
			"account-service.xml",
			"account-persist.xml",
			"account-persist-db.xml",
			"account-email.xml"};
			ApplicationContext ctx = new ClassPathXmlApplicationContext(resources);
			accountService = (AccountService) ctx.getBean("accountService");*/
			String key = accountService.generateCaptchaKey();
			System.out.println(key);
		} catch (Exception e) {
			logger.error("",e);
		}
	}

	@Test
	public void testGenerateCaptchaImage() {
		try {
			String key = accountService.generateCaptchaKey();
			System.out.println(key);
			byte[] image = accountService.generateCaptchaImage(key);
			
			File file = new File("d:/testData/test.jpg");
			FileOutputStream os = new FileOutputStream(file);
			os.write(image);
			os.flush();
			os.close();
		} catch (Exception e) {
			logger.error("",e);
		} 
	}

	@Test
	public void testSignUp() {
		try {
			SignUpRequest request = new SignUpRequest();
			String captchaKey = accountService.generateCaptchaKey();
			String captchaValue = "13479";
			request.setActivateServiceUrl("test");
			request.setCaptchaKey(captchaKey);
			request.setCaptchaValue(captchaValue);
			request.setPassword("abcd");
			request.setConfirmPassword("abcd");
			request.setEmail("418204356@qq.com");
			request.setId("id1");
			request.setName("name");
			
			accountService.signUp(request);
		} catch (AccountServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testActivate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testLogin() {
		try {
			String id = "id";
			String password = "abcd";
			String md5 = DigestUtils.md5Hex(password);
			accountService.login(id, md5);
		} catch (AccountServiceException e) {
			logger.error("",e);
		}
	}

}
