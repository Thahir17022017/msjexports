package com.msjexports.handlers;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Logouthandler extends HttpServlet{
	
	

	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(Logouthandler.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			doGet(req, resp);
			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
       
		try {
		logger.info("Running in LogoutHandler Get method");
		// Set to expire far in the past.
		resp.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");

		// Set standard HTTP/1.1 no-cache headers.
		resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		resp.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		resp.setHeader("Pragma", "no-cache");
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		RequestDispatcher rd = req.getRequestDispatcher("adminlogout/admin_logout.jsp");
		rd.include(req, resp);
			
		
		
		
		
		

		
	}
		catch(Exception e)
		{
			logger.error("Exception in Logouthandler",e);
		}
	}

	
}