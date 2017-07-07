package com.guang.mvnbook.account.service;

public interface AccountService {
	String generateCaptchaKey() throws AccountServiceException;
	byte[] generateCaptchaImage(String key) throws AccountServiceException;
	void signUp(SignUpRequest signUpRequest) throws AccountServiceException;
	void activate(String activateNumber) throws AccountServiceException;
	void login(String id,String password) throws AccountServiceException;
}
