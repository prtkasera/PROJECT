	package com.cognizant.pts.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.cognizant.pts.entity.Patient;
import com.cognizant.pts.model.PatientModel;
import com.cognizant.pts.service.PatientService;


@SessionAttributes({"patientList","gender","onePatient"})

@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value="afterlogin.htm",method=RequestMethod.POST)
	public String detailsFormPage()
	{
		return "afterlogin";
	}
	
	
	@RequestMapping(value="updatepatient.htm",method=RequestMethod.POST)
	public ModelAndView updatePatient(@ModelAttribute("onePatient")PatientModel patientModel)
	{
		ModelAndView mv=new ModelAndView();
		
		//mv.setViewName("viewpatients");
		
		boolean productPersist=patientService.updatePatient(patientModel);
		if(productPersist)
		{
			List<Patient> patientList=patientService.viewAllPatients();
			mv.addObject("patientList",patientList);
			mv.addObject("status1","Patient Successfully Updated");
			
			mv.setViewName("viewpatients");
		}
		else
		{
			
			mv.addObject("status","Patient Not Updated");
			
			mv.setViewName("viewonepatient");
		}
		return mv;
		
	}

	@RequestMapping(value="viewonepatient.htm" ,method=RequestMethod.GET)
	public ModelAndView viewOnePatients(ModelMap map,@RequestParam("patientId")String patientId)
	{
		ModelAndView mv=new ModelAndView();
		List<String> genderList=new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Trans Gender");
		mv.addObject("gender", genderList);
		PatientModel patientModel=patientService.viewOnePatient(patientId);
	
		map.addAttribute("onePatient",patientModel);

		mv.setViewName("viewonepatient");
		return mv;
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
	public ModelAndView persistPatient(@ModelAttribute("patientModel")PatientModel patientModel)
	{
		ModelAndView mv=new ModelAndView();
		
		boolean productPersist=patientService.persistPatient(patientModel);
		if(productPersist)
		{
			
			mv.addObject("status","Patient Successfully Registered");
			
			mv.setViewName("addpatient");
		}
		else
		{
			
			mv.addObject("status","Patient Not Registered");
			
			mv.setViewName("addpatient");
		}
		return mv;
		
	}
	
	
	@ModelAttribute("patientModel")
	public PatientModel createPatientObject(){
		PatientModel patientModel=new PatientModel();
		return patientModel;
}
}
