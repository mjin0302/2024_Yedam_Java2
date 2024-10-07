package chap07;

public class Computer extends Calculator {
	// 메소드 재정의
	// return 말고 나머지는 수정 불가
	@Override
	double areaCircle(double r) {
		// return 값만 내가 원하는대로 가능
		return Math.PI * r * r;
	}
	
	double ac(double r) {
		if(r >= 10) {
			double rs = super.areaCircle(r);
			System.out.println("computer super");
			return rs;
		} else {
			double rs = areaCircle(r);
			System.out.println("computer not super");
			return rs;
		}
	}

}
