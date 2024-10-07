package chap06;

public class Book {
	/*
	 * 1. 도서 객체 생성 class
	 *    책 제목, 도서번호, 도서 가격
	 *    외부에서 필드 접근을 막고, getter, setter 사용해서 접근 
	*/
	// field
	private String title;
	private String bookNo;
	private int price;
	
	// constructor
	Book() {};
	
	Book(String title, String bookNo, int price) {
		this.title = title;
		this.bookNo = bookNo;
		this.price = price;
	};
	
	// method
	// getter, setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
