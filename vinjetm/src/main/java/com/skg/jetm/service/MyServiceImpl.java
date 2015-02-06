package com.skg.jetm.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skg.jetm.dao.MySimpleDAO;

@Service("myService")
public class MyServiceImpl implements MyService {
	
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	MySimpleDAO mysimpelDAO;
	
	public void completeQuickly(){
		System.out.println("Completing quickly in My Service Impl");
		mysimpelDAO.getNoRecords();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void completeSlowly(){
		try {
			mysimpelDAO.getNoRecords();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void goInLoop(int loopCount){
		
		for(int i = 0; i < loopCount; i++){
			mysimpelDAO.updateNothing();
		}
	}
}
