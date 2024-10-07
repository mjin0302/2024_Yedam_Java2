package chap13;

public class Student_p604 {
	
	// field
	public int studentNum;
	public String name;
	
	// constructor
	public Student_p604(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		
		return name.hashCode() + studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student_p604) {
			Student_p604 stu = (Student_p604)obj;
			
			return stu.name.equals(name) && (stu.studentNum == studentNum);
		} else {
			return false;
		}
	}
}
