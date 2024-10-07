package chap13;

import java.util.List;
import java.util.Vector;

public class BoardMain {
	
	public static void main(String[] args) {
		
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		list.remove(2);
		list.remove(3);
		System.out.println("제목 \t내용\t글쓴이\t");
		System.out.println("=========================");
//		for(int i = 0; i < list.size(); i++) {
//			Board board = list.get(i);
//			System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
//		}
		
		for(Board bd : list) {
			System.out.printf("%s\t%s\t%s\n", bd.subject, bd.content, bd.writer);
		}
		
		// 해시코드
		Board bd = new Board("제목", "내용", "글쓴이"); //
		// println 메소드 자체가 toString 메소드를 실행시킨다
		System.out.println("bd = " + bd);						// bd의 주소값
		System.out.println("hashCode = " + bd.hashCode());	// hashCode는 int형이다
		System.out.println("String = " + bd.toString());	// 객체가 가지고 있는 주소값
		
	} // End Main
	
} // End Class
