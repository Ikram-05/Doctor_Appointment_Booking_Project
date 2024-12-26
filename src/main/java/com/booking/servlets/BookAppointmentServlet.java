package com.booking.servlets;

import com.booking.entity.Appointment;
import com.booking.entity.Doctor;
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
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/bookAppointment")
public class BookAppointmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("SELECT d FROM Doctor d WHERE d.availability = 'Available'");
        List<Doctor> doctors = query.getResultList();
        request.setAttribute("doctors", doctors);
        request.getRequestDispatcher("bookAppointment.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        User user = (User) request.getSession().getAttribute("user");
        EntityManager em = JPAUtil.getEntityManager();

        Doctor doctor = em.find(Doctor.class, doctorId);
        if (doctor != null) {
            em.getTransaction().begin();
            Appointment appointment = new Appointment();
            appointment.setUser(user);
            appointment.setDoctor(doctor);
            appointment.setAppointment_date(Date.valueOf(LocalDate.now()));
            appointment.setStatus("Scheduled");
            em.persist(appointment);
            em.getTransaction().commit();
        }
        response.sendRedirect("viewAppointments");
    }
}