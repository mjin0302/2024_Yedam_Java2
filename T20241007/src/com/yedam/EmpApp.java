package com.yedam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {
		// Main
		Scanner sc = new Scanner(System.in);
		
		boolean stop = true;
		
		String empNum;  	// 사번
		String name; 		// 이름
		String phone; 		// 전화번호
		String hireDate;	// 입사일
		int salary; 		// 급여
		
		Employee emp = null;
		EmpDAO DAO = new EmpDAO();
		
		List<Employee> list = new ArrayList<>();
		
		int cnt = 0;
		
		while(stop) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("1. 등록 | 2. 목록 | 3. 수정(급여) | 4. 삭제 | 5. 조회(입사일자) | 6. 종료");
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("선택 > ");
			int selNo = Integer.parseInt(sc.nextLine());
			
			switch(selNo) {
			
			case 1:
				System.out.println("[사원 등록]");
				
				System.out.print("사번입력 >> ");
				empNum = sc.nextLine();
				
				System.out.print("이름입력 >> ");
				name = sc.nextLine();
				
				System.out.print("전화번호입력 >> ");
				phone = sc.nextLine();
				
				System.out.print("입사일입력 >> ");
				hireDate = sc.nextLine();
				
				System.out.print("급여 >> ");
				salary = Integer.parseInt(sc.nextLine());
				
				emp = new Employee(empNum, name, phone, hireDate, salary);
				cnt = DAO.insert(emp);
				
				if(cnt > 0) {
					System.out.println(name + "님이 등록되었습니다.");
					break;
				}
				break;
				
			case 2:
				list = DAO.selectAllList();
				
				System.out.println("사번\t이름\t전화번호");
				System.out.println("=========================");
				
				for(Employee temp : list) {
					if(temp != null) {
						System.out.printf("%s\t%s\t%s\n", temp.getEmpNum(), temp.getName(), temp.getPhone());
					} else {
						System.out.println("조회 결과가 없습니다.");
						continue;
					}
				}
				
				break;
				
			case 3:
				System.out.print("사번 >> ");
				empNum = sc.nextLine();
				System.out.print("급여 >> ");
				salary = Integer.parseInt(sc.nextLine());
				
				cnt = DAO.update(empNum, salary);
				
				if(cnt > 0) {
					System.out.println("수정이 완료되었습니다.");
					break;
				}
				System.out.println("수정 실패");
				break;
				
			case 4:
				System.out.print("사번 >> ");
				empNum = sc.nextLine();
				
				cnt = DAO.delete(empNum);
				
				if(cnt > 0) {
					System.out.println("회원삭제 완료");
					break;
				}
				System.out.println("삭제 실패");
				break;
				
			case 5:
				System.out.print("입사일자 >> ");
				hireDate = sc.nextLine();
				
				list = DAO.select(hireDate);
				
				System.out.println("사번\t이름\t입사일자");
				System.out.println("==============================");
				
				for(Employee temp : list) {
					System.out.printf("%s\t%s\t%s\n", temp.getEmpNum(), temp.getName(), temp.getHireDate());	
				}
				
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
	}

}
