package cat.com.vo;

import java.util.Date;

public class OrderSheet {

	// field
	// 주문서 헤더
	private String orderCode;
	private String id;
	private Date orderDate;
	private int totalPrice;

	// 주문서 디테일
	private String orderDetailCode;
	private String productCode;
	private int quantity;
	private int orderPrice;

	// constructor
	public OrderSheet() {}

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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
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

	@Override
	public String toString() {
		return "OrderSheet [orderCode=" + orderCode + ", id=" + id + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice
				+ ", orderDetailCode=" + orderDetailCode + ", productCode=" + productCode + ", quantity=" + quantity
				+ ", orderPrice=" + orderPrice + ", toString()=" + super.toString() + "]";
	}
}
