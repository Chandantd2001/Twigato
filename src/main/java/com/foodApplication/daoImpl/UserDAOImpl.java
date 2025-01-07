package com.foodApplication.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodApplication.dBUtil.DBConnection;
import com.foodApplication.dao.UserDAO;
import com.foodApplication.model.User;

public class UserDAOImpl implements UserDAO {
    static Connection connection;
    private static final String INSERT = "INSERT INTO user (username, password, email, address) VALUES (?, ?, ?, ?)";
    private static final String FETCH="SELECT * FROM user";
    private static final String FETCHONE="SELECT * FROM user where UserId=?";
    private static final String UPDATE="UPDATE user SET password=? WHERE UserId=?";
    private static final String DELETE="DELETE FROM user WHERE UserId=?";
    private static final String FETCHEMAIL="SELECT * FROM user where email=?";
    private static final String FETCHID="SELECT UserId FROM user where email=?";
    
    private static PreparedStatement pstmt;
    private static Statement stmt;
    private static ResultSet resultSet;
    private User s;
	private ResultSet generatedKeys;
	private int userId;
    private static ArrayList<User> studentList=new ArrayList<User>();
    
    
    static{
        connection = DBConnection.getConnection();
    }



    @Override
    public int insert(User user) {
        
        try 
        {
        	pstmt = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getAddress());
            int aff=pstmt.executeUpdate();
            System.out.println(aff);
            if(aff>0) {
            	generatedKeys=pstmt.getGeneratedKeys();
            	if(generatedKeys.next()) {
            		userId=generatedKeys.getInt(1);
            		System.out.println(userId);
            		user.setUserId(userId);
            	}
            }
           
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        return userId;
    }

	@Override
	public ArrayList<User> fetchAll() {
		try {
			stmt=connection.createStatement();
			resultSet=stmt.executeQuery(FETCH);
			studentList=extractListFromResultSet(resultSet);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public User fetchOne(int id) {
		try {
			pstmt=connection.prepareStatement(FETCHONE);
			pstmt.setInt(1,id);
			resultSet=pstmt.executeQuery();
			studentList=extractListFromResultSet(resultSet);
			s=studentList.get(0);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	
	ArrayList<User> extractListFromResultSet(ResultSet resultSet){
		try {
			while(resultSet.next()) {
				studentList.add(new User(
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5)
						));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public int update(int id, String passsword) {
		try {
			pstmt=connection.prepareStatement(UPDATE);
			pstmt.setString(1, passsword);
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
	
	@Override
	public User fetchEmail(String email) {
		try {
			pstmt=connection.prepareStatement(FETCHEMAIL);
			pstmt.setString(1,email);
			resultSet=pstmt.executeQuery();
			studentList=extractListFromResultSet(resultSet);
			s=studentList.get(0);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public int fetchId(String passsword) {
		int id=0;
		try {
			System.out.println("Entry of try block");
			pstmt=connection.prepareStatement(FETCHID);
			pstmt.setString(1, passsword);
			resultSet=pstmt.executeQuery();
			if(resultSet.next()) {
				id=resultSet.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return id;
		
	}

    

}
