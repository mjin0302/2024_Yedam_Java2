package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMain {

	public static void main(String[] args) {
		// set : 순서 보장 안됨, 중복 객체 저장 안됨, 반복자 필요함
		
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");		// 이미 Java값이 저장되어 있어서 저장X
		set.add("iBATIS");
		
		// 저장된 객체 수 얻기
		int size = set.size();
		System.out.println("총 객체 수: " + size);
		
		// 반복자 얻기
		Iterator<String> iterator = set.iterator();
		
		// 객체 수 만큼 돌기
		while(iterator.hasNext()) {
			String ele = iterator.next();
			System.out.println("\t" + ele);
		}
		System.out.println("=========================");
		System.out.println("총 객체 수: " + set.size());
		// 향상된 for문을 이용해 객체 출력
		for(String str : set) {
			
			System.out.println("\t" + str);
		}
		
		set.remove("JDBC");
		set.remove("iBATIS");
		
		System.out.println("총 객체 수: " + set.size());
		
		// 반복자 얻기
		iterator = set.iterator();
		// 객체 수만큼 루핑
		for(String ele : set) {
			System.out.println("\t" + ele);
		}
		
		// 모든 객체를 제거하고 비움
		set.clear();
		if(set.isEmpty()) System.out.println("비어 있음");
		
	} // End Main

} // End Class
