package com.booking.servlets;

import com.booking.entity.Appointment;
import com.booking.entity.User;
import com.booking.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/manageAppointments")
public class ManageAppointmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User patient = (User) request.getSession().getAttribute("user");
        if (patient == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("SELECT a FROM Appointment a WHERE a.user = :user");
        query.setParameter("user", patient);
        List<Appointment> appointments = query.getResultList();
        request.setAttribute("appointments", appointments);
        request.getRequestDispatcher("viewAppointments.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
        EntityManager em = JPAUtil.getEntityManager();
        Appointment appointment = em.find(Appointment.class, appointmentId);
        if (appointment != null) {
            em.getTransaction().begin();
            appointment.setStatus("Cancelled");
            em.merge(appointment);
            em.getTransaction().commit();
        }
        response.sendRedirect("manageAppointments");
    }
}

