package cat.com.vo;

public class Cart {

	// field
	private String id;			// 회원 ID
	private String productId;	// 상품코드
	private int quantity;		// 상품 수량

	// constructor
	Cart() {};

	// method
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

	@Override
	public String toString() {
		return "Cart [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", toString()="
				+ super.toString() + "]";
	}

}
