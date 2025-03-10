package com.spr.hibernate;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;



public class HibernateDQLExample 
{
	private static Session session;
   public static void main(String[] args)
   {
	    session = HibernateUtil.getSessionFactory().openSession();
	   
	  // getRecord(1);
	  // getRecord(1);
	   fetchUsingHQL();
	    //usingCriteriaAPI();
	   // usingNativeSQLQuery();
	  
	   session.close();
   }
   
   public static void getRecord(int id)
   {
	  // Student student = session.load(Student.class, id);  //throw an exception if no record find
	   Student student = session.get(Student.class, id);     // assigns null value to object
	   if(student != null ) System.out.println(student.getName());
	   
   }
   
   public static void fetchUsingHQL()
   {
	   //Hibernate Query Language (HQL) is similar to SQL but uses entity names instead of table names.
	   
	   /*String hql = "FROM Employee e WHERE e.salary > :salary";
	   Query query = session.createQuery(hql, Employee.class);
	   query.setParameter("salary", 50000);
	   List<Employee> employees = query.getResultList();
       */

	   List<Student> students = session.createQuery("FROM Student", Student.class).list();

	   for (Student s : students) {
	       System.out.println(s.getName());
	   }
   }
   
   public static void usingCriteriaAPI()
   {
	   CriteriaBuilder cb = session.getCriteriaBuilder();
	   CriteriaQuery<Student> cq = cb.createQuery(Student.class);
	   Root<Student> root = cq.from(Student.class);
	   cq.select(root);

	   List<Student> students = session.createQuery(cq).getResultList();
	   for (Student s : students) {
	       System.out.println(s.getName());
	   }
   }
   
   public static void usingNativeSQLQuery()
   {
	   Session session = HibernateUtil.getSessionFactory().openSession();
	   
	  List<Student> students = session.createNativeQuery("SELECT * FROM students",Student.class).getResultList();

	   for (Student s : students) {
	       System.out.println(s.getEmail()); 
	   }
   }
}


/*
1. Using Hibernate Session API
If you're using Hibernate's SessionFactory, you can retrieve data using:

session.get()
session.load()
HQL (Hibernate Query Language)
Criteria API
Native SQL Query


🔹 Fetch Record by ID (session.get())

Session session = HibernateUtil.getSessionFactory().openSession();
Student student = session.get(Student.class, 1);
System.out.println(student.getName());
session.close();
✅ Returns null if no record is found.

🔹 Fetch Record by ID (session.load())

Session session = HibernateUtil.getSessionFactory().openSession();
Student student = session.load(Student.class, 1);
System.out.println(student.getName());
session.close();
⚠ Throws ObjectNotFoundException if no record exists.

🔹 Fetch All Records Using HQL
Hibernate Query Language (HQL) is similar to SQL but uses entity names instead of table names.

Session session = HibernateUtil.getSessionFactory().openSession();
List<Student> students = session.createQuery("FROM Student", Student.class).list();

for (Student s : students) {
    System.out.println(s.getName());
}
session.close();


🔹 Fetch Records Using Criteria API

Session session = HibernateUtil.getSessionFactory().openSession();
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<Student> cq = cb.createQuery(Student.class);
Root<Student> root = cq.from(Student.class);
cq.select(root);

List<Student> students = session.createQuery(cq).getResultList();
for (Student s : students) {
    System.out.println(s.getName());
}
session.close();


🔹 Fetch Records Using Native SQL Query

Session session = HibernateUtil.getSessionFactory().openSession();
List<Object[]> students = session.createNativeQuery("SELECT * FROM students").list();

for (Object[] s : students) {
    System.out.println(s[1]); // Assuming 2nd column is 'name'
}
session.close();


*/