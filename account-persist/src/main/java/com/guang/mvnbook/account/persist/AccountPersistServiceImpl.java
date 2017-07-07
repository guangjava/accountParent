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
 * @comment �����˻����ݳ־û�����XML�ļ���ʽ�����û����ݣ���֧���˻���������ȡ�����¡�ɾ���Ȳ���
 * @author admin
 * @date 2016��4��8������4:06:22
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
	 * �����ѯ����������null
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
	 * ������ĵ��в鲻��ԭ��¼�������ʧ�ܣ�����null
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
	 * ����XMLԪ�ش���Account����
	 * @param element XMLԪ��
	 * @return ������Account����
	 * @author admin
	 * @date 2016��4��8������4:41:30
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
	 * ����Account���󴴽�XMLԪ��
	 * @param account Account����
	 * @return ������XMLԪ��
	 * @author admin
	 * @date 2016��4��8������4:50:17
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
	 * �洢XML�ļ�
	 * @param doc XML�ļ�
	 * @throws AccountPersistException ��װ��IOException
	 * @author admin
	 * @date 2016��4��8������5:11:32
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
	 * ��ȡXML�ļ�
	 * @return ��ȡ��XML�ļ�
	 * @throws AccountPersistException ��װ��writeDocument�׳����쳣��DocumentException
	 * @author admin
	 * @date 2016��4��8������5:32:03
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
			//������dataFile����Ϊ�����ʼdataFile�����ڣ���ʹ�½��ˣ�����û�ж����ڴ���
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
