package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample_p604 {

	public static void main(String[] args) {
		
		Set<Student_p604> set =  new HashSet<Student_p604>();
		
		set.add(new Student_p604(1, "표하연"));
		set.add(new Student_p604(2, "배서진"));
		set.add(new Student_p604(3, "권나윤"));
		set.add(new Student_p604(4, "김민진"));
		set.add(new Student_p604(5, "박주현"));
		
		Iterator<Student_p604> iterator = set.iterator();
		while(iterator.hasNext()) {
			Student_p604 stu = iterator.next();
			System.out.println(stu.studentNum + " : " + stu.name);
		}
		
	} // End Main

} // End Class
