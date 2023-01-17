package com.hibernaterelationships.demo;

import com.hibernaterelationships.entities.Course;
import com.hibernaterelationships.entities.Instructor;
import com.hibernaterelationships.entities.InstructorDetail;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class CreateCourseOneToMany {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			int id = 5;
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, id);

			Course course1 = new Course("AI");
			Course course2 = new Course("APP");

			instructor.addCourse(course1);
			instructor.addCourse(course2);

			session.save(course1);
			session.save(course2);

			session.getTransaction().commit();

		} catch (Exception e) {

			System.out.print("Exception:" + e);

		} finally {
			session.close();
		}
	}

}
