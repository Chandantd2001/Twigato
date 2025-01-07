package com.tap.register;

import java.io.IOException;
import java.util.Map;

import com.foodApplication.dao.OrderItemsDAO;
import com.foodApplication.dao.OrdersDAO;
import com.foodApplication.daoImpl.Cart;
import com.foodApplication.daoImpl.OrderDAOImpl;
import com.foodApplication.daoImpl.OrderItemsDAOImpl;
import com.foodApplication.model.CartItem;
import com.foodApplication.model.OrderItems;
import com.foodApplication.model.Orders;
import com.foodApplication.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet{
	
	private OrdersDAO odao;
	private OrderItemsDAO oidao;
	public void init() {
		try {
			odao=new OrderDAOImpl();
			oidao=new OrderItemsDAOImpl();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		User user=(User)session.getAttribute("User");

		int userId = (Integer) session.getAttribute("userId"); 

		System.out.println("User is not null");
		System.out.println("Cart is not null");
		
		if(cart!=null && user!=null && !cart.getItems().isEmpty()) {
			System.out.println("Inside CheckedOutServlet IF is true");
			
			String paymentMethod=req.getParameter("paymentMode");
			
			if (paymentMethod == null || paymentMethod.isEmpty()) {
	            resp.getWriter().println("Payment mode is required.");
	            return;
	        }

			System.out.println(user);
			System.out.println(userId);
			System.out.println(session.getAttribute("restaurentId"));
			System.out.println(paymentMethod);
			
			Orders order=new Orders();
			order.setUserId(userId);
//			System.out.println(session.getAttribute("restaurentId"));
			order.setRestaurentId((int)session.getAttribute("restaurentId"));
			order.setPaymentMode(paymentMethod);
			order.setStatus("Pending");
			
			float totalAmount=0.0f;
			for(CartItem item:cart.getItems().values()) {
				totalAmount+=item.getPrice()*item.getQuantity();
			}
			
			order.setTotalAmount(totalAmount);
			int orderId = odao.insert(order);
			
			

			 if (orderId > 0) {
		            // Step 7: Insert each cart item into the order_items table
//		            OrderItemsDAO orderItemsDAO = new OrderItemsDAOImpl();
//		            boolean allItemsInserted = true;
		            for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
		                CartItem cartItem = entry.getValue();
		                OrderItems orderItem = new OrderItems();
		                orderItem.setOrdersId(orderId);
		                orderItem.setMenuId(cartItem.getItemId());
		                orderItem.setQuantity(cartItem.getQuantity());
		                orderItem.setItemTotal((int)cartItem.getPrice() * cartItem.getQuantity());

		                int result = oidao.insert(orderItem);
		                System.out.println(result);
		            }
		            
		            

			session.removeAttribute("cart");
			session.setAttribute("order", order);
			
			resp.sendRedirect("orderConf.jsp");			
			
		}
	}
		else {
			resp.sendRedirect("yourCart.jsp");
		}
	}
}
