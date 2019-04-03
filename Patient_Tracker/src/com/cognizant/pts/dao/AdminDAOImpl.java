package com.cognizant.pts.dao;

import java.math.BigDecimal;
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
	public int doLogin(Admin admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Admin o where o.adminId=:adminId");
		query.setString("adminId", admin.getAdminId());
		Query query1=session.createQuery("from Admin o where adminPassword=:adminPassword");
		query1.setString("adminPassword", admin.getAdminPassword());
		
		List<Admin> adminIdList=query.list();
		List<Admin> adminPasswordList=query1.list();
		if(adminIdList.isEmpty())
		{
			return 1;
	    }
		else if(adminPasswordList.isEmpty())
		{
			return 2;
		}
		else 
		{
			return 3;
		}
	}
		

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		generateAdminId();
		Transaction transaction=session.beginTransaction();
		session.persist(admin);
		transaction.commit();
		session.close();
		return true;
	}
	public void generateAdminId()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createSQLQuery("select ADMINSEQ.nextval from DUAL");
		Long key=((BigDecimal) query.uniqueResult()).longValue();
		StoreAdminId.addAdminId(key.intValue());
		}

}
