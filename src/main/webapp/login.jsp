<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('images/food.webp'); /* Add your background image path here */
            background-size: cover; /* Ensure the image covers the entire body */
            background-position: center; /* Center the background image */
            background-attachment: fixed; /* Keeps the background image fixed during scrolling */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            flex-direction: column; /* Align items in a column */
        }
        .login-container {
            background-color: rgba(255, 193, 193, 0.9); /* Transparent Soft Pink */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 90%;
            max-width: 400px;
            color: #5D4037; /* Rich Brown */
        }
        h1 {
            text-align: center;
            color: white; /* White color for "Twigato" */
            font-size: 3rem; /* Adjusted size */
            margin-bottom: 20px;
        }
        h2 {
            text-align: center;
            color: #5D4037; /* Brown color for the "Login" text */
        }
        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
            color: #5D4037; /* Rich Brown */
        }
        input {
            width: calc(100% - 20px); /* Prevent touching the container border */
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 8px; /* Reduced gap */
            margin-left: 10px;
            margin-right: 10px;
            border: 1px solid #5D4037; /* Rich Brown */
            border-radius: 4px;
        }
        button {
            width: calc(100% - 20px); /* Prevent touching the container border */
            margin-left: 10px;
            margin-right: 10px;
            padding: 10px;
            background-color: #FF9800; /* Bright Orange */
            color: #FFF8E1; /* Light Beige */
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #E67E22; /* Slightly darker orange */
        }
        .link {
            text-align: center;
            margin-top: 10px;
        }
        .link a {
            color: #5D4037; /* Rich Brown */
            text-decoration: none;
        }
        .link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <!-- Title Section: Twigato -->
    <h1>Twigato</h1>

    <!-- Login Form Section -->
    <div class="login-container">
        <h2>Login</h2>
        <form action="LoginServlet" method="POST">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>

            <button type="submit">Login</button>

            <div class="link">
                <a href="register.jsp">Go back to Register</a>
            </div>
        </form>
    </div>
</body>
</html>
