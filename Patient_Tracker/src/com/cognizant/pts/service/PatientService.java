package com.cognizant.pts.service;

import java.util.List;

import com.cognizant.pts.entity.Patient;

public interface PatientService {

	List<Patient> viewAllPatients();
	boolean updatePatient(Patient patient);
	boolean deletePatient(Patient patient);
	boolean addPatient(Patient patient);
}
