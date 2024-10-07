package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMain {

	public static void main(String[] args) {
		
		// 연결하기
		Connection conn = null;
		
		//jdbc Driver 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
						"jdbc:Oracle:thin:@localhost:1521:xe",
						"java",	// 계정 ID
						"1234"	// 비밀번호
					);
			System.out.println("연결 성공");
			
			// 데이터 수정
			String sql = "UPDATE boards "
					   + "SET    btitle = ?, content = ? "
					   + "WHERE  bno = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle", "content"});
			pstmt.setString(1, "비염은");
			pstmt.setString(2, "괴로워");
			pstmt.setInt(3, 2);
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 갯수 : " + rows);
			
//			if(rows > 0) {
				//
//				ResultSet rs = pstmt.getGeneratedKeys();	// 데이터베이스의 값을 가져오는 것
//				
//				if(rs.next()) {
//					int bno = rs.getInt(1);	// 1 : 컬럼번호
//					System.out.println(bno);
//					String btitle = rs.getString(2);	// 1 : 컬럼번호
//					String content = rs.getString(3);	// 1 : 컬럼번호
//					System.out.printf("수정된 번호 : " + bno + "\t수정된 제목 : " + btitle + "\n");
//					System.out.printf("수정된 번호 : %d\t수정된 제목 : %s\t수정된 내용 : %s", bno, btitle, content);
//				}
//			}
			
			pstmt.close();
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
			}
		}

	}

}
