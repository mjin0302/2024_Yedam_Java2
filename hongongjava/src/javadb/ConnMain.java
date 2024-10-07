package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMain {

	public static void main(String[] args) {
		// Database 연결
		// jdbc 등록
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			// DB 연결
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"java",
						"1234"
					);
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			if(conn != null) {
				
				try {
					conn.close();	// 연결 끊는것
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}

	}

}
