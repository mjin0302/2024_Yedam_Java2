package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberMain {

	public static void main(String[] args) {
		// 
		Set<Member> set = new HashSet<Member>();
		
		// new연산자를 이용해 생성하면 주소값이 다 다르다
		set.add(new Member("홍길동", 30)); 
		set.add(new Member("홍길동", 30));
		set.add(new Member("최길동", 30));
		set.add(new Member("최길동", 50));
		
		System.out.println("총 객체 수 : " + set.size());
		System.out.println();
		
		System.out.println("이름\t나이");
		System.out.println("===============");
		for(Member ele : set) {
			System.out.printf("%s\t%d\n", ele.name, ele.age);
		}
		
		// 반복자
		// set이 가지고 있는 메소드에 의해서 iterator을 만들 수 있음
		Iterator<Member> iterator = set.iterator();
		while(iterator.hasNext()) {
			Member m = iterator.next();
			System.out.println(m.name + m.age);
		}
		
		
	} // End Main

} // End Class
