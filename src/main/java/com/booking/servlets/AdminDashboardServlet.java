package com.booking.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.dao.UserDAO;
import com.booking.entity.User;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch all users from the database
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getAll();

        // Set users in request scope and forward to adminDashboard.jsp
        request.setAttribute("users", users);
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }
}

