package com.cognizant.pts.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class AdminIdGenerator extends SequenceStyleGenerator {
	public Serializable generate(SessionImplementor arg0,Object arg1)
		throws HibernateException{
			return "ADMIN"+StoreAdminId.getAdminId();
		}
	}

