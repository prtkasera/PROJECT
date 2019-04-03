package com.cognizant.pts.dao;

import java.util.ArrayList;
import java.util.List;

public class StorePatientId {

	static List<Integer> idList=new ArrayList<Integer>();
	public static void addPatientId(int id){
		idList.add(0,id);
	}
	public static int getPatientId(){
		return idList.get(0);
	}
}
