package com.spr.jpa_hibernate;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class InsertExample {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Employee emp = new Employee("mahesh", 1500);
            em.persist(emp);  // Insert operation
            tx.commit();
            System.out.println("Inserted: " + emp);
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            JPAUtil.close();
        }
    }
}
