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
	
} // End Class
