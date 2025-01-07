<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodApplication.model.*" %>
<%@ page import="com.foodApplication.daoImpl.*"%>
<%@ page import="com.foodApplication.dao.*"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #FFCF9D; /* Warm Beige */
        color: #333; /* Dark Text */
    }

    h1 {
        text-align: center;
        color: #5D4037; /* Rich Brown */
    }

    .cart-container {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .cart-card {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: rgba(255, 193, 193, 0.9); /* Transparent Soft Pink */
        border-radius: 8px;
        padding: 15px;
        margin: 10px 0;
        width: 60%;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .item-details {
        flex: 2;
        text-align: left;
        color: #5D4037; /* Rich Brown */
    }

    .highlight-total {
        color: #D84315; /* Bold Red-Orange for emphasis */
        font-weight: bold;
    }

    .item-actions {
        flex: 1;
        text-align: right;
    }

    .item-actions button {
        margin: 5px;
        padding: 8px 12px;
        border: none;
        background-color: #FF9800; /* Bright Orange */
        color: #FFF8E1; /* Light Beige */
        border-radius: 4px;
        cursor: pointer;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .item-actions button:hover {
        background-color: #E67E22; /* Slightly darker orange */
        transform: translateY(-5px); /* Raise button */
        box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .cart-summary {
        text-align: center;
        margin-top: 20px;
    }

    .cart-buttons {
        display: flex;
        justify-content: center;
        gap: 20px;
    }

    .cart-summary a {
        display: inline-block;
        margin: 10px 0;
        padding: 10px 20px;
        background-color: #FF9800; /* Bright Orange */
        color: #FFF8E1; /* Light Beige */
        text-decoration: none;
        border-radius: 4px;
        font-weight: bold;
        cursor: pointer;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .cart-summary a:hover {
        background-color: #E67E22; /* Slightly darker orange */
        transform: translateY(-5px); /* Raise button */
        box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .cart-summary h3 {
        color: #5D4037; /* Rich Brown */
        margin-bottom: 20px;
    }

    .navbar {
    display: flex;
    justify-content: flex-end; /* Move content to the right */
    align-items: center;
    background-color: #E67E22; /* Slightly darker orange */
    padding: 10px 20px;
}

    .navbar .left {
        font-size: 1.5em;
        color: #FFF8E1; /* Light Beige */
        font-weight: bold;
        text-decoration: none;
    }

    

.navbar .icons {
    display: flex;
    gap: 20px;
}

.navbar .icons a {
    color: #FFF8E1; /* Light Beige */
    text-decoration: none;
    font-size: 1.5em;
}

.navbar .icons a:last-child {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 35px;
    height: 35px;
    background-color: purple; /* Profile icon background color */
    color: white; /* Profile icon foreground color */
    border-radius: 50%;
    font-size: 1.2em;
    font-weight: bold;
}

.home-button {
    display: inline-block;
    margin-right: auto; /* Push other elements to the right */
    padding: 8px 12px;
    background-color: #FF9800; /* Bright Orange */
    color: #FFF8E1; /* Light Beige */
    text-decoration: none;
    border-radius: 4px;
    font-weight: bold;
    cursor: pointer;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.home-button:hover {
    background-color: #E67E22; /* Slightly darker orange */
    transform: translateY(-5px); /* Raise button */
    box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.15);
}


    .empty-cart {
        text-align: center;
        margin-top: 50px;
    }

    .empty-cart img {
        width: 150px;
        margin-top: 20px;
    }
    
    .navbar .left .heading {
    font-size: 1.5em;
    color: #FFF8E1; /* Light Beige */
    font-weight: bold;
    text-decoration: none;
    margin-right: auto; /* Push other items to the right */
}

.navbar {
    display: flex;
    justify-content: space-between; /* Space between the Twigato heading and icons */
    align-items: center;
    background-color: #E67E22; /* Slightly darker orange */
    padding: 10px 20px;
}

.navbar .left {
    font-size: 1.5em;
    color: #FFF8E1; /* Light Beige */
    font-weight: bold;
    text-decoration: none;
    margin-right: auto; /* Push other elements to the right */
}

.navbar .icons {
    display: flex;
    gap: 20px;
}

    
</style>
</head>
<body>
    <% User user = (User) session.getAttribute("User"); %>
    <div class="navbar">
    <div class="left">
        <a href="main.jsp" class="heading">Twigato</a> <!-- Twigato heading -->
    </div>
    <div class="icons">
        <a href="home.jsp">&#x1F3E0;</a> <!-- Home icon -->
        <a href="#">&#x1F6D2;</a> <!-- Cart icon -->
        <% if (user != null) { %>
            <a href="UserRemoveservlet">Logout</a>
        <% } else { %>
            <a href="login.jsp">Login</a>
        <% } %>
        <a href="#">
            <%= user != null ? user.getUsername().charAt(0) : "?" %>
        </a> <!-- Profile icon -->
    </div>
</div>




    <h1>Cart</h1>
    <%
    Cart cart = (Cart) session.getAttribute("cart");
    System.out.println(cart);
    if (cart == null || cart.getItems().isEmpty()) {
    %>
    <div class="empty-cart">
        <h1>Your cart is empty</h1>
         <img src="images/empty_cart.webp" alt="Empty Cart"> 
        <h3><a href="home.jsp" class="home-button">Go to Home</a></h3>
    </div>
    <%
    } else {
        int restaurantId = 0;
        if (!cart.getItems().isEmpty()) {
            restaurantId = cart.getItems().values().iterator().next().getRestaurentId();
        }
    %>
    <div class="cart-container">
    <% 
        double totamt = 0;
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem item = entry.getValue();
            totamt += item.getPrice() * item.getQuantity();
    %>
    <div class="cart-card">
        <div class="item-details">
            <h3><%= item.getName() %></h3>
            <p>Price: Rs. <%= item.getPrice() %></p>
            <p class="highlight-total">Total: Rs. <%= item.getPrice() * item.getQuantity() %></p>
        </div>
        <div class="item-actions">
            <form action="CartServlet" method="get" style="display: inline;">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="<%= item.getItemId() %>">
                <button type="submit" name="quantity" value="<%= item.getQuantity() - 1 %>">-</button>
            </form>
            <span><%= item.getQuantity() %></span>
            <form action="CartServlet" method="get" style="display: inline;">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="<%= item.getItemId() %>">
                <button type="submit" name="quantity" value="<%= item.getQuantity() + 1 %>">+</button>
            </form>
            <form action="CartServlet" method="get" style="display: inline;">
                <input type="hidden" name="action" value="remove">
                <input type="hidden" name="id" value="<%= item.getItemId() %>">
                <button type="submit">Remove</button>
            </form>
        </div>
    </div>
    <% } %>
    </div>
    <div class="cart-summary">
        <h3>Total amount: Rs. <%= totamt %></h3>
        <div class="cart-buttons">
            <a href="GetAllMenu?restaurentId=<%= restaurantId %>">Add more items</a>
            <a href="checkout.jsp">Proceed to Checkout</a>
        </div>
        <form action="CartServlet" method="get" style="margin-top: 20px;">
        <input type="hidden" name="action" value="clear">
        <button type="submit" style="background-color: red; color: white; padding: 10px 20px; border: none; border-radius: 5px;">
            Remove All Items
        </button>
        </form>
    </div>
    <% } %>
</body>
</html>
