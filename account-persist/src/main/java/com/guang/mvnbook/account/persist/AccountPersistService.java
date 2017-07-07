package com.guang.mvnbook.account.persist;

/**
 * 
 * @comment �˻�ע�����
 * @author admin
 * @date 2016��4��8������3:39:21
 * @version 1.0.0
 */
public interface AccountPersistService {
	/**
	 * �����˻�
	 * @param account Ҫ�������˻�
	 * @return �������˻�
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016��4��8������3:42:37
	 * @since 1.0.0
	 */
	Account createAccount(Account account) throws AccountPersistException;
	/**
	 * ��ȡ�˻�
	 * @param id �˻�ID
	 * @return ��ȡ���˻�
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016��4��8������3:44:23
	 * @since 1.0.0
	 */
	Account getAccount(String id) throws AccountPersistException;
	/**
	 * �����˻�
	 * @param account Ҫ���µ��˻�
	 * @return ���º���˻�
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016��4��8������3:45:04
	 * @since 1.0.0
	 */
	Account updateAccount(Account account) throws AccountPersistException;
	/**
	 * ɾ���˻�
	 * @param id Ҫɾ�����˻�ID
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016��4��8������3:45:33
	 * @since 1.0.0
	 */
	void deleteAccount(String id) throws AccountPersistException;
	/**
	 * �������
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016��4��21������10:14:25
	 * @since 1.0.0
	 * @see
	 */
	void cleanAccount() throws AccountPersistException;

}
