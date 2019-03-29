package com.cognizant.pts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pts.entity.Admin;
import com.cognizant.pts.service.AdminService;
import com.cognizant.pts.validation.AdminValidator;

@Controller
public class AdminController {

	@Autowired
	private AdminValidator adminValidator;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="index.htm",method=RequestMethod.GET)
	public String loadLoginForm()
	{
		return "home";
	}
	
	@RequestMapping(value="logout.htm",method=RequestMethod.POST)
	public String loadHomePage()
	{
		return "home";
	}

	@RequestMapping(value="doLogin.htm",method=RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("admin")Admin admin,Errors error)
	{
		ModelAndView mv=new ModelAndView();
		ValidationUtils.invokeValidator(adminValidator, admin, error);
		if(error.hasErrors())
		{
			mv.setViewName("home");
		}
		else{
		boolean checkAdminLogin=adminService.doLogin(admin);
		if(checkAdminLogin)
		{	
			mv.addObject("status","login Successful");
			mv.setViewName("afterlogin");
		}
		else
		{
			mv.addObject("status","login Denied");
			mv.setViewName("home");
		}
		}
		return mv;
	}
	
	@ModelAttribute("admin")
	public Admin creatAdminObject()
	{
		Admin admin=new Admin();
		return admin;
	}
	
	@RequestMapping(value="adminregistration.htm",method=RequestMethod.POST)
	public String loadAdminRegistrationForm()
	{
		List<String> genderList=new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Trans Gender");
		return "addadmin";
	}
	
	
	
	@RequestMapping(value="addadmin.htm",method=RequestMethod.POST)
	public ModelAndView persistAdmin(@ModelAttribute("adminreg")Admin adminreg)
	{
		
		ModelAndView mv=new ModelAndView();
		
		boolean adminPersist=adminService.addAdmin(adminreg);
		if(adminPersist)
		{
			mv.setViewName("home");
		}
		else
		{
			mv.addObject("status","Registration Failed");
			mv.setViewName("addadmin");
		}
		return mv;
	}
	
}
