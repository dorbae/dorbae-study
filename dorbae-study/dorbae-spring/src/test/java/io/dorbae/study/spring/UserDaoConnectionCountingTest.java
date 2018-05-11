/*****************************************************************
 * 
 * UserDaoConnectionCountingTest.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-11 15:12:17	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
package io.dorbae.study.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.dorbae.study.spring.context.CountingDaoFactory;
import io.dorbae.study.spring.dao.UserDao;
import io.dorbae.study.spring.db.CountingConnectionMaker;

/**
 * @author dorbae
 *
 */
public class UserDaoConnectionCountingTest {
	
	public static void main( String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( CountingDaoFactory.class);
		UserDao dao = context.getBean( "userDao", UserDao.class);
		
		//
		// DAO 사용 코드
		//
		CountingConnectionMaker ccm = context.getBean( "connectionMaker", CountingConnectionMaker.class);
		
		System.out.println( "Connection counter : " + ccm.getCounter());
	}

}
