package com.guang.mvnbook.account.captcha;

import java.util.Random;

/**
 * @comment 生成随机字符串
 * @author zhouchenguang
 * @date 2016年4月26日下午4:11:57
 * @version 1.0.0
 */
public class RandomGenerator {
	private static String range = "1234567890abcdefghijklmnopqrstuvwxyz";
	
	/**本方法为静态方法且线程安全，生成长度为8的随机字符串
	 * @return 长度8随机字符串，字母数字组合
	 * @author zhouchenguang
	 * @date 2016年4月26日下午3:46:32
	 * @since 1.0.0
	 */
	public static synchronized String getRandomString(){
		String result = null;
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<8;i++){
			
			sb.append(range.charAt(random.nextInt(range.length())));
		}
		result = new String(sb);
		return result;
	}

}
