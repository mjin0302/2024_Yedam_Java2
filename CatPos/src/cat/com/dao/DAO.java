package cat.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	public Connection conn;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	
	String sql = null;
	int rows = 0;

//	String url = "jdbc:oracle:thin:@43.202.63.165:1521:xe";
	String url = "jdbc:oracle:thin:@192.168.0.18:1521:xe";
	String user = "catpos";
	String pass = "catpos";

	public void connect() {
		// jdbc driver 가져오기 => 정상
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, pass);
			
//			System.out.println("연결성공");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	protected Connection connected() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, pass);
			
			return conn;
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public void disconnect() {
		
		// 사용한 리소스 환원.
		try {
			if(conn != null) { // 할당되었을때
				conn.close();
			}
			if(pstmt != null) { // 할당되었을때
				pstmt.close();
			}
			if(rs != null) { // 할당되었을때
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
