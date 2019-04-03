package com.cognizant.pts.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import com.cognizant.pts.entity.Patient;
import com.cognizant.pts.model.PatientModel;
import com.cognizant.pts.service.PatientService;
//import com.cognizant.pts.service.PatientServiceImpl;

@Component("PatientValidator")
public class PatientValidator implements Validator {

	@Autowired
	private PatientService patientService;

	@Override
	public boolean supports(Class<?> clazz) {
		return PatientModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PatientModel patientModel = (PatientModel) target;
		String Email_pattern = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"+ "A-Z]{2,7}$";
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		if (patientModel.getFirstName().matches("^[a-zA-Z]*$") == false)
			errors.rejectValue("firstName", "invalidFirstName.value");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		if (patientModel.getLastName().matches("^[a-zA-Z]*$") == false)
			errors.rejectValue("lastName", "invalidLastName.value");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age.required");
		if (patientModel.getAge() < 18 || patientModel.getAge() > 70)
			errors.rejectValue("age", "invalidAge.value");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required");

		if(patientModel.getDob().isEmpty()==false)
		{
		Pattern dob_pat = Pattern.compile("^([0-9]{2})-([0-9]{2})-([0-9]{4})$");
		if(dob_pat.matcher(patientModel.getDob()).matches()==false)	
		errors.rejectValue("dob", "invaliddob.value");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "contactNumber.required");
		if(patientModel.getContactNumber().isEmpty()==false)
		{
		Pattern contactNumber_pat = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		//Matcher m = contactNumber_pat.matcher(patientModel.getContactNumber());
		if(contactNumber_pat.matcher(patientModel.getContactNumber()).matches()==false)	
		errors.rejectValue("contactNumber", "invalidContactNumber.value");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "alternateContactNumber", "AlternateContactNumber.required");
		if(patientModel.getAlternateContactNumber().isEmpty()==false)
		{
			Pattern altcontactNumber_pat= Pattern.compile("(0/91)?[7-9][0-9]{9}");
			//Matcher n = altcontactNumber_pat.matcher(patientModel.getAlternateContactNumber());
			if(altcontactNumber_pat.matcher(patientModel.getAlternateContactNumber()).matches()==false)	
			errors.rejectValue("alternateContactNumber", "invalidAlternateContactNumber.value");
		}
		
		
		

		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "emailId.required");
		if(patientModel.getEmailId().isEmpty()==false)
		{
		Pattern eMailPat = Pattern.compile(Email_pattern);
		if (eMailPat.matcher(patientModel.getEmailId()).matches() == false)
			errors.rejectValue("emailId", "invalidEmail.value");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "addressLine1.required");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address_line2",
		// "address_line2.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "city.required");
		if (patientModel.getCity().matches("^[a-zA-Z]*$") == false)
			errors.rejectValue("city", "invalidCity.value");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "state.required");
		if (patientModel.getState().matches("^[a-zA-Z]*$") == false)
			errors.rejectValue("state", "invalidState.value");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "zipCode.required");
		if (patientModel.getZipCode() < 100000 || patientModel.getZipCode() > 999999)
			errors.rejectValue("zipCode", "invalidZip.value");

		

	}

}
