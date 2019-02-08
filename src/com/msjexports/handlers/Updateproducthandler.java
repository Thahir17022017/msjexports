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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.msjexports.db.ProductManager;


public class Updateproducthandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	final static Logger logger = LoggerFactory.getLogger(Updateproducthandler.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {	
		logger.info("Running in Updateproducthandler Post method");
		
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			logger.info("Session expired when user clicked on update products button from admin page");
			RequestDispatcher rd = req.getRequestDispatcher("adminlogout/sessionexp_logout.jsp");
			rd.include(req, resp);
		}
		else
		{
			StringBuilder jsonBuff = new StringBuilder();
			String line=null;
			BufferedReader readData = req.getReader();
			while((line=readData.readLine())!=null)
			{
				jsonBuff.append(line);
			}
			JsonParser parser = new JsonParser();
			JsonElement  element = parser.parse(jsonBuff.toString());
			
			if(element.isJsonObject())
			{
				JsonObject obj = element.getAsJsonObject();
				String fromProduct = obj.getAsJsonPrimitive("fromProduct").getAsString();
				String toProduct = obj.getAsJsonPrimitive("toProduct").getAsString();
				logger.info("fromProduct name :"+fromProduct);
				logger.info("toProduct name :"+toProduct);
				String path = getServletContext().getRealPath("db/data.db");
				ProductManager prodManager = new ProductManager(path);
				
				JsonObject resObj = new JsonObject();
				JsonArray resJson = prodManager.updateProduct(fromProduct, toProduct);
				resObj.add("UpdateProductName",resJson);
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				out.print(resObj.toString());
				out.flush();
			}
			
		}
	}
		catch(Exception e)
		{
			logger.error("Exception in Updateproducthandler",e);
		}
	}
}