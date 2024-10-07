package chap06;

public class Computer {
	// field
	// constructor
	// method
	int sum1(int[] values) {
		int sum = 0;
		for(int i = 0; i < values.length; i++) { 
			sum += values[i];
		}
		return sum;
	}
	
	int sum2(int ... values) {
		int sum = 0;
		for(int num : values) {
			sum += num;
		}
		
		return sum;
	}
}
