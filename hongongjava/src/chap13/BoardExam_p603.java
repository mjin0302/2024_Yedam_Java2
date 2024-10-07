package chap13;

import java.util.List;

public class BoardExam_p603 {

	public static void main(String[] args) {
		
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for(Board board : list) {
			System.out.println(board.getSubject() + " - " + board.getContent());
		}

	}

}
