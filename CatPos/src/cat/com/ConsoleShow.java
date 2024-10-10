package cat.com;

import java.util.List;
import java.util.Scanner;

import cat.com.vo.Cart;
import cat.com.vo.Product;

public class ConsoleShow{
	
	public static Scanner sc = new Scanner(System.in);
	
	public void consoleShow() {
		System.out.println(
				"                                                                               \r\n"
				+ "                                                                               \r\n"
				+ "           .---.            ,--,                                ____           \r\n"
				+ "          /. ./|          ,--.'|                              ,'  , `.         \r\n"
				+ "      .--'.  ' ;          |  | :               ,---.       ,-+-,.' _ |         \r\n"
				+ "     /__./ \\ : |          :  : '              '   ,'\\   ,-+-. ;   , ||         \r\n"
				+ " .--'.  '   \\' .   ,---.  |  ' |      ,---.  /   /   | ,--.'|'   |  || ,---.   \r\n"
				+ "/___/ \\ |    ' '  /     \\ '  | |     /     \\.   ; ,. :|   |  ,', |  |,/     \\  \r\n"
				+ ";   \\  \\;      : /    /  ||  | :    /    / ''   | |: :|   | /  | |--'/    /  | \r\n"
				+ " \\   ;  `      |.    ' / |'  : |__ .    ' / '   | .; :|   : |  | ,  .    ' / | \r\n"
				+ "  .   \\    .\\  ;'   ;   /||  | '.'|'   ; :__|   :    ||   : |  |/   '   ;   /| \r\n"
				+ "   \\   \\   ' \\ |'   |  / |;  :    ;'   | '.'|\\   \\  / |   | |`-'    '   |  / | \r\n"
				+ "    :   '  |--\" |   :    ||  ,   / |   :    : `----'  |   ;/        |   :    | \r\n"
				+ "     \\   \\ ;     \\   \\  /  ---`-'   \\   \\  /          '---'          \\   \\  /  \r\n"
				+ "      '---\"       `----'             `----'                           `----'   \r\n"
				+ "                                                                               "
					);
	} // End of consoleShow()
	
	public void productMenuPrint(List<Product> list) {
		// 80개
		System.out.println("----------------------------------------");
		System.out.println("              상품 목록");
		System.out.println("----------------------------------------");
		System.out.println("상품코드\t상품이름\t\t\t가격\t재고");
		System.out.println("========================================");
		
		for(Product pro : list) {
			System.out.printf("%s\t%s\t\t%d\t%d\t\n", pro.getProductId(), pro.getName(), pro.getPrice(), pro.getStock());
		}
		System.out.println();
		
	} // End of firstMenuShow()
	
	public Cart cartPrint() {
		System.out.println("조회된 상품 중 장바구니에 담을 상품이 있습니까 ? y/n");
		String yesORno = sc.nextLine();
		
		Cart cart = new Cart();
		
		if(yesORno.equalsIgnoreCase("y")) {
			System.out.println("장바구니에 담을 상품 코드를 입력하세요");
			String productId = sc.nextLine();
			cart.setProductId(productId);
			
			System.out.println("수량을 입력하세요");
			int quantity = Integer.parseInt(sc.nextLine());
			cart.setQuantity(quantity);
			
			return cart;
		} else if(yesORno.equalsIgnoreCase("n")) {
			return cart;
		} else {
			System.out.println("잘못된 입력값입니다. 다시 입력하세요");
			return null;
		}
	}
	
} // End Class
