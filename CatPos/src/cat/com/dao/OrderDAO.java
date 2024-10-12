package cat.com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cat.com.vo.Cart;
import cat.com.vo.OrderSheet;

public class OrderDAO extends DAO {
	
	// TODO 주문서 화면에 뿌려주기 그 전에 쿼리 먼저 확인하기...ㅠ
	public List<OrderSheet> selectAllOrderSheet(String id) {
		sql = "SELECT     od.product_code, "
			+ "           od.quantity, "
			+ "           od.order_price, "
			+ "           oh.id, "
			+ "           oh.order_date, "
			+ "           oh.total_price, "
			+ "           od. order_code, "
			+ "           p.name, "
			+ "           p.price, "
			+ "           NVL(s.input, 0) - NVL(s.output, 0) as stock "
			+ "FROM       order_head oh "
			+ "RIGHT JOIN order_detail od "
			+ "ON         oh.order_code = od.order_code "
			+ "INNER JOIN product p "
			+ "ON         od.product_code = p.product_code "
			+ "RIGHT JOIN stock_in_out s "
			+ "ON         p.product_code = s.product_code ";
		
		List<OrderSheet> list = new ArrayList<>();
		connect();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderSheet order = new OrderSheet();

				String orderCode = rs.getString("order_code");
				order.setOrderCode(orderCode);
				
				String uid = rs.getString("id");
				order.setId(uid);
				
				Date orderDate = rs.getDate("order_date");
				order.setOrderDate(orderDate);
				
				int totalPrice = rs.getInt("price");
				order.setTotalPrice(totalPrice);
				
				String orderDetailCode = rs.getString("order_detail_code");
				order.setOrderCode(orderDetailCode);
				
				String productCode = rs.getString("product_code");
				order.setProductCode(productCode);
				
				int quantity = rs.getInt("quantity");
				order.setQuantity(quantity);

				int orderPrice = rs.getInt("orderPrice");
				order.setQuantity(orderPrice);
				
				list.add(order);
			}
			
			return list;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		disconnect();
		return null;
	}
	
	public int deleteCartList(Connection conn, String id, List<String> codes) throws SQLException {
		
		sql = "DELETE FROM cart "
			+ "WHERE       UPPER(product_code) = UPPER(?) "
			+ "AND         UPPER(id) = UPPER(?)";
		
		try {
	        for (String code : codes) {
	        	
	        	pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, code); 
	            pstmt.setString(2, id);
	            
	            rows += pstmt.executeUpdate();
	            
	        } // End for
	        
			return rows;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return 0;
		
	}

	
	public String insertOrderHead(Connection conn, String id, int total) throws SQLException {
		
		sql = "INSERT INTO order_head (order_code, "
			+ "						   id, "
			+ "						   total_price) "
			+ "VALUES                 (order_code_seq.NEXTVAL, "
			+ "                        ?, "
			+ "                        ?) ";

		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, total);
			
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();	// 생성된 order_code
			
			if(rs.next()) {
				return rs.getString(1);	// order_code 반환해줌
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int insertOrderDetail(Connection conn, String headCode, List<Cart> list) throws SQLException {
		
		sql = "INSERT INTO order_detail (order_detail_code, "
			+ "                          product_code, "
			+ "                          quantity, "
			+ "                          order_price, "
			+ "                          order_code) "
			+ "VALUES                   (order_detail_code_seq.NEXTVAL, "
			+ "                          ?, "	// 상품코드
			+ "                          ?, "	// 수량
			+ "                          ?, "	// 상품금액
			+ "                          ? ) ";	// order_code
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(Cart cart : list) {
				
				pstmt.setString(1, cart.getProductId());
				pstmt.setInt(2, cart.getQuantity());
				pstmt.setInt(3, (cart.getPrice() * cart.getQuantity()));
				pstmt.setString(4, headCode);
			
				rows = pstmt.executeUpdate();
			}
			return rows;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int stockOutInsert(Connection conn, List<Cart> list) {
		
		sql = "INSERT INTO stock_in_out (stock_code, "
			+ 						    "output, "
			+						    "product_code) "
			+ "VALUES     				(stock_code_seq.NEXTVAL, "
			+ 							"?, "
			+ 						   	"? ) ";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(Cart cart : list) {
				pstmt.setInt(1, cart.getQuantity());
				pstmt.setString(2, cart.getProductId());
				
				rows += pstmt.executeUpdate();
			}
			return rows;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public void processOrder(String id, List<String> codes, List<Cart> cart, int total) {
	    
	    try {
	        // 데이터베이스 연결
	        conn = conn();
	        conn.setAutoCommit(false);  // 트랜잭션 시작
	        
	        // 1. 장바구니 삭제
	        int deleteRow = deleteCartList(conn, id, codes);
	        
	        // 2. 주문 헤더 생성
	        String orderCode = insertOrderHead(conn, id, total);
	        
	        // 3. 주문 상세 내역 추가
	        int insertRow = 0;
	        if(orderCode != null) {
	        	insertRow = insertOrderDetail(conn, orderCode, cart);
	        	System.out.println("orderCodeorderCodeorderCode" + orderCode);
	        } else {
	        	System.out.println("주문코드 생성 실패");
	        }
	        
	        // 4. 재고 출고 처리
	        int stockRow = stockOutInsert(conn, cart);
	        
	        // 모든 작업 성공 시 커밋
	        if(deleteRow > 0 && orderCode != null && insertRow > 0 && stockRow > 0) {
	        	conn.commit();
		        System.out.println("주문이 성공적으로 처리되었습니다.");
	        } else {
	        	conn.rollback();
	        	System.out.println("주문 처리 중 오류가 발생");
	        }
	        
	        
	    } catch (SQLException e) {
	        // 예외 발생 시 롤백
	    	try {
	            if (conn != null) {
	                conn.rollback();
	            }
	            System.out.println("주문 처리 중 오류가 발생");
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	        e.printStackTrace();
	        
	        e.printStackTrace();
	    } finally {
	        // 연결 해제
	        disconnect();
	    }
	}

	

}
