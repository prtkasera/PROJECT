 package com.cognizant.pts.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.pts.entity.Patient;
@Repository("PatientDAOImpl")
public class PatientDAOImpl implements PatientDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Patient> viewAllPatients() {
		// TODO Auto-generated method stub
	
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Patient");
		List<Patient> patientList=query.list();
		session.close();
		return patientList;
	
	}

	@Override
	public boolean updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePatient(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPatient(Patient patient) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(patient);
		tx.commit();
		session.close();
		return true;
	}

}
