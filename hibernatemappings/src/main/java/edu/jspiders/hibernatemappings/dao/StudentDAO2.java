package edu.jspiders.hibernatemappings.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernatemappings.dto.Student;
import edu.jspiders.hibernatemappings.dto.Subject;

public class StudentDAO2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		Student student1 = entityManager.find(Student.class, 1);
		entityManager.remove(student1);
		Student student2 = entityManager.find(Student.class, 2);
		entityManager.remove(student2);
		Subject subject1 = entityManager.find(Subject.class, 1);
		entityManager.remove(subject1);
		Subject subject2 = entityManager.find(Subject.class, 2);
		entityManager.remove(subject2);
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
