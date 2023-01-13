package com.hibernaterelationships.demo;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.hibernaterelationships.entities.Instructor;
import com.hibernaterelationships.entities.InstructorDetail;

public class GetInstructorDetailDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
		
			
			session.getTransaction().commit();
		} catch (Exception e) {

		}

	}
}
