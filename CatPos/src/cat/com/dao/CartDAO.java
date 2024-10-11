package cat.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cat.com.vo.Cart;
import cat.com.vo.Member;

public class CartDAO extends DAO {
	
	public int insertCart(String id, Cart cart) {
		
		sql = "MERGE "
			+ 	"INTO  CART c "
			+ "USING dual "
			+ 	"ON    (c.product_code = ?) "
			+ "WHEN MATCHED THEN "
			+ 	"UPDATE "
			+ 	"SET c.quantity = c.quantity + TO_NUMBER( ? ) " 
			+ "WHEN NOT MATCHED THEN "
			+ 	"INSERT (c.cart_code, c.id, c.product_code, c.quantity) "
			+ 	"VALUES (CART_CODE_SEQ.NEXTVAL, ?, ?, ?) ";
		
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cart.getProductId());
			pstmt.setInt(2, cart.getQuantity());
			pstmt.setString(3, id);
			pstmt.setString(4, cart.getProductId());
			pstmt.setInt(5, cart.getQuantity());
			
			rows = pstmt.executeUpdate(); 
			
			return rows;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return 0;
	} // End of insertCart()
	
	public List<Cart> selectAllList(Member mem) {
		
		sql = "SELECT     c.cart_code, "
		    +		     "c.quantity, "
		    +		     "c.product_code,"
		    +		     "c.id, "
		    +		     "p.name, "
		    +			 "p.price "
		    + "FROM       cart c "
		    + "INNER JOIN product p "
		    + "ON         c.product_code = p.product_code ";
		
		List<Cart> list = new ArrayList<Cart>();
		connect();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Cart cart = new Cart();

				String cartCode = rs.getString("cart_code");
				cart.setCartCode(cartCode);
				
				String id = rs.getString("id");
				cart.setId(id);
				
				String productId = rs.getString("product_code");
				cart.setProductId(productId);
				
				String productName = rs.getString("name");
				cart.setProductName(productName);
				
				int price = rs.getInt("price");
				cart.setPrice(price);
				
				int quantity = rs.getInt("quantity");
				cart.setQuantity(quantity);
			
				list.add(cart);
			}
			rows = pstmt.executeUpdate(); 
			
			return list;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return null;
	} // End of selectAllList()
	
	public int delectCart(Member mem, String code) {
		sql = "DELETE FROM cart "
			+ "WHERE  product_code = ? "
			+ "AND    id = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, code);
			pstmt.setString(2, mem.getId());
			
			rows = pstmt.executeUpdate(); 
			 
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

} // End of CartDAO()
