package com.guang.mvnbook.account.captcha;

import java.util.List;

/**
 * @comment 生成验证码服务
 * @author zhouchenguang
 * @date 2016年4月26日下午3:13:52
 * @version 1.0.0
 */
public interface AccountCaptchaService {
	/**
	 * @return 生成随机验证码主键
	 * @throws AccountCaptchaException
	 * @author admin
	 * @date 2016年4月26日下午3:15:00
	 * @since 1.0.0
	 */
	String generateCaptchaKey() throws AccountCaptchaException;
	/**
	 * @param key 验证码主键
	 * @return 根据主键生成验证码
	 * @throws AccountCaptchaException
	 * @author admin
	 * @date 2016年4月26日下午3:15:29
	 * @since 1.0.0
	 */
	byte[] generateCaptchaImage(String key) throws AccountCaptchaException;
	/** 对用户输入进行验证
	 * @param key 主键
	 * @param captchaValue 用户输入验证码
	 * @return 是否匹配
	 * @throws AccountCaptchaException
	 * @author zhouchenguang
	 * @date 2016年4月26日下午3:18:47
	 * @since 1.0.0
	 */
	boolean validateCaptcha(String key,String captchaValue) throws AccountCaptchaException;
	/**
	 * @return 预先定义验证码内容
	 * @author zhouchenguang
	 * @date 2016年4月26日下午3:19:51
	 * @since 1.0.0
	 */
	List<String> getPreDefinedTexts();
	/**
	 * @param texts 预先定义验证码内容
	 * @author zhouchenguang
	 * @date 2016年4月26日下午3:20:30
	 * @since 1.0.0
	 */
	void setPreDefinedTexts(List<String> texts);

}
