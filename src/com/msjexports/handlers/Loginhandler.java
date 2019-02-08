package com.msjexports.handlers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.msjexports.db.ProductManager;
import com.msjexports.prop.PropertyManager;


public class Loginhandler extends HttpServlet{
	
	

	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(Loginhandler.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
        String user=null,pwd = null;
		
		logger.info("Running in LoginHandler Post method");
		
		// Create a session object if it is already not  created.
	    
		
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		
//		logger.info("Username :" +username+" Password : "+password);
		StringBuilder jsonBuff = new StringBuilder();
		String line=null;
		BufferedReader readData = req.getReader();
		while((line=readData.readLine())!=null)
		{
			jsonBuff.append(line);
		}
		
		logger.info("Request JSON string :" + jsonBuff.toString());
		JsonParser parser = new JsonParser();
		JsonElement  element = parser.parse(jsonBuff.toString());
		
		if(element.isJsonObject())
		{
			logger.info("Json object : "+element.getAsJsonObject().toString());
			JsonObject obj = element.getAsJsonObject();
			user = obj.getAsJsonPrimitive("user").getAsString();
			pwd = obj.getAsJsonPrimitive("password").getAsString();
			
			logger.info("Username : "+user+" Password : "+pwd);
		}
		
//		if(storedUser!=null)
//		{
//			
//			RequestDispatcher rd = req.getRequestDispatcher("login/login.html");
//			rd.include(req, resp);
//		}
		
		
		
		
		// Set to expire far in the past.
		resp.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");

		// Set standard HTTP/1.1 no-cache headers.
		resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		resp.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		resp.setHeader("Pragma", "no-cache");
		
		String propPath = getServletContext().getRealPath("props/config.properties");
		PropertyManager propManager = new PropertyManager();
		propManager.loadProps(propPath);
		String aUser=propManager.readSpecProp("com.msjexports.uadmin");
		logger.info(" aUser "+aUser);
		String aPwd=propManager.readSpecProp("com.msjexports.upwd");
		logger.info(" aPwd "+aPwd);
		
		if(user.equals(aUser) && pwd.equals(aPwd))
		{
			logger.info("user credentials are correct");
			HttpSession session = req.getSession();
			session.setAttribute("uname",user);
			req.setAttribute("name",user);
			String path = getServletContext().getRealPath("props/config.properties");
			String path2 = getServletContext().getRealPath("db/data.db");
			PropertyManager manager1 = new PropertyManager();
			ProductManager prodManager = new ProductManager(path2);
			manager1.loadProps(path);
			
			req.setAttribute("usercount",manager1.readUserCount());
			req.setAttribute("list",prodManager.readProductNames());
			RequestDispatcher rd = req.getRequestDispatcher("admin/admin.jsp");
			rd.include(req, resp);
		}
		else
		{
			logger.info("user credentials are not correct");
			JsonObject respErrJson = new JsonObject();
			respErrJson.addProperty("Message","credentials are incorrect");
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			out.print(respErrJson.toString());
			out.flush();
		}
		}
		catch(Exception e)
		{
			logger.error("Exception in Loginhandler",e);
		}
		
		
		
		

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
			doGet(req, resp);
		
		
		
		
		
	}
	
	

}