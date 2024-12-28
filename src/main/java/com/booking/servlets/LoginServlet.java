package com.booking.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.booking.dao.*;
import com.booking.entity.*;
 
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if ("admin".equals(role)) {
            AdminDAO adminDAO = new AdminDAO();
            Admin admin = adminDAO.findAdminByEmail(email);

            if (admin != null && admin.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                response.sendRedirect("adminDashboard.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if ("doctor".equals(role)) {
            DoctorDAO doctorDAO = new DoctorDAO();
            Doctor doctor = doctorDAO.findDoctorByEmailAndPassword(email, password);

            if (doctor != null) {
                HttpSession session = request.getSession();
                session.setAttribute("doctor", doctor);
                response.sendRedirect("doctorDashboard.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if ("user".equals(role)) {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.findUserByEmailAndPassword(email, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("userDashboard.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Invalid role selection.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
