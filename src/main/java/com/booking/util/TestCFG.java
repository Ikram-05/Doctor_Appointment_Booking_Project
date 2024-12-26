package com.booking.util;

import com.booking.entity.User;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class TestCFG {

    public static void main(String[] args) {
        // Get the EntityManager from PersistenceUtil
        EntityManager entityManager = JPAUtil.getEntityManager();

        try {
            // Start a transaction
            entityManager.getTransaction().begin();

            // Create a query to fetch all users from the 'User' table
            Query query = entityManager.createQuery("from User", User.class);

            // Execute the query and get the result list
            List<User> users = query.getResultList();

            // Print the fetched users
            for (User user : users) {
                System.out.println(user);
            }

            // Commit the transaction
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up and close the EntityManager
            entityManager.close();
            JPAUtil.shutdown();
        }
    }
}
