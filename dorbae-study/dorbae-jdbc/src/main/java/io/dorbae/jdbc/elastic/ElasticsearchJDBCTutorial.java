package io.dorbae.jdbc.elastic;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*****************************************************************
 * 
 * ElasticsearchJDBCTutorial.java
 *
 *****************************************************************
 *
 * @version 0.0.0 2019-03-27 10:38:40 dorbae 최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
public class ElasticsearchJDBCTutorial {

	/**
	 *
	 * @version 1.0.0 2019-03-27 10:38:40 dorbae 최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param args
	 */
	public static void main( String[] args) {
		String className = "org.elasticsearch.xpack.sql.jdbc.EsDriver";
		String jdbcUrl = "jdbc:es://192.168.1.15:9200";

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			// Class.forName( className);
			Driver driver = DriverManager.getDriver( jdbcUrl);
			Properties props = new Properties();
			// props.setProperty( "user", "user");
			// props.setProperty( "password", "user");

			conn = driver.connect( jdbcUrl, props);
			System.out.println( "Connected.\n");
			
			System.out.printf( "TRANSACTION_ISOLATION=%d\n", conn.getTransactionIsolation());
			System.out.printf( "[%s(%d), %s(%d), %s(%d), %s(%d), %s(%d)]\n"
					, "NONE", Connection.TRANSACTION_NONE
					, "READ_COMMITTED", Connection.TRANSACTION_READ_COMMITTED
					, "READ_UNCOMMITTED", Connection.TRANSACTION_READ_UNCOMMITTED
					, "REPEATABLE_READ", Connection.TRANSACTION_REPEATABLE_READ
					, "SERIALIZABLE", Connection.TRANSACTION_SERIALIZABLE);
			
			System.out.printf( "AUTO_COMMIT=%b\n", conn.getAutoCommit());
			System.out.printf( "HOLDABILITY=%d\n", conn.getHoldability());
			System.out.printf( "[HOLD_CURSORS_OVER_COMMIT(%d), CLOSE_CURSORS_AT_COMMIT(%d)]\n", ResultSet.HOLD_CURSORS_OVER_COMMIT, ResultSet.CLOSE_CURSORS_AT_COMMIT);
			System.out.printf( "CATALOG=%s\n", conn.getCatalog());
			System.out.printf( "SCHEMA=%s\n", conn.getSchema());
			
			System.out.println();
			
			System.out.println( "conn.isReadOnly()=" + conn.isReadOnly());
			
			DatabaseMetaData dbmsMetatdata = conn.getMetaData();
			
			// DBMS supports what
			System.out.printf( "%s=%b\n", "supportsANSI92FullSQL", dbmsMetatdata.supportsANSI92FullSQL());
			System.out.printf( "%s=%b\n", "supportsANSI92IntermediateSQL", dbmsMetatdata.supportsANSI92IntermediateSQL());
			System.out.printf( "%s=%b\n", "supportsANSI92EntryLevelSQL", dbmsMetatdata.supportsANSI92EntryLevelSQL());
			System.out.printf( "%s=%b\n", "supportsBatchUpdates", dbmsMetatdata.supportsBatchUpdates());
			System.out.printf( "%s=%b\n", "supportsFullOuterJoins", dbmsMetatdata.supportsFullOuterJoins());
			System.out.printf( "%s=%b\n", "supportsOuterJoins", dbmsMetatdata.supportsOuterJoins());
			System.out.printf( "%s=%b\n", "supportsLimitedOuterJoins", dbmsMetatdata.supportsLimitedOuterJoins());
			System.out.printf( "%s=%b\n", "supportsSubqueriesInComparisons", dbmsMetatdata.supportsSubqueriesInComparisons());
			System.out.printf( "%s=%b\n", "supportsSubqueriesInExists", dbmsMetatdata.supportsSubqueriesInExists());
			System.out.printf( "%s=%b\n", "supportsSubqueriesInIns", dbmsMetatdata.supportsSubqueriesInIns());
			System.out.printf( "%s=%b\n", "supportsSubqueriesInQuantifieds", dbmsMetatdata.supportsSubqueriesInQuantifieds());
			System.out.printf( "%s=%b\n", "supportsCorrelatedSubqueries", dbmsMetatdata.supportsCorrelatedSubqueries());
			System.out.printf( "%s=%b\n", "supportsGroupBy", dbmsMetatdata.supportsGroupBy());
			System.out.printf( "%s=%b\n", "supportsGroupByBeyondSelect", dbmsMetatdata.supportsGroupByBeyondSelect());
			System.out.printf( "%s=%b\n", "supportsUnion", dbmsMetatdata.supportsUnion());
			System.out.printf( "%s=%b\n", "supportsUnionAll", dbmsMetatdata.supportsUnionAll());
			System.out.printf( "%s=%b\n", "supportsOrderByUnrelated", dbmsMetatdata.supportsOrderByUnrelated());
			System.out.println();
			
			// DBMS Functions
			System.out.printf( "SYSTEM_FUNCTIONS: %s\n", dbmsMetatdata.getSystemFunctions());
			System.out.printf( "NUMERIC_FUNCTIONS: %s\n", dbmsMetatdata.getNumericFunctions());
			System.out.printf( "STRING_FUNCTIONS: %s\n", dbmsMetatdata.getStringFunctions());
			System.out.printf( "TIMEDATE_FUNCTIONS: %s\n", dbmsMetatdata.getTimeDateFunctions());
			System.out.printf( "SQL_KEYWORD: %s\n", dbmsMetatdata.getSQLKeywords());
			System.out.println();
			
			// DBMS Data Type
			/*
			 * java.sql.SQLInvalidAuthorizationSpecException: current license is non-compliant for [jdbc]
			 * 위에 에러남. 정식버전에서 테스트 필요
			 */
//			rs = dbmsMetatdata.getTypeInfo();
//			System.out.println( "[DBMS Data Type]");
//			printResultSet(rs);
//			clearResource( rs);
			/*
			 * END
			 */
			System.out.println();
			
			// Catalog Info
			System.out.printf( "IS_CATALOG_AT_START=%b\n", dbmsMetatdata.isCatalogAtStart());
			System.out.printf( "CATALOG_TERM=%s\n", dbmsMetatdata.getCatalogTerm());
			/*
			 * java.sql.SQLInvalidAuthorizationSpecException: current license is non-compliant for [jdbc]
			 * 위에 에러남. 정식버전에서 테스트 필요
			 */
//			rs = dbmsMetatdata.getCatalogs();
//			while ( rs.next()) {
//				if ( !rs.wasNull()) {
//					System.out.printf( "CATALOG:%s\n", rs.getString( "TABLE_CAT"));
//				}
//			}
//			clearResource( rs);
			/*
			 * END
			 */
			System.out.println();
			
			// Schema Info
			System.out.printf( "SCHEMA_TERM=%s\n", dbmsMetatdata.getSchemaTerm());
			rs = dbmsMetatdata.getSchemas();
			while ( rs.next()) {
				if ( !rs.wasNull()) {
					System.out.printf( "SCHEMA:%s(%s)\n", rs.getString(  "TABLE_SCHEM"), rs.getString( "TABLE_CATALOG"));
				}
			}
			clearResource( rs);
			System.out.println();
			
			// Driver Info
			/*
			 * java.sql.SQLException: Client info not implemented yet
			 * 아직 지원 X
			 */
//			rs = dbmsMetatdata.getClientInfoProperties();
//			System.out.println( "Driver Information");
//			while ( rs.next()) {
//				if ( !rs.wasNull()) {
//					System.out.printf( "NAME=%s\n\tDESCRIPTION=%s\n\tMAX_LEN=%d\n\tDEFAULT_VALUE=%s\n"
//							, rs.getString( "NAME")
//							, rs.getString( "DESCRIPTION")
//							, rs.getInt( "MAX_LEN")
//							, rs.getString( "DEFAULT_VALUE"));
//				}
//			}
//			clearResource( rs);
			/*
			 * END
			 */
			System.out.println();
			
			
			/*
			 * java.sql.SQLFeatureNotSupportedException: Writes not supported
			 * 읽는 것만 되나?
			 */
//			// Insert Test (No Table Schema)
//			System.out.println( "[Test common insert]");
//			pstmt = conn.prepareStatement( "INSERT INTO test (col1, col2, col3, col4, col5) VALUES (?, ?, ?, ?, ?)");
//			pstmt.setString( 1, "Elasticsearch");
//			pstmt.setString( 2, "한글테스트");
//			pstmt.setLong( 3, 12345L);
//			pstmt.setDouble( 4, 123.45d);
//			pstmt.setTimestamp( 5, new java.sql.Timestamp( System.currentTimeMillis()));
//			if ( pstmt.executeUpdate() > 0) {
//				System.out.println( "Succeeded to insert data");
//			} else {
//				System.out.println( "Failed to insert data");
//			}
//			System.out.println();
//			
//			// Input other types in an object
//			System.out.println( "[Test inserting other type data in fields]");
//			pstmt.setString( 1, "Elasticsearch");
//			pstmt.setString( 2, "한글테스트");
//			pstmt.setString( 3, "되나?");	// 앞에서는 Long Type
//			pstmt.setDouble( 4, 123.45d);
//			pstmt.setTimestamp( 5, new java.sql.Timestamp( System.currentTimeMillis()));
//			if ( pstmt.executeUpdate() > 0) {
//				System.out.println( "Succeeded to insert data");
//			} else {
//				System.out.println( "Failed to insert data");
//			}
//			System.out.println();
			/*
			 * END
			 */
			
			// Select Test
			/*
			 * java.sql.SQLInvalidAuthorizationSpecException: current license is non-compliant for [jdbc]
			 */
//			System.out.println( "[Test select]");
//			clearResource( pstmt);
//			pstmt = conn.prepareStatement( "SELECT col1, col2, col3, col4, col5 FROM test");
//			rs = pstmt.executeQuery();
			/*
			 * END
			 */
			
		} catch ( SQLException e) {
			e.printStackTrace();
		} catch ( Exception e) {
			e.printStackTrace();
		} finally {
			clearResource( pstmt, rs);
			
			if ( conn != null) {
				try {
					conn.close();
				} catch ( Exception e) {}
			}
		}
	}
	
	private static void clearResource(Statement stmt, ResultSet rs) {
		if ( rs != null) {
			try {
				rs.close();
			} catch ( Exception e) {}
		}
		
		if ( stmt != null) {
			try {
				stmt.close();
			} catch ( Exception e) {}
		}
	}
	
	private static void clearResource(Statement stmt) {
		if ( stmt != null) {
			try {
				stmt.close();
			} catch ( Exception e) {}
		}
	}
	
	private static void clearResource(ResultSet rs) {
		if ( rs != null) {
			try {
				rs.close();
			} catch ( Exception e) {}
		}
	}
	
	private static void printResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		int ll = 0;
		while (rs.next()) {
			System.out.printf( "%s:%s(%s)\n", rsmd.getColumnName( 1), rs.getString( rsmd.getColumnName( 1)), rsmd.getColumnTypeName( 1));
			for ( ll = 2; ll <= columnCount; ll++) {
				System.out.printf( "\n%s:%s(%s)\n", rsmd.getColumnName( ll), rs.getString( rsmd.getColumnName( ll)), rsmd.getColumnTypeName( ll));
			}
		}
	}
}
