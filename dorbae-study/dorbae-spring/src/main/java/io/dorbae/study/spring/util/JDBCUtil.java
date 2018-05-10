/*****************************************************************
 * 
 * JDBCUtil.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-10 16:50:57	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
package io.dorbae.study.spring.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author dorbae
 *
 */
public class JDBCUtil {

	public static final void close(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
			}
	}

	public static final void close(PreparedStatement pstmt) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (Exception e) {
			}
	}

	public static final void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
	}
	
	public static final void close( Connection conn, PreparedStatement pstmt) {
		close( pstmt);
		close( conn);
	}
	
	public static final void close( Connection conn, PreparedStatement pstmt, ResultSet rs) {
		close( rs);
		close( pstmt);
		close( conn);
	}
}
