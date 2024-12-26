package com.booking.dao;


import com.booking.entity.Appointment;
import com.booking.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class AppointmentDAO {

    // Save a new appointment
    public void save(Appointment appointment) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(appointment);
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

    // Get appointment by ID
    public Appointment getById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(Appointment.class, id);
        } finally {
            entityManager.close();
        }
    }

    // Get all appointments
    public List<Appointment> getAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT a FROM Appointment a", Appointment.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    // Update appointment details
    public void update(Appointment appointment) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(appointment);
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

    // Delete appointment by ID
    public void delete(int id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Appointment appointment = entityManager.find(Appointment.class, id);
            if (appointment != null) {
                entityManager.remove(appointment);
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

    // Get appointments by doctor ID
    public List<Appointment> getByDoctorId(int doctorId) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Appointment> query = entityManager.createQuery("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId", Appointment.class);
            query.setParameter("doctorId", doctorId);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    public List<Appointment> findAppointmentsByDoctor(int doctorId) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        List<Appointment> appointments = null;
        
        try {
            // Query to fetch appointments based on doctor_id
            String query = "SELECT a FROM Appointment a WHERE a.doctor.doctor_id = :doctorId";
            appointments = entityManager.createQuery(query, Appointment.class)
                                       .setParameter("doctorId", doctorId)
                                       .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return appointments;
    }

}
