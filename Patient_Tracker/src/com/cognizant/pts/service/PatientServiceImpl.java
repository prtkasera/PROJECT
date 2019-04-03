package com.cognizant.pts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pts.dao.PatientDAO;
import com.cognizant.pts.entity.Patient;
import com.cognizant.pts.model.PatientModel;
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
	public boolean updatePatient(PatientModel patientModel) {
		// TODO Auto-generated method stub
		Patient patient =new Patient();

		patient.setPatientId(patientModel.getPatientId());
		patient.setFirstName(patientModel.getFirstName());
		patient.setLastName(patientModel.getLastName());
		patient.setAge(patientModel.getAge());
		patient.setDob(patientModel.getDob());
		patient.setGender(patientModel.getGender());
		patient.setContactNumber(patientModel.getContactNumber());
		patient.setAlternateContactNumber(patientModel.getAlternateContactNumber());
		patient.setEmailId(patientModel.getEmailId());
		patient.setAddressLine1(patientModel.getAddressLine1());
		patient.setAddressLine2(patientModel.getAddressLine2());
		patient.setCity(patientModel.getCity());
		patient.setState(patientModel.getState());
		patient.setZipCode(patientModel.getZipCode());

		return patientDao.updatePatient(patient);
	}

	@Override
	public boolean persistPatient(PatientModel patientModel) {
		// TODO Auto-generated method stub
		Patient patient=new Patient();

		//patient.setPatientId(patientModel.getPatientId());
		patient.setFirstName(patientModel.getFirstName());
		patient.setLastName(patientModel.getLastName());
		patient.setAge(patientModel.getAge());
		patient.setGender(patientModel.getGender());
		patient.setDob(patientModel.getDob());
		patient.setContactNumber(patientModel.getContactNumber());
		patient.setEmailId(patientModel.getEmailId());
		patient.setAlternateContactNumber(patientModel.getAlternateContactNumber());
		patient.setAddressLine1(patientModel.getAddressLine1());
		patient.setAddressLine2(patientModel.getAddressLine2());
		patient.setCity(patientModel.getCity());
		patient.setState(patientModel.getState());
		patient.setZipCode(patientModel.getZipCode());

		return patientDao.addPatient(patient);
	}

	@Override
	public PatientModel viewOnePatient(String patientId) {
		// TODO Auto-generated method stud
				
		Patient patient=patientDao.viewOnePatient(patientId);
		PatientModel patientModel=new PatientModel();

		patientModel.setPatientId(patient.getPatientId());
		patientModel.setFirstName(patient.getFirstName());
		patientModel.setLastName(patient.getLastName());
		patientModel.setAge(patient.getAge());
		patientModel.setDob(patient.getDob());
		patientModel.setGender(patient.getGender());
		patientModel.setEmailId(patient.getEmailId());
		patientModel.setContactNumber(patient.getContactNumber());
		patientModel.setAlternateContactNumber(patient.getAlternateContactNumber());
		patientModel.setAddressLine1(patient.getAddressLine1());
		patientModel.setAddressLine2(patient.getAddressLine2());
		patientModel.setCity(patient.getCity());
		patientModel.setState(patient.getState());
		patientModel.setZipCode(patient.getZipCode());

		return patientModel;
	}
	

	
	

}
