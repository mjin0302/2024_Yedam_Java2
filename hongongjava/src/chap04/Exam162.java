package chap04;

public class Exam162 {

	public static void main(String[] args) {
		// 주사위 2개를 던져서 합이 5가되면 종료 - game over
		// 5가 아니면 (1, 3) 주사위 눈 표시
		// 몇번만에 나왔는지?
		
		// boolean 
		int count = 0;
		while(true) {
			int dice1 = (int)(Math.random() * 6) + 1;
			int dice2 = (int)(Math.random() * 6) + 1;
			
			count += 1;
			System.out.printf("(%d, %d)\t", dice1, dice2);
			
			if((dice1 + dice2) == 5) {
				System.out.println("\nGame Over");
				System.out.println("몇번만에 5가 나왔을까?" + count);
				break;
			}
		}
		
		// 주사위 눈이 1이면 1등 ~ 6이면 6등
		int dice2 = (int)(Math.random() * 6) + 1;
		String rank;
		
		switch(dice2) {
			case 1: rank = "1등";
				break;
			case 2: rank = "2등";
				break;
			case 3: rank = "3등";
				break;
			case 4: rank = "4등";
				break;
			case 5: rank = "5등";
				break;
			case 6 : rank = "6등";
				break;
			default : rank = "값이 이상함";
				break;
		}
		System.out.printf("주사위 값: %d, 몇등? %s \n", dice2, rank);
		
		System.out.println(dice2 + "등");
		
		// 50에서 100까지 수를 발생
		// 90 이상이면 A, 80이상이면 B, 70이상이면 C, 60이상이면 D, 나머지 F
		int score = (int)(Math.random() * 51) + 50;
				
		switch(score / 10) {
			case 10: rank = "A";
			case 9: rank = "A";
				break;
			case 8: rank = "B";
				break;
			case 7: rank = "C";
				break;
			case 6: rank = "D";
				break;
			default : rank = "F";
				break;
		}
		System.out.printf("점수: %d, 학점: %s", score, rank);
		
		
		
		
		
		
		
		
	} // End Main

}
