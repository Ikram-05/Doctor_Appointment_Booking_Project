package com.booking.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.dao.DoctorDAO;
import com.booking.entity.Doctor;
import com.booking.util.JPAUtil;

@WebServlet("/setAvailability")
public class SetAvailabilityServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        String availability = request.getParameter("isAvailable"); // "Available" or "Not Available"

        EntityManager entityManager = JPAUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();  // Start transaction
            Doctor doctor = entityManager.find(Doctor.class, doctorId);
            if (doctor != null) {
                doctor.setAvailability(availability);
                entityManager.merge(doctor); // Update the doctor entity in the database
                entityManager.getTransaction().commit();  // Commit the transaction
                response.sendRedirect("doctorDashboard.jsp");
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Doctor not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();  // Rollback transaction in case of error
            }
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating availability");
        } finally {
            entityManager.close();  // Close the EntityManager
        }
    }
}


