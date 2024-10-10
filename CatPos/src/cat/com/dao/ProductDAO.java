package cat.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cat.com.vo.Product;

public class ProductDAO extends DAO{
	
	public List<Product> getAllProduct(String kind) {
		List<Product> list = new ArrayList<>();
		try {
			sql = "SELECT   product_id, "
			    +     	   "name,"
			    + 		   "price, "
			    +     	   "kind, "
			    +     	   "stock, "
			    +     	   "state "
			    + "FROM     product "
			    + "WHERE    kind = ? "
			    + "AND		UPPER(state) = UPPER('show') "
			    + "ORDER BY name ";
			
			connect();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product product = new Product();
			
				String productId = rs.getString("product_id");
				product.setProductId(productId);
				
				String name = rs.getString("name");
				product.setName(name);
				
				int price = rs.getInt("price");
				product.setPrice(price);
				
				String kind2 = rs.getString("kind");
				product.setKind(kind2);
				
				int stock = rs.getInt("stock");
				product.setStock(stock);
				
				String state = rs.getString("state");
				product.setState(state);
				
				
				list.add(product);
				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		disconnect();
		return null;
	}
}
