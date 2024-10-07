package 도서관리;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 목록(조회조건), 등록, 수정, 삭제, 단건조회
public class MemberDao extends DAO{
	// 부모로 부터 상속받은 Connection, getOpen, getClose 메소드를 가지고있다
	
	// 메모리 낭비를 막기 위해 싱글톤 방식으로 생성
	private static MemberDao instance = new MemberDao();
	MemberDao() {}
	
	// 인스턴스에 접근할 수 있는 방법
	public static MemberDao getInstance() {
		return instance;
	}
	
	String sql = null;
	
	Member checkMember(String id, String pass) {
		sql = "SELECT member_id, "
			+ 		 "member_name, "
			+ 		 "password, "
			+ 		 "phone, "
			+ 		 "responsibility, "
			+ 		 "creation_date "
			+ "FROM   tbl_member "
			+ "WHERE  UPPER(member_id) = UPPER(?) "
			+ "AND    UPPER(password) = UPPER(?) ";
		
		getOpen();
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Member mem = new Member();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setResponsibility(rs.getString("responsibility"));
				
				return mem;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
} // End class
