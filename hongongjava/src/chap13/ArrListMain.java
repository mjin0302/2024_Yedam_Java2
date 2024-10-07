package chap13;

import java.util.ArrayList;
import java.util.List;

public class ArrListMain {

	public static void main(String[] args) {
		// List Collection
		// ArrayList
		List<String> list = new ArrayList<String>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		
		int size = list.size();
		System.out.println("총 객체 수(5개) : " + size);
		System.out.println();
		
		// 인덱스 길이 객체
		String skill = list.get(2);
		System.out.println("2: " + skill);
		System.out.println();
		
		// ArrayList 값 출력
		for(int i = 0; i < size; i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		System.out.println();
		
		list.remove(2);			// Database가 지워짐
		list.remove(2);			// Servlet/JSP가 지워짐
		list.remove("iBATIS");	// iBATIS가 지워짐
		
		// 결과값 [0] -> Java, [1] -> JDBC
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		
		for(String obj : list) {
			System.out.println(obj);
		}
		
	} // End Main

}
