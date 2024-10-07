package chap06;

public class ShopService {
	// 싱글톤 기법 사용
	
	// field -> 자신의 객체 저장
	private static ShopService service = new ShopService();
	
	// 생성자 -> 외부 접근 막아야 함
	private ShopService() {};
	
	// method -> 외부로 객체 전달
	static ShopService getInstance() {
		return service;
	}
	
}
