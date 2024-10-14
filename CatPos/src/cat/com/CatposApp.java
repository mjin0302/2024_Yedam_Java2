package cat.com;

import java.util.Scanner;

import cat.com.service.LoginService;
import cat.com.service.MainMenuService;
import cat.com.vo.Member;

public class CatposApp {
	
	public static void main(String[] args) {

		// 스캐너
		Scanner sc = new Scanner(System.in);
		
		boolean stop = true;
		int menu = 0;

		// 콘솔창 출력 첫 인사
		ConsoleShow show = new ConsoleShow();
		show.consoleShow();
		
		LoginService service = new LoginService();
		Member mem = new Member();
		
		while (stop) {
			// 로그인 및 회원가입 메뉴 보여줌
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                       1. 로그인  |  2. 회원가입  |  3. 종료");
			System.out.println("--------------------------------------------------------------------------------");

			System.out.print("메뉴선택 ▷ ");
			try {
	            menu = Integer.parseInt(sc.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
	            continue;
	        }
			
			switch (menu) {
			case 1:
				// 로그인
				mem = service.login();
				
				if (mem != null) {
					System.out.println("😀 " + mem.getName() + "님 반갑습니다. 😀");
					
					MainMenuService main = new MainMenuService();
					stop = main.mainMenu(mem);
					
					break;
				}
				
				System.out.println("아이디와 비밀번호를 확인하세요. ");
				break;

			case 2:
				System.out.println("\n회원 가입을 진행합니다. ");
				
				// 회원가입
				String name = service.signInService();
				
				if(name != null) {
					System.out.println("\n" + name + "님 회원가입이 완료되었습니다.");
					System.out.println("가입하신 아이디를 사용하실려면 로그인을 해주세요.");
					break;
				}
				else System.out.println("회원가입 실패");
				
				break;
				
			case 3 :
				show.programEnd();
				stop = false;
				
				break;
				
			default : 
				System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
				break;
			}
			
		} // End of while
		
		sc.close();
	} // End of Main
	
} // End of Class
