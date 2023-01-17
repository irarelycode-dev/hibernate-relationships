package com.hibernaterelationships.demo;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.hibernaterelationships.entities.Course;
import com.hibernaterelationships.entities.Instructor;
import com.hibernaterelationships.entities.InstructorDetail;

public class GetInstructorCourses {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 5);
			List<Course> courses = instructor.getCourses();
			for (Course c : courses) {
				System.out.println("Course:" + c.getId() + " " + c.getTitle());
			}
		} catch (Exception e) {
			System.out.print("Exception:" + e);
		} finally {
			session.close();
		}
	}
}
