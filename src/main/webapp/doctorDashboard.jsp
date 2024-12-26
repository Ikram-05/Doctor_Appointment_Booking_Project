<%@page import="com.booking.entity.Doctor"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #007BFF;
            color: white;
            text-align: center;
            padding: 20px;
        }

        .container {
            width: 80%;
            margin: 20px auto;
        }

        .card {
            background-color: white;
            padding: 20px;
            margin: 20px 0;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2, h3 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        table th {
            background-color: #f2f2f2;
        }

        .availability-form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .availability-form label {
            font-weight: bold;
        }

        .availability-form select, .availability-form button {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .availability-form button {
            background-color: #28a745;
            color: white;
            cursor: pointer;
        }

        .availability-form button:hover {
            background-color: #218838;
        }

        .card h3 {
            margin-top: 0;
        }
    </style>
</head>
<body>
    <header>
        <h1>Doctor Dashboard</h1>
    </header>

    <div class="container">
        <h2>Welcome, Dr. 
            <%= session.getAttribute("doctor") != null ? ((Doctor)session.getAttribute("doctor")).getName() : "Doctor" %>!
        </h2>

        <!-- View Appointments Section -->
        <div class="card">
            <h3>Your Appointments</h3>
            <table>
                <thead>
                    <tr>
                        <th>User Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Appointment Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${empty appointments}">
                            <tr>
                                <td colspan="5" style="text-align: center;">No appointments found</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="appointment" items="${appointments}">
                                <tr>
                                    <td>${appointment.user.name}</td>
                                    <td>${appointment.user.age}</td>
                                    <td>${appointment.user.gender}</td>
                                    <td>${appointment.appointment_date}</td>
                                    <td>${appointment.status}</td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>

        <!-- Availability Update Form -->
        <div class="card">
            <h3>Set Your Availability</h3>
            <form action="SetAvailabilityServlet" method="post" class="availability-form">
                <input type="hidden" name="doctorId" value="<%= ((Doctor)session.getAttribute("doctor")).getDoctorid() %>"/>
                <label for="availability">Set Availability: </label>
                <select name="isAvailable" id="availability">
                    <option value="Available" <%= "Available".equals(((Doctor)session.getAttribute("doctor")).getAvailability()) ? "selected" : "" %>>Available</option>
                    <option value="Not Available" <%= "Not Available".equals(((Doctor)session.getAttribute("doctor")).getAvailability()) ? "selected" : "" %>>Not Available</option>
                </select>
                <button type="submit">Update Availability</button>
            </form>
        </div>
    </div>
</body>
</html>
