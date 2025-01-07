<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodApplication.model.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #FFF8E1; /* Light Beige */
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        color: #5D4037; /* Rich Brown */
        margin-top: 20px;
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
	    text-align: center;
	    transition: transform 0.3s ease, box-shadow 0.3s ease; /* Transition for hover effect */
	    cursor: pointer;
	    text-decoration: none; /* Remove underline from link */
	    opacity: 1; /* Visible by default */
	    transition: opacity 0.3s ease; /* Smooth transition for visibility changes */
	}

    .card:hover {
        transform: scale(1.05); /* Slightly enlarges the card */
        box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2); /* Adds a stronger shadow */
        background-color: rgba(255, 193, 193, 0.95); /* Slight change in background on hover */
    }

	.card.hidden {
	    opacity: 0; /* Make card invisible */
	    pointer-events: none; /* Prevent interaction */
	    visibility: hidden; /* Hide visually */
	}
	
    .card img {
	    width: 100%;
	    border-radius: 8px;
	    margin-bottom: 10px;
	}

    .card h2 {
        font-size: 1.3em;
        color: #5D4037; /* Rich Brown */
    }

    .card p {
        font-size: 0.9em;
        color: #666;
        margin: 5px 0;
    }

    .availability {
        color: green; /* Highlighting availability in green */
        font-weight: bold;
    }

    .card form {
        margin-top: 10px;
    }

    .card button {
        background-color: #FF9800; /* Bright Orange */
        color: #FFF8E1; /* Light Beige */
        border: none;
        padding: 10px 15px;
        font-size: 0.9em;
        border-radius: 5px;
        cursor: pointer;
    }

    .card button:hover {
        background-color: #E67E22; /* Slightly darker orange */
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
	function filterMenuItems() {
	    const filter = document.getElementById("search-bar").value.toLowerCase();
	    const cards = document.querySelectorAll(".card");
	
	    cards.forEach(card => {
	        const itemName = card.querySelector("h2").textContent.toLowerCase();
	        if (itemName.includes(filter)) {
	            card.classList.remove("hidden");
	        } else {
	            card.classList.add("hidden");
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
            <input type="text" id="search-bar" placeholder="Search by cuisine or restaurant name" onkeyup="filterMenuItems()">

            <i>&#x1F50D;</i> <!-- Search icon -->
        </div>
        <div class="icons">
            <a href="home.jsp">&#x1F3E0;</a> <!-- Home icon -->
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

    <h1>Menu List of Restaurant: <%= request.getAttribute("restaurentName") %></h1>
    <% List<Menu> menuList = (List<Menu>) request.getAttribute("menuList"); %>
    <div class="container">
        <% for (Menu menu : menuList) { %>
            <div class="card">
                <img src="<%= menu.getImagePath() %>" alt="<%= menu.getName() %>">
                <h2><%= menu.getName() %></h2>
                <p><strong>Description:</strong> <%= menu.getDescription() %></p>
                <p><strong>Price:</strong> $<%= menu.getPrice() %></p>
                <p><strong>Is Available:</strong> <span class="availability"><%= menu.isAvailable() == 1 ? "Yes" : "No" %></span></p>
                <form action="CartServlet" method="get">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="id" value="<%= menu.getMenuId() %>">
                    <input type="hidden" name="name" value="<%= menu.getName() %>">
                    <input type="hidden" name="quantity" value="1"> <!-- Default quantity is 1 -->
                    <button type="submit">Add to Cart</button>
                </form>
                <!-- Cart Button to Redirect to cart.jsp -->
                <!-- <a href="cart.jsp" class="button-to-cart">Go to Cart</a> -->
            </div>
        <% } %>
    </div>
</body>
</html>
