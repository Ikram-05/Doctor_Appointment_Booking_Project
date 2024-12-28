package com.booking.dao;


import com.booking.entity.Doctor;
import com.booking.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DoctorDAO {

    // Save a new doctor
    public void save(Doctor doctor) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(doctor);
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

    // Get doctor by ID
    public Doctor getById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(Doctor.class, id);
        } finally {
            entityManager.close();
        }
    }

    // Get all doctors
    public List<Doctor> getAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Doctor> query = entityManager.createQuery("SELECT d FROM Doctor d", Doctor.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    // Update doctor details
    public void update(Doctor doctor) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(doctor);
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

    // Delete doctor by ID
    public void delete(int id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Doctor doctor = entityManager.find(Doctor.class, id);
            if (doctor != null) {
                entityManager.remove(doctor);
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

    // Find doctor by specialization
    public List<Doctor> findBySpecialization(String specialization) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Doctor> query = entityManager.createQuery("SELECT d FROM Doctor d WHERE d.specialization = :specialization", Doctor.class);
            query.setParameter("specialization", specialization);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    

    public Doctor findDoctorByEmailAndPassword(String email, String password) {
    	 EntityManager entityManager = JPAUtil.getEntityManager();
         EntityTransaction transaction = entityManager.getTransaction();
        try {
            String hql = "FROM Doctor d WHERE d.email = :email AND d.password = :password";
            Query query = entityManager.createQuery(hql);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return (Doctor) query.getSingleResult(); // Returns the doctor object or throws NoResultException if not found
        }  catch (NoResultException e) {
            return null;  // No doctor found
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding doctor by email and password");
        } finally {
            entityManager.close();
        }

    }
    
    public List<Doctor> findAvailableDoctors() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT d FROM Doctor d WHERE d.availability = 'Available'", Doctor.class)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }

    public Doctor findDoctorById(int doctorId) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(Doctor.class, doctorId);
        } finally {
            entityManager.close();
        }
    }

    
    public void updateAvailability(int doctorId, String availability) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();  // Start transaction
            Doctor doctor = entityManager.find(Doctor.class, doctorId);
            if (doctor != null) {
                doctor.setAvailability(availability); // Set the new availability value
                entityManager.merge(doctor); // Persist changes to the database
            }
            entityManager.getTransaction().commit();  // Commit the transaction
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();  // Rollback transaction in case of error
            }
        } finally {
            entityManager.close();  // Close the EntityManager
        }
    }

    

}



