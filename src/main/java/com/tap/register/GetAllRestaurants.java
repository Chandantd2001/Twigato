package com.tap.register;

import java.io.IOException;

import java.util.ArrayList;

import com.foodApplication.dao.RestaurentDAO;
import com.foodApplication.daoImpl.RestaurentDAOImpl;
import com.foodApplication.model.Restaurent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/GetAllRestaurants")
public class GetAllRestaurants extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Restaurent>restList=new ArrayList<Restaurent>();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//returns a list of cookies
//		Cookie[] cookies=request.getCookies();		
//		
//		//checks whether the a cookie is present inside the cookies variable (using getValue() cookie value is fetched)
//		if(cookies[0].getValue()!=null)	{	
			RestaurentDAO rdao=new RestaurentDAOImpl();
			ArrayList<Restaurent> restList=rdao.fetchAll();
			
			HttpSession session = request.getSession();
	        session.setAttribute("restaurents", restList);
	        
	        response.sendRedirect("home.jsp");
//		}
//		else {
//			response.sendRedirect("login.jsp");
//		}
		
	}
}
