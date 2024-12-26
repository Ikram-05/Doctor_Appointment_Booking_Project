<!-- bookAppointment.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Book Appointment</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        .container { max-width: 600px; margin: auto; }
        h1 { text-align: center; }
        form { margin-top: 20px; }
        label, select, button { display: block; width: 100%; margin-top: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Book an Appointment</h1>
        <form action="bookAppointment" method="post">
            <label for="doctorId">Select Doctor:</label>
            <select name="doctorId" id="doctorId" required>
                <c:forEach var="doctor" items="${doctors}">
                    <option value="${doctor.id}">${doctor.name} - ${doctor.specialization}</option>
                </c:forEach>
            </select>
            <button type="submit">Book Appointment</button>
        </form>
    </div>
</body>
</html>