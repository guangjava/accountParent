package com.account.spring.security.tool;

public final class Hex {
	private static final char[] Hex = {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
	};
	
	public static char[] encode(byte[] bytes) {
		final int nBytes = bytes.length;
		char[] result = new char[nBytes*2];
		int j = 0;
		for (int i = 0; i < nBytes; i++) {
			// Char for top 4 bits
			result[j++] = Hex[(bytes[i]&0xF0) >>> 4];
			// Bottom 4
			result[j++] = Hex[bytes[i]&0x0F];
		}
		return result;
	}
}
