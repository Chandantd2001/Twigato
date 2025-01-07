package com.tap.register;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.foodApplication.dao.UserDAO;
// Assuming UserDAOimpl.java is in the `dao` package
import com.foodApplication.daoImpl.UserDAOImpl;
import com.foodApplication.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO userDAO = new UserDAOImpl();
	

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        
        
		HttpSession session=request.getSession();

        // Check if passwords match
        if (password.equalsIgnoreCase(confirmPassword)) {
        	try {
                int res=userDAO.insert(new User(username,password,email,address));
                System.out.println(res);
                if(res>0) {
//                	session.setAttribute("userId", res);
                	response.sendRedirect("login.jsp");;
            	}
            	else {
            		response.sendRedirect("failure.jsp");
            	}
	         }
        	catch (Exception e) {
	               e.printStackTrace();
	            }
            
        }
        else {
        	response.sendRedirect("failure.jsp");
        }

        // If passwords match, pass data to UserDAOImpl
        
        
        
        
        
    }

}
