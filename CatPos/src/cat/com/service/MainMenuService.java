package cat.com.service;

import cat.com.ConsoleShow;
import cat.com.vo.Member;

public class MainMenuService extends ConsoleShow {
	
	public void mainMenu(Member mem) {
		
		stop = true;
		while(stop) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("          1. 상품구매  |  2. 장바구니  |  3. 관리자  |  4. 뒤로가기  |  5. 종료");
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
			
			case 1:
				ProductMenuService proService = new ProductMenuService();
				proService.productMenu(mem.getId(), mem.getName());
				
				//stop = false;
				break;
			
			case 2:
				CartMenuService cService = new CartMenuService();
				cService.cartMenu(mem);
				break;
				
			case 3:
				AdminMenuService aService = new AdminMenuService();
				if(mem.getRole().equalsIgnoreCase("admin") || mem.getRole().equalsIgnoreCase("staff")) {
					
					aService.adminMenu(mem);
				} else {
					System.out.println("접근 권한이 없습니다.");
					continue;
				}
				break;
				
			case 4: return;
				
			case 5 :
				programEnd();
				stop = false;
				break;
				
			default : 
				System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
				break;
					
			} // End Switch
			
		} // End While
		
	} // End of mainMenu()
	
}// End of Class
