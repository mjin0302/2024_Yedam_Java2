package chap04;

public class Exam173 {

	public static void main(String[] args) {
		// 50에서 100까지 3의 배수 합 구하기
		// 3의 배수 출력, 마지막에 3의 배수합 출력
		// 3의 배수 갯수 출력
		int count = 0;
		int sum = 0;
		
		for(int i = 50; i <= 100; i++) {
			if(i % 3 == 0) {
				count++;
				sum += i;
				System.out.println(i + " ");
			}
		}
		System.out.println("3의 배수의 합은? " + sum);
		System.out.println("3의 배수 갯수는? " + count + "개");
		
		// 1에서 n까지의 합이 300이 넘는 순간 n값 구하기
		// 7의 배수의 합이 300이 넘는 순간의 7의 배수 찾기
		// 7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84, 91 
		int su = 0;
		sum = 0;
		while(sum < 300) {
			su += 7;
			sum += su;
		}
		System.out.println("7의 배수: " + su);
		System.out.println("7의 배수 합: " + sum);
		
		su = 0;
		sum = 0;
		while(true) {
			su += 7;
			sum += su;
			if(sum >= 300) break;
		}
		System.out.println("7의 배수: " + su);
		System.out.println("7의 배수 합: " + sum);
		
		boolean stop = true;
		int num = 0;
		sum = 0;
		while(stop) {
			num++;
			if(num % 7 == 0) {
				sum += num;
				if(sum > 300) {
					stop = false;
				}
			}
		}
		System.out.println("7의 배수: " + num);
		System.out.println("7의 배수 합: " + sum);
		
		// 구구단 : 중첩 for문
		for(int i = 2; i < 10; i++) {
			System.out.println("=== " + i + "단 ===");
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %2d\n",i, j, (i*j));
			}
		}
		
		for(int i = 2; i < 10; i++) {
			System.out.print("=== " + i + "단 ===\t");
		}
		System.out.println();
		
		for(int i = 1; i < 10; i++) {
			for(int j = 2; j < 10; j++) {
				System.out.printf("%d * %d = %2d \t",j , i, (i * j));
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // End Main

} // End Class
