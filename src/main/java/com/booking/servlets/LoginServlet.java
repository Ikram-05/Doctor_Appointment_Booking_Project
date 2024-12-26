package com.booking.servlets;

import com.booking.dao.UserDAO;
import com.booking.dao.DoctorDAO;
import com.booking.entity.User;
import com.booking.entity.Doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if ("user".equals(role)) {
            // Patient Login
            UserDAO userDAO = new UserDAO();
            User user = userDAO.findUserByEmailAndPassword(email, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("userDashboard.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else if ("doctor".equals(role)) {
            // Doctor Login
            DoctorDAO doctorDAO = new DoctorDAO();
            Doctor doctor = doctorDAO.findDoctorByEmailAndPassword(email, password);

            if (doctor != null) {
                HttpSession session = request.getSession();
                session.setAttribute("doctor", doctor);
                response.sendRedirect("doctorDashboard.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else if ("admin".equals(role)) {
            // Admin Login (example logic with hardcoded admin)
            if ("admin@example.com".equals(email) && "adminpassword".equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", "admin");
                response.sendRedirect("adminDashboard.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
