package com.msjexports.handlers;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class AdminHandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	final static Logger logger = LoggerFactory.getLogger(AdminHandler.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
		logger.info("Running in get method");
//		resp.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
//		resp.addHeader("Cache-Control", "post-check=0, pre-check=0");
//		resp.setHeader("Pragma","no-cache"); 
//		resp.setDateHeader ("Expires", 0); 
		RequestDispatcher rd = req.getRequestDispatcher("adminlogin/admin_login.html");
		rd.include(req, resp);
		}
		catch(Exception e)
		{
			logger.error("Exception in AdminHandler",e);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}