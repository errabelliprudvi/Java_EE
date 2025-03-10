package com.spr.jpa_hibernate;


import jakarta.persistence.EntityManager;

public class SelectExample {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        Employee emp = em.find(Employee.class, 2);  // Fetch by ID
      
        if (emp != null ) {
            System.out.println("Employee Found: " + emp);
          
        } else {
            System.out.println("Employee Not Found!");
        }

        em.close();
        JPAUtil.close();
    }
}
