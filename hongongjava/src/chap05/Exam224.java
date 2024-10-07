package chap05;

import java.util.Scanner;

public class Exam224 {

	public static void main(String[] args) {
		// 
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1. 학생수  |  2. 점수입력  |  3. 점수리스트  |  4. 분석  |  5. 종료");
			System.out.println("------------------------------------------------------------");
			System.out.print("선택 > ");
			int no = Integer.parseInt(sc.nextLine());
			
			switch(no) {
			case 1 :
				System.out.print("학생수 > ");
				studentNum = Integer.parseInt(sc.nextLine());
				scores = new int[studentNum];
				break;
			case 2 :
				if(studentNum > 0) {
					for(int i = 0; i < scores.length; i++) {
						System.out.printf("score[%d] > ", i);
						scores[i] = Integer.parseInt(sc.nextLine());
					}
				} else {
					System.out.println("학생수를 먼저 입력하세요");
					continue;
				}
				break;
			case 3 :
				if(scores == null || scores.length == 0) {
					System.out.println("등록된 점수가 존재하지 않습니다. 점수를 등록하세요");
					continue;
				} else {
					for(int i = 0; i < scores.length; i++) {
						System.out.printf("score[%d]: %d\n", i, scores[i]);
					}
					break;
				}
			case 4 :
				int max = 0;
				int total = 0;
				double avg = 0;
				for(int i = 0; i < scores.length; i++) {
					if(max < scores[i]) {
						max = scores[i];
					}
					total += scores[i];
				}
				System.out.println("최고점수: " + max);
				System.out.printf("평균 점수: %f\n", (double)total / scores.length);
				break;
			case 5 : 
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("선택한 메뉴가 없습니다. 다시 선택하세요");
			}
		}
		sc.close();
	}

}
