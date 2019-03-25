package com.cognizant.pts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pts.dao.PatientDAO;
import com.cognizant.pts.entity.Patient;
@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDAO patientDao;

	@Override
	public List<Patient> viewAllPatients() {
		// TODO Auto-generated method stub
		return patientDao.viewAllPatients();
	}

	@Override
	public boolean updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientDao.updatePatient();
	}

	@Override
	public boolean deletePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientDao.deletePatient();
	}

	@Override
	public boolean addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientDao.addPatient();
	}
	

	
	

}
