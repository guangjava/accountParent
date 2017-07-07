package com.guang.mvnbook.account.captcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

public class AccountCaptchaServiceImpl implements AccountCaptchaService,InitializingBean{
	private static Logger log = LoggerFactory.getLogger(AccountCaptchaServiceImpl.class);
	private DefaultKaptcha producer;
	private List<String> preDefinedTexts;
	private Map<String,String> captchaMap;
	private int textCount = 0;

	public AccountCaptchaServiceImpl() {
		captchaMap = new HashMap<String,String>();
	}

	@Override
	public String generateCaptchaKey() throws AccountCaptchaException {
		String key = RandomGenerator.getRandomString();
		String value = generateKaptchaText();
		captchaMap.put(key, value);
		return key;
	}

	@Override
	public byte[] generateCaptchaImage(String key) throws AccountCaptchaException {
		String text = captchaMap.get(key);
		if(text==null){
			throw new AccountCaptchaException("The captcha key "+key+" not found");
		}
		BufferedImage image = producer.createImage(text);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "jpg", out);
		} catch (IOException e) {
			log.error("",e);
			throw new AccountCaptchaException("image build error",e);
		}
		return out.toByteArray();
	}

	@Override
	public boolean validateCaptcha(String key, String captchaValue) throws AccountCaptchaException {
		String text = captchaMap.get(key);
		if(text==null){
			throw new AccountCaptchaException("The captcha key "+key+" not found");
		}
		if(text.equals(captchaValue)){
			captchaMap.remove(key);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<String> getPreDefinedTexts() {
		return preDefinedTexts;
	}

	@Override
	public void setPreDefinedTexts(List<String> texts) {
		this.preDefinedTexts = texts;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		producer = new DefaultKaptcha();
		producer.setConfig(new Config(new Properties()));
	}
	
	private String generateKaptchaText(){
		String text = null;
		if(preDefinedTexts!=null && !preDefinedTexts.isEmpty()){
			text = preDefinedTexts.get(textCount);
			textCount = (textCount+1)%preDefinedTexts.size();
			return text;
		}
		return producer.createText();
	}

}
