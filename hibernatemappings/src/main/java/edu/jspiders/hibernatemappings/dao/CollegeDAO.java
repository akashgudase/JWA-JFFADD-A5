package edu.jspiders.hibernatemappings.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernatemappings.dto.College;
import edu.jspiders.hibernatemappings.dto.Teacher;

public class CollegeDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		College college = new College();
		college.setName("ABC");
		college.setLocation("Pune");

		Teacher teacher1 = new Teacher();
		teacher1.setName("Ramesh");
		teacher1.setMobile(9876543210l);
		teacher1.setCollege(college);

		Teacher teacher2 = new Teacher();
		teacher2.setName("Suresh");
		teacher2.setMobile(9876543211l);
		teacher2.setCollege(college);

		Collection<Teacher> teachers = new ArrayList<Teacher>();
		teachers.add(teacher1);
		teachers.add(teacher2);

		college.setTeachers(teachers);

		openConnection();
		entityTransaction.begin();
		entityManager.persist(teacher1);
		entityManager.persist(teacher2);
		entityManager.persist(college);
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
