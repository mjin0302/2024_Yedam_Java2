package chap05;

public class Exam195 {
	
	public static void main(String[] args) {
		// 참조타입의 번지 비교 -> == 을 사용
		// 데이터(문자열) 비교 -> equals()를 사용
		String strVar1 = "신민철";
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2) {
			System.out.println("strVar1과 strVar2 참조가 같음");
		} else {
			System.out.println("=strVar1과 strVar2 참조가 다름");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("strVar1과 strVar2 문자열이 같음");
		}
		
		String strVar3 = new String("신민철");
		String strVar4 = new String("신민철");
		
		if(strVar3 == strVar4) {
			System.out.println("3과 4는 참조열이 같음");
		} else {
			System.out.println("3과 4는 참조열이 다름");
		}
		
		if(strVar3.equals(strVar4)) {
			System.out.println("3과 4는 문자열이 같음");
		}
	}

}
