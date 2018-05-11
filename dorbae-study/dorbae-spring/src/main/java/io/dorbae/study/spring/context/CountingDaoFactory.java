/*****************************************************************
 * 
 * CountingDaoFactory.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-11 15:09:31	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
package io.dorbae.study.spring.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.dorbae.study.spring.dao.UserDao;
import io.dorbae.study.spring.db.ConnectionMaker;
import io.dorbae.study.spring.db.CountingConnectionMaker;
import io.dorbae.study.spring.db.DConnectionMaker;

/**
 * @author dorbae
 *
 */
@Configuration
public class CountingDaoFactory {
	@Bean
	public UserDao userDao() {
//		return new UserDao( this.connectionMaker());
		UserDao userDao = new UserDao();
//		userDao.setConnectionMaker( this.connectionMaker());
		userDao.setDataSource( this.dataSource());
		return userDao;
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker( this.realConnectionMaker());
	}
	
	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new DConnectionMaker();
	}
	
	

}
