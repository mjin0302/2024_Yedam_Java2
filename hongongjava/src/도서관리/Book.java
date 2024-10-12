package 도서관리;

public class Book {
	// sql을 통해 조회한 정보를 담아놓기 위한 클래스
	// field
	// 필드는 외부 접근 막기 - getter/setter
	private String bnum;
	private String title;
	private String writer;
	private int price;
	
	// constructor
	public Book() {
	}
	
	public Book(String title) {
		this.title = title;
	}
	
	public Book(String bnum, String title, String writer, int price) {
		this.bnum = bnum;
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	
	// method
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return bnum + "\t" + title + "\t" + writer + "\t" + price + "\t";
	}
}
