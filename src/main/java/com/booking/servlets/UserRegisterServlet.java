package com.booking.servlets;


import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.booking.entity.User;
import com.booking.util.JPAUtil;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contact = request.getParameter("contact");
        String gender = request.getParameter("gender");

        // User entity creation
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setContact(contact);
        user.setGender(gender);

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(user);
            tx.commit();
            response.sendRedirect("login.jsp?message=Registration successful!");
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            response.sendRedirect("userRegister.jsp?error=User registration failed.");
        } finally {
            em.close();
        }
    }
}
