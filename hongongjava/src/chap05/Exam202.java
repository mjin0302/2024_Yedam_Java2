package chap05;

import java.util.Arrays;

public class Exam202 {

	public static void main(String[] args) {
		// 배열을 생성
		int[] scores = {83, 90, 87};
		
		// 배열을 이용하는 방법
		System.out.println("scores[0]: " + scores[0]);
		System.out.println("scores[0]: " + scores[1]);
		System.out.println("scores[0]: " + scores[2]);
		
		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("총합: " + sum);
		double avg = (double) sum / scores.length;
		System.out.printf("평균: %.2f\n", avg );
//		----------------------------------------------------------------------------------------------------
		// 배열에 1에서 100까지의 임의의 수 10개를 저장
		int[] intArr = new int[10];
		System.out.print("intArr: ");
		for(int i = 0; i < intArr.length; i++) {
			int num = (int)(Math.random() * 100) + 1;
			intArr[i] = num;
			
			System.out.print(intArr[i] + " ");
		}
		System.out.println();
		intArr = Arrays.stream(intArr).distinct().toArray();
		System.out.println(Arrays.toString(intArr));
		
		// 배열의 합과 평균(소수 첫째자리까지 나타냄),
		int hap = 0;
		double avg2 = 0;
		int max = 0;
		int min = intArr[0];
		for(int i = 0; i < intArr.length; i++) {
			hap += intArr[i];
			avg2 = (double)hap / intArr.length;
			
			// 최대값, 최소값을 구하세요
			if(max < intArr[i]) max = intArr[i];
			if(min > intArr[i]) min = intArr[i];
		}
		System.out.printf("총 합: %d\t평균: %.1f\n", hap, avg2);
		System.out.printf("최대값: %d\t최소값: %d", max, min);
		System.out.println();

	}
}
