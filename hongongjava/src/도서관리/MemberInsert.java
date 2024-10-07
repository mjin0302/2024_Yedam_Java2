package 도서관리;

import java.sql.SQLException;

public class MemberInsert extends MemberDao {
	
	int insertMemeber(Member mem) {
		
		sql = "INSERT INTO tbl_member (member_id, "
				+ 					  "password, "
				+ 					  "member_name, "
				+ 					  "phone) "
				+  "VALUES            ( ? , "
				+ "                     ? , "
				+ "                     ? , "
				+ "                     ? )";
		
		getOpen();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getPassword());
			pstmt.setString(3, mem.getMemberName());
			pstmt.setString(4, mem.getPhone());
			
			int rows = pstmt.executeUpdate();
			
			return rows;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		getClose();
		
		return 0;
	}
}
