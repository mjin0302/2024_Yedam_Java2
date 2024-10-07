package chap06;

public class Student {
	// 필드(속성)
	String stNo;
	String name;
	// 국어, 영어, 수학 점수
	int kor;
	int eng;
	int math;
	
	// 생성자(객체 생성) -> 객체의 속성을 초기화
	// 매게 변수가 우선권을 가짐
	// !! 생성자는 리턴값이 없고 클래스 이름과 같아야함
	// 외부에서 값을 받아서 생성자가 처리함
	Student () {}
	
	Student(String stNo, String name) {
		this.stNo = stNo;
		this.name = name;
	}
	Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// 메소드(기능)
	void Study() {
		System.out.println("공부합니다.");
	}
	
	int totalScore () {
		return kor + eng + math;
	}
	
	double average() {
		
		return totalScore() / 3.0;
	}
	
	String grade() {
		
		// 등급을 저장할 변수
		String rank = "";
		
		switch((int)average() / 10) {
			case 10 : 
				break;
			case 9 : rank = "A";
				break;
			case 8 : rank = "B";
				break;
			case 7 : rank = "C";
				break;
			case 6 : rank = "D";
				break;
			default : rank = "F";
				break;
		}
		
		return rank;
	}
	
}
