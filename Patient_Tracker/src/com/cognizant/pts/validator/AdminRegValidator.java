package com.cognizant.pts.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import com.cognizant.pts.entity.Admin;
import com.cognizant.pts.model.AdminModel;
import com.cognizant.pts.service.AdminService;

@Component("AdminRegValidator")
public class AdminRegValidator implements Validator {

	@Autowired
	private AdminService adminService;

	@Override
	public boolean supports(Class<?> clazz) {
		return AdminModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AdminModel adminModel = (AdminModel) target;
		String Email_pattern = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"+ "A-Z]{2,7}$";
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		if (adminModel.getFirstName().matches("^[a-zA-Z]*$") == false)
			errors.rejectValue("firstName", "invalidFirstName.value");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		if (adminModel.getLastName().matches("^[a-zA-Z]*$") == false)
			errors.rejectValue("lastName", "invalidLastName.value");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age.required");
		if (adminModel.getAge() < 18 || adminModel.getAge() > 70)
			errors.rejectValue("age", "invalidAge.value");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required");

		if(adminModel.getDob().isEmpty()==false)
		{
		Pattern dob_pat = Pattern.compile("^([0-9]{2})-([0-9]{2})-([0-9]{4})$");
		if(dob_pat.matcher(adminModel.getDob()).matches()==false)	
		errors.rejectValue("dob", "invaliddob.value");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "contactNumber.required");
		if(adminModel.getContactNumber().isEmpty()==false)
		{
		Pattern contactNumber_pat = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		//Matcher m = contactNumber_pat.matcher(adminModel.getContactNumber());
		if(contactNumber_pat.matcher(adminModel.getContactNumber()).matches()==false)	
		errors.rejectValue("contactNumber", "invalidContactNumber.value");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "alternateContactNumber", "AlternateContactNumber.required");
		if(adminModel.getAlternateContactNumber().isEmpty()==false)
		{
			Pattern altcontactNumber_pat= Pattern.compile("(0/91)?[7-9][0-9]{9}");
			//Matcher n = altcontactNumber_pat.matcher(adminModel.getAlternateContactNumber());
			if(altcontactNumber_pat.matcher(adminModel.getAlternateContactNumber()).matches()==false)	
			errors.rejectValue("alternateContactNumber", "invalidAlternateContactNumber.value");
		}
		
		
		

		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "emailId.required");
		if(adminModel.getEmailId().isEmpty()==false)
		{
		Pattern eMailPat = Pattern.compile(Email_pattern);
		if (eMailPat.matcher(adminModel.getEmailId()).matches() == false)
			errors.rejectValue("emailId", "invalidEmail.value");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "addressLine1.required");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address_line2",
		// "address_line2.required");
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminPasswrod", "password.required");
		
	}

}
