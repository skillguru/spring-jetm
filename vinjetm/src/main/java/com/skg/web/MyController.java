package com.skg.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.skg.jetm.dao.MySimpleDAO;
import com.skg.jetm.service.MyService;


public class MyController  implements Controller{
	
	@Autowired
	MyService myService;
	
	@Autowired
	MySimpleDAO mySimpleDAO;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		myService.completeQuickly();
		//mySimpleDAO.getNoRecords();
		
		myService.goInLoop(10);
		return new ModelAndView("start.jsp");
		
	}
	

}
