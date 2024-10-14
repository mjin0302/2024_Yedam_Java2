package cat.com.service;

import cat.com.ConsoleShow;
import cat.com.vo.Member;

public class MainMenuService extends ConsoleShow {
	
	public boolean mainMenu(Member mem) {
		
		while(stop) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("   1. 상품목록  |  2. 장바구니  |  3. 주문목록  |  4. 관리자  |  5. 뒤로가기  |  6. 종료");
			System.out.println("--------------------------------------------------------------------------------");
			
			System.out.print("메뉴선택 ▷ ");
			try {
	            menu = Integer.parseInt(sc.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("\n잘못된 입력입니다. 메뉴에 있는 번호를 입력하세요.");
	            continue;
	        }
			System.out.println();
			
			switch(menu) {
			
			case 1:	// 상품목록
				ProductMenuService proService = new ProductMenuService();	// 상품조회
				stop = proService.productMenu(mem.getId(), mem.getName());

				if(stop == false) return false;
				
				break;
			
			case 2:	// 장바구니
				CartMenuService cartService = new CartMenuService();		// 장바구니
				stop = cartService.cartMenu(mem);
				
				if(stop == false) return false;
				
				break;
				
			case 3:	// 주문목록
				orderAllList(mem.getId());
				break;
				
			case 4:	// 관리자
				if(mem.getRole().equalsIgnoreCase("Owner") || mem.getRole().equalsIgnoreCase("Staff")) {
					AdminMenuService adminService = new AdminMenuService();	// 관리자
					stop = adminService.adminMenu(mem);
					
					if(stop == false) return false;
				} else {
					System.out.println("접근 권한이 없습니다.");
					continue;
				}
				break;
			
			case 5:	// 뒤로가기 
				stop = false;
				break;
				
			case 6 :	// 프로그램 종료
				ConsoleShow show = new ConsoleShow();
				show.programEnd();
				return false;
				
			default : 
				System.out.println("\n선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
				break;
					
			} // End Switch
			
		} // End While
		return true;
	} // End of mainMenu()
	
}// End of Class
