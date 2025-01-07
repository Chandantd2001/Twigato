package com.foodApplication.dao;

import java.util.ArrayList;
import java.util.List;

import com.foodApplication.model.User;

public interface UserDAO {
	ArrayList<User> fetchAll();
	User fetchOne(int id);	
	int update(int id,String passsword);
	int delete(int id);
	int insert(User user);
	User fetchEmail(String email);
	int fetchId(String email);
}
