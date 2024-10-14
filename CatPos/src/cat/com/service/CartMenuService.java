package cat.com.service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cat.com.ConsoleShow;
import cat.com.dao.CartDAO;
import cat.com.dao.OrderDAO;
import cat.com.vo.Cart;
import cat.com.vo.Member;

public class CartMenuService {
	
	public void cartAllListPrint(List<Cart> list) {
		
		if(list.size() > 0) {
			System.out.println("-------------------------------------------------------");
			System.out.println("\t\t     장바구니 목록");
			System.out.println("-------------------------------------------------------");
			System.out.println("상품코드\t상품이름\t\t\t가격\t수량\t합계");
			System.out.println("=======================================================");
			
			for(Cart cart : list) {
				System.out.printf("%s\t%s\t\t\t%d\t%s\t%d\n",cart.getProductId(), cart.getProductName(), cart.getPrice(), cart.getQuantity(),(cart.getPrice() * cart.getQuantity()));
			}
		} else {
			System.out.println("\n");
			System.out.println(
					" _______  _______  ______    _______    ___   _______    _______  __   __  _______  _______  __   __ \r\n"
					+ "|       ||   _   ||    _ |  |       |  |   | |       |  |       ||  |_|  ||       ||       ||  | |  |\r\n"
					+ "|       ||  |_|  ||   | ||  |_     _|  |   | |  _____|  |    ___||       ||    _  ||_     _||  |_|  |\r\n"
					+ "|       ||       ||   |_||_   |   |    |   | | |_____   |   |___ |       ||   |_| |  |   |  |       |\r\n"
					+ "|      _||       ||    __  |  |   |    |   | |_____  |  |    ___||       ||    ___|  |   |  |_     _|\r\n"
					+ "|     |_ |   _   ||   |  | |  |   |    |   |  _____| |  |   |___ | ||_|| ||   |      |   |    |   |  \r\n"
					+ "|_______||__| |__||___|  |_|  |___|    |___| |_______|  |_______||_|   |_||___|      |___|    |___|  "
					);
			System.out.println("\n");
		}
		System.out.println();
		
	}
	
	public boolean cartMenu(Member mem) {
		
		int menu = 0;
		boolean stop = true;
		int rows = 0;
		String answer = null;
		Scanner sc = new Scanner(System.in);
		
		CartDAO cartDAO = new CartDAO();
		OrderDAO oDao = new OrderDAO();
		
		while(stop) {
			
			List<Cart> cList = new ArrayList<>();
			cList = cartDAO.selectAllList(mem);
			
			System.out.println("😀 " + mem.getName() + "님 장바구니 메뉴입니다. 😀");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("     1. 장바구니조회  |  2. 상품삭제  |  3. 장바구니 상품구매  |  4. 뒤로가기  |  5. 종료");       
			System.out.println("--------------------------------------------------------------------------------");
			
			System.out.print("메뉴선택 ▷ ");
			try {
	            menu = Integer.parseInt(sc.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("\n잘못된 입력입니다. 메뉴에 있는 번호를 입력하세요.");
	            continue;
	        }
			System.out.println();
			
			switch(menu) {
				case 1 :	// 장바구니 조회
					cartAllListPrint(cList);
					
					break;
					
				case 2 :	// 장바구니 상품 삭제
					cartAllListPrint(cList);
					if(cList.size() > 0) {
						System.out.print("삭제할 상품코드를 입력하세요 ▷ ");
						String code = sc.nextLine();
						rows = cartDAO.delectCart(mem, code);
						if(rows > 0) {
							System.out.println("\n" + rows + "건 삭제되었습니다.");
						}
					} 
					break;
					
				case 3 :	// 장바구니 전체구매 진행
					cartAllListPrint(cList);
					
					if(cList.size() > 0) {
						while (true) { 
							int totalPrice = 0;
							
							List<String> codes = new ArrayList<String>();
							for(Cart cart : cList) {
			            		totalPrice += cart.getPrice() * cart.getQuantity();
			            		codes.add(cart.getProductId());
			            	}
			            	System.out.println("\n총 금액 : " +  NumberFormat.getInstance().format(totalPrice));
			            	
				            System.out.print("\n장바구니 전체구매를 진행하시겠습니까? (Y / N) ▷ ");
				            answer = sc.nextLine();
				            
				            if (answer.equalsIgnoreCase("Y")) {	// 입력값이 y
				            	// 구매를 하는 순간 카트 테이블에서 삭제, 주문서 테이블에 insert
				            	oDao.processOrder(mem.getId(), codes, cList, totalPrice);
				            	
				            	if(rows > 0) {
									System.out.println("\n" + NumberFormat.getInstance().format(totalPrice) + "원 결제되었습니다. 감사합니다 ღ");
								}
				            	break;
				            } else if (answer.equalsIgnoreCase("N")) {	// 입력값이 n
				                continue; 
				            } else {
				                System.out.println("\n잘못된 입력값입니다. 다시 입력하세요.");
				            }
				            
				        } // End of While
				
					} // End of IF 
				
					break;
					
				case 4:	return true; // 뒤로가기
					
				case 5 :
					ConsoleShow show = new ConsoleShow();
					show.programEnd();
					return false;
					
				default : 
					System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
					break;
					
			} // End of switch
			
		} // End of While
		return true;
	}
}
