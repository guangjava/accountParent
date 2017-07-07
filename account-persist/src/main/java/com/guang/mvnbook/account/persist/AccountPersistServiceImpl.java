package com.guang.mvnbook.account.persist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @comment 负责账户数据持久化，以XML文件格式保存用户数据，并支持账户创建、读取、更新、删除等操作
 * @author admin
 * @date 2016年4月8日下午4:06:22
 * @version 1.0.0
 * @see AccountPersistService
 */
public class AccountPersistServiceImpl implements AccountPersistService{
	private static final String ELEMENT_ROOT = "account-persist";
	private static final String ELEMENT_ACCOUNTS = "accounts";
	private static final String ELEMENT_ACCOUNT = "account";
	private static final String ELEMENT_ACCOUNT_ID = "id";
	private static final String ELEMENT_ACCOUNT_NAME = "name";
	private static final String ELEMENT_ACCOUNT_EMAIL = "email";
	private static final String ELEMENT_ACCOUNT_PASSWORD = "password";
	private static final String ELEMENT_ACCOUNT_ACTIVATED = "activated";

	private Logger log = LoggerFactory.getLogger(AccountPersistServiceImpl.class);

	private String file;
	private SAXReader reader = new SAXReader();

	@Override
	public Account createAccount(Account account) throws AccountPersistException {
		Document doc = readDocument();
		Element accountsEle = doc.getRootElement().element(ELEMENT_ACCOUNTS);
		Element element = buildAccountElement(account);

		accountsEle.add(element);

		writeDocument(doc);

		return account;
	}

	/**
	 * 如果查询不到，返回null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Account getAccount(String id) throws AccountPersistException {
		Document doc = readDocument();
		Element accountsEle = doc.getRootElement().element(ELEMENT_ACCOUNTS);

		for(Iterator<Element> it = accountsEle.elementIterator();it.hasNext();){
			Element element = it.next();
			if(element.elementText(ELEMENT_ACCOUNT_ID).equals(id)){
				return buildAccount(element);
			}
		}
		return null;
	}

	/**
	 * 如果在文档中查不到原纪录，则更新失败，返回null
	 */
	@Override
	public Account updateAccount(Account account) throws AccountPersistException {
		String id = account.getId();

		if(getAccount(id) != null){
			deleteAccount(id);

			createAccount(account);

			return account;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteAccount(String id) throws AccountPersistException {
		Document doc = readDocument();
		Element accountsEle = doc.getRootElement().element(ELEMENT_ACCOUNTS);

		for(Iterator<Element> it = accountsEle.elementIterator();it.hasNext();){
			Element element = it.next();

			if(element.elementText(ELEMENT_ACCOUNT_ID).equals(id)){
				accountsEle.remove(element);

				writeDocument(doc);
				return;
			}
		}

	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * 根据XML元素创建Account对象
	 * @param element XML元素
	 * @return 创建的Account对象
	 * @author admin
	 * @date 2016年4月8日下午4:41:30
	 * @since 1.0.0
	 */
	private Account buildAccount(Element element){
		Account account = new Account();

		account.setId(element.elementText(ELEMENT_ACCOUNT_ID));
		account.setName(element.elementText(ELEMENT_ACCOUNT_NAME));
		account.setEmail(element.elementText(ELEMENT_ACCOUNT_EMAIL));
		account.setPassword(element.elementText(ELEMENT_ACCOUNT_PASSWORD));
		account.setActivated(element.elementText(ELEMENT_ACCOUNT_ACTIVATED));

		return account;
	}

	/**
	 * 根据Account对象创建XML元素
	 * @param account Account对象
	 * @return 创建的XML元素
	 * @author admin
	 * @date 2016年4月8日下午4:50:17
	 * @since 1.0.0
	 */
	private Element buildAccountElement(Account account){
		Element element = DocumentFactory.getInstance().createElement(ELEMENT_ACCOUNT);

		element.addElement(ELEMENT_ACCOUNT_ID).setText(account.getId());
		element.addElement(ELEMENT_ACCOUNT_NAME).setText(account.getName());
		element.addElement(ELEMENT_ACCOUNT_EMAIL).setText(account.getEmail());
		element.addElement(ELEMENT_ACCOUNT_PASSWORD).setText(account.getPassword());
		element.addElement(ELEMENT_ACCOUNT_ACTIVATED).setText(account.getActivated());

		return element;
	}

	/**
	 * 存储XML文件
	 * @param doc XML文件
	 * @throws AccountPersistException 封装的IOException
	 * @author admin
	 * @date 2016年4月8日下午5:11:32
	 * @since 1.0.0
	 */
	private void writeDocument(Document doc) throws AccountPersistException{
		Writer out = null;

		try {
			out = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			XMLWriter writer = new XMLWriter(out,OutputFormat.createPrettyPrint());

			writer.write(doc);
		}  catch (IOException e) {
			log.error("Unable to write persist data XML", e);
			throw new AccountPersistException("Unable to write persist data XML",e);
		}  finally{
			try {
				if(out != null){
					out.close();
				}
			} catch (IOException e) {
				log.error("Unable to close persist data XML writer", e);
				throw new AccountPersistException("Unable to close persist data XML writer",e);
			}
		}
	}

	/**
	 * 读取XML文件
	 * @return 读取的XML文件
	 * @throws AccountPersistException 封装的writeDocument抛出的异常和DocumentException
	 * @author admin
	 * @date 2016年4月8日下午5:32:03
	 * @since 1.0.0
	 */
	private Document readDocument() throws AccountPersistException{
		File dataFile = new File(file);

		if(!dataFile.exists()){
			dataFile.getParentFile().mkdirs();

			Document doc = DocumentFactory.getInstance().createDocument();
			Element rootEle = doc.addElement(ELEMENT_ROOT);
			rootEle.addElement(ELEMENT_ACCOUNTS);

			writeDocument(doc);
		}

		try {
			//不能用dataFile，因为如果开始dataFile不存在，即使新建了，还是没有读到内存中
			return reader.read(new File(file));
		} catch (DocumentException e) {
			log.error("Unable to read persist data XML", e);
			throw new AccountPersistException("Unable to read persist data XML",e);
		}
	}

	@Override
	public void cleanAccount() throws AccountPersistException {
		File persistFile = new File("target/test-classes/persist-data.xml");

		if(persistFile != null){
			persistFile.delete();
		}

	}

}
