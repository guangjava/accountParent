package com.guang.mvnbook.account.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @comment 用来生成MD5编码
 * @author admin
 * @date 2016年4月12日下午3:39:44
 * @version 1.0.0
 */
public class MD5Utility {
	private static final Logger log = LoggerFactory.getLogger(MD5Utility.class);
	private static final char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9'
											,'A','B','C','D','E','F'};
	
	/**
	 * 进行MD5编码
	 * @param sourceStr 源字符串
	 * @return MD5编码
	 * @author admin
	 * @date 2016年4月12日下午3:40:22
	 * @since 1.0.0
	 */
	public static String getMD5Code(String sourceStr){
		try {
			String resultStr = new String();
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultStr = byte2String(md.digest(sourceStr.getBytes()));
			return resultStr;
		} catch (NoSuchAlgorithmException e) {
			log.error("MD5 Error", e);
			return null;
		}
	}
	
	/**
	 * 字节数组转化成字符串<p>
	 * 这里字节数据为二进制数，需要分别针对高低四位转化成十六进制数字
	 * @param bytes 字节数组
	 * @return 合成的字符串
	 * @author admin
	 * @date 2016年4月12日下午3:42:24
	 * @since 1.0.0
	 */
	private static String byte2String(byte[] bytes){
		StringBuffer strBuffer = new StringBuffer();
		
		for(int i=0;i<bytes.length;i++){
			strBuffer.append(hexDigits[bytes[i]>>>4&0xf]);
			strBuffer.append(hexDigits[bytes[i]&0xf]);
		}
		
		return strBuffer.toString();
	}

}
