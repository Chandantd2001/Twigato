<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Failure Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #ffeded;
        color: #d9534f;
        text-align: center;
        padding-top: 100px;
        margin: 0;
    }
    .container {
        background-color: #ffffff;
        width: 50%;
        margin: auto;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    h2 {
        color: #d9534f;
    }
    p {
        font-size: 16px;
    }
    a {
        text-decoration: none;
        color: #ffffff;
        background-color: #d9534f;
        padding: 10px 20px;
        border-radius: 4px;
        display: inline-block;
        margin-top: 20px;
    }
    a:hover {
        background-color: #c9302c;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Registration Failed</h2>
        <p>Invalid credentials or an error occurred. Please try again.</p>
        <a href="register.jsp">Go Back</a>
    </div>
</body>
</html>
