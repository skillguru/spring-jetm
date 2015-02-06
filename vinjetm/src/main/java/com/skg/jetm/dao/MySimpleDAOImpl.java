package com.skg.jetm.dao;

import org.springframework.stereotype.Repository;

@Repository("mySimpleDAO")
public class MySimpleDAOImpl implements MySimpleDAO{

	public void getNoRecords() {
		
		System.out.println(" Inside DAO method");
		
	}

	public void updateNothing(){
		System.out.println(" And updating nothing ......");
	}
}
