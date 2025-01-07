package com.foodApplication.model;

public class Restaurent {
	private int restaurentId;
	private String Name;
	private String cusineType;
	private int deliveryTime;
	private String address;
	private float ratings;
	private int isActive;
	private String imagePath;
	
	
	public int getRestaurentId() {
		return restaurentId;
	}
	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCusineType() {
		return cusineType;
	}
	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public int isActive() {
		return isActive;
	}
	public void setActive(int isActive) {
		this.isActive = isActive;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	public Restaurent(int restaurentId, String name, String cusineType, int deliveryTime, String address,
			float ratings, int isActive, String imagePath) {
		super();
		this.restaurentId = restaurentId;
		Name = name;
		this.cusineType = cusineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.ratings = ratings;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}
	
	
	public Restaurent() {
		super();
	}
	@Override
	public String toString() {
		return  restaurentId + "       " + Name + "       " + cusineType
				+ "         " + deliveryTime + "          " + address + "       " + ratings + "       "
				+ isActive + "         " + imagePath;
	}
	
	
}
