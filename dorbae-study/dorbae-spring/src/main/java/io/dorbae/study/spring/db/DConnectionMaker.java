/*****************************************************************
 * 
 * DConnectionMaker.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-10 16:44:13	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
package io.dorbae.study.spring.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author dorbae
 *
 */
public class DConnectionMaker implements ConnectionMaker {

	/**
	 *
	 * @version	1.0.0	2018-05-10 16:44:13	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * (non-Javadoc)
	 * @see io.dorbae.study.spring.db.ConnectionMaker#makeConnection()
	 */
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName( "org.mariadb.jdbc.Driver");
		return DriverManager.getConnection( "jdbc:mariadb://localhost:3306/test", "tester", "tester");

	}

}
