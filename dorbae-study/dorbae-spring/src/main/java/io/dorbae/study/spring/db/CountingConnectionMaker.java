/*****************************************************************
 * 
 * CountingConnectionMaker.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-11 15:06:15	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
package io.dorbae.study.spring.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author dorbae
 *
 */
public class CountingConnectionMaker implements ConnectionMaker {
	
	private int counter = 0;
	private ConnectionMaker realConnectionMaker;
	
	/**
	 *
	 * @version	1.0.0	2018-05-11 15:06:59	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 */
	public CountingConnectionMaker( ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}
	
	/**
	 *
	 * @version	1.0.0	2018-05-11 15:06:15	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * (non-Javadoc)
	 * @see io.dorbae.study.spring.db.ConnectionMaker#makeConnection()
	 */
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		this.counter++;
		return this.realConnectionMaker.makeConnection();
	}
	
	public int getCounter() {
		return this.counter;
	}

}
