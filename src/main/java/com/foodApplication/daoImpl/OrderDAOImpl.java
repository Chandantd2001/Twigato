package com.foodApplication.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodApplication.dBUtil.DBConnection;
import com.foodApplication.model.Orders;
import com.foodApplication.dao.OrdersDAO;

public class OrderDAOImpl implements OrdersDAO{
	
	private static final String INSERT="Insert into orders(UserId,RestaurentId,TotalAmount,"
			+ "Status,PaymentMode) values(?,?,?,?,?)";
	private static final String FETCHALL="Select * from orders";
	private static final String FETCHONE="Select * from orders where OrdersId=?";
	private static final String UPDATE="Update orders set Price=? where OrdersId=?";
	private static final String DELETE="delete from orders where OrdersId=?";
	
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private Orders o;
	private ResultSet generatedKeys;
	private int orderId;
	private static Connection connection;
	
	private static ArrayList<Orders> orderslist=new ArrayList<Orders>();

	static {
		connection=DBConnection.getConnection();
	}

	@Override
	public int insert(Orders orders) {
		try {
			pstmt=connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, orders.getUserId());
			pstmt.setInt(2, orders.getRestaurentId());
			pstmt.setFloat(3, orders.getTotalAmount());
			pstmt.setString(4, orders.getStatus());
			pstmt.setString(5, orders.getPaymentMode());
			int affected_rows=pstmt.executeUpdate();
			
			if(affected_rows>0) {
				generatedKeys=pstmt.getGeneratedKeys();
				while(generatedKeys.next()) {
					orderId=generatedKeys.getInt(1);
					orders.setOrderId(orderId);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderId;
	}

	@Override
	public ArrayList<Orders> fetchAll() {
		try {
			stmt=connection.createStatement();
			resultSet=stmt.executeQuery(FETCHALL);
			orderslist=extractListFromResultSet(resultSet);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderslist;
	}

	@Override
	public Orders fetchOne(int id) {
		try {
			pstmt=connection.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			orderslist=extractListFromResultSet(resultSet);
			o=orderslist.get(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	
	
	ArrayList<Orders> extractListFromResultSet(ResultSet resultSet){
		try {
			while(resultSet.next()) {
				orderslist.add(new Orders(
						resultSet.getInt(1),
						resultSet.getInt(2),
						resultSet.getFloat(3),
						resultSet.getString(4),
						resultSet.getString(5)
						));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderslist;
	}

	@Override
	public int update(int id, String status) {
		try {
			pstmt=connection.prepareStatement(UPDATE);
			pstmt.setString(1, status);
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

}
