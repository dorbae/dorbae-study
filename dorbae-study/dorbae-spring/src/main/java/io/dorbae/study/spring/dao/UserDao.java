/*****************************************************************
 * 
 * UserDao.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-10 15:30:38	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
package io.dorbae.study.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import io.dorbae.study.spring.db.ConnectionMaker;
import io.dorbae.study.spring.util.JDBCUtil;
import io.dorbae.study.spring.vo.User;

/**
 * @author dorbae
 *
 */
public class UserDao {
//	private ConnectionMaker connectionMaker;
	private DataSource dataSource;
	
	/* 생성자 DI 시 필요 */
//	public UserDao( ConnectionMaker connectionMaker) {
//		this.connectionMaker = connectionMaker;
//	}
	/* 의존관계 검색 이용 */
//	public UserDao() {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DaoApplicationContext.class);
//		this.connectionMaker = context.getBean( "connectionMaker", ConnectionMaker.class);
//	}
	
//	public void add( User user) throws ClassNotFoundException, SQLException {
	public void add( User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
//			conn = connectionMaker.makeConnection();
			conn = this.dataSource.getConnection();
			pstmt = conn.prepareStatement( "INSERT INTO USERS (ID, NAME, PASSWORD) VALUES (?, ?, ?)");
			pstmt.setString( 1, user.getId());
			pstmt.setString( 2, user.getName());
			pstmt.setString( 3, user.getPassword());
			pstmt.executeUpdate();
		
//		} catch ( ClassNotFoundException | SQLException e) {
		} catch ( SQLException e) {
			e.printStackTrace();
			throw e;
			
		} finally {
			JDBCUtil.close( conn, pstmt);
		}
		
	
	}
	
//	public User get( String id) throws ClassNotFoundException, SQLException {
	public User get( String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			conn = this.connectionMaker.makeConnection();
			conn = this.dataSource.getConnection();
			pstmt = conn.prepareStatement( "SELECT * FROM USERS WHERE ID = ?");
			pstmt.setString( 1,  id);
			rs = pstmt.executeQuery();
			rs.next();
			User user = new User();
			user.setId( rs.getString( 1));
			user.setName( rs.getString( 2));
			user.setPassword( rs.getString( 3));
			
			return user;
		
//		} catch ( ClassNotFoundException | SQLException e) {
		} catch ( SQLException e) {
			throw e;
			
		} finally {
			JDBCUtil.close( conn, pstmt, rs);
		}
		
	}
	
	/* 수정자 메소드 DI 방식 */
//	public void setConnectionMaker( ConnectionMaker connectionMaker) {
//		this.connectionMaker = connectionMaker;
//	}
	public void setDataSource( DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
