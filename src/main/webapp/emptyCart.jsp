<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empty Cart</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }

        .empty-cart {
            text-align: center;
        }

        .empty-cart h1 {
            font-size: 2.5em;
            color: #333;
        }

        .empty-cart p {
            font-size: 1.2em;
            color: #555;
            margin-bottom: 20px;
        }

        .empty-cart button {
            padding: 10px 20px;
            font-size: 1em;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .empty-cart button:hover {
            background-color: #0056b3;
        }

        .empty-cart .emoji {
            font-size: 3em;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="empty-cart">
        <div class="emoji">🛒</div>
        <h1>Your Cart is Empty</h1>
        <p>Looks like you haven’t added anything to your cart yet!</p>
        <button onclick="redirectToMenu()">Go to Menu</button>
    </div>

    <script>
        function redirectToMenu() {
            window.location.href = '/menuList.jsp'; // Replace with the actual menu page URL
        }
    </script>
</body>
</html>
