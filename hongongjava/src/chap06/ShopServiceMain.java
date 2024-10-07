package chap06;

public class ShopServiceMain {

	public static void main(String[] args) {
		// 
		
		ShopService shop = ShopService.getInstance();
		ShopService shop2 = ShopService.getInstance();
		
		if(shop == shop2) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
		

	}

}
