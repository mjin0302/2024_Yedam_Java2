package cat.com.service;

import cat.com.ConsoleShow;
import cat.com.dao.SalesDAO;
import cat.com.vo.Member;

public class SalesService extends ConsoleShow {

	public void salesMenu(Member mem) {
		int menu = 0;
		while (stop) {
			System.out.println("😀" + mem.getName() + "님 메뉴를 선택하세요. 😀");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("         1. 총 매출 조회  |  2. 상품별 매출 조회  |  3. 뒤로가기  |  4. 종료");
			System.out.println("--------------------------------------------------------------------------------");

			System.out.print("메뉴선택 > ");
			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\n잘못된 입력입니다. 메뉴에 있는 번호를 입력하세요.");
				continue;
			}

			System.out.println();
			
			SalesDAO salesDao = new SalesDAO();
			
			switch (menu) {
			case 1:	// 총 매출 조회
				sales(salesDao.getTotalSales());
				break;

			case 2:	// 상품별 매출 조회
				salesByProduct(salesDao.getSalesByProduct());
				break;

			case 3:	// 뒤로가기
				return;

			case 4: // 종료
				programEnd();
				stop = false;
				break;

			default:
				System.out.println("선택한 메뉴는 존재하지 않습니다. 다시 선택 하세요.");
				break;

			} // End of switch
		}

	}
}
