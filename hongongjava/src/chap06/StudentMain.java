package chap06;

public class StudentMain {

	public static void main(String[] args) {
		// 객체를 이용해서 실행할 곳
		// 객체를 생성해서 사용가능
		// 객체 생성
//		Student st1 = new Student("240901", "김옹심");
//		
//		System.out.println(st1.stNo);
//		System.out.println(st1.name);
//		st1.Study();
//		
//		Student st2 = new Student("200902", "김땡댕");
//		System.out.println(st2.stNo);
//		System.out.println(st2.name);
//		st2.Study();
		
//		Student st3 = new Student("홍길동", 80, 90, 88);
//		Student st4 = new Student("성춘향", 100, 87, 99);
//		Student st5 = new Student("이몽룡", 60, 70, 80);
//		Student st6 = new Student("머시기", 30, 50, 66);
//		Student st7 = new Student("거시기", 100, 100, 100);
		
		System.out.println("이름\t국어\t수학\t영어\t총점\t평균\t등급");
		String[] names = {"표하연", "배서진", "권나윤", "김민진", "박주현"};
		System.out.println("=====================================================");
		
		for(int i = 0; i < names.length; i++) {
			int kor = (int)(Math.random() * 100) + 1;
			int eng = (int)(Math.random() * 100) + 1;
			int math = (int)(Math.random() * 100) + 1;
			
			Student stu = new Student(names[i], kor, eng, math);
			System.out.printf("%s\t%2d\t%2d\t%2d\t%3d\t%.2f\t%2s", stu.name, stu.kor, stu.eng, stu.math, stu.totalScore(), stu.average(), stu.grade());
			System.out.println();
		}
		
	}

}
