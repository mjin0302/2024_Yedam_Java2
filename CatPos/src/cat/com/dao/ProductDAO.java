package cat.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cat.com.vo.Product;

public class ProductDAO extends DAO{
	
	public int getProductStock(String code) {
		sql = "SELECT 	 p.product_code, "
			+ "          SUM(NVL(s.input ,0) - NVL(s.output, 0)) as stock "
			+ "FROM   	 product p LEFT JOIN stock_in_out s "
			+ "ON     	 p.product_code = s.product_code "
			+ "WHERE  	 p.product_code = ? "
			+ "GROUP BY p.product_code ";
		
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, code);
			
			rs = pstmt.executeQuery();
			int stock = 0;
			while(rs.next()) {
				stock = rs.getInt("stock");
			}
			return stock;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Product> getAllProduct(String kind) {
		List<Product> list = new ArrayList<>();
		try {
			sql = "SELECT 	p.product_code, "
				+ "         p.name, "
				+ "         NVL(p.price, 0) as price, "
				+ "         p.kind, "
				+ "         p.state, "
				+ "         SUM(NVL(s.input ,0) - NVL(s.output, 0)) as stock "
				+ "FROM   	product p INNER JOIN stock_in_out s "
				+ "ON     	p.product_code = s.product_code "
				+ "WHERE  	p.kind = ? "
				+ "AND	  	UPPER(p.state) = UPPER('show') "
				+ "GROUP BY p.product_code, p.name, price, p.kind, p.state "
				+ "ORDER BY TO_NUMBER(p.product_code) ";
			
			connect();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
			
				String productId = rs.getString("product_code");
				product.setProductId(productId);
				
				String name = rs.getString("name");
				product.setName(name);
				
				int price = rs.getInt("price");
				product.setPrice(price);
				
				String kind2 = rs.getString("kind");
				product.setKind(kind2);
				
				String state = rs.getString("state");
				product.setState(state);
				
				int stock = rs.getInt("stock");
				product.setStock(stock);
				
				list.add(product);
				
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		return null;
	}
}
