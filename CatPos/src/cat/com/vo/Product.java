package cat.com.vo;

public class Product {

	// field
	private String productId;	// 상품코드
	private String name;		// 상품이름
	private int price;			// 상품가격
	private String kind;		// 상품 카테고리
	private String state;		// 상품 상태

	private int stock;			// 재고수량
	

	// constructor
	public Product() {}
	
	// method
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", kind=" + kind + ", state="
				+ state + ", stock=" + stock + ", toString()=" + super.toString() + "]";
	}
	

}
