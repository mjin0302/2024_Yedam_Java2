package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DataAccessObject
public class EmpDAO {
	
	// field
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql;

	// localhost대신 192.168.0.18로 하기
	String url = "jdbc:Oracle:thin:@192.168.0.18:1521:xe";
	String id = "java";
	String pass = "1234";

	// method
	// 1. 연결 설정 메소드(void)
	public void getOpen() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection(url, id, pass);

			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // End Open

	// 2. 연결 끊기 메소드(void)
	public void getClose() {
		if (conn != null) {
			try {
				conn.close();

				System.out.println("연결끊기");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // End if
		
	} // End Close

	// 문제2번. 추가, 수정, 삭제, 조회(입사일자 기준), 목록 출력
	// 회원 추가
	public int insert(Employee emp) {
		getOpen();
		
		try {
			sql = "INSERT INTO employee (emp_num, "
				+ 						"name, "
				+ 						"phone, "
				+ 						"hire_date, "
				+ 						"salary) "
				+ "VALUES 				(?, "
				+ 						"?, "
				+ 						"?, "
				+ 						"TO_DATE(?, 'YYYY-MM-DD'), "
				+ 						"?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmpNum());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getPhone());
			pstmt.setString(4, emp.getHireDate());
			pstmt.setInt(5, emp.getSalary());
				
			int rows = pstmt.executeUpdate();
			
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		getClose();
		return 0;
		
	} // End insert

	// 목록조회
	public List<Employee> selectAllList() {
		getOpen();
		
		sql = "SELECT  emp_num, "
			+         "name, "
			+         "phone, "
			+      	  "hire_date, " 
			+      	  "salary " 
			+ "FROM    employee "
			+ "ORDER BY emp_num";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			List<Employee> list = new ArrayList<>();
			
			while(rs.next()) {
				String empNum = rs.getString(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String hireDate = rs.getString(4);
				int salary = rs.getInt(5);
				
				Employee emp = new Employee(empNum, name, phone, hireDate, salary);
				
				list.add(emp);
			}
			
			getClose();
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 수정 
	public int update(String empNum, int salary) {
		getOpen();
		
		try {
			sql = "UPDATE employee "
				+ "SET    salary = ? "
				+ "WHERE  emp_num = ? ";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, salary);
			pstmt.setString(2, empNum);
				
			int rows = pstmt.executeUpdate();
			
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		getClose();
		return 0;
	}
	
	// 삭제
	public int delete(String empNum) {
		getOpen();
		
		try {
			sql = "DELETE FROM employee "
				+ "WHERE  	   emp_num = ? ";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, empNum);
				
			int rows = pstmt.executeUpdate();
			
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		getClose();
		return 0;
	}

	public List<Employee> select(String hireDate) {
		sql = "SELECT   emp_num, " 
		    +     	   "name, "
			+	       "phone, " 
			+   	   "TO_CHAR(hire_date, 'YYYY-MM-DD'), " 
	        + 		   "salary " 
	        + "FROM     employee "
	        + "WHERE    hire_date >= TO_DATE(?, 'YYYY-MM-DD') "
	        + "ORDER BY emp_num";
			
		getOpen();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hireDate);
			
			ResultSet rs = pstmt.executeQuery();
			
			List<Employee> list = new ArrayList<>();
			
			while(rs.next()) {
				String empNum = rs.getString(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String hireDate2 = rs.getString(4);
				int salary = rs.getInt(5);
				
				Employee emp = new Employee(empNum, name, phone, hireDate2, salary);
				
				list.add(emp);
			}
			
			return list;
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
		getClose();
	    return null;
	}

	// 조회하면 - 입사일자 기준으로 조회
}
