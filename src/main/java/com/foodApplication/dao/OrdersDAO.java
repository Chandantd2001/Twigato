package com.foodApplication.dao;

import java.util.ArrayList;

import com.foodApplication.model.Orders;


public interface OrdersDAO {
	int insert(Orders orders);
	ArrayList<Orders> fetchAll();
	Orders fetchOne(int id);	
	int update(int id,String status1);
	int delete(int id);
}
