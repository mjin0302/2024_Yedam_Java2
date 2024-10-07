package chap06;

public class Singleton {
	// 전체 프로그램에서 하나의 객체만 존재하게 하는 코딩 기법
	// 셍성ㅈㅏ 접근 불가, 필드 접근 불가하게 만들어야함
	// class 접근
	
	// 필드
	private static Singleton st = new Singleton();
	String name = "홍길동";
	
	
	// 생성자
	private Singleton() {};
	
	// 메소드 : 외부로 객체 전달(전달해야 외부에ㅓㅅ 사용 가능)
	static Singleton getInstance() {
		return st;
	}
	
}
