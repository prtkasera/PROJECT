package com.cognizant.pts.service;

import com.cognizant.pts.entity.Admin;
import com.cognizant.pts.model.AdminModel;

public interface AdminService {

	int doLogin(AdminModel adminModel);
	boolean addAdmin(AdminModel adminModel);
	
}
