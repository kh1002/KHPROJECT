package ssol.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	public static void close(ResultSet rs) {
		if(rs!= null) {
			try {
				rs.close();
			} catch(SQLException es) {}
		}
	}
	public static void close(Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch(SQLException es) {} 
		}
	}
	public static void close(Connection conn) {
		if(conn!= null) {
			try {
				conn.close();
			} catch (Exception es) {}
		}
	}
	
	public static void rollback(Connection conn) {
		if(conn != null) {
			try {
				conn.rollback();
			} catch (Exception es) {}
		}
	}
}
