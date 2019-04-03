 package com.cognizant.pts.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.pts.entity.Admin;
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
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.merge(patient);
		tx.commit();
		session.close();
		return true;
	}

	

	@Override
	public Patient viewOnePatient(String patientId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Patient o where patientId=:patientId");
		query.setString("patientId", patientId);
		Patient patient =(Patient)query.uniqueResult();
		session.close();
		return patient;
	}
	@Override
	public boolean addPatient(Patient patient) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		generatePatientId();
		Transaction transaction=session.beginTransaction();
		session.persist(patient);
		transaction.commit();
		session.close();
		return true;
	}
	public void generatePatientId()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createSQLQuery("select PATIENTSEQ.nextval from DUAL");
		Long key=((BigDecimal) query.uniqueResult()).longValue();
		StorePatientId.addPatientId(key.intValue());
		}

}
