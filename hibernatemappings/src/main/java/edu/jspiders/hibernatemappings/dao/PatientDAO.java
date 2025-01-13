package edu.jspiders.hibernatemappings.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernatemappings.dto.BloodReport;
import edu.jspiders.hibernatemappings.dto.Patient;

public class PatientDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		Patient patient = new Patient();
		patient.setName("Ramesh");
		patient.setMobile(9876543210l);

		BloodReport bloodReport = new BloodReport();
		bloodReport.setDescription("abc");
		bloodReport.setPatient(patient);

		patient.setBloodReport(bloodReport);

		openConnection();
		entityTransaction.begin();
		entityManager.persist(bloodReport);
		entityManager.persist(patient);
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
