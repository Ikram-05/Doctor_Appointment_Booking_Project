package com.booking.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import com.booking.util.JPAUtil;
import com.booking.entity.Admin;

public class AdminDAO {

    // Create Admin
    public void createAdmin(Admin admin) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(admin);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Update Admin
    public void updateAdmin(Admin admin) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(admin);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Delete Admin
    public void deleteAdmin(int adminId) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Admin admin = em.find(Admin.class, adminId);
            if (admin != null) {
                em.remove(admin);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Find Admin by ID
    public Admin findAdminById(int adminId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Admin.class, adminId);
        } finally {
            em.close();
        }
    }

    // Find Admin by Email (with Exception Handling)
    public Admin findAdminByEmail(String email) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Admin a WHERE a.email = :email", Admin.class)
                     .setParameter("email", email)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;  // Return null if no admin is found
        } finally {
            em.close();
        }
    }

    // Get All Admins
    public List<Admin> getAllAdmins() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
        } finally {
            em.close();
        }
    }
}
