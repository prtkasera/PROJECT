package com.cognizant.pts.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.pts.entity.Admin;
@Repository("AdminDAOImpl")
public class AdminDAOImpl implements AdminDAO{
@Autowired
private SessionFactory sessionFactory;
	@Override
	public boolean doLogin(Admin admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Admin o where o.adminId=:adminId and adminPassword=:adminPassword");
		query.setParameter("adminId", admin.getAdminId());
		query.setParameter("adminPassword",admin.getAdminPassword());
		List<Admin> adminLoginList=query.list();
		if(adminLoginList.isEmpty())
		{
			return false;
	    }
		else
		{
			return true;
		}
	}
		

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.persist(admin);
		transaction.commit();
		session.close();
		return true;
	}

}
