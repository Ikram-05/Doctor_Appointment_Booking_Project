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
            font-family: 'Poppins', sans-serif;
            background-color: #eef2f3;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        
        .container {
            width: 100%;
            max-width: 700px;
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 30px;
            font-size: 2.5rem;
        }

        .card {
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
            padding: 40px;
            margin: 20px 0;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
        }

        .form-group {
            margin-bottom: 25px;
            text-align: left;
        }

        .form-group label {
            font-size: 16px;
            margin-bottom: 10px;
            display: block;
            font-weight: 500;
        }

        .form-group select, 
        .form-group input {
            width: 100%;
            padding: 14px;
            font-size: 15px;
            border-radius: 8px;
            border: 1px solid #ddd;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }

        .form-group input:focus, 
        .form-group select:focus {
            border-color: #5c67f2;
            outline: none;
        }

        .btn {
            width: 100%;
            padding: 14px;
            font-size: 18px;
            background-color: #5c67f2;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            margin-top: 15px;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .btn:hover {
            background-color: #4a54e1;
            transform: translateY(-3px);
        }

        .error {
            color: red;
            font-size: 15px;
            margin: 20px 0;
        }

        .link-section {
            margin-top: 30px;
        }

        .link-section a {
            color: #5c67f2;
            text-decoration: none;
            font-size: 16px;
            font-weight: 500;
        }

        .link-section a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Welcome to the Doctor Appointment Booking System</h1>

        <div class="card">
            <h2>Login to Continue</h2>

            <form action="LoginServlet" method="post">
                <div class="form-group">
                    <label for="email">Email Address:</label>
                    <input type="email" id="email" name="email" required>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>

                <div class="form-group">
                    <label for="role">Select Role:</label>
                    <select id="role" name="role" required>
                        <option value="user">User (Patient)</option>
                        <option value="doctor">Doctor</option>
                        <option value="admin">Admin</option>
                    </select>
                </div>

                <button type="submit" class="btn">Login</button>

                <div class="error">
                    <c:if test="${not empty errorMessage}">
                        <p>${errorMessage}</p>
                    </c:if>
                </div>
            </form>
        </div>

        <div class="card">
            <h3>New to the System?</h3>
            <div class="link-section">
                <p><a href="userRegister.jsp">Register Here</a></p>
            </div>
        </div>
    </div>

</body>
</html>
