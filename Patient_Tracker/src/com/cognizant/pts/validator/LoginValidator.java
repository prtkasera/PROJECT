package com.cognizant.pts.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cognizant.pts.entity.Admin;
import com.cognizant.pts.model.AdminModel;
import com.cognizant.pts.service.AdminService;
@Component("AdminValidator")
public class LoginValidator implements Validator{

	@Autowired
	private AdminService adminService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(AdminModel.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		AdminModel adminModel=(AdminModel)arg0;
		int adminAuth=adminService.doLogin(adminModel);
		System.out.println(adminAuth);
		if(adminAuth==1)
		{
			arg1.rejectValue("adminId", "adminId.invalid");
		}
		else if(adminAuth==2)
		{
			arg1.rejectValue("adminPassword", "adminPassword.invalid");
		}
		
	}

}
