package edu.jspiders.hibernatemappings.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernatemappings.dto.Student;
import edu.jspiders.hibernatemappings.dto.Subject;

public class StudentDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		Subject subject1 = new Subject();
		subject1.setName("SQL");
		subject1.setFees(10000.00);

		Subject subject2 = new Subject();
		subject2.setName("Core Java");
		subject2.setFees(15000.00);

		Collection<Subject> subjects = new ArrayList<Subject>();
		subjects.add(subject1);
		subjects.add(subject2);

		Student student1 = new Student();
		student1.setName("Ramesh");
		student1.setMobile(9876543210l);
		student1.setSubjects(subjects);

		Student student2 = new Student();
		student2.setName("Suresh");
		student2.setMobile(9876543211l);
		student2.setSubjects(subjects);

		openConnection();
		entityTransaction.begin();
		entityManager.persist(subject1);
		entityManager.persist(subject2);
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityTransaction.commit();
		closeConnection();

	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate_mappings");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null)
			entityManagerFactory.close();
		if (entityManager != null)
			entityManager.close();
		if (entityTransaction != null) {
			if (entityTransaction.isActive())
				entityTransaction.rollback();
		}
	}

}
