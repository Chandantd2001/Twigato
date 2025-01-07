package com.foodApplication.dao;

import java.util.ArrayList;

import com.foodApplication.model.Menu;

public interface MenuDAO {
	int insert(Menu menu);
	ArrayList<Menu> fetchAll();
	Menu fetchOne(int id);	
	int update(int id,int price);
	int delete(int id);
	ArrayList<Menu> fetchMenuByRestaurent(int restId);
}
