package com.spr.jpa_hibernate;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DeleteExample {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Employee emp = em.find(Employee.class, 1);
            if (emp != null) {
                em.remove(emp);  // Delete operation
                System.out.println("Deleted Employee: " + emp);
            } else {
                System.out.println("Employee Not Found!");
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            JPAUtil.close();
        }
    }
}
