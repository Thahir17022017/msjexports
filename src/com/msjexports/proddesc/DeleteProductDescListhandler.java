package com.msjexports.proddesc;
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
import com.msjexports.db.DescListManager;



public class DeleteProductDescListhandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private String deleteListValue="";
	private String deleteListId = "";
	
	final static Logger logger = LoggerFactory.getLogger(DeleteProductDescListhandler.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			logger.info("Running in DeleteProductDescListhandler Post method");
			HttpSession session = req.getSession(false);
			if(session == null)
			{
				logger.info("Session expired when user clicked on delete list prod desc button from admin page");
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
				
				logger.info("Request JSON string :" + jsonBuff.toString());
				JsonParser parser = new JsonParser();
				JsonElement  element = parser.parse(jsonBuff.toString());
				if(element.isJsonObject())
				{
					logger.info("Json object : "+element.getAsJsonObject().toString());
					JsonObject obj = element.getAsJsonObject();
					
					deleteListValue = obj.getAsJsonPrimitive("deleteListValue").getAsString();
					deleteListId  = obj.getAsJsonPrimitive("deleteListId").getAsString();
					logger.info("Received delete list "+deleteListId);
					
				}
				String path = getServletContext().getRealPath("db/data.db");
				DescListManager paraManager = new DescListManager(path);
				
				int cnt = paraManager.deleteDescList(deleteListId);
				logger.info("Delete Para count value "+cnt);
				JsonObject jsonResp= new JsonObject();
				if(cnt==1)
				{
					
					jsonResp.addProperty("deleteListId", deleteListId);
					jsonResp.addProperty("deleteListValue", deleteListValue);
		        	
				}
				
	        	PrintWriter out = resp.getWriter();
	        	resp.setContentType("application/json");
	        	resp.setCharacterEncoding("UTF-8");
				out.print(jsonResp.toString());
				out.flush();
			}
		}
		catch(Exception e)
		{
			logger.error("Exception in delete product description list handler",e);
		}
	}

}