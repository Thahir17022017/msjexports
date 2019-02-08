package com.msjexports.handlers;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msjexports.db.ProductManager;
import com.msjexports.email.EmailManager;

public class SendEnquiryhandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	final static Logger logger = LoggerFactory.getLogger(SendEnquiryhandler.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		String setcaptcha = null;
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			Object captchaObj = session.getAttribute("captcha");
			if(captchaObj instanceof String)
			{
				setcaptcha = (String)captchaObj;
				logger.info(" Downcasted Session captcha value : "+setcaptcha);
			}
			logger.info(" Session captcha value : "+setcaptcha);
			
			String userCaptcha = req.getParameter("captcha");
			logger.info(" User captcha value : "+userCaptcha);
			
			String enq_name = req.getParameter("name");
			logger.info(" User name value : "+enq_name);
			
			String enq_email = req.getParameter("email");
			logger.info(" User email value : "+enq_email);
			
			String enq_phone = req.getParameter("phone");
			logger.info(" User phone value : "+enq_phone);
			
			String enq_country = req.getParameter("country");
			logger.info(" User country value : "+enq_country);
			
			String enq_products = req.getParameter("products");
			logger.info(" User products value : "+enq_products);
			
			String enq_message = req.getParameter("message");
			logger.info(" User message value : "+enq_message);
			
			String path = getServletContext().getRealPath("db/data.db");
			ProductManager prodManager = new ProductManager(path);
		    List<String> prodNames = prodManager.readProductNames();
		    logger.info("Send Enquiry page handler"+prodNames);
			req.setAttribute("IndexList",prodManager.readProductNames());  
			
			
			if(userCaptcha.equals(setcaptcha))
			{
				String propPath = getServletContext().getRealPath("props/config.properties");
				EmailManager emailManager = new EmailManager(propPath);
				emailManager.sendEmail(enq_name, enq_email, enq_phone, enq_country, enq_products, enq_message);
				RequestDispatcher rd = req.getRequestDispatcher("enquiry/enquiry3.jsp");
				rd.include(req, resp);
			}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("enquiry/enquiry2.jsp");
				rd.include(req, resp);
			}
		}
		
	}
		catch(Exception e)
		{
			logger.error("Exception in SendEnquiryhandler",e);
		}
	}

}