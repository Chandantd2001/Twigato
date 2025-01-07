package com.foodApplication.model;

public class CartItem {			//Model Class
	private int itemId;
	private int restaurentId;
	private String name;
	private int quantity;
	private float price;
	
	public CartItem() {
		super();
	}

	public CartItem(int itemId, int restaurentId, String name, int quantity, float price) {
		super();
		this.itemId = itemId;
		this.restaurentId = restaurentId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", restaurentId=" + restaurentId + ", name=" + name + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	
	
	
}
