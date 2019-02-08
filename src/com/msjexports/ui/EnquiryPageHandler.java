package com.msjexports.ui;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msjexports.db.ProductManager;


public class EnquiryPageHandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(EnquiryPageHandler.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			logger.info("Running in EnquiryPageHandler");
			
			String path = getServletContext().getRealPath("db/data.db");
			ProductManager prodManager = new ProductManager(path);
		    List<String> prodNames = prodManager.readProductNames();
		    logger.info("Enquiry page product names "+prodNames);
			req.setAttribute("IndexList",prodManager.readProductNames());
			RequestDispatcher rd = req.getRequestDispatcher("enquiry/enquiry.jsp");
			rd.forward(req, resp);
		}
		catch(Exception e)
		{
			logger.error("Exception in Enquiry Page",e);
		}
	}

}