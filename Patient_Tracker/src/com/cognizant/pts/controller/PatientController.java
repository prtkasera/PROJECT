package com.cognizant.pts.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pts.entity.Patient;
import com.cognizant.pts.service.PatientService;



@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value="index.htm" ,method=RequestMethod.GET)
	public ModelAndView viewPatients()
	{
		ModelAndView mv=new ModelAndView();
		List<Patient> patientList=patientService.viewAllPatients();
		mv.addObject("patientList",patientList);
		mv.setViewName("viewPatients");
		return mv;
	}
	
	//@Requestmapping(value="addPatient.htm",method=RequestMethod.GET)
	
}
