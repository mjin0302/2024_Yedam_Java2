package chap06;

public class CalcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator myCalcu = new Calculator();
		
		// 정사각형의 넓이 구하기
		double result = myCalcu.areaRectangle(10);
		
		// 직사각형의 넓이 구하기
		double result2 = myCalcu.areaRectangle(10, 20);
		
		// 결과 출력
		System.out.println("정사각형의 넓이 = " + result);
		System.out.println("직사각형의 넓이 = " + result2);
	}

}
