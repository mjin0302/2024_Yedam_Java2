package cat.com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cat.com.vo.Cart;
import cat.com.vo.OrderSheet;

public class OrderDAO extends DAO {
	
	public List<OrderSheet> selectAllOrderSheet(String id) {
		
		sql = "SELECT     od.product_code , 	-- 상품코드\r\n"
			+ "           od.quantity , 			-- 주문 수량\r\n"
			+ "           od.order_price , 		-- 주문가격\r\n"
			+ "           oh.id , 						-- 주문자 id	\r\n"
			+ "           TO_CHAR(oh.order_date, 'YYYY-MM-DD HH24:MI:SS') as order_date, 		-- 주문일시\r\n"
			+ "           oh.total_price , 		-- 주문 총 합계\r\n"
			+ "           od.order_code , 		-- 주문헤더 코드\r\n"
			+ "           p.name , 						-- 상품명\r\n"
			+ "           p.price, 					-- 상품 개당가격\r\n"
			+ "           SUM(NVL(s.input, 0) - NVL(s.output, 0)) as stock 	-- 재고\r\n"
			+ "FROM       order_head oh \r\n"
			+ "RIGHT JOIN order_detail od \r\n"
			+ "ON         oh.order_code = od.order_code \r\n"
			+ "INNER JOIN product p \r\n"
			+ "ON         od.product_code = p.product_code \r\n"
			+ "RIGHT JOIN stock_in_out s \r\n"
			+ "ON         p.product_code = s.product_code \r\n"
			+ "WHERE      UPPER(oh.id) = UPPER(?)\r\n"
			+ "GROUP BY   od.product_code, 	-- 상품코드\r\n"
			+ "           od.quantity, 			-- 주문 수량\r\n"
			+ "           od.order_price, 		-- 주문가격\r\n"
			+ "           oh.id, 						-- 주문자 id	\r\n"
			+ "           oh.order_date, 		-- 주문일시\r\n"
			+ "           oh.total_price, 		-- 주문 총 합계\r\n"
			+ "           od.order_code, 		-- 주문헤더 코드\r\n"
			+ "           p.name, 						-- 상품명\r\n"
			+ "           p.price					-- 상품 개당가격\r\n"
			+ "ORDER BY   oh.order_date DESC";
		
		List<OrderSheet> list = new ArrayList<>();
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderSheet order = new OrderSheet();
				
				String productCode = rs.getString("product_code");
				order.setProductCode(productCode);
				
				int quantity = rs.getInt("quantity");
				order.setQuantity(quantity);
				
				int orderPrice = rs.getInt("order_price");
				order.setOrderPrice(orderPrice);
				
				String uid = rs.getString("id");
				order.setId(uid);
				
				String orderDate = rs.getString("order_date");
				order.setOrderDate(orderDate);
				
				int totalPrice = rs.getInt("total_price");
				order.setTotalPrice(totalPrice);

				String orderCode = rs.getString("order_code");
				order.setOrderCode(orderCode);
				
				String name = rs.getString("name");
				order.setName(name);
				
				int price = rs.getInt("price");
				order.setPrice(price);
				
				int stock = rs.getInt("stock");
				order.setStock(stock);
				
				list.add(order);
			}
			
			return list;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		disconnect();
		return null;
	} // End of selectAllOrderSheet
	
	public int deleteCartList(Connection connect, String id, List<String> codes) throws SQLException {
		
		int rows = 0;
		
		sql = "DELETE FROM cart "
			+ "WHERE       UPPER(product_code) = UPPER(?) "
			+ "AND         UPPER(id) = UPPER(?)";
		
		try {
			for (String code : codes) {
	        	
				pstmt = connect.prepareStatement(sql);
				
	            pstmt.setString(1, code); 
	            pstmt.setString(2, id);
	            
	            rows += pstmt.executeUpdate();
	            pstmt.clearParameters();
	            
	        } // End for
	        
			return rows;
	    } catch (SQLException e) {
	    	System.out.println(e);
	        e.printStackTrace();
	    }
		
		return 0;
		
	} // End of deleteCartList

	
	public String insertOrderHead(Connection connect, String id, int total) throws SQLException {
		
	    String sqlSeq = "SELECT order_code_seq.NEXTVAL FROM dual";  // 시퀀스 값을 먼저 조회
	    String sqlInsert = "INSERT INTO order_head (order_code, id, order_date, total_price) "
	                     + "VALUES (?, ?, SYSDATE, ?)";

	    try {
	        // 시퀀스 값 조회
	        pstmt = connect.prepareStatement(sqlSeq);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            String orderCode = rs.getString(1);  // 조회된 시퀀스 값 저장

	            // INSERT 쿼리 준비
	            pstmt = connect.prepareStatement(sqlInsert);
	            pstmt.setString(1, orderCode);  // 시퀀스 값을 첫 번째 파라미터로 설정
	            pstmt.setString(2, id);
	            pstmt.setInt(3, total);

	            pstmt.executeUpdate();

	            return orderCode;  // 삽입된 order_code 반환
	            
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	} // End of insertOrderHead
	
	public int insertOrderDetail(Connection connect, String headCode, List<Cart> list) throws SQLException {
		
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
			pstmt = connect.prepareStatement(sql);
			
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
	} // End of insertOrderDetail
	
	public int stockOutInsert(Connection connect, List<Cart> list) {
		
		sql = "INSERT INTO stock_in_out (stock_code, "
			+ 						    "output, "
			+						    "product_code) "
			+ "VALUES     				(stock_code_seq.NEXTVAL, "
			+ 							"?, "
			+ 						   	"? ) ";
		
		
		try {
			pstmt = connect.prepareStatement(sql);
			
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
		
		// 데이터베이스 연결
		Connection connect = connected();
	    try {
	    	connect.setAutoCommit(false);  // 트랜잭션 시작
	        
	        // 1. 장바구니 삭제
	        int deleteRow = deleteCartList(connect, id, codes);
	        
	        // 2. 주문 헤더 생성
	        String orderCode = insertOrderHead(connect, id, total);
	        
	        // 3. 주문 상세 내역 추가
	        int insertRow = 0;
	        if(orderCode != null) {
	        	insertRow = insertOrderDetail(connect, orderCode, cart);
	        } else {
	        	System.out.println("주문코드 생성 실패");
	        }
	        
	        // 4. 재고 출고 처리
	        int stockRow = stockOutInsert(connect, cart);
	        
	        // 모든 작업 성공 시 커밋
	        if(deleteRow > 0 && orderCode != null && insertRow > 0 && stockRow > 0) {
	        	connect.commit();
		        System.out.println("주문이 성공적으로 처리되었습니다.");
	        } else {
	        	connect.rollback();
	        	System.out.println("주문 처리 중 오류가 발생");
	        }
	        
	        
	    } catch (SQLException e) {
	        // 예외 발생 시 롤백
	    	try {
	            if (connect != null) {
	            	connect.rollback();
	            }
	            System.out.println(e);
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
