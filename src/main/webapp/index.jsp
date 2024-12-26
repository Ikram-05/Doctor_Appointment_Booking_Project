<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Doctor Appointment Booking</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding-top: 50px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-top: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            font-size: 16px;
            margin-bottom: 5px;
        }
        .form-group select, .form-group input {
            width: 100%;
            padding: 8px;
            font-size: 14px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            text-align: center;
            cursor: pointer;
            width: 100%;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
            font-size: 14px;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Welcome to the Doctor Appointment Booking System</h1>

        <div class="card">
            <h2>Login or Register</h2>

            <form action="LoginServlet" method="post">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>

                <div class="form-group">
                    <label for="role">Role:</label>
                    <select id="role" name="role" required>
                        <option value="user">User (Patient)</option>
                        <option value="doctor">Doctor</option>
                        <option value="admin">Admin</option>
                    </select>
                </div>

                <button type="submit" class="btn">Login</button>

            </form>

            <div class="error">
                <c:if test="${not empty errorMessage}">
                    <p>${errorMessage}</p>
                </c:if>
            </div>
        </div>

        <div class="card">
            <h3>New User? Register Here</h3>
            <a href="userRegister.jsp" class="btn">Register as User</a><br><br>
            <a href="doctorRegister.jsp" class="btn">Register as Doctor (Admin Only)</a><br><br>
        </div>
    </div>

</body>
</html>
    