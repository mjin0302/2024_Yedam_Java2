package cat.com.service;

import cat.com.ConsoleShow;
import cat.com.vo.Member;

public class AdminMenuService extends ConsoleShow {

	// method
	public void adminMenu(Member mem) {
		
		stop = true;
		while(stop) {
			System.out.println("😀" + mem.getName() + "관리자님 메뉴를 선택하세요. 😀");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("       1. 상품관리  |  2. 매출조회  |  3. 뒤로가기  |  4. 종료");       
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
				case 1 :
					
					break;
					
				case 2 :
					
					break;
					
				case 3 :
					
					break;
					
				case 4 :
					programEnd();
					stop = false;
					break;
					
				default : 
					System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
					break;
					
			} // End of switch
			
		} // End of While
		
	} // End of adminMenu()
	
} // End of Class AdminMenuService()
