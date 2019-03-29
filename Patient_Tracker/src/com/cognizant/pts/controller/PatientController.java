package com.cognizant.pts.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.cognizant.pts.entity.Patient;
import com.cognizant.pts.service.PatientService;


@SessionAttributes({"patientList","gender"})

@Controller
public class PatientController {

	
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value="afterlogin.htm",method=RequestMethod.POST)
	public String detailsFormPage()
	{
		return "afterlogin";
	}
	
	@RequestMapping(value="patient.htm" ,method=RequestMethod.POST)
	public ModelAndView viewPatients()
	{
		ModelAndView mv=new ModelAndView();
		List<Patient> patientList=patientService.viewAllPatients();
		mv.addObject("patientList",patientList);
		mv.setViewName("viewpatients");
		return mv;
	}
	
	@RequestMapping(value="addpatientform.htm",method=RequestMethod.POST)
	public ModelAndView loadAddPatientForm()
	{
		ModelAndView mv=new ModelAndView();
		List<String> genderList=new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Trans Gender");
		mv.addObject("gender", genderList);
		mv.setViewName("addpatient");
		return mv;
	}

	
	@RequestMapping(value="addpatient.htm",method=RequestMethod.POST)
	public ModelAndView persistPatient(@ModelAttribute("patient")Patient patient)
	{
		ModelAndView mv=new ModelAndView();
		
		boolean productPersist=patientService.addPatient(patient);
		if(productPersist)
		{
			
			mv.addObject("status","Product Successfully Registered");
			
			mv.setViewName("addpatient");
		}
		else
		{
			
			mv.addObject("status","Product Not Registered");
			
			mv.setViewName("addpatient");
		}
		return mv;
		
	}
	
	@ModelAttribute("patient")
	public Patient createPatientObject(){
		Patient patient=new Patient();
		return patient;
}
}
