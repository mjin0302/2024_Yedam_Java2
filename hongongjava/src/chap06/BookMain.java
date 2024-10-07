package chap06;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		/* 
		 * 2. 도서관리 Main
		 * 	  메뉴 -> 1. 도서 수 입력 2. 도서 입력 3. 도서목록 조회 4. 도서분석 5. 종료
		 * 	  도서 수 만큼의 배열생성 -> 도서 객체 저장
		 * 	  메뉴 항목 선택 
		 * 		1 -> 도서 수 입력 ok
		 * 		2 -> 도서 객체 생성 배열에 저장 ok
		 * 		3 -> 도서 목록 출력
		 * 			 3-1. 책 제목을 입력받는다.
		 * 			 3-2. 책 제목을 set 메소드를 이용해 book에 넣는다
		 * 		그러면? 변수가 있어야하고.. 
		 * 		4 -> 도서 평균 가격, 최대가격 출력
		 * 		5 -> 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		
		boolean stop = true;	// while 동작
		int num = 0;			// 도서 수
		
		Book[] books = null;	// 도서 객체를 저장할 Book타입의 배열
		int total = 0;
		
		while(stop) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("1. 도서 수 입력 | 2. 도서 입력 | 3. 도서목록 조회 | 4. 도서분석 | 5. 종료");
			System.out.println("-----------------------------------------------------------------");
			System.out.print("선택 > ");
			int no = Integer.parseInt(sc.nextLine());
			if(!Character.isDigit(no)) System.out.println("없는 메뉴 입니다. 다시 선택하세요");
			else continue;
			
			switch(no) {
				case 1 : 
					System.out.print("저장 할 도서 수를 입력하세요. > ");
					num = Integer.parseInt(sc.nextLine());
					books = new Book[num];
					break;
					
				case 2 :
					if(books != null) {
						for(int i = 0; i < books.length; i++) {
							
							String bookNo = String.valueOf(i + 1);
							
							System.out.print("책 제목을 입력하세요. > ");
							String title = sc.nextLine();
							
							System.out.print("책 가격을 입력하세요. > ");
							int price = Integer.parseInt(sc.nextLine());
							
							books[i] = new Book(bookNo, title, price);
							
						}
						break;
					} else {
						System.out.println("저장할 도서 수를 먼저 입력하세요.");
						continue;
					}
					
				case 3 :
					if(books != null) {
						System.out.println("책번호\t제목\t가격\t");
						System.out.println("=====================================================");
						for(Book book : books) {
							System.out.printf("%10s\t%10s\t%d\n", book.getBookNo(), book.getTitle(), book.getPrice());
						}
						System.out.println();
						break;
					} else {
						System.out.println("책 정보를 먼저 입력하세요");
						continue;
					}
					
				case 4 :
					int max = books[0].getPrice();
					for(int i = 0; i < books.length; i++) {
						total += books[i].getPrice();
						
						if(max < books[i].getPrice()) {
							max = books[i].getPrice();
						}
					}
					System.out.printf("합 = %d\t평균 가격 = %d\t최대가격 = %d\n", total, (total / books.length), max);
					break;
					
				case 5 :
					System.out.println("Program End");
					stop = false;
					break;
				default :
					if(!Character.isDigit(no)) System.out.println("없는 메뉴 입니다. 다시 선택하세요");
					break;
			} // End switch
			
		} // End While
		
	} // End Class

} // End main
