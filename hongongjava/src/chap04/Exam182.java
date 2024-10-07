package chap04;

import java.util.Scanner;

public class Exam182 {

	public static void main(String[] args) {
		// 2. for문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 구하는 코드를 작성해보세요.
		
		// 3. while문과 Math.random() 메소드를 이용해서 2개의 주사위를 던졌을 때 나오는 눈을(눈1, 눈2)형태로 출력
		//	  눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추는 코드를 작성
		//	  눈의 합이 5가 되는 조합은(1, 4), (4, 1), (2, 3), (3, 2)입니다.
		
		// 4. 중첩 for문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x, y) 형태로 출력해보세요.
		//    단, x와 y는 10 이하의 자연수 입니다.
		//	  (4 * x) + (5 * y) == 60
		for(int x = 1; x < 11; x++) {
			for(int y = 1; y < 11; y++) {
				if((4 * x) + (5 * y) == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
		
		// 5. for문을 이용해서 다음과 같이 *을 출력하는 코드를 작성해보세요.
		//    *
		//    **
		//    ***
		//    ****
		//    *****
		String star = "";
		for(int i = 0; i < 5; i++) {
			star += "*";
			System.out.println(star);
		}
		System.out.println("==============================");
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==============================");
		
		int num = 1;
		int num2 = 1;
		for(int i = 1; num < 6; i++) {
			System.out.print("*");
			if(i == num2) {
				System.out.println();
				num++;
				num2 = num2 + num;
			}
		}

		// 6. for문을 이용해서 다음과 같이 *을 출력하는 코드를 작성해보세요.
		//    	  *
		//    	 **
		//    	***
		//     ****
		//    *****
		System.out.println("==============================");
		System.out.println();
		star = "";
		String blank = "";
		for(int i = 1; i < 5; i++) {
			star += "*";
			for(int j = i; j < 4; j++) {
				blank += " ";
			}
			System.out.println(blank + star);
			blank = "";
		}
		
		System.out.println("==============================");
		
//		star = "";
//		for(int i = 0; i < 5; i++) {
//			star += "*";
//			System.out.printf("%5s\n", star);
//		}
		
		
		
		
		// 7. while문과 Scanner를 이용해서 키보드로 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드를 빈칸에 작성
		//    프로그램을 실행하면 다음과 같은 실행결과가 나와야 합니다. (Scanner의 nextLine() 사용)
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------------------");
			System.out.println("1. 예금  |  2. 출금  |  3. 잔고  |  4. 종료");
			System.out.println("----------------------------------------");
			System.out.print("선택 > ");
			
			int selNo = Integer.parseInt(sc.nextLine());	// 메뉴 선택
			int money = 0;	// 입력 받을 금액
			
			switch(selNo) {
			case 1 : 
				System.out.print("예금할 금액을 입력하세요 > ");
				money = Integer.parseInt(sc.nextLine());
				balance += money;
				System.out.println(money + "원 입금");
				break;
			case 2 : 
				System.out.print("출금할 금액을 입력하세요 > ");
				money = Integer.parseInt(sc.nextLine());
				if(balance < money) {
					System.out.println("금액이 부족합니다.");
					System.out.println("출금 가능액은" + balance + "입니다.");
					break;
				} else {
					balance -= money;
					System.out.println(money + "원 출금");
					break;
				}
			case 3 : 
				System.out.println("잔고: " + balance + "원");
				break;
			case 4 : 
				run = false;
				System.out.println("프로그램 종료");
				break;
			default :
				System.out.println("메뉴가 존재하지 않습니다. 다시 선택하세요");
			}
			
		}
		sc.close();
	} // End Main

} // End Class
