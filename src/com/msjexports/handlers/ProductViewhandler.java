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



public class ProductViewhandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	final static Logger logger = LoggerFactory.getLogger(ProductViewhandler.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			logger.info("Session expired when user clicked on products link from admin page");
			RequestDispatcher rd = req.getRequestDispatcher("adminlogout/sessionexp_logout.jsp");
			rd.include(req, resp);
		}
		else
		{
			resp.setHeader("resultfor", "configure");
			RequestDispatcher rd = req.getRequestDispatcher("jsps/products.jsp");
			rd.include(req, resp);
		}
		
	}
		catch(Exception e)
		{
			logger.error("Exception in ProductViewhandler",e);
		}
	}

}