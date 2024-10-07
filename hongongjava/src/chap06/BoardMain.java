package chap06;

public class BoardMain {

	public static void main(String[] args) {
		// 
		Board board = new Board("제목1", "내용1");
		Board board2 = new Board("제목2", "내용2", "작성자1");
		Board board3 = new Board("제목3", "내용3", "작성자2", "날짜1");
		Board board4 = new Board("제목4", "내용4", "작성자3", "날짜2", 10);
		
		System.out.printf("제목: %s, 내용: %s, 작성자: %s, 날짜: %s, count: %d\n", board.title, board.content, board.writer, board.date, board.hitcount);
		System.out.printf("제목: %s, 내용: %s, 작성자: %s, 날짜: %s, count: %d\n", board2.title, board2.content, board2.writer, board2.date, board2.hitcount);
		System.out.printf("제목: %s, 내용: %s, 작성자: %s, 날짜: %s, count: %d\n", board3.title, board3.content, board3.writer, board3.date, board3.hitcount);
		System.out.printf("제목: %s, 내용: %s, 작성자: %s, 날짜: %s, count: %d\n", board4.title, board4.content, board4.writer, board4.date, board4.hitcount);
	}

}
