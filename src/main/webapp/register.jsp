<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Twigato</title>
    <style>
        body {
    margin: 0;
    font-family: Arial, sans-serif;
    background-image: url('images/food3.jpg'); /* Updated path to the new background image */
    background-size: cover; /* Ensures the image covers the entire page */
    background-position: center; /* Keeps the image centered */
    background-attachment: fixed; /* Keeps the background fixed during scrolling */
    color: #FFFFFF; /* Make text white */
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

.container {
    text-align: center;
    background-color: rgba(255, 193, 193, 0.9); /* Transparent Soft Pink */
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
    width: 90%;
    max-width: 400px;
    color: #5D4037; /* Rich Brown */
}

h1 {
    font-size: 2.5rem;
    margin-bottom: 20px;
    color: #FFFFFF; /* White text for "Twigato" */
}

h1 a {
    text-decoration: none; /* Remove underline */
    color: #FFFFFF; /* White text */
}

h1 a:hover {
    text-decoration: none; /* Ensure no underline on hover */
}

h2 {
    text-align: center;
    color: #5D4037; /* Change the "Sign Up" text color to brown */
    margin-bottom: 20px;
}

label {
    font-weight: bold;
    display: block;
    margin-top: 10px;
}

input {
    width: calc(100% - 40px); /* Reduced width to shorten input fields */
    padding: 10px;
    margin-top: 5px;
    margin-bottom: 10px;
    border: 1px solid #5D4037; /* Rich Brown */
    border-radius: 4px;
}

button {
    width: calc(100% - 40px); /* Shortened button width */
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
    <h1><a href="main.jsp">Twigato</a></h1>
    <div class="container">
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
</body>
</html>
