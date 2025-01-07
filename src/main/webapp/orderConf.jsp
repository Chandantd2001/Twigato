<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #f6d365, #fda085); /* Warm gradient */
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden;
        }

        .container {
            text-align: center;
            background: rgba(255, 255, 255, 0.9);
            padding: 40px 20px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            position: relative;
            z-index: 2; /* Keeps the container above the scooter animation */
        }

        h1 {
            font-size: 2.5rem;
            color: #4e342e; /* Rich brown */
            margin-bottom: 10px;
            animation: popIn 1s ease-out;
        }

        @keyframes popIn {
            from {
                transform: scale(0.8);
                opacity: 0;
            }
            to {
                transform: scale(1);
                opacity: 1;
            }
        }

        p {
            font-size: 1.2rem;
            color: #6d4c41; /* Softer brown */
            margin-top: 0;
            animation: fadeIn 1.5s ease-in;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        button {
            background: #ff7043;
            color: #fff;
            border: none;
            padding: 12px 25px;
            font-size: 1.2rem;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.3s ease, transform 0.2s;
            margin-top: 20px;
        }

        button:hover {
            background: #d84315;
            transform: scale(1.05);
        }

        /* Animated Scooter Above the Heading */
        .scooter {
            position: absolute;
            top: 50px; /* Adjust position above the heading */
            right: -300px; /* Start outside the right boundary */
            width: 250px; /* Adjust size of the scooter */
            animation: scooterMove 6s linear infinite; /* Smooth right-to-left animation */
            z-index: 1; /* Keeps scooter above the background */
        }

        @keyframes scooterMove {
            0% {
                right: -400px; /* Start off-screen on the right */
            }
            100% {
                right: 100%; /* Move off-screen on the left */
            }
        }

        /* Optional CSS for blending the background (requires a transparent image to work correctly) */
        img.transparent-background {
            mix-blend-mode: multiply; /* Blends the white parts with the background */
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Your order has been placed!</h1>
        <p>Thank you for choosing us! Your delicious food is on its way and will arrive shortly. We appreciate your trust and hope you enjoy your meal.</p>
        <button onclick="redirectToHome()">Go to Home</button>
    </div>

    <script>
        function redirectToHome() {
            window.location.href = 'home.jsp';
        }
    </script>
</body>
</html>
