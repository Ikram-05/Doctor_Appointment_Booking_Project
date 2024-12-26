package com.booking.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.dao.DoctorDAO;
import com.booking.entity.Doctor;

@WebServlet("/UserDashboardServlet")
public class UserDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch available doctors from the database
        DoctorDAO doctorDAO = new DoctorDAO();
        List<Doctor> doctors = doctorDAO.getAll();

        // Set doctors in request scope and forward to userDashboard.jsp
        request.setAttribute("doctors", doctors);
        request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
    }
}
