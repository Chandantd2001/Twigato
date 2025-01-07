package com.tap.register;


import java.io.IOException;
import java.sql.Connection;

import com.foodApplication.dBUtil.DBConnection;
import com.foodApplication.dao.UserDAO;
import com.foodApplication.daoImpl.UserDAOImpl;
import com.foodApplication.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
//    private static final String FETCH="SELECT password FROM user where email=?";
	private static Connection connection;
//	private Statement stmt;
//	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        HttpSession session = request.getSession();
        
        try {
//        	pstmt=connection.prepareStatement(FETCH);
//        	pstmt.setString(1, email);
//        	ResultSet resultSet=pstmt.executeQuery();
//        	String dbpassword=resultSet.getString(1);
        	
        	
        	UserDAO udao=new UserDAOImpl();
        	User u=udao.fetchEmail(email);
        	if(u!=null) {
        		String dbpassword=u.getPassword();
            	String userName=u.getUsername();
        		String address=u.getAddress();
            	int uId=u.getUserId();
            	
            	System.out.println(u);
            	System.out.println(password);
            	System.out.println(dbpassword);
            	System.out.println(uId);
            	
            	
            	
            	if(password.equals(dbpassword)) {
            		// Store email and password in session
            		
                    int userId=udao.fetchId(email);
                    System.out.println(userId);
            		session.setAttribute("userId", userId);
            		
            		
                    Cookie ck=new Cookie("email",email);
                    response.addCookie(ck);
                    
                    User userDetails=new User(userName,password,email,address);
                    session.setAttribute("User", userDetails);
//                    session.setAttribute("userId", sessio.getAttribute("userId"));
//                    request.removeAttribute("userId");

                    // Redirect to GetAllRestaurants servlet
                    response.sendRedirect("GetAllRestaurants");
                }
                else {
                	response.sendRedirect("failure.jsp");
                }
        	}
        	else {
            	response.sendRedirect("failure.jsp");
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
	}
}
