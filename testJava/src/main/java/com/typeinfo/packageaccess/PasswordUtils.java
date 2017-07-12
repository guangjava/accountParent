package com.typeinfo.packageaccess;

import java.util.List;

import com.typeinfo.interfacea.UserCase;

public class PasswordUtils {
	@UserCase(id=47, description = "Password must contain at least one numeric")
	boolean validatePassword(String password){
		return password.matches("\\w*\\d\\w*");
	}
	@UserCase(id=48)
	String encryptPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	@UserCase(id=49,description = "New passwords can't equal previously used ones")
	boolean checkForNewPassword(List<String> prevPasswords,String password){
		return !prevPasswords.contains(password);
	}
}
