package com.msjexports.ui;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msjexports.db.ProductManager;


public class IndexPageHandler extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	final static Logger logger = LoggerFactory.getLogger(IndexPageHandler.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setLocale(Locale.US);
		logger.info("Running in Index Servlet");
		String path = getServletContext().getRealPath("db/data.db");
		ProductManager prodManager = new ProductManager(path);
		List<String> prodNames = prodManager.readProductNames();
		logger.info("Read Index Product names are ",prodNames);
		req.setAttribute("IndexList",prodNames);
		RequestDispatcher rd = req.getRequestDispatcher("index/index.jsp");
		rd.forward(req, resp);
		}
		catch(Exception e)
		{
			logger.error("Exception in Index Page",e);
		}
		
	}
	
	
}