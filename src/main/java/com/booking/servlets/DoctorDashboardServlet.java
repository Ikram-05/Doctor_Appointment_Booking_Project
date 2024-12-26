package com.booking.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.dao.AppointmentDAO;
import com.booking.entity.Appointment;
import com.booking.entity.Doctor;

@WebServlet("/DoctorDashboardServlet")
public class DoctorDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the doctor ID from the request, assuming it's passed from the login process
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));

        // Get the list of appointments for the doctor
        AppointmentDAO appointmentDao = new AppointmentDAO();
        List<Appointment> appointments = appointmentDao.findAppointmentsByDoctor(doctorId);

        // Set the appointments as a request attribute for the JSP
        request.setAttribute("appointments", appointments);

        // Forward to the doctor dashboard JSP
        request.getRequestDispatcher("doctorDashboard.jsp").forward(request, response);
    }
}
