package cat.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cat.com.vo.OrderSheet;

public class SalesDAO extends DAO{
	public int getTotalSales() {
		
		sql = "SELECT SUM(total_price) AS total_price "
			+ "FROM   order_head";
		
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				return rs.getInt("total_price");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
		
		return 0;
		
	}
	
	public List<OrderSheet> getSalesByProduct() {
		
		sql = "SELECT 	p.product_code, "
			+ "			p.name AS name, "
			+ "			SUM(od.quantity) AS quantity, "
			+ "       	SUM(od.order_price) AS order_price "
			+ "FROM   	order_detail od "
			+ "JOIN   	product p "
			+ "ON     	od.product_code = p.product_code "
			+ "GROUP BY p.product_code, "
			+ "			p.name "
			+ "ORDER BY order_price DESC ";
		
		List<OrderSheet> list = new ArrayList<>();
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderSheet order = new OrderSheet();
				
				String productCode = rs.getString("product_code");
				order.setProductCode(productCode);
				
				String name = rs.getString("name");
				order.setName(name);
				
				int quantity = rs.getInt("quantity");
				order.setQuantity(quantity);
				
				int orderPrice = rs.getInt("order_price");
				order.setOrderPrice(orderPrice);
				
				list.add(order);
			}
			
			return list;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		disconnect();
		return null;
	}
}
