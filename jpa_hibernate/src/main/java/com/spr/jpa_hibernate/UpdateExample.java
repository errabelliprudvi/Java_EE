package com.spr.jpa_hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UpdateExample {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Employee emp = em.find(Employee.class, 1);
            if (emp != null) {
                emp.setSalary(60000);
                em.merge(emp);  // Update operation
                System.out.println("Updated Employee: " + emp);
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
