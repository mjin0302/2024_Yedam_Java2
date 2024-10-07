package chap05;

public class Exam214 {

	public static void main(String[] args) {
		// 2차원 배열
		int[][] scores = {
				{10, 20, 30},
				{40, 50, 60}
		};
		
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++) {
				System.out.print(scores[i][j] + " ");
			}
			System.out.println();
		}
		
//		for(int i = 0; i < scores.length; i++) {
//			for(int j : scores[i]) {
//				System.out.print(scores[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 2 * 3 배열을 선언하고 
		// 1에서 10까지 무작위 수를 입력하세요
		
		int[][] nums = new int[2][3];
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				int randomNum = (int)(Math.random() * 10) + 1;
				nums[i][j] += randomNum;
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
		
		// 향상된 for문
		int[] su = {10, 20, 30, 40, 50};
		
		// 배열의 합
		// 향상된 for문을 이용
		int sum = 0;
		for(int ele : su) {
			sum += ele;
		}
		System.out.println("sum = " + sum);
		
		// 배열의 합, 최대값, 최소값
		// 향상된 for문을 이용
		int[] su2 = {10, 20, 30, 40, 50};
		
		// 배열의 합
		// 향상된 for문을 이용
		int sum2 = 0;
		int max = Integer.MIN_VALUE;	// int값 중에 최소값
		int min = Integer.MAX_VALUE;	// int 값 중에 최대값
		for(int ele : su2) {
			sum2 += ele;
			if(max < ele) max = ele;
			if(min > ele) min = ele;
		}
		System.out.printf("sum = %d\tmax = %d\tmin = %d", sum, max, min);
		
		
		
	} //End Main

} // End Class
