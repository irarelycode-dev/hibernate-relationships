package com.hibernaterelationships.demo;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.hibernaterelationships.entities.Instructor;
import com.hibernaterelationships.entities.InstructorDetail;

public class DeleteDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			int id = 1;
			Instructor tmpInstructor = session.get(Instructor.class, id);
			System.out.println("Found Instructor:" + tmpInstructor);
			if (tmpInstructor != null) {
				System.out.print("Deleting:" + tmpInstructor);
				session.delete(tmpInstructor);
			}
			session.getTransaction().commit();
		} catch (Exception e) {

		}

	}
}
