<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- doctorViewAppointments.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Doctor's Appointments</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>My Scheduled Appointments</h1>
    <table>
        <tr>
            <th>Patient</th>
            <th>Date</th>
            <th>Status</th>
        </tr>
        <c:forEach var="appointment" items="${appointments}">
            <tr>
                <td>${appointment.user.name}</td>
                <td>${appointment.appointmentDate}</td>
                <td>${appointment.status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>