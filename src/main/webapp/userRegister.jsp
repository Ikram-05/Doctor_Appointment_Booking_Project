<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            margin-top: 30px;
        }

        .form-container {
            width: 40%;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }

        table {
            width: 100%;
            margin-bottom: 20px;
        }

        td {
            padding: 8px;
        }

        input[type="text"], input[type="email"], input[type="password"], input[type="radio"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0 15px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        input[type="radio"] {
            width: auto;
            margin-right: 10px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            font-size: 16px;
        }

        .back-link a {
            color: #007bff;
            text-decoration: none;
        }

        .back-link a:hover {
            text-decoration: underline;
        }

        .error {
            color: red;
            font-size: 14px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h2>User Registration</h2>
    <div class="form-container">
        <form action="UserRegisterServlet" method="post">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" required></td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" required></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" required></td>
                </tr>
                <tr>
                    <td>Contact:</td>
                    <td><input type="text" name="contact" required></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>
                        <input type="radio" name="gender" value="Male" required> Male
                        <input type="radio" name="gender" value="Female" required> Female
                    </td>
                </tr>
            </table>
            <input type="submit" value="Register">
        </form>
        <div class="back-link">
            <a href="index.jsp">Back to Home</a>
        </div>

        <c:if test="${not empty param.error}">
            <div class="error">${param.error}</div>
        </c:if>
    </div>
</body>
</html>
