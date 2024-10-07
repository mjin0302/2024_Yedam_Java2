package chap10;

public class ThrowsMain {
	
	public static void main(String[] args) {
		// 예외 떠넘기기
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			// 넘겨받은 예외 처리
			System.out.println("Class를 찾지 못함");
		}
		
	}

	// ClassNotFoundException -> 이 메소드를 호출하는 애 한테 예외가 떠넘겨짐
	private static void findClass() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class clazz = Class.forName("java.lang.String2");
	}
}
