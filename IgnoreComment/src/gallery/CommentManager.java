package gallery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import ssol.jdbc.JdbcUtil;
import gallery.Comment;

public class CommentManager {
	private static CommentManager instance = new CommentManager();
		
	public static CommentManager getInstance() {
		return instance;
	}
	private CommentManager() {}

	private Connection getConnection() throws Exception{
		String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
		
		
	//댓글쓰기
	public void insertComment(Comment cm) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into theme_comment_pink values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cm.getContent_id());
			pstmt.setInt(2, cm.getComment_id());
			pstmt.setString(3, cm.getCommenter());
			pstmt.setString(4, cm.getCommentt());
			pstmt.setString(5, cm.getPassword());
			pstmt.setTimestamp(6, cm.getReg_date());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
	
	
/*	public ArrayList getComments(int con_num, int start, int end) throws Exception {*/
	
	public ArrayList getComments(int con_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList clist = null;
		
		try {
			conn = getConnection();
			String sql = "select content_id, comment_id, commenter, commentt, password, reg_date, r " 
				+ "from (select content_id, comment_id, commenter, commentt, password, reg_date, rownum r "	
				+ "from (select content_id, comment_id, commenter, commentt, password, reg_date, "
				+ "from theme_comment_pink where content_id="+con_num+" order by reg_date desc) order by reg_date desc) ";
			pstmt = conn.prepareStatement(sql);
				
			rs = pstmt.executeQuery();
			
			//만약 쿼리가 실행되어 값이 있으면?
			if(rs.next()) {
				clist = new ArrayList();
				do {
					Comment cm = new Comment();
					cm.setComment_id(rs.getInt("comment_id"));
					cm.setContent_id(rs.getInt("content_id"));
					cm.setCommenter(rs.getString("commenter"));
					cm.setCommentt(rs.getString("commentt"));
					cm.setPassword(rs.getString("password"));
					cm.setReg_date(rs.getTimestamp("reg_date"));
					
					clist.add(cm);
				} while(rs.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return clist;
	}
}





/*

public class CommentDBBean {
	private static CommentDBBean instance = new CommentDBBean();
	
	public static CommentDBBean getInstance() {
		return instance;
	}
	private CommentDBBean() {}
	
	*/
	/*
	private Connection getConnection() throws Exception{
		String jdbcDriver="jdbc:apache:commons:dbcp:/pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	*/
	//덧글을 입력하는 메서드
/*	public void insertComment(CommentDataBean cdb) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into comment_zzuggumi values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cdb.getContent_num());
			pstmt.setString(2, cdb.getCommenter());
			pstmt.setString(3, cdb.getCommentt());
			pstmt.setString(4, cdb.getPasswd());
			pstmt.setTimestamp(5, cdb.getReg_date());
			pstmt.setString(6, cdb.getIp());
			pstmt.setInt(7, cdb.getComment_num());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}*/

/*	//덧글을 가져와 포장하는 메서드?
	public ArrayList getComments(int con_num, int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList cm = null;
		
		try {
			conn = getConnection();
			String sql = "select content_num, commenter, commentt, reg_date, ip, comment_num, r " 
				+ "from (select content_num, commenter, commentt, reg_date, ip, comment_num, rownum r "	
				+ "from (select content_num, commenter, commentt, reg_date, ip, comment_num "
				+ "from comment_zzuggumi where content_num="+con_num+" order by reg_date desc) order by reg_date desc) where r>= ? and r<= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			//만약 쿼리가 실행되어 값이 있으면?
			if(rs.next()) {
				cm = new ArrayList();
				do {
					CommentDataBean cdb = new CommentDataBean();
					cdb.setComment_num(rs.getInt("comment_num"));
					cdb.setContent_num(rs.getInt("content_num"));
					cdb.setCommenter(rs.getString("commenter"));
					cdb.setCommentt(rs.getString("commentt"));
					cdb.setIp(rs.getString("ip"));
					cdb.setReg_date(rs.getTimestamp("reg_date"));
					cm.add(cdb);
				} while(rs.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return cm;
	}
	
	//덧글의 수를 세는 메서드
	public int getCommentCount(int con_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList cm = null;
		int count=0;
		
		try {
			conn = getConnection();
			String sql = "select * from comment_zzuggumi where content_num="+con_num+" order by reg_date desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cm = new ArrayList();
				do {
					CommentDataBean cdb = new CommentDataBean();
					cdb.setCommenter(rs.getString("commenter"));
					cdb.setCommentt(rs.getString("commentt"));
					cdb.setIp(rs.getString("ip"));
					cdb.setReg_date(rs.getTimestamp("reg_date"));
					cm.add(cdb);					
				} while(rs.next());
				count = cm.size();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return count;
		
	}
	
	//덧글을 삭제하는 메서드
	public int deleteComment(int content_num, String passwd, int comment_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd ="";
		int x=-1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select passwd from comment_zzuggumi where content_num=? and comment_num=?");
			pstmt.setInt(1, content_num);
			pstmt.setInt(2, comment_num);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					pstmt = conn.prepareStatement("delete from comment_zzuggumi where content_num=? and comment_num=?");
					pstmt.setInt(1, content_num);
					pstmt.setInt(2, comment_num);
					pstmt.executeUpdate();
					x=1;
				} else 
					x=0;
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return x;
	}
	
}


*/