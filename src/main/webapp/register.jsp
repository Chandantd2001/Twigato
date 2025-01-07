<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-image: url('images/food.webp'); /* Add the background image path here */
        background-size: cover; /* Ensure the image covers the entire body */
        background-position: center; /* Center the background image */
        background-attachment: fixed; /* Keeps the background image fixed during scrolling */
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .header, .footer {
        background-color: #FF9800; /* Bright Orange */
        color: #FFF8E1; /* Light Beige */
        text-align: center;
        padding: 10px 0;
        width: 100%;
        position: fixed;
    }
    .header {
        top: 0;
    }
    .footer {
        bottom: 0;
        font-size: 12px; /* Reduced footer content size */
    }
    .register-container {
        background-color: rgba(255, 193, 193, 0.9); /* Transparent Soft Pink */
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        width: 90%;
        max-width: 400px;
        margin-top: 30px; /* Adjust this margin to move the form upwards */
        color: #5D4037; /* Rich Brown */
        overflow: hidden; /* Prevent scrolling */
    }
    h1 {
        margin: 0;
    }
    h2 {
        text-align: center;
        color: #5D4037; /* Change the "Sign Up" text color to brown */
    }
    label {
        font-weight: bold;
        display: block;
        margin-top: 10px;
    }
    input {
        width: calc(100% - 20px); /* Prevent touching the container border */
        padding: 10px;
        margin-top: 5px;
        margin-bottom: 8px; /* Further reduced gap between input fields */
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
    <!-- Header Section -->
    <div class="header">
        <h1>Twigato</h1>
    </div>

    <!-- Registration Form Section -->
    <div class="register-container">
        <h2>Sign Up</h2>
        <form action="Register" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" placeholder="Enter your username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>

            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" placeholder="Enter your address" required>

            <button type="submit">Submit</button>
            <div class="link">
                <p><a href="login.jsp">Already have an account? Sign in</a></p>
            </div>
        </form>
    </div>

    <!-- Footer Section -->
    <div class="footer">
        <p>2024 Twigato, all rights reserved</p>
    </div>
</body>
</html>
