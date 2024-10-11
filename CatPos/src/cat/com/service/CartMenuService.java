package cat.com.service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import cat.com.ConsoleShow;
import cat.com.dao.CartDAO;
import cat.com.vo.Cart;
import cat.com.vo.Member;

public class CartMenuService extends ConsoleShow{
	
	public void cartMenu(Member mem) {
		
		stop = true;
		CartDAO cDao = new CartDAO();
		
		List<Cart> cList = new ArrayList<>();
		cList = cDao.selectAllList(mem);
		
		while(stop) {
			System.out.println("😀 " + mem.getName() + "님 장바구니 메뉴입니다. 😀");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("      1. 장바구니조회  |  2. 상품삭제  |  3. 장바구니 상품구매  |  4. 뒤로가기  |  5. 종료");       
			System.out.println("--------------------------------------------------------------------------------");
			
			System.out.print("메뉴선택 > ");
			try {
	            menu = Integer.parseInt(sc.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
	            continue;
	        }
			System.out.println();
			
			switch(menu) {
				case 1 :
					cartAllListPrint(cList);
					break;
					
				case 2 :
					cartAllListPrint(cList);
					if(cList.size() > 0) {
						System.out.print("삭제할 상품코드를 입력하세요 >> ");
						String code = sc.nextLine();
						rows = cDao.delectCart(mem, code);
						if(rows > 0) {
							System.out.println(rows + "건 삭제되었습니다.");
						}
					} 
					break;
					
				case 3 :
					cartAllListPrint(cList);
					
					if(cList.size() > 0) {
						while (true) { 
							int totalPrice = 0;
							
							for(Cart cart : cList) {
			            		totalPrice += cart.getPrice() * cart.getQuantity();
			            	}
			            	System.out.println("총 금액 : " +  NumberFormat.getInstance().format(totalPrice));
			            	
				            System.out.print("장바구니 전체구매를 진행하시겠습니까? (Y / N) > ");
				            answer = sc.nextLine();
				            
				            if (answer.equalsIgnoreCase("Y")) {
								
				            	if(rows > 0) {
									System.out.println(NumberFormat.getInstance().format(totalPrice) + "원 결제되었습니다. 감사합니다 ღ");
								}
				            	
				            	break;
				            } else if (answer.equalsIgnoreCase("N")) {
				                continue; 
				            } else {
				                System.out.println("잘못된 입력값입니다. 다시 입력하세요.");
				            }
				            
				        } // End of While
				
					} // End of IF 
				
					break;
					
				case 4:	return;
					
				case 5 :
					programEnd();
					stop = false;
					break;
					
				default : 
					System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
					break;
					
			} // End of switch
			
		} // End of While
		
	}
}
