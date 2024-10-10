package cat.com.dao;

import java.sql.SQLException;
import java.util.List;

import cat.com.vo.Cart;

public class CartDAO extends DAO {
	
	public int insertCart(String id, List<Cart> list) {
		sql = "INSERT INTO cart (cart_code, "
			+ 					"id, "
			+ 					"product_id, "
			+ 					"quantity )"
			+ "VALUES 			(cart_code_seq.nextval, "
			+					" ?, "
			+ 		  			" ?, "
			+ 		  			" ? )";
		
//		List<Cart> cartList = new ArrayList<Cart>();
		
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(Cart cart : list) {
				pstmt.setString(1, id);
				pstmt.setString(2, cart.getProductId());
				pstmt.setInt(3, cart.getQuantity());
				
				rows = pstmt.executeUpdate(); 
				
			}
			
			return rows;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return 0;
	}
}
