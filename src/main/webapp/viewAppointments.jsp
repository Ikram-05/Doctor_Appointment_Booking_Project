<!-- viewAppointments.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>My Appointments</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .cancel-btn { background-color: red; color: white; border: none; padding: 5px 10px; cursor: pointer; }
    </style>
</head>
<body>
    <h1>My Appointments</h1>
    <table>
        <tr>
            <th>Doctor</th>
            <th>Date</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <c:forEach var="appointment" items="${appointments}">
            <tr>
                <td>${appointment.doctor.name}</td>
                <td>${appointment.appointmentDate}</td>
                <td>${appointment.status}</td>
                <td>
                    <form action="manageAppointments" method="post">
                        <input type="hidden" name="appointmentId" value="${appointment.id}"/>
                        <button class="cancel-btn" type="submit">Cancel</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>