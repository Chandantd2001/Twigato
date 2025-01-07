package com.foodApplication.dao;

import java.util.ArrayList;

import com.foodApplication.model.OrderItems;

public interface OrderItemsDAO {
	int insert(OrderItems orders);
	ArrayList<OrderItems> fetchAll();
	OrderItems fetchOne(int id);	
	int delete(int id);
	int update(int id, int quantity);
}
