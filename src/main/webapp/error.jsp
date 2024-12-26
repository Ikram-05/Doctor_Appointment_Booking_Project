<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- error.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8d7da;
        }
        .container {
            text-align: center;
            background-color: #ffffff;
            padding: 40px;
            border: 1px solid #dc3545;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #dc3545;
        }
        p {
            margin: 20px 0;
        }
        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Oops! Something Went Wrong</h1>
        <p>An unexpected error occurred. Please try again later.</p>
        <p><a href="index.jsp">Return to Home</a></p>
    </div>
</body>
</html>
    