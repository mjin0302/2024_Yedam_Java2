package com.yedam;

import java.util.Date;

public class Employee {
	// 데이터 정보 저장

	// field
	private String empNum; // 사번
	private String name; // 이름
	private String phone; // 전화번호
	private String hireDate; // 입사일
	private int salary; // 급여

	// constructor
	Employee() { }

	Employee(String empNum, String name, String phone, String hireDate, int salary) {
		this.empNum = empNum;
		this.name = name;
		this.phone = phone;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	// method
	public String getEmpNum() {
		return empNum;
	}

	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
