package com.cognizant.pts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pts.dao.AdminDAO;
import com.cognizant.pts.entity.Admin;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDAO adminDao;
	
	
	@Override
	public boolean doLogin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.doLogin(admin);
	}

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.addAdmin(admin);
	}

}
