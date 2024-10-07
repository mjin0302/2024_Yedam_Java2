package chap05;

public class Exam223 {

	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		int count = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				count++;
			}
			System.out.println();
		}
		avg = (double)sum / (double)count;
		System.out.printf("sum: %d\tcount: %f", sum, avg);
	}

}
