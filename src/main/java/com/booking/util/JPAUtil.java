package com.booking.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory;

    // Static block to initialize the EntityManagerFactory
    static {
        try {
            // Create EntityManagerFactory using the persistence unit defined in persistence.xml
            entityManagerFactory = Persistence.createEntityManagerFactory("doc");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Initial EntityManagerFactory creation failed." + e);
        }
    }

    // Method to get the EntityManagerFactory
    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    // Method to get the EntityManager
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Method to close the EntityManagerFactory
    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
