package 도서관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	// field
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet rs;

	String url = "jdbc:Oracle:thin:@localhost:1521:xe";
	String id = "java";
	String pass = "1234";

	// constructor

	// method
	// 1. 연결 설정 메소드(void)
	public void getOpen() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection(url, id, pass);

			// System.out.println("연결성공");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // End Open

	// 2. 연결 끊기 메소드(void)
	public void getClose() {
		if (conn != null) {
			try {
				conn.close();

				// System.out.println("연결끊기");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // End if
		
	} // End Close
	
} // End Class
