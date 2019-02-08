package com.msjexports.handlers;
import java.io.BufferedReader;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.msjexports.prop.PropertyManager;


public class Visitorhandler extends HttpServlet
{


	private static final long serialVersionUID = 1L;
	
	final static Logger logger = LoggerFactory.getLogger(Visitorhandler.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try 
		{
			String newUser = null;
			StringBuilder jsonBuff = new StringBuilder();
			String line=null;
			BufferedReader readData = req.getReader();
			while((line=readData.readLine())!=null)
			{
				jsonBuff.append(line);
			}
			
			logger.info("Request New User JSON string :" + jsonBuff.toString());
			
			JsonParser parser = new JsonParser();
			JsonElement  element = parser.parse(jsonBuff.toString());
			
			if(element.isJsonObject())
			{
			
				JsonObject obj = element.getAsJsonObject();
				newUser = obj.getAsJsonPrimitive("newUser").getAsString();
				if(newUser.equalsIgnoreCase("true"))
				{
					logger.info("write code for saving the count");
					logger.info("Context Path"+getServletContext().getContextPath());
					logger.info("Context Path"+getServletContext().getRealPath("props/config.properties"));
					String path = getServletContext().getRealPath("props/config.properties");
//					inputStream = getServletContext().getResourceAsStream("props/config.properties");
//					
					PropertyManager manager = new PropertyManager();
					manager.loadProps(path);
					manager.updateUserCount(path);
				}
			}
		}
		catch(Exception e)
		{
			logger.error("Exception in Visitorhandler",e);
		}
		
}
	
}