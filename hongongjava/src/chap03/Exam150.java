package chap03;

import java.util.Scanner;

public class Exam150 {

	public static void main(String[] args) {
		// 4.
		// 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때 1인당 몇 개를 가질 수 있고,
		// 몇 개가 남는지를 구하는 코드입니다. 
		// 1, 2에 들어갈 알 맞은 코드를 작성하세요
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft);
		
		// 5.	
		// 다음 코드를 실행하면 출력 결과로 5를 기대했는데 4가 출되었습니다.	
		// 어디에서 잘못 작성 된 것일까요?
		int var1 = 5;
		int var2 = 2;
		
		// 해당 부분의 타입변환이 안되어 소수점 뒷자리가 버려졌기 때문
		double var3 = (double)var1 / (double)var2; // 2.0
		System.out.println("var3 : " + var3);
		int var4 = (int) (var3 * var2); // 4.5 * 2
		System.out.println("var4 : " + var4);
		
		// 6. 다음은 십의 자리 이하를 버리는 코드입니다.
		// 변수 value의 값이 356이라면 300이 나올 수 있도록 빈칸에 알맞은 코드를 작성하세요(산술 연산자만 사용)
		int value = 356;
		System.out.println("value : " + (value - 56));
		
		// 7. 다음 코드를 실행하면 출력 결과로 "10%입니다."를 기대 했는데
		//    "10%가 아닙니다."가 출력되었습니다. 어디에서 잘못 작성된 것일까요?
		// 답 : if 조건문에 비교 대상 타입이 잘못되서 
		float var5 = 10f;
		float var6 = var5 / 100; // 10/100
		if(var6 == (float)0.1) { 
			System.out.println("10%입니다.");
		} else {
			System.out.println("10%가 아닙니다.");
		}
		
		// 8. 다음 코드는 사다리꼴의 넓이를 구하는 코드입니다. 
		//	  정확히 소수 자릿수가 나올 수 있도록 빈칸에 알맞은 코드를 작성하세요
		// ((윗변 + 아랫변) * 높이) / 2
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (double)((lengthTop + lengthBottom) * height) / 2;
		System.out.println("사다리꼴의 넓이 : " + area);
		
//		 9. 키보드로 두 실수를 다음과 같이 입력받습니다.(Scanner 이용)
//		 	입력된 첫 번째 수에 두 번째 수를 나눈 결과를 "결과:값"으로 출력하되,
//		 	두 번째 수에 0 또는 0.0이 입력되었을 경우 "결과:무한대" 출력되도록 코드를 작성해보세요(Scanner의 next()사용).
//		    첫 번째 수 : 7.3
//			두 번째 수 : 2.5
//			--------------------
//		 	결과:2.92 (or 결과:무한대)
		Scanner sc = new Scanner(System.in);
		System.out.print("실수를 입력하세요 > ");
		double dnum = Double.parseDouble(sc.nextLine());
		System.out.print("실수를 입력하세요 > ");
		double dnum2 = Double.parseDouble(sc.nextLine());
		if(dnum2 != 0 || dnum2 != 0.0) {
			double result = dnum / dnum2;
			System.out.println("결과 : " + result);
		} else {
			System.out.println("결과 : 무한대");
		}
		
		
		// 10. 반지름이 10인 원의 넓이를 구하는데 다음과 같이 var2, ".", var3을 + 연산해서 원주율을 얻은 다음 계산하려고 합니다.
		//     올바른 결과가 나오도록 코드를 수정해보세요.
		int num = 10;
		int num2 = 3;
		int num3 = 14;
		double num4 = num * num * Double.parseDouble(num2 + "." + num3);
		System.out.println("원의 넓이 : " + num4);
		
		// 11. 키보드로 아이디와 패스워드를 입력받습니다. 
		//     입력 조건으로 이름은 "문자열"이고, 패스워드는 "정수"입니다(패스워드는 int타입으로 변환).
		//     입력된 내용을 비교해서 아이디가 "java"이고 패스워드가 12345라면 "로그은 성공"을 출력하고 그렇지 않으면 "로그인 실패"를 출력하도록
		System.out.print("아이디 > ");
		String name = sc.nextLine();
		
		System.out.print("패스워드 > ");
		String strPassword = sc.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password == 12345) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패 : 패스워드가 틀림");
			}
		} else {
			System.out.println("로그인 실패 : 아이디 존재하지 않음");
		}
		
		// 12. 다음 코드는 비교 연산자와 논리 연산자의 복합 연산식입니다.
		//	   연산식의 출력 결과를 괄호()속에 넣으세요
		int x = 10;
		int y = 5;
		System.out.println((x > 7) && (y <= 5));	// true
		System.out.println((x % 3 == 2) || (y % 2 != 1)); //false
		
		// 13. 대입 연산자(=)와 산술 연산자(+, -, *, /)로 구성된 실행문을 대입 연산자 하나로 구성된 실행문으로 변경해보세요
		int result2 = 22;
		
		result2 = result2 + 10; // result2 += 10
		result2 = result2 - 10;	// result2 -= 10
		result2 = result2 * 10;	// result2 *= 10
		result2 = result2 / 10;	// result2 /= 10
		
//		result2 += 10;
//		result2 -= 10;
//		result2 *= 10;
//		result2 /= 10;
		
		System.out.println("result2 : " + result2);
		
		// 14. 다음 코드를 실행 했을 때 출력 결과는 무엇입니까?
		int score = 85;
		String result3 = (!(score > 90)) ? "가" : "나";
		System.out.println(result3);	// 출력 => 가
		
	}

}
