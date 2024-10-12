package cat.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cat.com.dao.CartDAO;
import cat.com.dao.OrderDAO;
import cat.com.dao.ProductDAO;
import cat.com.service.AdminMenuService;
import cat.com.service.CartMenuService;
import cat.com.service.ProductMenuService;
import cat.com.vo.Cart;
import cat.com.vo.OrderSheet;
import cat.com.vo.Product;

public class ConsoleShow{
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int menu = 0;
	public static boolean stop = true;
	public static int rows = 0;
	public static String answer = null;
	
	public static ProductMenuService proService = new ProductMenuService();	// 상품조회
	public static CartMenuService cartService = new CartMenuService();		// 장바구니
	public static AdminMenuService adminService = new AdminMenuService();	// 관리자
	
	public static List<Cart> cList = new ArrayList<>();
	public static List<Product> list = new ArrayList<>();	
	public static List<OrderSheet> orderList = new ArrayList<>();
	
	public static Cart cart = new Cart();
	
	public static ProductDAO dao = new ProductDAO();	// 상품
	public static CartDAO cartDAO = new CartDAO();		// 장바구니
	public static OrderDAO oDao = new OrderDAO(); 		// 주문서
	
	public void consoleShow() {
		
		System.out.println(
				".--.      .--.    .-''-.    .---.        _______      ,-----.    ,---.    ,---.    .-''-.   \r\n"
				+ "|  |_     |  |  .'_ _   \\   | ,_|       /   __  \\   .'  .-,  '.  |    \\  /    |  .'_ _   \\  \r\n"
				+ "| _( )_   |  | / ( ` )   ',-./  )      | ,_/  \\__) / ,-.|  \\ _ \\ |  ,  \\/  ,  | / ( ` )   ' \r\n"
				+ "|(_ o _)  |  |. (_ o _)  |\\  '_ '`)  ,-./  )      ;  \\  '_ /  | :|  |\\_   /|  |. (_ o _)  | \r\n"
				+ "| (_,_) \\ |  ||  (_,_)___| > (_)  )  \\  '_ '`)    |  _`,/ \\ _/  ||  _( )_/ |  ||  (_,_)___| \r\n"
				+ "|  |/    \\|  |'  \\   .---.(  .  .-'   > (_)  )  __: (  '\\_/ \\   ;| (_ o _) |  |'  \\   .---. \r\n"
				+ "|  '  /\\  `  | \\  `-'    / `-'`-'|___(  .  .-'_/  )\\ `\"/  \\  ) / |  (_,_)  |  | \\  `-'    / \r\n"
				+ "|    /  \\    |  \\       /   |        \\`-'`-'     /  '. \\_/``\".'  |  |      |  |  \\       /  \r\n"
				+ "`---'    `---`   `'-..-'    `--------`  `._____.'     '-----'    '--'      '--'   `'-..-'   \r\n"
				+ "                                                                                            "
				);
	} // End of consoleShow()
	
	public void productMenuPrint(List<Product> list) {
		// 80개
		System.out.println("---------------------------------------------");
		System.out.println("\t\t  상품 목록");
		System.out.println("---------------------------------------------");
		System.out.println("상품코드\t상품이름\t\t\t가격\t재고");
		System.out.println("=============================================");
		
		for(Product pro : list) {
			System.out.printf("%s\t%s\t\t%d\t%d\n", pro.getProductId(), pro.getName(), pro.getPrice(), pro.getStock());
		}
		System.out.println();
		
	} // End of firstMenuShow()
	
	public void cartAllListPrint(List<Cart> list) {
		if(list.size() >= 1) {
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
	
	public void programEnd() {
		System.out.println(
				".-------. .-------.        ,-----.      .-_'''-.   .-------.       ____    ,---.    ,---.            .-''-.  ,---.   .--. ______      \r\n"
				+ "\\  _(`)_ \\|  _ _   \\     .'  .-,  '.   '_( )_   \\  |  _ _   \\    .'  __ `. |    \\  /    |          .'_ _   \\ |    \\  |  ||    _ `''.  \r\n"
				+ "| (_ o._)|| ( ' )  |    / ,-.|  \\ _ \\ |(_ o _)|  ' | ( ' )  |   /   '  \\  \\|  ,  \\/  ,  |         / ( ` )   '|  ,  \\ |  || _ | ) _  \\ \r\n"
				+ "|  (_,_) /|(_ o _) /   ;  \\  '_ /  | :. (_,_)/___| |(_ o _) /   |___|  /  ||  |\\_   /|  |        . (_ o _)  ||  |\\_ \\|  ||( ''_'  ) | \r\n"
				+ "|   '-.-' | (_,_).' __ |  _`,/ \\ _/  ||  |  .-----.| (_,_).' __    _.-`   ||  _( )_/ |  |        |  (_,_)___||  _( )_\\  || . (_) `. | \r\n"
				+ "|   |     |  |\\ \\  |  |: (  '\\_/ \\   ;'  \\  '-   .'|  |\\ \\  |  |.'   _    || (_ o _) |  |        '  \\   .---.| (_ o _)  ||(_    ._) ' \r\n"
				+ "|   |     |  | \\ `'   / \\ `\"/  \\  ) /  \\  `-'`   | |  | \\ `'   /|  _( )_  ||  (_,_)  |  |         \\  `-'    /|  (_,_)\\  ||  (_.\\.' /  \r\n"
				+ "/   )     |  |  \\    /   '. \\_/``\".'    \\        / |  |  \\    / \\ (_ o _) /|  |      |  |          \\       / |  |    |  ||       .'   \r\n"
				+ "`---'     ''-'   `'-'      '-----'       `'-...-'  ''-'   `'-'   '.(_,_).' '--'      '--'           `'-..-'  '--'    '--''-----'`     \r\n"
				+ "                                                                                                                                      "
				);
	} // End of progranEnd()
	
} // End Class
