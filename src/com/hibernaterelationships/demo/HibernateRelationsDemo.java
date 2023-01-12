package com.hibernaterelationships.demo;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.hibernaterelationships.entities.Instructor;
import com.hibernaterelationships.entities.InstructorDetail;

public class HibernateRelationsDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Instructor tmpInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://luv2code.com", "coding");
			tmpInstructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			session.save(tmpInstructor);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("error:" + e);
		} finally {
			session.close();
		}

	}
}
