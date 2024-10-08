package cat.com;

import java.util.Scanner;

import cat.com.vo.Member;

public class CatposApp {

	public static void main(String[] args) {
		
		// 스캐너
		Scanner sc = new Scanner(System.in);
		
		// 콘솔창 출력 첫 인사
		ConsoleShow show = new ConsoleShow();
		show.consoleShow();
		
		Member mem = null;
		
		while(true) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                       1. 로그인  |  2. 회원가입  |  3. 종료");
			System.out.println("--------------------------------------------------------------------------------");
			
			System.out.print("메뉴선택 > ");
			System.out.println("1. 로그인  |  2. 회원가입  |  3. 종료");
			
			System.out.print("아이디 입력 > ");
			String id = sc.nextLine();
			System.out.print("비밀번호 입력 > ");
			String pass = sc.nextLine();
			
//			mem = mDao.checkMember(id, pass);
//			
//			if(mem != null) {
//				System.out.println(mem.getMemberName() + "님 반갑습니다.");
//				break;
//			}
			
			System.out.println("아이디와 비밀번호를 확인하세요. ");
		} // End of 로그인 체크
		
		boolean stop = true;
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
