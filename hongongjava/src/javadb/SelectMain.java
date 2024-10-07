package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {

	public static void main(String[] args) {
		// 테이블 조회
		
		// oracle 연결
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"java",
						"1234"
					);
			System.out.println("연결 성공");
			
			// 데이터 조회
			String sql = "SELECT   bno, "
					   + 		  "btitle, "
					   + 		  "content, "
					   + 		  "bwriter, "
					   + 		  "bdate "
					   + "FROM     boards "
					   //+ "WHERE    bwriter = ? "
					   + "ORDER BY bno";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, "글쓴이2");
			
			// 만들어진 문장 실행 SELECT문만 executeQuery 해줘야함 나머지는 UPDATE
			ResultSet rs = pstmt.executeQuery();
			
			// 결과 조회
			// ResultSet의 형태는 테이블 형태이다.
			// 그래서 next()는 true OR false를 반환한다. 
			// 리턴값이 true이면 다음 행이 출력된다. false이면 당연 while문 종료되겠지
			
			while(rs.next()) {
				Board bd = new Board();
				bd.setBno(rs.getInt(1));
				bd.setBtitle(rs.getString(2));
				bd.setContent(rs.getString(3));
				bd.setBwriter(rs.getString(4));
				bd.setBdate(rs.getDate(5));
				
				System.out.println(bd);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					//
					e.printStackTrace();
				}
				
			}
		}

	}

}
