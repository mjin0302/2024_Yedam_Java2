package cat.com.service;

import java.util.ArrayList;
import java.util.List;

import cat.com.ConsoleShow;
import cat.com.dao.CartDAO;
import cat.com.dao.ProductDAO;
import cat.com.vo.Cart;
import cat.com.vo.Product;

public class ProductMenuService extends ConsoleShow {
	
	public void productMenu(String id, String name) {
		
		boolean stop = true;
		int menu = 0;
		String kind = null;	// 카테고리
		
		ProductDAO dao = new ProductDAO();
		Cart cart = new Cart();
		CartDAO cartDAO = new CartDAO();
		 
		List<Product> list = new ArrayList<>();
		List<Cart> cList = new ArrayList<>();
		while(stop) {
			System.out.println("😀" + name + "님 구매하실 상품의 카테고리를 선택하세요 😀");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                     1. 사료 | 2. 간식 | 3. 장난감 | 4. 용품 | 5. 뒤로가기");
			System.out.println("--------------------------------------------------------------------------------");
			
			System.out.print("메뉴선택 > ");
			menu = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			switch(menu) {
				case 1 :
					kind = "사료";
					
					list = dao.getAllProduct(kind);
					productMenuPrint(list);
					
					cart = cartPrint();
					cList.add(cart);
					cartDAO.insertCart(id, cList);
					break;
					
				case 2 :
					kind = "간식";
					
					list = dao.getAllProduct(kind);
					productMenuPrint(list);
					
					cart = cartPrint();
					cList.add(cart);
					cartDAO.insertCart(id, cList);
					break;
					
				case 3 :
					kind = "장난감";
					
					list = dao.getAllProduct(kind);
					productMenuPrint(list);
					
					cart = cartPrint();
					cList.add(cart);
					cartDAO.insertCart(id, cList);
					break;
					
				case 4 :
					kind = "용품";
					
					list = dao.getAllProduct(kind);
					productMenuPrint(list);
					
					cart = cartPrint();
					cList.add(cart);
					cartDAO.insertCart(id, cList);
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
