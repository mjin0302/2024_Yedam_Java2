package 김민진;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		// 2024.09.26 과제
		// 1. 배열에 저장 된 값들의 합, 최대값, 최소값 구하기

		// 1-1. 배열 값 : 1에서 100까지의 난수(Math.random()) 10개 배열에 저장
		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			int num = (int) (Math.random() * 100) + 1;
			nums[i] += num;
		}
		// 1-2. 배열 값 출력
		System.out.println(Arrays.toString(nums));
		// 1-3. 배열 값의 합계, 최대값, 최소값 출력
		int max = 0;
		int min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (max < nums[i])
				max = nums[i];
			if (min > nums[i])
				min = nums[i];
		}
		System.out.printf("최소값: %d\t최소값: %d\n", min, max);
		System.out.println();
		System.out.println("==================================================");
		System.out.println();

		// 2. 2차원 배열 출력
		// 배열= {{1,2,3}, {1,2}, {1}, {1,2,3}};
		int[][] arrNums = { 
				{ 1, 2, 3 }, 
				{ 1, 2 }, 
				{ 1 }, 
				{ 1, 2, 3 } 
			};

		for (int i = 0; i < arrNums.length; i++) {
			for (int j = 0; j < arrNums[i].length; j++) {
				System.out.print(arrNums[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("==================================================");
		System.out.println();
		// 3. 현재 관객의 수 출력
		// • 관객이 있는 좌석은 1, 없는 좌석은 0 : 난수 이용
		// • 극장의 자리는 1줄에 10좌석씩 3줄
		// 3-1 3행 10열의 배열에 0 또는 1 저장 -> 값 출력
		// 3-2 관객 수 계산하기 -> 현재 관객 수는 00명
		int[][] audience = new int[3][10];
		int count = 0;
		for (int i = 0; i < audience.length; i++) {
			for (int j = 0; j < audience[i].length; j++) {
				int ranNum = (int) (Math.random() * 2);
				audience[i][j] += ranNum;
				System.out.print(audience[i][j] + " ");
				if (audience[i][j] == 1)
					++count;
			}
			System.out.println();
		}
		System.out.println("현재 관객수는 : " + count);
		
		System.out.println();
		System.out.println("==================================================");
		System.out.println();

		// 4. 학생 별 평균 계산하기 (난수 생성해서)
		// • 학생 3명, 각 학생당 5번의 테스트 점수를 배열에 저장
		// • 50 <= 점수 <= 100
		// • 학생 별 평균 계산 출력 (한명당 평균점수 내기)
		Scanner sc = new Scanner(System.in);
		int[][] scores = new int[3][5];
		int[] total = new int[3];
		int avg = 0;

		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				int scoreNum = (int) (Math.random() * 51) + 50;
				scores[i][j] += scoreNum;
				System.out.printf("%5d ", scores[i][j]);
				total[i] += scores[i][j];
			}
			System.out.printf("%3d번째 학생의 총 합: %3d점", i, total[i]);
			System.out.println();
		}
		for (int i = 0; i < scores.length; i++) {
			avg = total[i] / scores[i].length;
			System.out.printf("%4d 번째 학생의 평균: %d\n", i, avg);
		}
		
		System.out.println();
		System.out.println("==================================================");
		System.out.println();

		// 5. 카드를 랜덤하게 선택하여 화면에 출력
		// • 배열 : {"Clubs", "Diamonds", "Hearts", "Spades"}
		// • 배열 : {"2","3","4", "5", "6","7","8","9","10","Jack","Queen","King","Ace"}
		// • 각 카드를 랜덤하게 선택하는 코드 작성(5번)
		// 배열 선언
		String[][] cards = { 
				{ "Clubs", "Diamonds", "Hearts", "Spades" },
				{ "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" } 
			};
		// 단어를 저장 할 배열 선언
		String[] word = new String[2];
		// cards 다중배열에서 랜덤하게 뽑기위해 index번호 저장 할 배열 선언
		int[] indexNum = new int[2];
		for (int i = 0; i < cards.length; i++) {
			// index번호 랜덤생성
			indexNum[i] += (int)(Math.random() * cards[i].length);
			
			// word 배열 초기화 후 값 추가
            word[i] = cards[i][indexNum[i]];
        }
		System.out.println(Arrays.toString(word) + " " + Arrays.toString(indexNum));
		System.out.printf("%s의 %s\n", word[0], word[1]);
		
		System.out.println();
		System.out.println("==================================================");
		System.out.println();

		// 6. 2차원 배열 만들기
		// • 3*5 크기의 2차원 배열 생성하고 초기값은 0으로 초기화
		int[][] intNums = new int[3][5]; // 0
		int cnt = 0;
		// • 5개의 정수 1을 랜덤하게 배치
		while(true) {
			int row = (int)(Math.random() * intNums.length); // 0 0 0  3
			int col = (int)(Math.random() * intNums[row].length); // 0 0 0 0 0 5
			
			intNums[row][col] = 1;
			
			if(cnt < 5) cnt++;
			else if (cnt >= 5) break;
			
		}
		for(int i = 0; i < intNums.length; i++) {
			for(int j = 0; j < intNums[i].length; j++) {
				System.out.print(intNums[i][j] + "\t");
			}
			System.out.println();
		}
		// • 최종 배열 출력

	} // End Main

} // End Class
