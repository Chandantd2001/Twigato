package com.foodApplication.model;

public class OrderItems {
	private int orderItemId;
	private int ordersId;
	private int menuId;
	private int quantity;
	private int itemTotal;
	
	
	public OrderItems() {
		super();
	}


	public OrderItems( int ordersId, int menuId, int quantity, int itemTotal) {
		super();
		this.ordersId = ordersId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}


	public int getOrderItemId() {
		return orderItemId;
	}
//
//
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}


	public int getOrdersId() {
		return ordersId;
	}


	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getItemTotal() {
		return itemTotal;
	}


	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}


	@Override
	public String toString() {
		return ordersId + "			" + menuId+ "			" + quantity + "			" + itemTotal;
	}
	
	
	
	
}
