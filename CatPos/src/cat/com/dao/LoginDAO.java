package cat.com.dao;

import java.sql.SQLException;
import java.util.Date;

import cat.com.vo.Member;

public class LoginDAO extends DAO {
	
	public Member loginChk(String id, String pw) {
		connect();
		
		sql = "SELECT   id, "
		    +    	   "pass, "
		    +    	   "phone, "
		    +    	   "hire_date, "
		    +     	   "role, "
		    +     	   "product_id, "
		    +      	   "name "
		    + "FROM     member "
		    + "WHERE    UPPER(id) = UPPER( ? ) "
		    + "AND		pass =  ? "
		    + "ORDER BY id ";
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
				
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member  = new Member();

				String uId = rs.getString("id");
				member.setId(uId);
				
				String uPass = rs.getString("pass");
				member.setPass(uPass);
				
				String phone = rs.getString("phone");
				member.setPhone(phone);
				
				Date hireDate = rs.getDate("hire_date");
				member.setHireDate(hireDate);

				String role = rs.getString("role");
				member.setRole(role);
				
				String name = rs.getString("name");
				member.setName(name);
			
				return member;
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		disconnect();
		return null;
		
	} // End of loginChk()
	
	// 회원가입
	public int signIn(Member mem) {
		connect();
		sql = "INSERT INTO member ( id, "
			+ 					   "pass, "
			+ 					   "phone, "
			+ 					   "name )  "
			+ "VALUES             ( ?, "
			+ "                     ?, "
			+ "                     ?, "
			+ "                     ? )";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPass());
			pstmt.setString(3, mem.getPhone());
			pstmt.setString(4, mem.getName());
			
			return rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		disconnect();
		return 0;
		
	} // End of signIn

}
