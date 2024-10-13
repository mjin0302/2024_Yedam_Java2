package cat.com.vo;

public class OrderSheet {

	// field
	// 주문서 헤더
	private String orderCode; 		// 주문서 헤더 코드
	private String id; 				// 주문자 id
	private String orderDate; 		// 주문 일시
	private int totalPrice; 		// 총 가격

	// 주문서 디테일
	private String orderDetailCode; // 주문서 상세 코드
	private String productCode; 	// 상품 코드
	private int quantity; 			// 상품 주문 수량
	private int orderPrice;			// 상품 당 합계 가격(상품 수량 * 개당 가격)

	// 상품
	private String name; 			// 상품명
	private int price; 				// 상품 개당 가격
	
	private int stock;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	// constructor
	public OrderSheet() {
	}

	// method
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderDetailCode() {
		return orderDetailCode;
	}

	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
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
	
	@Override
	public String toString() {
		return "OrderSheet [orderCode=" + orderCode + ", id=" + id + ", orderDate=" + orderDate + ", totalPrice="
				+ totalPrice + ", orderDetailCode=" + orderDetailCode + ", productCode=" + productCode + ", quantity="
				+ quantity + ", orderPrice=" + orderPrice + ", toString()=" + super.toString() + "]";
	}
}
