package com.guang.mvnbook.account.email;

/**
 * 
 * @comment 发送邮件服务
 * @author admin
 * @date 2016年3月31日上午10:14:40
 * @version 1.0.0
 */
public interface AccountEmailService {
	/**
	 * 发送HTML格式的email
	 * @param to 收件地址
	 * @param subject 邮件主题
	 * @param htmlText 正文内容
	 * @throws AccountEmailException 邮件出错，抛出异常
	 * @author admin
	 * @date 2016年3月30日下午4:22:20
	 * @since 1.0.0
	 */
	void sendMail(String to,String subject,String htmlText) throws AccountEmailException;

}
