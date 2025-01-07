package com.tap.register;

import java.io.IOException;

import com.foodApplication.dao.MenuDAO;
import com.foodApplication.daoImpl.Cart;
import com.foodApplication.daoImpl.MenuDAOImpl;
import com.foodApplication.model.CartItem;
import com.foodApplication.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // STEP-1: Get the session for the cart
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // STEP-2: Fetch request parameters
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // Fetch the action and item ID
        String action = req.getParameter("action");
        System.out.println("Action: " + action);

        int itemId = 0;
        if (req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
            itemId = Integer.parseInt(req.getParameter("id"));
        }

        // Create a MenuDAO object for fetching menu details
        MenuDAO menuDAO = null;
        try {
            menuDAO = new MenuDAOImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // STEP-3: Handle cart actions
        try {
            if (action.equals("add")) {
                Menu menuItem = menuDAO.fetchOne(itemId);

                if (menuItem != null) {
                    int newRestaurantId = menuItem.getRestaurentId();
                    Integer currentRestaurantId = (Integer) session.getAttribute("currentRestaurantId");

                    // If the restaurant ID is different, clear the cart
                    if (currentRestaurantId == null || currentRestaurantId != newRestaurantId) {
                        cart.removeAll();
                        session.setAttribute("currentRestaurantId", newRestaurantId); // Update to new restaurant ID
                    }

                    // Add the new item to the cart
                    int quantity = 1;
                    CartItem cartItem = new CartItem(
                            menuItem.getMenuId(),
                            menuItem.getRestaurentId(),
                            menuItem.getName(),
                            quantity,
                            menuItem.getPrice());

                    cart.addItem(cartItem);
                }
            } else if (action.equals("update")) {
                System.out.println("Updating item");
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                cart.updateItem(itemId, quantity);
            } else if (action.equals("remove")) {
                cart.removeItem(itemId);
            } else if (action.equals("clear")) {
                cart.removeAll();
                session.removeAttribute("currentRestaurantId");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirect to the cart page
        System.out.println("Processing cart");
        resp.sendRedirect("yourCart.jsp");
    }
}
