package com.foodApplication.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodApplication.dBUtil.DBConnection;
import com.foodApplication.dao.RestaurentDAO;
import com.foodApplication.model.Restaurent;

public class RestaurentDAOImpl implements RestaurentDAO{
	
	private static final String INSERT="INSERT INTO restaurent(RestaurentID, Name, CuisineType,DeliveryTime, Address, Ratings, isActive, ImagePath) VALUES(?, ?, ?, ?, ?, ?, ?,?)";
	private static final String FETCH="SELECT * FROM restaurent";
    private static final String FETCHONE="SELECT * FROM restaurent where RestaurentID=?";
    private static final String UPDATE="UPDATE restaurent SET ratings=? WHERE RestaurentID=?";
    private static final String DELETE="DELETE FROM restaurent WHERE RestaurentID=?";
    private static final String FETCHNAME="SELECT Name FROM restaurent where RestaurentID=?";
    
	private static Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private ArrayList<Restaurent> restList=new ArrayList<Restaurent>();
	private Restaurent r;

	static{
        connection = DBConnection.getConnection();
    }

	
	
	@Override
	public int insert(Restaurent restaurent) {
		try {
			pstmt=connection.prepareStatement(INSERT);
			pstmt.setInt(1,restaurent.getRestaurentId());
			pstmt.setString(2,restaurent.getName());
			pstmt.setString(3,restaurent.getCusineType());
			pstmt.setInt(4,restaurent.getDeliveryTime());
			pstmt.setString(5,restaurent.getAddress());
			pstmt.setFloat(6,restaurent.getRatings());
			pstmt.setInt(7,restaurent.isActive());
			pstmt.setString(8,restaurent.getImagePath());
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Restaurent> fetchAll() {
		try {
			stmt=connection.createStatement();
			resultSet=stmt.executeQuery(FETCH);
			restList=extractListFromResultSet(resultSet);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return restList;
	}

	@Override
	public Restaurent fetchOne(int id) {
		try {
			pstmt=connection.prepareStatement(FETCHONE);
			pstmt.setInt(1,id);
			resultSet=pstmt.executeQuery();
			restList=extractListFromResultSet(resultSet);
			r=restList.get(0);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	
	ArrayList<Restaurent> extractListFromResultSet(ResultSet resultSet){
		try {
			while(resultSet.next()) {
				restList.add(new Restaurent(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getString(5),
						resultSet.getFloat(6),
						resultSet.getInt(7),
						resultSet.getString(8)
						));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return restList;
	}
	
	
	@Override
	public int update(int id, float ratings) {
		try {
			pstmt=connection.prepareStatement(UPDATE);
			pstmt.setFloat(1, ratings);
			pstmt.setInt(2, id);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());;
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
	
	public String fetchName(int id) {
		String t="";
		try {
			pstmt=connection.prepareStatement(FETCHNAME);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			if(resultSet.next()) {
				t=resultSet.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}

}
