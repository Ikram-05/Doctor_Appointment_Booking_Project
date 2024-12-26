package com.booking.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.entity.Appointment;
import com.booking.entity.User;
import com.booking.util.JPAUtil;

@WebServlet("/doctorAppointments")
public class DoctorAppointmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User doctor = (User) request.getSession().getAttribute("user");
        if (doctor == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("SELECT a FROM Appointment a WHERE a.doctor = :doctor");
        query.setParameter("doctor", doctor);
        List<Appointment> appointments = query.getResultList();
        request.setAttribute("appointments", appointments);
        request.getRequestDispatcher("doctorViewAppointments.jsp").forward(request, response);
    }
}
