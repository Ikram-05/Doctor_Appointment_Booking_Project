<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .form-container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f4f4f4;
        }
        .form-container input, .form-container select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Register</h2>
        <form action="RegisterServlet" method="POST">
            <label for="role">Select Role:</label>
            <select name="role" required>
                <option value="user">Patient</option>
                <option value="doctor">Doctor (Admin Only)</option>
            </select>

            <label for="name">Name:</label>
            <input type="text" name="name" required>

            <label for="email">Email:</label>
            <input type="email" name="email" required>

            <label for="username">Username:</label>
            <input type="text" name="username" required>

            <label for="password">Password:</label>
            <input type="password" name="password" required>

            <label for="contact">Contact:</label>
            <input type="text" name="contact" required>

            <label for="gender">Gender:</label>
            <input type="text" name="gender" required>

            <!-- Doctor-specific fields -->
            <div id="doctor-fields" style="display: none;">
                <label for="specialization">Specialization:</label>
                <input type="text" name="specialization">

                <label for="availability">Availability:</label>
                <input type="text" name="availability">
            </div>

            <button type="submit">Register</button>
        </form>
    </div>

    <script>
        const roleSelect = document.querySelector('select[name="role"]');
        const doctorFields = document.getElementById('doctor-fields');

        roleSelect.addEventListener('change', function() {
            if (this.value === 'doctor') {
                doctorFields.style.display = 'block';
            } else {
                doctorFields.style.display = 'none';
            }
        });
    </script>
</body>
</html>
