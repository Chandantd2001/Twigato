package com.foodApplication.model;

public class Orders {
	
	private int orderId;
	private int userId;
	private int restaurentId;
	private float totalAmount;
	private String Status;
	private String paymentMode;
	
	

	public Orders() {
		super();
	}

	public Orders(int userId, int restaurentId, float totalAmount, String status,String paymentMode) {
		super();
		this.userId = userId;
		this.restaurentId = restaurentId;
		this.totalAmount = totalAmount;
		Status = status;
		this.paymentMode=paymentMode;
	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return  userId + "			" + restaurentId
				+ "			" + totalAmount + "			" + Status +"     "+paymentMode;
	}
	
	

}
