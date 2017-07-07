package com.guang.mvnbook.account.utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @comment ����MD5������
 * @author admin
 * @date 2016��4��12������3:48:10
 * @version 1.0.0
 * @see MD5Utility
 */
public class MD5UtilityTest {

	/**
	 * 
	 * 
	 * @author admin
	 * @date 2016��4��12������3:48:45
	 * @since 1.0.0
	 * @see
	 */
	@Test
	public void testGetMD5Code() {
		String result = MD5Utility.getMD5Code("hello");
		assertEquals("5D41402ABC4B2A76B9719D911017C592",result);
	}

}
