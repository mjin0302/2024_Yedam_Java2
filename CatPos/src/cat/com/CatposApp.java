package cat.com;

import java.util.Scanner;

public class CatposApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ConsoleShow show = new ConsoleShow();
		show.consoleShow();
		
		boolean stop = true;
		
		DAO dao = new DAO();
		dao.connect();

		while(stop) {
			// 메뉴 선택 함수
			show.firstMenuShow();
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
				case 1 :
					
					break;
					
				case 2 :
					
					break;
					
				case 3 :
					System.out.println("Program End");
					stop = false;
					break;
					
				default : 
					System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
					break;
					
			} // End of switch
			
		} // End of While
		
	} // End of Main
					
} // End of Class
