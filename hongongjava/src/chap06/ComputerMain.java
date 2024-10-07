package chap06;

public class ComputerMain {

	public static void main(String[] args) {
		// 
		Computer computer = new Computer();
		int[] values = {1, 2, 3};
		int result1 = computer.sum1(values);
		
		System.out.println("result1: " + result1);
		
		int result2 = computer.sum1(new int[] {1, 2, 3, 4, 5});
		System.out.println("result2: " + result2);
		
		int result3 = computer.sum2(1, 2, 3);
		System.out.println("result3: " + result3);
		
		int result4 = computer.sum2(1, 2, 3, 4, 5);
		System.out.println("result4: " + result4);
	}

}
