package cat.com;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cat.com.dao.OrderDAO;
import cat.com.vo.OrderSheet;
import cat.com.vo.Product;

public class ConsoleShow{
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int menu = 0;
	public static boolean stop = true;
	public static int rows = 0;
	public static String answer = null;
	
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
		System.out.println("상품코드\t 상품이름\t\t\t 가격\t 재고");
		System.out.println("=============================================");
		
		for(Product pro : list) {
			System.out.printf("%s\t %s\t\t %d\t %d\n", pro.getProductId(), pro.getName(), pro.getPrice(), pro.getStock());
		}
		System.out.println();
		
	} // End of firstMenuShow()
	
	
	
	public void orderAllList(String id) {
			
		OrderDAO odao = new OrderDAO();
		List<OrderSheet> list = new ArrayList<OrderSheet>();
		list = odao.selectAllOrderSheet(id);
		
		if(list.size() > 0) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("\t\t\t     주문 목록");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("상품코드\t 상품이름\t\t\t 수량\t 합계\t\t 주문일시");
			System.out.println("=====================================================================================");
			
			for(OrderSheet order : list) {
				System.out.printf("%s\t %s\t\t\t %d\t %s\t\t %s\n",order.getProductCode(), order.getName(), order.getQuantity(), NumberFormat.getInstance().format((order.getQuantity() * order.getPrice())), order.getOrderDate());
			}
		} else {
			System.out.println("\n");
			System.out.println(" ____ _____       ___  ___ ___  ____  ______  __ __ \n"
					+ "|    / ___/      /  _]|   |   ||    \\|      ||  |  |\n"
					+ " |  (   \\_      /  [_ | _   _ ||  o  )      ||  |  |\n"
					+ " |  |\\__  |    |    _]|  \\_/  ||   _/|_|  |_||  ~  |\n"
					+ " |  |/  \\ |    |   [_ |   |   ||  |    |  |  |___, |\n"
					+ " |  |\\    |    |     ||   |   ||  |    |  |  |     |\n"
					+ "|____|\\___|    |_____||___|___||__|    |__|  |____/ \n"
					+ "                                                    ");
			System.out.println("\n");
		}
		System.out.println();
		
	}
	
	public void sales(int price) {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\t\t 전체 총 매출 = " + NumberFormat.getInstance().format(price) + "원 입니다.");
		System.out.println("--------------------------------------------------------------------------------\n");
	}
	
	public void salesByProduct(List<OrderSheet> list) {
		if(list != null) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("\t\t\t     상품별 매출조회");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("상품코드\t 상품이름\t\t\t 수량\t\t 합계");
			System.out.println("================================================================================");
			
			for(OrderSheet order : list) {
				System.out.printf("%s\t %s\t\t\t %d\t\t %s\n",order.getProductCode(), order.getName(),order.getQuantity(), NumberFormat.getInstance().format(order.getOrderPrice()));
			}
			System.out.println();
		} else {
			System.out.println("\n");
			System.out.println(" ____ _____       ___  ___ ___  ____  ______  __ __ \n"
					+ "|    / ___/      /  _]|   |   ||    \\|      ||  |  |\n"
					+ " |  (   \\_      /  [_ | _   _ ||  o  )      ||  |  |\n"
					+ " |  |\\__  |    |    _]|  \\_/  ||   _/|_|  |_||  ~  |\n"
					+ " |  |/  \\ |    |   [_ |   |   ||  |    |  |  |___, |\n"
					+ " |  |\\    |    |     ||   |   ||  |    |  |  |     |\n"
					+ "|____|\\___|    |_____||___|___||__|    |__|  |____/ \n"
					+ "                                                    ");
			System.out.println("\n");
		}
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
