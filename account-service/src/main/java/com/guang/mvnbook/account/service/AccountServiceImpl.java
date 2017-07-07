package com.guang.mvnbook.account.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.guang.mvnbook.account.captcha.AccountCaptchaException;
import com.guang.mvnbook.account.captcha.AccountCaptchaService;
import com.guang.mvnbook.account.captcha.RandomGenerator;
import com.guang.mvnbook.account.email.AccountEmailException;
import com.guang.mvnbook.account.email.AccountEmailService;
import com.guang.mvnbook.account.persist.Account;
import com.guang.mvnbook.account.persist.AccountPersistException;
import com.guang.mvnbook.account.persist.AccountPersistService;

public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountPersistService accountPesistService;
	@Autowired
	private AccountEmailService accountEmailService;
	@Autowired
	private AccountCaptchaService accountCaptchaService;
	private Map<String, String> activationMap = new HashMap<>();

	@Override
	public String generateCaptchaKey() throws AccountServiceException {
		try {
			return accountCaptchaService.generateCaptchaKey();
		} catch (AccountCaptchaException e) {
			throw new AccountServiceException("Unable to generate Captcha key.", e);
		}
	}

	@Override
	public byte[] generateCaptchaImage(String key) throws AccountServiceException {
		try {
			return accountCaptchaService.generateCaptchaImage(key);
		} catch (AccountCaptchaException e) {
			throw new AccountServiceException("Unable to generate Captcha Image.", e);
		}
	}

	@Override
	@Transactional(rollbackFor={Exception.class})
	public void signUp(SignUpRequest signUpRequest) throws AccountServiceException {
		try {
			//验证密码
			String password = signUpRequest.getPassword();
			String confirmPassword = signUpRequest.getConfirmPassword();
			if (password==null || !password.equals(confirmPassword)) {
				throw new AccountServiceException("2 passwords do not match.");
			}
			//验证码
			String key = signUpRequest.getCaptchaKey();
			String value = signUpRequest.getCaptchaValue();
			if(!accountCaptchaService.validateCaptcha(key, value)){
				throw new AccountServiceException( "Incorrect Captcha." );
			}
			//存储用户
			Account account = new Account();
			account.setId(signUpRequest.getId());
			account.setEmail(signUpRequest.getEmail());
			account.setName(signUpRequest.getName());
			account.setPassword(DigestUtils.md5Hex(password));
			account.setActivated("0");
			accountPesistService.createAccount(account);
			//发送激活码
			String activationId = RandomGenerator.getRandomString();
			activationMap.put(activationId, signUpRequest.getId());
			String link = signUpRequest.getActivateServiceUrl().endsWith("/")?
					signUpRequest.getActivateServiceUrl()+activationId :
						signUpRequest.getActivateServiceUrl()+"?key="+activationId;
			accountEmailService.sendMail(signUpRequest.getEmail(), "Please Activate Your Account", link);
		} catch (AccountCaptchaException e) {
			throw new AccountServiceException("Unable to validate captcha.", e);
		} catch (AccountPersistException e) {
			throw new AccountServiceException( "Unable to create account.", e );
		} catch (AccountEmailException e) {
			throw new AccountServiceException( "Unable to send actiavtion mail.", e );
		}
		
	}

	@Override
	public void activate(String activateNumber) throws AccountServiceException {
		try {
			String id = activationMap.get(activateNumber);
			if (id == null) {
				throw new AccountServiceException( "Invalid account activation ID." );
			}
			Account account = accountPesistService.getAccount(id);
			account.setActivated("1");
			accountPesistService.updateAccount(account);
		} catch (AccountPersistException e) {
			throw new AccountServiceException( "Unable to activate account." );
		}
		
	}

	@Override
	public void login(String id, String password) throws AccountServiceException {
		try {
			Account account = accountPesistService.getAccount(id);
			if (account == null) {
				throw new AccountServiceException( "Account does not exist." );
			}
			if (!account.getActivated().equals("1")) {
				throw new AccountServiceException( "Account is disabled." );
			}
			if (!account.getPassword().equals(DigestUtils.md5Hex(password))) {
				throw new AccountServiceException( "Incorrect password." );
			}
			System.out.println("login succeed");
		} catch (AccountPersistException e) {
			throw new AccountServiceException( "Unable to log in.", e );
		}
		
		
	}

}
