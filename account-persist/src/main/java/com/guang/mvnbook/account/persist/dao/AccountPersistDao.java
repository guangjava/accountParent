package com.guang.mvnbook.account.persist.dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.mybatis.spring.SqlSessionTemplate;

import com.guang.mvnbook.account.persist.Account;
import com.guang.mvnbook.account.persist.AccountPersistException;
import com.guang.mvnbook.account.persist.AccountPersistService;

public class AccountPersistDao implements AccountPersistService{
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}

	@Override
	public Account createAccount(Account account) throws AccountPersistException {
		if(getAccount(account.getId())!=null){
			return null;
		}
		String password = DigestUtils.md5Hex(account.getPassword());
		account.setPassword(password);
		session.insert("com.guang.mvnbook.account.persist.Account.createAccount", account);
		return account;
	}

	@Override
	public Account getAccount(String id) throws AccountPersistException {
		return session.selectOne("com.guang.mvnbook.account.persist.Account.getAccount", id);
	}

	@Override
	public Account updateAccount(Account account) throws AccountPersistException {
		session.update("com.guang.mvnbook.account.persist.Account.updateAccount", account);
		return account;
	}

	@Override
	public void deleteAccount(String id) throws AccountPersistException {
		session.delete("com.guang.mvnbook.account.persist.Account.deleteAccount", id);
		
	}

	@Override
	public void cleanAccount() throws AccountPersistException {
		session.delete("com.guang.mvnbook.account.persist.Account.cleanAccount");
		
	}
	
	

}
