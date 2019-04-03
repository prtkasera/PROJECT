package com.cognizant.pts.service;

import java.util.List;

import com.cognizant.pts.entity.Patient;
import com.cognizant.pts.model.PatientModel;

public interface PatientService {

	List<Patient> viewAllPatients();
	PatientModel viewOnePatient(String patientId);
	boolean updatePatient(PatientModel patientModel);
	boolean persistPatient(PatientModel patientModel);
		
}
