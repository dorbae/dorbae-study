/*****************************************************************
 * 
 * DaoApplicationContext.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-10 16:59:29	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
package io.dorbae.study.spring.context;

import io.dorbae.study.spring.dao.UserDao;
import io.dorbae.study.spring.db.ConnectionMaker;
import io.dorbae.study.spring.db.DConnectionMaker;

/**
 * @author dorbae
 *
 */
public class DaoApplicationContext {
	
	public UserDao userDao() {
		UserDao userDao = new UserDao( this.connectionMaker());
		return userDao;
	}
	
//	public AccountDao accountDao() {
//		AccountDao accountDao = new AccountDao( this.connectionMaker());
//		return accountDao;
//	}
//	
//	public MessageDao messageDao() {
//		MessageDao messageDao = new MessageDao( this.connectionMaker());
//		return messageDao;
//	}
	
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
