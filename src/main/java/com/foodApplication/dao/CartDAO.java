package com.foodApplication.dao;

import java.util.Map;

import com.foodApplication.model.CartItem;

public interface CartDAO {
	void addItem(CartItem item);
	void updateItem(int itemId,int quantity);
	void removeItem(int itemId);
	Map<Integer,CartItem> getItems();
	void removeAll();
}
