package com.spr.jpa_hibernate;

import jakarta.persistence.*;
import java.util.List;

public class FetchAllExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJpaUnit");
        EntityManager em = emf.createEntityManager();
        
        try {
            // Fetching all records
            List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class)
                                         .getResultList();
            
            // Printing records
            for (Employee emp : employees) {
                System.out.println(emp.getId() + " - " + emp.getName() + " - " + emp.getSalary());
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}

