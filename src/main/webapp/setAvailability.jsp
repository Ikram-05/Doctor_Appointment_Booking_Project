<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- setAvailability.jsp -->
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Set Availability</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #e9f7ef;
        }
        .container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label, select, button {
            margin: 10px 0;
        }
        button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Set Availability</h1>
        <form action="setAvailability" method="post">
            <label for="availability">Availability:</label>
            <select name="availability" id="availability">
                <option value="Available">Available</option>
                <option value="Not Available">Not Available</option>
            </select>
            <button type="submit">Update</button>
        </form>
    </div>
</body>
</html>
    