package com.msjexports.handlers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

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
import com.msjexports.db.AliasManager;
import com.msjexports.db.ProductManager;


public class Addproducthandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	final static Logger logger = LoggerFactory.getLogger(Addproducthandler.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {	
		logger.info("Running in Addproducthandler Post method");
		boolean flag=false;
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			logger.info("Session expired when user clicked on add products button from admin page");
			RequestDispatcher rd = req.getRequestDispatcher("adminlogout/sessionexp_logout.jsp");
			rd.include(req, resp);
		}
		else
		{
			StringBuilder jsonBuff = new StringBuilder();
			String line=null;
			String addedProdName="";
			BufferedReader readData = req.getReader();
			while((line=readData.readLine())!=null)
			{
				jsonBuff.append(line);
			}
			JsonParser parser = new JsonParser();
			JsonElement  element = parser.parse(jsonBuff.toString());
			
			if(element.isJsonObject())
			{
				String path = getServletContext().getRealPath("db/data.db");
				JsonObject obj = element.getAsJsonObject();
				String addProdName = obj.getAsJsonPrimitive("addProduct").getAsString();
				logger.info("Single product name :"+addProdName);
				if(addProdName.contains(":"))
				{
					String[] addNameswithAlias = addProdName.split(":");
					ProductManager prdManager = new ProductManager(path);
					addedProdName = prdManager.addProduct(addNameswithAlias[0]);
					AliasManager aliasManager = new AliasManager(path);
					String prodId = aliasManager.getProductId(addNameswithAlias[0]);
					aliasManager.addAlias(addNameswithAlias[1], prodId);
				}
				else
				{
					ProductManager prdManager = new ProductManager(path);
					addedProdName = prdManager.addProduct(addProdName);
				}
						
				
				JsonObject resObj = new JsonObject();
				resObj.addProperty("ProductName",addedProdName);
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				out.print(resObj.toString());
				out.flush();
			}
			if(element.isJsonArray())
			{
				JsonArray recvNames = element.getAsJsonArray();
				
				JsonObject resObj = new JsonObject();
				JsonArray newNames = new JsonArray();
				
				String path = getServletContext().getRealPath("db/data.db");
				Iterator<JsonElement> itr = recvNames.iterator();
				while(itr.hasNext())
				{
					String prodName = itr.next().getAsString();
					logger.info("Prod Name in multiple products"+prodName);
					if(prodName.contains(":"))
					{
						flag=true;
						String[] addNameswithAlias = prodName.split(":");
						ProductManager prdManager = new ProductManager(path);
						addedProdName = prdManager.addProduct(addNameswithAlias[0]);
						AliasManager aliasManager = new AliasManager(path);
						String prodId = aliasManager.getProductId(addNameswithAlias[0]);
						aliasManager.addAlias(addNameswithAlias[1], prodId);
						newNames.add(addNameswithAlias[0]);
												
					}
					else
					{
						ProductManager prdManager = new ProductManager(path);
						addedProdName = prdManager.addProduct(prodName);
						
					}
				}
				if(flag==true)
				{
					resObj.add("ProductNames",newNames);
				}
				else
				{
					resObj.add("ProductNames",recvNames);
				}
				
				
				logger.info(" Before sending result json obj "+resObj.toString());
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
			logger.error("Exception in Addproducthandler",e);
		}
	}

}