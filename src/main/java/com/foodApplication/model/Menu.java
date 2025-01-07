package com.foodApplication.model;

public class Menu {
	
	private int menuId;
	private int restaurentId;
	private String name;
	private String description;
	private int price;
	private int isAvailable;
	private String imagePath;
	
	
	public Menu() {
		super();
	}


	public Menu(int menuId, int restaurentId, String name, String description, int price, int isAvailable,
			String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurentId = restaurentId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int isAvailable() {
		return isAvailable;
	}


	public void setAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	@Override
	public String toString() {
		return  menuId + "			" + restaurentId + "			" + name + "			"
				+ description + "			" + price + "			" + isAvailable + "			" + imagePath;
	}
	
	
	

}
