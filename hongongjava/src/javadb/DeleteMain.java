package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMain {

	public static void main(String[] args) {
		// 연결
		
		Connection conn = null;
		
		// Oracle jdbc 드라이버 가져오는거
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"java",
						"1234"
					);
			System.out.println("연결 성공");
			
			// 데이터 삭제
			String sql = "DELETE FROM boards "
					   + "WHERE bno = ?";
			// sql에 저장된 query구문을 연결?
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 4);
			
			// 만들어진 문장 실행
			int rows = pstmt.executeUpdate();
			System.out.println("삭제행 수 : " + rows);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			} // End if
		}
		
	} // End Main

} //End Class
