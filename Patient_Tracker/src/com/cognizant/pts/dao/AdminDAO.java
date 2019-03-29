package com.cognizant.pts.dao;



import com.cognizant.pts.entity.Admin;

public interface AdminDAO {

	boolean doLogin(Admin admin);
	boolean addAdmin(Admin admin);
	
}
