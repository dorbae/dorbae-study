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

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import io.dorbae.study.spring.dao.UserDao;
import io.dorbae.study.spring.db.ConnectionMaker;
import io.dorbae.study.spring.db.DConnectionMaker;

/**
 * @author dorbae
 *
 */
/* 스프링의 빈 팩토리를 위한 오브젝트 설정을 담당하는 클래스 지칭 */
@Configuration
public class DaoFactory {
	/* 오브젝트 생성을 담당하는 IoC용 메소드라는 표시 */
	@Bean
	public UserDao userDao() {
		/* 생성자 주입 */
//		UserDao userDao = new UserDao( this.connectionMaker());
		/* 수정자 메소드 주입 */
		UserDao userDao = new UserDao();
//		userDao.setConnectionMaker( this.connectionMaker());
		userDao.setDataSource( this.dataSource());
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
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass( org.mariadb.jdbc.Driver.class);
		dataSource.setUrl( "jdbc:mariadb://localhost:3306/test");
		dataSource.setUsername( "tester");
		dataSource.setPassword( "tester");
		
		return dataSource;
		
	}
}
