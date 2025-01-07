<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Not Logged In</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #FFF8E1; /* Light Beige */
            color: #5D4037; /* Rich Brown */
            text-align: center;
        }

        h1 {
            color: #FF9800; /* Bright Orange */
        }

        button {
            padding: 10px 20px;
            background-color: #FF9800; /* Bright Orange */
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #FB9EC6; /* Soft Pink */
        }
    </style>
</head>
<body>
    <h1>You are not logged in!</h1>
    <p>Please log in to access the checkout page.</p>
    <button onclick="location.href='login.jsp'">Go to Login Page</button>
</body>
</html>
