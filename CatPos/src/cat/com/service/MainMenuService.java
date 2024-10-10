package cat.com.service;

import cat.com.ConsoleShow;
import cat.com.vo.Member;

public class MainMenuService extends ConsoleShow {
	
	public void mainMenu(Member mem) {
		
		boolean stop = true;
		
		while(stop) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                    1. 상품구매 | 2. 관리자 | 3. 뒤로가기 | 4. 종료");
			System.out.println("--------------------------------------------------------------------------------");
			
			System.out.print("메뉴선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			switch(menu) {
			
			case 1:
				ProductMenuService proService = new ProductMenuService();
				proService.productMenu(mem.getId(), mem.getName());
				
				stop = false;
				break;
				
			case 2:
				if(mem.getRole().equals("Admin")) {
					System.out.println("관리자 모드 허용");
					
				} else {
					System.out.println("접근 권한이 없습니다.");
					continue;
				}
				break;
				
			case 3: return;
				
			case 4 :
				System.out.println("Program End");
				stop = false;
				break;
				
			default : 
				System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
				break;
					
			} // End Switch
			
		} // End While
		
		sc.close();
	} // End of mainMenu()
	
}// End of Class
