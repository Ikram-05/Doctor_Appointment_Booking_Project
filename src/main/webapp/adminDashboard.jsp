<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.booking.entity.Doctor" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #4CAF50;
            padding: 20px;
            text-align: center;
            color: white;
        }
        header h1 {
            margin: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .btn {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .card {
            border: 1px solid #ddd;
            padding: 20px;
            margin-bottom: 20px;
            background-color: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .card h3 {
            margin-top: 0;
        }
    </style>
</head>
<body>
    <header>
        <h1>Admin Dashboard</h1>
    </header>

    <div class="container">
        <h2>Welcome, Admin!</h2>

        <!-- Doctors Section -->
        <div class="card">
            <h3>Manage Doctors</h3>
            <a href="doctorRegister.jsp" class="btn">Add New Doctor</a>
            <table>
                <thead>
                    <tr>
                        <th>Doctor Name</th>
                        <th>Specialization</th>
                        <th>Email</th>
                        <th>Availability</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Debug Doctor List --%>
                    <%
                        java.util.List<Doctor> doctorList = (java.util.List<Doctor>) request.getAttribute("doctors");
                        if (doctorList != null) {
                            for (Doctor doc : doctorList) {
                                System.out.println("Doctor: " + doc.getName() + ", Specialization: " + doc.getSpecialization());
                            }
                        } else {
                            System.out.println("Doctors list is null.");
                        }
                    %>
                    
                    <c:forEach var="doctor" items="${doctors}">
                        <tr>
                            <td>${doctor.name}</td>
                            <td>${doctor.specialization}</td>
                            <td>${doctor.email}</td>
                            <td>${doctor.availability}</td>
                            <td>
                                <a href="editDoctor.jsp?id=${doctor.doctorid}" class="btn">Edit</a>
                                <a href="deleteDoctorServlet?id=${doctor.doctorid}" class="btn">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Users Section -->
        <div class="card">
            <h3>Manage Users</h3>
            <table>
                <thead>
                    <tr>
                        <th>User Name</th>
                        <th>Email</th>
                        <th>Contact</th>
                        <th>Gender</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>${user.contact}</td>
                            <td>${user.gender}</td>
                            <td>
                                <a href="editUser.jsp?id=${user.user_id}" class="btn">Edit</a>
                                <a href="deleteUserServlet?id=${user.user_id}" class="btn">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Appointments Section -->
        <div class="card">
            <h3>Manage Appointments</h3>
            <table>
                <thead>
                    <tr>
                        <th>Patient Name</th>
                        <th>Doctor</th>
                        <th>Appointment Date</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="appointment" items="${appointments}">
                        <tr>
                            <td>${appointment.user.name}</td>
                            <td>${appointment.doctor.name}</td>
                            <td>${appointment.appointment_date}</td>
                            <td>${appointment.status}</td>
                            <td>
                                <a href="editAppointment.jsp?id=${appointment.appointment_id}" class="btn">Edit</a>
                                <a href="deleteAppointmentServlet?id=${appointment.appointment_id}" class="btn">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</body>
</html>
