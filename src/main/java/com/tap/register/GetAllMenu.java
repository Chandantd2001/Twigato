package com.tap.register;

import java.io.IOException;
import java.util.ArrayList;

import com.foodApplication.dao.MenuDAO;
import com.foodApplication.dao.RestaurentDAO;
import com.foodApplication.daoImpl.MenuDAOImpl;
import com.foodApplication.daoImpl.RestaurentDAOImpl;
import com.foodApplication.model.Menu;
import com.foodApplication.model.Restaurent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GetAllMenu")
public class GetAllMenu extends HttpServlet {

    MenuDAO mdao = new MenuDAOImpl();
    RestaurentDAO rdao=new RestaurentDAOImpl();
    private ArrayList<Menu> menuList;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int restId = Integer.parseInt(req.getParameter("restaurentId"));
        System.out.println(restId);
//        menuList=null;
        menuList = mdao.fetchMenuByRestaurent(restId);
        String restName=rdao.fetchName(restId);
        System.out.println(restName);
        
        HttpSession session = req.getSession();
        if (menuList == null || menuList.isEmpty()) {
            resp.sendRedirect("noMenuFound.jsp");
        } else {
            req.setAttribute("menuList", menuList);
            req.setAttribute("restaurentId", restId);
            req.setAttribute("restaurentName", restName);
            session.setAttribute("restaurentId", restId);
            req.getRequestDispatcher("menuList.jsp").forward(req, resp);
        }
    }
}
