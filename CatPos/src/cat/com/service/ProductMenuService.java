package cat.com.service;

import java.util.ArrayList;
import java.util.List;

import cat.com.ConsoleShow;
import cat.com.dao.CartDAO;
import cat.com.dao.ProductDAO;
import cat.com.vo.Cart;
import cat.com.vo.Product;

public class ProductMenuService extends ConsoleShow {
	
	public static Cart isAddToCart() {
		Cart cart = new Cart();
		
		while (true) { 
            System.out.print("장바구니에 추가하시겠습니까? (Y / N) > ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("y")) {
                System.out.print("장바구니에 담을 상품 코드를 입력하세요 > ");
                String productId = sc.nextLine();
                cart.setProductId(productId);
                
                System.out.print("수량을 입력하세요 > ");
                int quantity = Integer.parseInt(sc.nextLine());
                cart.setQuantity(quantity);
                
                return cart; // 장바구니에 추가 후 cart 반환
            } else if (answer.equalsIgnoreCase("n")) {
                return null; 
            } else {
                System.out.println("잘못된 입력값입니다. 다시 입력하세요.");
            }
            
        } // End of While
		
	} // End of isAddToCart
	
	
	public void productMenu(String id, String name) {
		
		boolean stop = true;
		int menu = 0;
		int rows = 0;
		
		ProductDAO dao = new ProductDAO();
		Cart cart = null;
		CartDAO cartDAO = new CartDAO();
		 
		List<Product> list = new ArrayList<>();
		List<Cart> cList = new ArrayList<>();
		while(stop) {
			System.out.println("😀" + name + "님 구매하실 상품의 카테고리를 선택하세요 😀");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("       1. 사료  |  2. 간식  |  3. 장난감  |  4. 용품  |  5. 뒤로가기  |  6. 종료");       
			System.out.println("--------------------------------------------------------------------------------");
			
			System.out.print("메뉴선택 > ");
			menu = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			switch(menu) {
				case 1 :
					
					list = dao.getAllProduct("사료");		//카테고리별 상품조회
					productMenuPrint(list);	// 상품 목록 뿌리기
					
					cart = isAddToCart();
					if(cart != null) {
						cList.add(cart);
						rows = cartDAO.insertCart(id, cList);
						if(rows > 0) {
							System.out.println(rows + "개 추가되었습니다.");
						}
						break;
					}
					break;
					
				case 2 :
					list = dao.getAllProduct("간식");		//카테고리별 상품조회
					productMenuPrint(list);	// 상품 목록 뿌리기
					
					cart = isAddToCart();
					if(cart != null) {
						cList.add(cart);
						rows = cartDAO.insertCart(id, cList);
						if(rows > 0) {
							System.out.println(rows + "개 추가되었습니다.");
						}
						break;
					}
					break;
					
				case 3 :
					list = dao.getAllProduct("장난감");	//카테고리별 상품조회
					productMenuPrint(list); 	// 상품 목록 뿌리기
					
					// isAddToCart()의 반환값이 null이 아닐 때
					cart = isAddToCart();
					if(cart != null) {
						cList.add(cart);
						rows = cartDAO.insertCart(id, cList);
						if(rows > 0) {
							System.out.println(rows + "개 추가되었습니다.");
						}
						break;
					}
					break;
					
				case 4 :
					list = dao.getAllProduct("용품");		//카테고리별 상품조회
					productMenuPrint(list);	// 상품 목록 뿌리기
					
					cart = isAddToCart();
					if(cart != null) {
						cList.add(cart);
						rows = cartDAO.insertCart(id, cList);
						if(rows > 0) {
							System.out.println(rows + "개 추가되었습니다.");
						}
						break;
					}
					break;
					
				case 5 : return;
				
				case 6 :
					System.out.println("Program End");
					stop = false;
					break;
					
				default : 
					System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
					break;
					
			} // End of switch
			
		} // End of While
		
		sc.close();
	} // End of productMenu
	
} // End of Class
