package cat.com.vo;

public class Cart {

	// field
	private String cartCode; 	// 코드
	private String id;			// 회원 ID
	private String productId;	// 상품코드
	private String productName; // 상품이름
	private int price;		// 상품가격
	private int quantity;		// 상품 수량

	// constructor
	public Cart() {};

	// method
	public String getCartCode() {
		return cartCode;
	}

	public void setCartCode(String cartCode) {
		this.cartCode = cartCode;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [cartCode=" + cartCode + ", id=" + id + ", productId=" + productId + ", quantity=" + quantity
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
