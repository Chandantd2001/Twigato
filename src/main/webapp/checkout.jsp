<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodApplication.model.*" %>
<%@ page import="com.foodApplication.daoImpl.*"%>
<%@ page import="com.foodApplication.dao.*"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #FFF8E1; /* Light Beige */
            color: #5D4037; /* Rich Brown */
        }

        h1, h2 {
            text-align: center;
            color: #5D4037; /* Rich Brown */
        }

        .navbar {
            display: flex;
            justify-content: space-between;
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

        .form-container {
            background-color: #FB9EC6; /* Dark Pink */
            border-radius: 8px;
            padding: 20px;
            margin: 20px auto;
            width: 50%;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input, select {
            width: 100%;
            padding: 12px; /* Increased padding inside input fields */
            margin-bottom: 10px; /* Increased gap between input fields */
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px; /* Increased font size */
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #FF9800; /* Bright Orange */
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #FFC1C1; /* Soft Pink */
        }
    </style>
</head>
<body>
    <!-- Top Navigation Bar -->
    <% 
    User user = (User) session.getAttribute("User"); 
    if (user == null) {
        response.sendRedirect("notLoggedIn.jsp");
        return; // Ensure no further code is executed after the redirect
    }
    %>
    <div class="navbar">
        <a href="home.jsp" class="left">Twigato</a> <!-- Twigato heading on the left -->
        <div class="icons">
            <a href="home.jsp">&#x1F3E0;</a> <!-- Home icon -->
            <a href="yourCart.jsp">&#x1F6D2;</a> <!-- Cart icon -->
            <a href="#">
                <%= user != null ? user.getUsername().charAt(0) : "?" %>
            </a> <!-- Profile icon -->
        </div>
    </div>

    <h1>Checkout</h1>

    <!-- Address Form -->
    <div class="form-container">
        <form action="CheckoutServlet" method="post">
            <h2>Address Details</h2>
            <label for="fullAddress">Full Address:</label>
            <input type="text" id="fullAddress" name="fullAddress" placeholder="Enter your complete address" required>
        </form>
    </div>

    <!-- Payment Form -->
    <div class="form-container">
        <form action="CheckoutServlet" method="post">
            <h2>Payment Mode</h2>
            <label for="paymentMode">Select Payment Mode:</label>
            <select id="paymentMode" name="paymentMode" required>
                <option value="">-- Select Payment Mode --</option>
                <option value="creditCard">Credit Card</option>
                <option value="qrCode">QR Code</option>
                <option value="cash">Cash</option>
            </select>
            <div class="form-group">
                <button type="submit">Pay</button>
            </div>
        </form>
    </div>
</body>
</html>
