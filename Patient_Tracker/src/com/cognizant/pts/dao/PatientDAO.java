package com.cognizant.pts.dao;

import java.util.List;

import com.cognizant.pts.entity.Patient;

public interface PatientDAO {

	
	List<Patient> viewAllPatients();
	boolean updatePatient(Patient patient);
	boolean deletePatient(Patient patient);
	boolean addPatient(Patient patient);
	
	
}
