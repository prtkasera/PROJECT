package com.cognizant.pts.service;

import com.cognizant.pts.entity.Admin;

public interface AdminService {

	boolean doLogin(Admin admin);
	boolean addAdmin(Admin admin);
	
}
