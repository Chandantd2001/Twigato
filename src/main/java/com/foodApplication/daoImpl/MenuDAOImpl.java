package com.foodApplication.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodApplication.model.Menu;
import com.foodApplication.model.Restaurent;
import com.foodApplication.dBUtil.DBConnection;
import com.foodApplication.dao.MenuDAO;

public class MenuDAOImpl implements MenuDAO{

	private static final String INSERT="Insert into menu(MenuId,RestaurentId,Name,Description,"
			+ "Price,isAvailable,ImagePath) values(?,?,?,?,?,?,?)";
	private static final String FETCH="Select * from menu";
	private static final String FETCHONE="Select * from menu where MenuId=?";
	private static final String FETCHRESTAURENT="Select * from menu where RestaurentId=?";
	private static final String UPDATE="Update menu set Price=? where MenuId=?";
	private static final String DELETE="delete from menu where MenuId=?";
	private static Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private Menu m;

//	private ArrayList<Menu> menulist=new ArrayList<Menu>();
	
	static {
		connection=DBConnection.getConnection();
	}

	
	@Override
	public int insert(Menu menu) {
		try {
			pstmt=connection.prepareStatement(INSERT);
			pstmt.setInt(1, menu.getMenuId());
			pstmt.setInt(2, menu.getRestaurentId());
			pstmt.setString(3, menu.getName());
			pstmt.setString(4, menu.getDescription());
			pstmt.setInt(5, menu.getPrice());
			pstmt.setInt(6, menu.isAvailable());
			pstmt.setString(7, menu.getImagePath());
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Menu> fetchAll() {
		ArrayList<Menu> menulist=new ArrayList<Menu>();
		try {
			stmt=connection.createStatement();
			resultSet=stmt.executeQuery(FETCH);
			menulist=extractListFromResultSet(resultSet);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return menulist;
	}

	@Override
	public Menu fetchOne(int id) {
		ArrayList<Menu> menulist=new ArrayList<Menu>();
		try {
			pstmt=connection.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			menulist=extractListFromResultSet(resultSet);
			m=menulist.get(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	
	ArrayList<Menu> extractListFromResultSet(ResultSet resultSet){
		ArrayList<Menu> menulist=new ArrayList<Menu>();
		try {
			while(resultSet.next()) {
				menulist.add(new Menu(
						resultSet.getInt(1),
						resultSet.getInt(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getInt(5),
						resultSet.getInt(6),
						resultSet.getString(7)
						));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return menulist;
	}

	@Override
	public int update(int id, int price) {
		try {
			pstmt=connection.prepareStatement(UPDATE);
			pstmt.setInt(1, price);
			pstmt.setInt(2, id);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			pstmt=connection.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<Menu> fetchMenuByRestaurent(int restId) {
		ArrayList<Menu> menulist=new ArrayList<Menu>();
		try {
			pstmt=connection.prepareStatement(FETCHRESTAURENT);
			pstmt.setInt(1, restId);
			resultSet=pstmt.executeQuery();
			menulist=extractListFromResultSet(resultSet);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return menulist;
	}

}
