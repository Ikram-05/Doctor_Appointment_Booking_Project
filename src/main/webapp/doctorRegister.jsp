<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .form-container {
            max-width: 400px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-container label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        .form-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .form-container button {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        .form-container button:hover {
            background-color: #218838;
        }

        .form-container .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h2>Doctor Registration</h2>
    <div class="form-container">
        <!-- Form to register a new doctor -->
        <form action="DoctorRegisterServlet" method="post">
            <label for="name">Doctor Name</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="specialization">Specialization</label>
            <input type="text" id="specialization" name="specialization" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Register Doctor</button>
        </form>

        <c:if test="${param.error != null}">
            <div class="error">${param.error}</div>
        </c:if>

        <c:if test="${param.message != null}">
            <div class="success">${param.message}</div>
        </c:if>
    </div>
</body>
</html>
