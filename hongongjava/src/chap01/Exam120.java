package chap01;

import java.util.Scanner;

public class Exam120 {

	public static void main(String[] args) {
		// p120 
		// 문제 1번
		String name = "감자바";
		int age = 25;
		String tell = "010", tel2 = "123", tel3 = "4567";
		System.out.println("이름 : " + name);
		System.out.print("나이 : " + age + "\n");
		System.out.printf("전화 : %s-%s-%s \n", tell, tel2, tel3);
		
		// 문제 2번
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 수 : ");
		String strNum1 = sc.nextLine();
		
		System.out.print("두 번째 수 : ");
		String strNum2 = sc.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈 결과 : " + result);
		
		// 문제 3번
		System.out.print("이름 : ");
		String u_name = sc.nextLine();
		
		System.out.print("주민번호 앞 6자리 : ");
		String u_regNum = sc.nextLine();
		
		System.out.print("전화번호 중간번호 4자리 입력하세요 : ");
		String u_phone = sc.nextLine();
		System.out.print("전화번호 뒷번호 4자리 입력하세요 : ");
		String u_phone2 = sc.nextLine();
		
		System.out.println("이름 : " + u_name);
		System.out.println("주민번호 앞 6자리 : " + u_regNum);
		System.out.printf("전화번호 : 010-%s-%s \n", u_phone, u_phone2);
		
		// 두 수를 입력 받아서 큰 수 - 작은 수
		System.out.print("첫 번째 수 : ");
		num1 = sc.nextInt();
		sc.nextLine();
		System.out.print("두 번째 수 : ");
		num2 = sc.nextInt();
		sc.nextLine();
		
		if(num1 > num2) {
			result = num1 - num2;
			System.out.printf("결과 > %d - %d = %d", num1, num2, result);
			
		} else {
			result = num2 - num1;
			System.out.printf("결과 > %d - %d = %d", num2, num1, result);
		}
	}

}
