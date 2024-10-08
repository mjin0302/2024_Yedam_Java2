package cat.com.vo;

public class Sales {

	private String productId;	// 상품코드
	private String id;			// 회원 ID
	private int quantity;		// 수량
	private int totalPrice;		// 총 금액

	// constructor
	Sales() {}

	// method
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal_price() {
		return totalPrice;
	}

	public void setTotal_price(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Sales [productId=" + productId + ", id=" + id + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ ", toString()=" + super.toString() + "]";
	}
	
}
