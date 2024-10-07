package chap06;

public class SingletonMain {

	public static void main(String[] args) {
		// 싱글톤 사용시 객체생성 불가 -> 메소드를 호출해서 객체를 받아와야 함
		
		Singleton st = Singleton.getInstance();
		Singleton st2 = Singleton.getInstance();
		
		if(st == st2) {
			System.out.println("같음");
		} else {
			System.out.println("다른 객체");
		}
		
		System.out.println(st.name);
		System.out.println(st2.name);
	}

}
