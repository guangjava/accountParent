package com.guang.mvnbook.account.persist;

/**
 * 
 * @comment 账户注册服务
 * @author admin
 * @date 2016年4月8日下午3:39:21
 * @version 1.0.0
 */
public interface AccountPersistService {
	/**
	 * 创建账户
	 * @param account 要创建的账户
	 * @return 创建的账户
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016年4月8日下午3:42:37
	 * @since 1.0.0
	 */
	Account createAccount(Account account) throws AccountPersistException;
	/**
	 * 读取账户
	 * @param id 账户ID
	 * @return 读取的账户
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016年4月8日下午3:44:23
	 * @since 1.0.0
	 */
	Account getAccount(String id) throws AccountPersistException;
	/**
	 * 更新账户
	 * @param account 要更新的账户
	 * @return 更新后的账户
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016年4月8日下午3:45:04
	 * @since 1.0.0
	 */
	Account updateAccount(Account account) throws AccountPersistException;
	/**
	 * 删除账户
	 * @param id 要删除的账户ID
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016年4月8日下午3:45:33
	 * @since 1.0.0
	 */
	void deleteAccount(String id) throws AccountPersistException;
	/**
	 * 清空数据
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016年4月21日上午10:14:25
	 * @since 1.0.0
	 * @see
	 */
	void cleanAccount() throws AccountPersistException;

}
