package com.guang.mvnbook.account.persist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guang.mvnbook.account.utils.MD5Utility;

/**
 * 
 * @comment AccountPersistServiceImpl�Ĳ�����
 * @author admin
 * @date 2016��4��11������1:39:08
 * @version 1.0.0
 * @see AccountPersistServiceImpl
 */
public class AccountPersistServiceTest {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(AccountPersistServiceTest.class);
	private AccountPersistService accountPersistService;

	/**
	 * ��ִ�в�������ǰִ�У����ȼ������ļ��Ƿ���ڣ�������ɾ����<p>
	 * ����ʹ��account-persist.xml�����ļ���ʼ��SpringFramework��IoC�������ٴ������л�ȡҪ���Ե�AccountPersistService����<p>
	 * Ȼ���½�һ��Account���󣬲����г־û���
	 * @throws Exception
	 * @author admin
	 * @date 2016��4��11������2:15:58
	 * @since 1.0.0
	 */
	@Before
	public void setUp() throws Exception {
		
		String[] resources = {"account-persist.xml",
								"account-persist-db.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resources);
		accountPersistService = (AccountPersistService) ctx.getBean("accountPersistService1");
		
		accountPersistService.cleanAccount();
		Account account = new Account();
		
		account.setId("001");
		account.setName("admin");
		account.setPassword(MD5Utility.getMD5Code("admin"));
		account.setEmail("admin@localhost.cn");
		account.setActivated("1");
		
		accountPersistService.createAccount(account);
		
		((ConfigurableApplicationContext)ctx).close();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	/**
	 * ����AccountPersistService��createAccount����
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016��4��11������2:23:25
	 * @since 1.0.0
	 * @see AccountPersistService#createAccount(Account)
	 */
	@Test
	public void testCreateAccount() throws AccountPersistException {
		Account account = new Account();
		
		account.setId("002");
		account.setName("guang");
		account.setPassword(MD5Utility.getMD5Code("guang"));
		account.setEmail("guang@localhost.cn");
		account.setActivated("1");
		
		accountPersistService.createAccount(account);
		
		assertNotNull(accountPersistService.getAccount("002"));
	}

	/**
	 * ����getAccount����
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016��4��11������2:30:10
	 * @since 1.0.0
	 */
	@Test
	public void testGetAccount() throws AccountPersistException {
		Account account = accountPersistService.getAccount("001");
		
		assertEquals(account.getId(),"001");
		assertEquals(account.getName(),"admin");
		assertEquals(account.getPassword(),MD5Utility.getMD5Code("admin"));
		assertEquals(account.getEmail(),"admin@localhost.cn");
		assertEquals(account.getActivated(),"1");
		
	}

	/**
	 * ��updateAccount�����Ĳ���
	 * @throws AccountPersistException
	 * @author admin
	 * @date 2016��4��11������2:38:49
	 * @since 1.0.0
	 */
	@Test
	public void testUpdateAccount() throws AccountPersistException {
		Account accountA = accountPersistService.getAccount("001");
		
		accountA.setName("mike");
		accountA.setPassword(MD5Utility.getMD5Code("mike"));
		accountA.setEmail("mike@localhost.cn");
		accountA.setActivated("0");
		
		accountPersistService.updateAccount(accountA);
		
		Account accountB = accountPersistService.getAccount("001");
		
		assertEquals(accountB.getName(),"mike");
		assertEquals(accountB.getPassword(),MD5Utility.getMD5Code("mike"));
		assertEquals(accountB.getEmail(),"mike@localhost.cn");
		assertEquals(accountB.getActivated(),"0");
	}

	@Test
	public void testDeleteAccount() throws AccountPersistException {
		assertNotNull(accountPersistService.getAccount("001"));
		
		accountPersistService.deleteAccount("001");
		
		assertNull(accountPersistService.getAccount("001"));
	}

}
