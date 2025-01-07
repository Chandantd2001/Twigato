package com.foodApplication.dao;

import java.util.ArrayList;

import com.foodApplication.model.Restaurent;

public interface RestaurentDAO {
	int insert(Restaurent user);
	ArrayList<Restaurent> fetchAll();
	Restaurent fetchOne(int id);	
	int delete(int id);
	int update(int id, float ratings);
	String fetchName(int restId);
}
