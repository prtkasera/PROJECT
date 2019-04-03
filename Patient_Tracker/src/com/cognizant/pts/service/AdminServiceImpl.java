package com.cognizant.pts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pts.dao.AdminDAO;
import com.cognizant.pts.entity.Admin;
import com.cognizant.pts.model.AdminModel;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDAO adminDao;
	
	
	@Override
	public int doLogin(AdminModel adminModel) {
		// TODO Auto-generated method stub
		
		Admin admin=new Admin();
		
		admin.setAdminId(adminModel.getAdminId());
		admin.setFirstName(adminModel.getFirstName());
		admin.setLastName(adminModel.getLastName());
		admin.setAge(adminModel.getAge());
		admin.setGender(adminModel.getGender());
		admin.setDob(adminModel.getDob());
		admin.setContactNumber(adminModel.getContactNumber());
		admin.setAlternateContactNumber(adminModel.getAlternateContactNumber());
		admin.setEmailId(adminModel.getEmailId());
		admin.setAdminPassword(adminModel.getAdminPassword());
		
		return adminDao.doLogin(admin);
	}

	@Override
	public boolean addAdmin(AdminModel adminModel) {
		// TODO Auto-generated method stub
		Admin admin=new Admin();
		
	//	admin.setAdminId(adminModel.getAdminId());
		admin.setFirstName(adminModel.getFirstName());
		admin.setLastName(adminModel.getLastName());
		admin.setAge(adminModel.getAge());
		admin.setGender(adminModel.getGender());
		admin.setDob(adminModel.getDob());
		admin.setContactNumber(adminModel.getContactNumber());
		admin.setAlternateContactNumber(adminModel.getAlternateContactNumber());
		admin.setEmailId(adminModel.getEmailId());
		admin.setAdminPassword(adminModel.getAdminPassword());

		return adminDao.addAdmin(admin);
	}

}
