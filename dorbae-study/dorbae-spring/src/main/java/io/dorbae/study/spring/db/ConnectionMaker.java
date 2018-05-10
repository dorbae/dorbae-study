/*****************************************************************
 * 
 * ConnectionMaker.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-10 16:43:06	dorbae	최초생성
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
public interface ConnectionMaker {
	
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
