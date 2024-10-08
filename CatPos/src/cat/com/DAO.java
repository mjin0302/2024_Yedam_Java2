package cat.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	public Connection conn;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null; 

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "catpos";
	String pass = "catpos";
	
	public String sql;

	public void connect() {
		// jdbc driver 가져오기 => 정상
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("에러발생");
			e.printStackTrace();
		}
	}
	
	public void disconn() {
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
