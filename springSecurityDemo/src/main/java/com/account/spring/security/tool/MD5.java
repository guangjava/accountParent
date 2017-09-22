package com.account.spring.security.tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5 {
	private static Logger log = LoggerFactory.getLogger(MD5.class);
	
	/**
     * Encodes the rawPass using a MessageDigest.
     * If a salt is specified it will be merged with the password before encoding.
     *
     * @param rawPass The plain text password
     * @param salt The salt to sprinkle
     * @return Hex string of password digest.
     */
	public static String encodePassword(String rawPass,Object salt) {
		String saltedPass = mergePasswordAndSalt(rawPass,salt,false);
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
			return new String(Hex.encode(digest));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			log.error("",e);
			return null;
		}
	}

	/**
     * Used to generate a merged password and salt <code>String</code>.<P>The generated password
     * will be in the form of <code>password{salt}</code>.</p>
     *  <p>A <code>null</code> can be passed to either method, and will be handled correctly. If the
     * <code>salt</code> is <code>null</code> or empty, the resulting generated password will simply be the passed
     * <code>password</code>. The <code>toString</code> method of the <code>salt</code> will be used to represent the
     * salt.</p>
     *
     * @param password the password to be used (can be <code>null</code>)
     * @param salt the salt to be used (can be <code>null</code>)
     * @param strict ensures salt doesn't contain the delimiters
     *
     * @return a merged password and salt <code>String</code>
     *
     * @throws IllegalArgumentException if the salt contains '{' or '}' characters.
     */
	private static String mergePasswordAndSalt(String password, Object salt, boolean strict) {
		if (password == null) password = "";
		if (strict && salt!=null) {
			if (salt.toString().indexOf("{")!=-1 || salt.toString().indexOf("}")!=-1) {
				throw new IllegalArgumentException("Cannot use { or } in salt.toString()");
			}
		}
		if (salt==null || "".equals(salt)) return password;
		else return password+"{"+salt.toString()+"}";
	}
}
