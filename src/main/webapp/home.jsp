<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodApplication.model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FFF8E1; /* Light Beige */
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            color: #5D4037; /* Rich Brown */
        }

        .top-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #FF9800; /* Bright Orange */
            padding: 10px 20px;
            color: #FFF8E1; /* Light Beige */
        }

        .top-bar .heading {
            font-size: 1.5em;
            font-weight: bold;
            text-align: left;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #E67E22; /* Slightly darker orange */
            padding: 10px 20px;
        }

        .navbar .search-container {
            display: flex;
            align-items: center;
        }

        .navbar .search-container input {
            padding: 8px;
            font-size: 1em;
            width: 400px; /* Increased width */
            border: none;
            border-radius: 4px;
        }

        .navbar .search-container i {
            margin-left: -30px;
            color: #888;
        }

        .navbar .icons {
            display: flex;
            gap: 20px;
            align-items: center;
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
            background-color: purple; /* Profile icon background color changed to purple */
            color: white; /* Profile icon foreground color changed to white */
            border-radius: 50%;
            font-size: 1.2em;
            font-weight: bold;
            text-align: center;
        }

        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        .card {
            background-color: rgba(255, 193, 193, 0.9); /* Transparent Soft Pink */
            border: 1px solid #FF9800; /* Bright Orange */
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 300px;
            padding: 15px;
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease; /* Transition for hover effect */
            cursor: pointer; /* Makes the card clickable */
        }

        .card:hover {
            transform: scale(1.05); /* Slightly enlarges the card */
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2); /* Adds a stronger shadow */
        }

        .card img {
            width: 100%; /* Ensures the image spans the full width of the card */
            height: 150px; /* Set a fixed height for the upper half */
            object-fit: cover; /* Ensures the image covers the space without distortion */
            border-radius: 8px 8px 0 0; /* Round only the top corners for a seamless appearance */
            margin-bottom: 0; /* No margin at the bottom to align perfectly with the content */
        }

        .card h2 {
            font-size: 1.5em;
            color: #5D4037; /* Rich Brown */
            margin: 10px 0;
        }

        .card p {
            margin: 5px 0;
            color: #666;
            font-size: 0.9em;
        }

        .highlight-delivery {
            font-size: 1em;
            color: #8B4513; /* Dark Brown */
            font-weight: bold;
        }

        .highlight-ratings {
            font-size: 1em;
            color: green; /* Green for ratings */
            font-weight: bold;
        }

        .button {
            margin-top: 15px;
            padding: 10px 15px;
            background-color: #FF9800; /* Bright Orange */
            color: #FFF8E1; /* Light Beige */
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 1em;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 5px; /* Adds space between text and icon */
        }

        .button i {
            font-size: 1.2em;
        }

        .button:hover {
            background-color: #E67E22; /* Slightly darker orange */
        }

        .status {
            font-size: 1.1em;
            color: green;
            margin-top: 10px;
        }

        .status.inactive {
            color: red;
        }
        
        .top-bar .heading {
		    font-size: 1.5em;
		    font-weight: bold;
		    text-align: left;
		    color: #5D4037; /* Rich Brown */
		    text-decoration: none; /* Remove underline */
		}
        
    </style>
    <script>
        function filterRestaurants() {
            const filter = document.getElementById("search-bar").value.toLowerCase();
            const cards = document.querySelectorAll(".card");

            cards.forEach(card => {
                const name = card.querySelector("h2").textContent.toLowerCase();
                const cuisine = card.querySelector("p").textContent.toLowerCase();

                if (name.includes(filter) || cuisine.includes(filter)) {
                    card.style.display = "flex";
                } else {
                    card.style.display = "none";
                }
            });
        }
    </script>
</head>
<body>
    <% User user = (User) session.getAttribute("User"); %>
    <div class="top-bar">
    <a href="main.jsp" class="heading">Twigato</a>
	</div>


    <div class="navbar">
        <div class="search-container">
            <input type="text" id="search-bar" placeholder="Search by cuisine or restaurant name" onkeyup="filterRestaurants()">
            <i>&#x1F50D;</i> <!-- Search icon -->
        </div>
        <div class="icons">
            <a href="#" onclick="location.reload()">&#x1F3E0;</a> <!-- Home icon -->
            <a href="yourCart.jsp">&#x1F6D2;</a> <!-- Cart icon -->
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

    <h1>Welcome, <%= user != null ? user.getUsername() : "Guest" %>!</h1>
    <% List<Restaurent> rList = (List<Restaurent>) session.getAttribute("restaurents"); %>

    <div class="container">
        <% 
        for (Restaurent r : rList) { %>
            <div class="card" onclick="location.href='GetAllMenu?restaurentId=<%= String.valueOf(r.getRestaurentId()) %>'">
                <img src="<%= r.getImagePath() %>" alt="Image of <%= r.getName() %>">
                <h2><%= r.getName() %></h2>
                <p><strong>Cuisine:</strong> <%= r.getCusineType() %></p>
                <p><strong class="highlight-delivery">Delivery Time:</strong> <span class="highlight-delivery"><%= r.getDeliveryTime() %> mins</span></p>
                <p><strong>Address:</strong> <%= r.getAddress() %></p>
                <p><strong class="highlight-ratings">Ratings:</strong> <span class="highlight-ratings"><%= r.getRatings()%></span></p>
                <a href="GetAllMenu?restaurentId=<%= String.valueOf(r.getRestaurentId()) %>" class="button">
                    <i>&#x1F4CC;</i> <!-- Icon near Open button -->
                    <%= r.isActive() == 1 ? "Open" : "Closed" %>
                </a>
            </div>
        <% } %>
    </div>
</body>
</html>
