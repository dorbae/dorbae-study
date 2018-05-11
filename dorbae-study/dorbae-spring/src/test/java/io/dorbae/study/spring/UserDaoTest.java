/*****************************************************************
 * 
 * UserDaoTest.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-10 17:16:54	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
package io.dorbae.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.dorbae.study.spring.context.DaoFactory;
import io.dorbae.study.spring.dao.UserDao;
import io.dorbae.study.spring.vo.User;

/**
 * @author dorbae
 *
 */
public class UserDaoTest {
	public static void main( String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext( DaoFactory.class);
		UserDao dao = context.getBean( "userDao", UserDao.class);
		String id = Long.toString( Math.round( Math.random() * 100000000d));
		User user = new User();
		user.setId( id);
		user.setName( "dorbae");
		user.setPassword( "passswd");
		
		dao.add( user);
		System.out.printf( "Insert!!! (id=%s)\n", id);
		
		user = dao.get( id);
		System.out.println( "Get User");
		System.out.println( "ID : " + user.getId());
		System.out.println( "NAME : " + user.getName());
		System.out.println( "PASSWORD : " + user.getPassword());
		
	}
}
