package com.hibernaterelationships.demo;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.hibernaterelationships.entities.Instructor;
import com.hibernaterelationships.entities.InstructorDetail;

public class GetInstructorDetailDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			int id = 2;
			InstructorDetail tmpInstructorDetail = session.get(InstructorDetail.class, id);
			System.out.println("tmpInstructorDetail:" + tmpInstructorDetail);
			System.out.print("Instructor from instructorDetail:" + tmpInstructorDetail.getInstructor());
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.print("Error:" + e);
		} finally {
			session.close();
		}

	}
}
