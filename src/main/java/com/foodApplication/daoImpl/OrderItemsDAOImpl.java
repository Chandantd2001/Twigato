package com.foodApplication.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodApplication.dBUtil.DBConnection;
import com.foodApplication.dao.OrderItemsDAO;
import com.foodApplication.model.OrderItems;
import com.foodApplication.model.Orders;

public class OrderItemsDAOImpl implements OrderItemsDAO{

	private static final String INSERT="Insert into orderitems(OrdersId,MenuId,Quantity,"
			+ "ItemTotal) values(?,?,?,?)";
	private static final String FETCHALL="Select * from orderitems";
	private static final String FETCHONE="Select * from orderitems where OrderItemIdId=?";
	private static final String UPDATE="Update orderitems set Quantity=? where OrderItemId=?";
	private static final String DELETE="delete from orderitems where OrderItemId=?";
	
	private static Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private OrderItems oi;
	private ResultSet generatedKeys;
	int orderItemId=0;
	private static ArrayList<OrderItems> orderItemlist=new ArrayList<OrderItems>();

	static {
		connection=DBConnection.getConnection();
	}

	@Override
	public int insert(OrderItems orderItem) {
		try {
			pstmt=connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
//			pstmt.setInt(1, orderItem.getOrderItemId());
			pstmt.setInt(1, orderItem.getOrdersId());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setInt(4, orderItem.getItemTotal());
			int affected_rows= pstmt.executeUpdate();
			
			if(affected_rows>0) {
				try {
					generatedKeys=pstmt.getGeneratedKeys();
					while(generatedKeys.next()) {
						orderItemId = generatedKeys.getInt(1); 
						orderItem.setOrderItemId(orderItemId);
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderItemId;
	}

	@Override
	public ArrayList<OrderItems> fetchAll() {
		try {
			stmt=connection.createStatement();
			resultSet=stmt.executeQuery(FETCHALL);
			orderItemlist=extractListFromResultSet(resultSet);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderItemlist;
	}

	@Override
	public OrderItems fetchOne(int id) {
		try {
			pstmt=connection.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			orderItemlist=extractListFromResultSet(resultSet);
			oi=orderItemlist.get(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return oi;
	}
	
	ArrayList<OrderItems> extractListFromResultSet(ResultSet resultSet){
		try {
			while(resultSet.next()) {
				orderItemlist.add(new OrderItems(
						resultSet.getInt(1),
						resultSet.getInt(2),
						resultSet.getInt(3),
						resultSet.getInt(4)
						));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderItemlist;
	}

	@Override
	public int update(int id, int quantity) {
		try {
			pstmt=connection.prepareStatement(UPDATE);
			pstmt.setInt(1, quantity);
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
