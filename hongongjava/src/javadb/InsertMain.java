package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertMain {

	public static void main(String[] args) {
		// 데이터 추가
		Connection conn = null;
		
		// jdbc 드라이버 등록
		try {
			// jdbc 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결
			conn = DriverManager.getConnection(
						"jdbc:Oracle:thin:@localhost:1521:xe",
						"java",
						"1234"
					
					);
			System.out.println("연결 성공");
					
			// 데이터 추가
			String sql = "INSERT INTO boards (bno, btitle, content, bwriter, bdate) "
					   + "VALUES (seq_bno.nextVal, ?, ?, ?, sysdate)";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle"});
			pstmt.setString(1, "눈오는 밤");
			pstmt.setString(2, "눈이 펑펑 내려요.......");
			pstmt.setString(3, "snow");
			
			int rows = pstmt.executeUpdate();
			if(rows > 0) {
				//
				ResultSet rs = pstmt.getGeneratedKeys();	// 데이터베이스의 값을 가져오는 것
				if(rs.next()) {
					int bno = rs.getInt(1);	// 1 : 컬럼번호
					String btitle = rs.getString(2);	// 1 : 컬럼번호
					System.out.println("저장된 번호 : " + bno + "\t저장된 제목 : " + btitle + "\n");
				}
				System.out.println("추가 성공");
				rs.close();
			} else {
				System.out.println("추가 실패");
			}
			
			pstmt.close();	// sql 자원 닫기	
			
		} catch (ClassNotFoundException e) {
			// 
			e.printStackTrace();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
		}

	}

}
