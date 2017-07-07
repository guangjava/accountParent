package com.guang.mvnbook.account.email;

/**
 * 
 * @comment �����ʼ�����
 * @author admin
 * @date 2016��3��31������10:14:40
 * @version 1.0.0
 */
public interface AccountEmailService {
	/**
	 * ����HTML��ʽ��email
	 * @param to �ռ���ַ
	 * @param subject �ʼ�����
	 * @param htmlText ��������
	 * @throws AccountEmailException �ʼ������׳��쳣
	 * @author admin
	 * @date 2016��3��30������4:22:20
	 * @since 1.0.0
	 */
	void sendMail(String to,String subject,String htmlText) throws AccountEmailException;

}
