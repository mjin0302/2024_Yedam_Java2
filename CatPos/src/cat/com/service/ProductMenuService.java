package cat.com.service;

import java.util.ArrayList;
import java.util.List;

import cat.com.ConsoleShow;
import cat.com.vo.Cart;
import cat.com.vo.Product;

public class ProductMenuService extends ConsoleShow {
	
	public static Cart isAddToCart(List<String> code) {
		
		stop = true;
		menu = 0;
		rows = 0;
		
		while (true) { 
            System.out.print("장바구니에 추가하시겠습니까? (Y / N) > ");
            answer = sc.nextLine();

            if (answer.equalsIgnoreCase("y")) {
            	while (true) {
                    System.out.print("장바구니에 담을 상품 코드를 입력하세요 > ");
                    String productId = sc.nextLine();

                    if (!code.contains(productId)) {	// 입력한 상품 코드가 넘겨받은 코드 리스트에 포함되지 않는 경우
                        System.out.println("잘못된 상품 코드입니다. 다시 입력하세요.");
                        continue; 
                    }

                    cart.setProductId(productId); // 일치하면 장바구니에 상품 코드 설정

                    System.out.print("수량을 입력하세요 > ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    cart.setQuantity(quantity); // 수량 설정

                    return cart; // 장바구니에 추가 후 cart 반환
                }
            } else if (answer.equalsIgnoreCase("n")) {
                return null; 
            } else {
                System.out.println("잘못된 입력값입니다. 다시 입력하세요.");
            }
            
        } // End of While
		
	} // End of isAddToCart
	
	public void productMenu(String id, String name) {
		
		stop = true;
		menu = 0;
		rows = 0;
		
		while(stop) {
			List<String> codes = new ArrayList<>();	//	상품 코드 저장
			
			System.out.println("😀 " + name + "님 구매하실 상품의 카테고리를 선택하세요 😀");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("       1. 사료  |  2. 간식  |  3. 장난감  |  4. 용품  |  5. 뒤로가기  |  6. 종료");       
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
				case 1 :	// 상품 사료 카테고리 선택
					list = dao.getAllProduct("사료");		//카테고리별 상품조회
					System.out.println(list);
					productMenuPrint(list);	// 상품 목록 뿌리기
					
					for(Product pro : list) {
						codes.add(pro.getProductId());
					}
					cart = isAddToCart(codes);
					
					if(cart != null) {
						rows = cartDAO.insertCart(id, cart);
						System.out.println("id = " + id);
						System.out.println("cart = " + cartDAO.insertCart(id, cart));
						if(rows > 0) {
							System.out.println(rows + "개 추가되었습니다.");
						}
						break;
					}
					break;
					
				case 2 :	// 상품 간식 카테고리 선택
					list = dao.getAllProduct("간식");		//카테고리별 상품조회
					System.out.println(list);
					productMenuPrint(list);	// 상품 목록 뿌리기
					
					for(Product pro : list) {
						codes.add(pro.getProductId());
					}
					cart = isAddToCart(codes);
					
					if(cart != null) {
						rows = cartDAO.insertCart(id, cart);
						if(rows > 0) {
							System.out.println(rows + "개 추가되었습니다.");
						}
						break;
					}
					break;
					
				case 3 :	// 상품 장난감 카테고리 선택
					list = dao.getAllProduct("장난감");	//카테고리별 상품조회
					System.out.println(list);
					productMenuPrint(list); 	// 상품 목록 뿌리기
					
					for(Product pro : list) {
						codes.add(pro.getProductId());
					}
					cart = isAddToCart(codes);
					
					// isAddToCart()의 반환값이 null이 아닐 때
					if(cart != null) {
						rows = cartDAO.insertCart(id, cart);
						if(rows > 0) {
							System.out.println(rows + "개 추가되었습니다.");
						}
						break;
					}
					break;
					
				case 4 :	// 상품 용품 카테고리 선택
					list = dao.getAllProduct("용품");		//카테고리별 상품조회
					productMenuPrint(list);	// 상품 목록 뿌리기
					
					for(Product pro : list) {
						codes.add(pro.getProductId());
					}
					cart = isAddToCart(codes);
					
					// isAddToCart()의 반환값이 null이 아닐 때
					if(cart != null) {
						rows = cartDAO.insertCart(id, cart);
						if(rows > 0) {
							System.out.println(rows + "개 추가되었습니다.");
						}
						break;
					}
					break;
					
				case 5 : return;	// 뒤로가기
				
				case 6 :
					programEnd();
					stop = false;
					break;
					
				default : 
					System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
					break;
					
			} // End of switch
			
		} // End of While
		
	} // End of productMenu
	
} // End of Class
