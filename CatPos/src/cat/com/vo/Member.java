package cat.com.vo;

import java.util.Date;

public class Member {

	private String id;			// 회원 ID
	private String pass;		// 비밀번호
	private String phone;		// 전화번호
	private Date hireDate;		// 입사일
	private String role;		// 권한
	private String productId;	// 상품 코드t
	private String name;

	// constructor
	public Member() { }

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public Member(String id, String pw, String name, String phone) {
		this.id = id;
		this.pass = pw;
		this.name = name;
		this.phone = phone;
	}

	// method
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pass=" + pass + ", phone=" + phone + ", hireDate=" + hireDate + ", role=" + role
				+ ", productId=" + productId + ", name=" + name + "]";
	}
	
}
