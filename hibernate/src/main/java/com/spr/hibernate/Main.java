package com.spr.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setName("John Doe");
        student.setEmail("john@example.com");
       
        session.save(student);
        //session.delete(student);
        session.delete("Student", student);
        transaction.commit();
        session.close();
    }
}
