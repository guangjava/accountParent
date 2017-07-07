package com.guang.mvnbook.account.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @comment ��������MD5����
 * @author admin
 * @date 2016��4��12������3:39:44
 * @version 1.0.0
 */
public class MD5Utility {
	private static final Logger log = LoggerFactory.getLogger(MD5Utility.class);
	private static final char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9'
											,'A','B','C','D','E','F'};
	
	/**
	 * ����MD5����
	 * @param sourceStr Դ�ַ���
	 * @return MD5����
	 * @author admin
	 * @date 2016��4��12������3:40:22
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
	 * �ֽ�����ת�����ַ���<p>
	 * �����ֽ�����Ϊ������������Ҫ�ֱ���Ըߵ���λת����ʮ����������
	 * @param bytes �ֽ�����
	 * @return �ϳɵ��ַ���
	 * @author admin
	 * @date 2016��4��12������3:42:24
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
