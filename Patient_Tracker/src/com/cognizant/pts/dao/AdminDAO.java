package com.cognizant.pts.dao;



import com.cognizant.pts.entity.Admin;

public interface AdminDAO {

	int doLogin(Admin admin);
	boolean addAdmin(Admin admin);
	
}
