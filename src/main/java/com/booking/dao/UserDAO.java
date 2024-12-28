package com.booking.dao;


import com.booking.entity.User;
import com.booking.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.List;

public class UserDAO {

    // Save a new patient
    public void save(User user) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    // Get patient by ID
    public User getById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(User.class, id);
        } finally {
            entityManager.close();
        }
    }

    // Get all patients
    public List<User> getAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM User p", User.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    // Update patient details
    public void update(User user) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    // Delete patient by ID
    public void delete(int id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    public User findUserByEmailAndPassword(String email, String password) {
    	EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            String hql = "FROM User u WHERE u.email = :email AND u.password = :password";
            Query query = entityManager.createQuery(hql);
            query.setParameter("email", email);
            query.setParameter("password", password);

            return (User) query.getSingleResult(); // Returns the user object or throws NoResultException if not found
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle exception properly in production code
        } finally {
            entityManager.close();
        }
    }

   

    
    
}
