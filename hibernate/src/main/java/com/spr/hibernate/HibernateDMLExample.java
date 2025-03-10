package com.spr.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateDMLExample {
    
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public static void main(String[] args) {
        insert();
        update();
        delete();
    }
    
    public static void insert() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) { // Auto-close session
            transaction = session.beginTransaction();
            
            Employee emp = new Employee();
            emp.setName("John Doe");
            emp.setSalary(50000);
            
            session.save(emp); // OR session.persist(emp) for JPA compliance

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    
    public static void update() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            
            int empId = 1;
            Employee emp = session.get(Employee.class, empId);
            if (emp != null) {
                emp.setSalary(60000);
                emp.setEmail("abc@gmail.com");
                
                session.merge(emp); // Use merge for detached entities
                
                transaction.commit();
            } else {
                System.out.println("Employee not found!");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    
    public static void delete() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            
            int empId = 1;
            Employee emp = session.get(Employee.class, empId);
            if (emp != null) {
                session.delete(emp);
                transaction.commit();
            } else {
                System.out.println("Employee not found!");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
