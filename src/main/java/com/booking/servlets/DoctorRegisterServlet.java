package com.booking.servlets;

import com.booking.entity.Doctor;
import com.booking.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DoctorRegisterServlet")
public class DoctorRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles the registration logic
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String specialization = request.getParameter("specialization");
        String password = request.getParameter("password");

        // Input validation
        if (name == null || email == null || specialization == null || password == null) {
            response.sendRedirect("doctorRegister.jsp?error=Please fill in all fields");
            return;
        }

        // Create a new Doctor entity
        Doctor newDoctor = new Doctor();
        newDoctor.setName(name);
        newDoctor.setEmail(email);
        newDoctor.setSpecialization(specialization);
        newDoctor.setPassword(password); // Consider hashing the password for security

        // Use JPA to persist the new doctor
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(newDoctor);  // Persist the doctor entity
            em.getTransaction().commit();
            response.sendRedirect("adminDashboard.jsp?message=Doctor registered successfully");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            response.sendRedirect("doctorRegister.jsp?error=Failed to register doctor");
        } finally {
            em.close();
        }
    }
}

