package 도서관리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMain {
	
	static Scanner sc = new Scanner(System.in);
	static MemberDao mDao = MemberDao.getInstance();
	static boolean stop = true;
	
	public static void main(String[] args) {
		Member mem = null;
		// 도서 관리
		// 메인메뉴
		
		// 아이디, 비번 체크하기
		// 이름을 활용해서 로그인되면 그 해당 아이디 이름님 환영합니다 메세지 띄우기
		while(true) {
			System.out.print("아이디 입력 > ");
			String id = sc.nextLine();
			System.out.print("비밀번호 입력 > ");
			String pass = sc.nextLine();
			
			mem = mDao.checkMember(id, pass);
			
			if(mem != null) {
				System.out.println(mem.getMemberName() + "님 반갑습니다.");
				break;
			}
			
			System.out.println("아이디와 비밀번호를 확인하세요. ");
		} // End of 로그인 체크
		
		// 권한이 User => 도서관리 처리.
		if(mem.getResponsibility().equals("User")) {
			bookManage();
		}
		// 권한이 Admin => 회원관리 처리.
		if(mem.getResponsibility().equals("Admin")) {
			memberManage();
		}
		
	} // End Main
	
	static void bookManage() { // 도서관리
		
		
		int cnt = 0;
		
		String bnum;
		String title;
		String writer;
		
		Book book = null;
		BookDao dao = new BookDao();
		List<Book> bList = new ArrayList<>();
		
		
		while(stop) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("1. 도서등록 | 2. 도서검색 | 3. 도서 전체조회 | 4. 도서 삭제 | 5. 도서 정보 변경 | 6. 종료");
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("선택 > ");
			int selNo = Integer.parseInt(sc.nextLine());
			
			switch(selNo) {
			// 선택 1번 : 도서등록
			case 1 :
				System.out.println("[도서등록]");
				System.out.print("책번호 : > ");
				bnum = sc.nextLine();
				System.out.print("책 제목 : > ");
				title = sc.nextLine();
				System.out.print("저자 : > ");
				writer = sc.nextLine();
				System.out.print("가격 : > ");
				int price = Integer.parseInt(sc.nextLine());
				
				book = new Book(bnum, title, writer, price);
				cnt = dao.insert(book);
				
				if(cnt > 0) {
					System.out.println(cnt + "개 추가 성공");
				} else {
					System.out.println("추가 실패");
				}
				
				break;
				
			// 선택 2번 : 도서검색 => 책제목으로 검색
			case 2 :
				System.out.print("검색할 도서 제목을 입력하세요 > ");
				title = sc.nextLine();
				
				book = dao.selectOne(title);
				System.out.println("번호\t제목\t\t저자\t가격");
				System.out.println("========================================");
				if(book != null) {
					System.out.printf("%s\t%s\t\t%s\t%d\n", book.getBnum(), book.getTitle(), book.getTitle(), book.getPrice());
				} else {
					System.out.println("결과가 없습니다. 다시 입력하세요");
					continue;
				}
				
				break;
				
			// 선택 3번 : 도서전체 조회
			case 3 :
				bList = dao.selectAll();
				
				System.out.println("번호\t제목\t\t저자\t가격");
				System.out.println("========================================");
				
				for(Book temp : bList) {
					if(temp != null) {
						System.out.printf("%s\t%s\t\t%s\t%d\n", temp.getBnum(), temp.getTitle(), temp.getTitle(), temp.getPrice());
					} else {
						System.out.println("결과가 없습니다.");
						continue;
					}
				}
				
				break;
				
			// 선택 4번 : 도서 삭제
			case 4 :
				
				
				
				break;
				
			// 선택 5번 : 도서 정보 변경
			//			책 제목, 변경할 책 번호, 변경할 책 가격 입력 => 수정
			case 5 :
				// 책 제목 입력받음 
				// 내가 하고싶은건 책 제목이 있으면 지우고 아니면 continue
				System.out.print("변경하실 책 제목을 입력하세요 > ");
				title = sc.nextLine();
				
				book = new Book(title);
				dao.update(book);
				
				break;

			// 선택 7번 : 프로그램 종료
			case 6:
				System.out.println("Program End");
				stop = false;
				break;
				
			default:
				System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
				break;
			} // End Switch
			
		} // End While
		
	} // End of bookManage()
	
	
	static void memberManage() { // 회원관리
		
		Member mem = new Member();
		List<Member> mList = null;
		
		System.out.println("관리자 메뉴입니다.");
		
		while(stop) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("1. 회원등록 | 2. 회원검색 | 3. 회원 전체조회 | 4. 회원삭제 | 5. 회원정보변경 | 6. 종료");
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("선택 > ");
			int selNo = Integer.parseInt(sc.nextLine());
			
			String uId;
			String uPw;
			String uName;
			String uPhone;
			
			switch(selNo) {
				case 1:
					System.out.println("[회원 등록]");
					
					System.out.print("아이디 : > ");
					uId = sc.nextLine();
					mem.setMemberId(uId);
					
					System.out.print("비밀번호 : > ");
					uPw = sc.nextLine();
					mem.setPhone(uPw);
					
					System.out.print("이름 : > ");
					uName= sc.nextLine();
					mem.setMemberName(uName);
					
					System.out.print("전화번호 : > ");
					uPhone = sc.nextLine();
					mem.setPassword(uPhone);
					
					MemberInsert memIn = new MemberInsert();
					int cnt = memIn.insertMemeber(mem);
					
					if(cnt > 0) {
						System.out.println(uId + "님 등록 성공");
					}
					
					break;
				case 2:
					System.out.print("검색할 회원 이름을 입력하세요. : > ");
					uName = sc.nextLine();
					mem.setMemberId(uName);
					MemberSelect memSel2 = new MemberSelect();
					mList = memSel2.memberSelect(uName);
					
					System.out.println("\t\t회원 목록\t\t");
					System.out.println("ID\tPASS\t이름\t전화번호\t권한\t생성날짜");
					System.out.println("=================================================================");
					
					for(Member member : mList) {
						System.out.println(member);
					}
					
					break;
					
				case 3:
					// 회원목록 출력
					MemberSelect memSel = new MemberSelect();
					mList = memSel.memberList();
					
					System.out.println("\t\t회원 목록\t\t");
					System.out.println("ID\tPASS\t이름\t전화번호\t권한\t생성날짜");
					System.out.println("=================================================================");
					
					for(Member member : mList) {
						System.out.println(member);
					}
					
					break;
					
				case 4:
					
					break;
					
				case 5:
					
					break;
				case 6:
					System.out.println("Program End");
					stop = false;
					break;
					
				default:
					System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
					break;
			}
			
				
		}
//		case 6 :
//		
	} // End of memberManage()

} // End Class
