package 도서관리;

import java.util.Date;

public class Member {
	// field
	private String memberId;
	private String password;
	private String memberName;
	private String phone;
	private String responsibility;
	private Date   creationDate;
	
	// constructor
	
	
	// method
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getResponsibility() {
		return responsibility;
	}
	
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Override
	public String toString() {
		
		return memberId + "\t" + password + "\t\t" + memberName + "\t" + phone + "\t\t" + responsibility + "\t" + creationDate;
	}
	
	
}
