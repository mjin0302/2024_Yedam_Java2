package cat.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cat.com.vo.Cart;

public class CartDAO extends DAO {
	
	// 상품 ID로 상품 이름을 조회하는 메소드
	private String getProductName(String productId) {
	    String selectSql = "SELECT name FROM products WHERE product_id = ?"; // 예시 테이블 이름
	    String productName = null;

	    try {
	        pstmt = conn.prepareStatement(selectSql);
	        pstmt.setString(1, productId);
	        
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            productName = rs.getString("name"); // 이름 조회
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return productName; // 상품 이름 반환
	}
	
	public int insertCart(String id, List<Cart> list) {
		sql = "INSERT INTO cart (CART_CODE, "
			+ 					"id, "
			+ 					"product_id, "
			+ 					"quantity ) "
			+ "VALUES 			(CART_CODE_SEQ.NEXTVAL, "
			+					" ?, "
			+ 		  			" ?, "
			+ 		  			" ? ) ";
		
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(Cart cart : list) {
				pstmt.setString(1, id);
				pstmt.setString(2, cart.getProductId());
				pstmt.setInt(3, cart.getQuantity());
				
			}
			rows = pstmt.executeUpdate(); 
			
			return rows;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return 0;
	}
}
