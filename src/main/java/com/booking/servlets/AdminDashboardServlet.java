package com.booking.servlets;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.dao.AppointmentDAO;
import com.booking.dao.DoctorDAO;
import com.booking.dao.UserDAO;
import com.booking.entity.Appointment;
import com.booking.entity.Doctor;
import com.booking.entity.User;
import com.booking.util.JPAUtil;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = JPAUtil.getEntityManager();
        DoctorDAO doctorDAO=new DoctorDAO();
        UserDAO userDAO=new UserDAO();
        AppointmentDAO appointmentDAO=new AppointmentDAO();
        try {
            System.out.println("EntityManager created: " + (em != null ? "Yes" : "No"));

            // Fetch all doctors
            List<Doctor> doctors = doctorDAO.getAll();
            request.setAttribute("doctors", doctors);

            // Fetch all users
            List<User> users = userDAO.getAll();
            request.setAttribute("users", users);

            // Fetch all appointments
            List<Appointment> appointments = appointmentDAO.getAll();
            request.setAttribute("appointments", appointments);

         
            // Forward to JSP
            RequestDispatcher rd = request.getRequestDispatcher("adminDashboard.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error fetching data: " + e.getMessage());
            response.sendRedirect("errorPage.jsp");
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}