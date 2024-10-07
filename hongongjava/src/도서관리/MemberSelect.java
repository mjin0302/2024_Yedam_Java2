package 도서관리;

import java.util.ArrayList;
import java.util.List;

public class MemberSelect extends MemberDao {
	
	List<Member> list = new ArrayList<Member>();
	
	// List<Member> 반환 타입
	List<Member> memberList() {
		sql = "SELECT member_id, "
			+ 			"member_name, "
			+ 			"password, "
			+ 			"phone, "
			+ 			"responsibility, "
			+ 			"creation_date "
			+ 	 "FROM   tbl_member ";
		
		
		getOpen();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();	// 쿼리 결과값 조회
			
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getClose();
		return list;
	
	} // End of memberList()
	
	List<Member> memberSelect(String name) {
		sql = "SELECT member_id, "
			+ 		 "member_name, "
			+ 		 "password, "
			+ 		 "phone, "
			+ 		 "responsibility, "
			+ 		 "creation_date "
			+ "FROM   tbl_member "
			+ "WHERE  UPPER(member_name) = UPPER(?) ";
		
		getOpen();
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			rs = pstmt.executeQuery();	// 쿼리 결과값 조회
			
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getClose();
		
		return list;
	
	} // End of memberList()
	
} // End of Class
