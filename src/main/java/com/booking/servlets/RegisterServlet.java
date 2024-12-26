package com.booking.servlets;


import com.booking.dao.*;
import com.booking.dao.DoctorDAO;
import com.booking.entity.User;
import com.booking.entity.Doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");

        if ("user".equals(role)) {
            // Handle User (Patient) registration
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String contact = request.getParameter("contact");
            String gender = request.getParameter("gender");

            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);
            user.setContact(contact);
            user.setGender(gender);

            UserDAO userDAO = new UserDAO();
            userDAO.save(user);
            response.sendRedirect("login.jsp");

        } else if ("doctor".equals(role)) {
            // Handle Doctor registration (Admin only)
            String name = request.getParameter("name");
            String specialization = request.getParameter("specialization");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String availability = request.getParameter("availability");

            Doctor doctor = new Doctor();
            doctor.setName(name);
            doctor.setSpecialization(specialization);
            doctor.setEmail(email);
            doctor.setPassword(password);
            doctor.setAvailability(availability);

            DoctorDAO doctorDAO = new DoctorDAO();
            doctorDAO.save(doctor);
            response.sendRedirect("login.jsp");
        }
    }
}
