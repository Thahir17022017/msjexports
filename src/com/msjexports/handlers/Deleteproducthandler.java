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
import com.msjexports.db.BannerImageManager;
import com.msjexports.db.DescListManager;
import com.msjexports.db.DescParagraphManager;
import com.msjexports.db.GalleryImageManager;
import com.msjexports.db.ProductManager;
import com.msjexports.db.UsesListManager;

import com.msjexports.util.UtilityManager;

public class Deleteproducthandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	private static final String UPLOAD_DIR = "uploads";
	
	final static Logger logger = LoggerFactory.getLogger(Deleteproducthandler.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {	
		logger.info("Running in Deleteproducthandler Post method");
		String deletedProdName="";
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			logger.info("Session expired when user clicked on delete products button from admin page");
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
				String delProdName = obj.getAsJsonPrimitive("delProduct").getAsString();
				logger.info("del product name :"+delProdName);
				
				String path = getServletContext().getRealPath("db/data.db");
				
				UsesListManager usesListManager = new UsesListManager(path);
				String prodId = usesListManager.getProductId(delProdName);
				usesListManager.deleteUsesListProduct(prodId);
				
				DescListManager descListManager = new DescListManager(path);
				descListManager.deleteDescListProduct(prodId);
				
				DescParagraphManager paraManager = new DescParagraphManager(path);
				paraManager.deleteDescParaProduct(prodId);
				
				AliasManager manager = new AliasManager(path);
				manager.deleteAlias(prodId);
				
				UtilityManager utilManager = new UtilityManager();
				String imageFolderPath = getServletContext().getRealPath(UPLOAD_DIR);
				
				GalleryImageManager galleryManager = new GalleryImageManager(path);
				String image1 = galleryManager.checkExistingGalleryImage(prodId, "Image 1");
			    String image2 = galleryManager.checkExistingGalleryImage(prodId, "Image 2");
			    String image3 = galleryManager.checkExistingGalleryImage(prodId, "Image 3");
			    galleryManager.deleteGallery(prodId);
			    
			    if(image1 != "")
			    {
			    	utilManager.deleteOldImageFile(imageFolderPath, image1);
			    }
			    if(image2 != "")
			    {
			    	utilManager.deleteOldImageFile(imageFolderPath, image2);
			    }
			    if(image3 != "")
			    {
			    	utilManager.deleteOldImageFile(imageFolderPath, image3);
			    }
				
				BannerImageManager bannerManager = new BannerImageManager(path);
				String bannerName = bannerManager.checkExistingBannerImage(prodId);
				
				
				
            	utilManager.deleteOldImageFile(imageFolderPath, bannerName);
            	bannerManager.deleteBanner(prodId);
				
				ProductManager prodManager = new ProductManager(path);
				JsonObject resObj = new JsonObject();
				deletedProdName = prodManager.delProduct(delProdName);
				resObj.addProperty("DelProductName",deletedProdName);
				
				
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				out.print(resObj.toString());
				out.flush();
			}
			if(element.isJsonArray())
			{
				String path = getServletContext().getRealPath("db/data.db");
				JsonArray recvNames = element.getAsJsonArray();
				Iterator<JsonElement> itr = recvNames.iterator();
				while(itr.hasNext())
				{
					String prodName = itr.next().getAsString();
					UsesListManager usesListManager = new UsesListManager(path);
					String prodId = usesListManager.getProductId(prodName);
					usesListManager.deleteUsesListProduct(prodId);
					
					DescListManager descListManager = new DescListManager(path);
					descListManager.deleteDescListProduct(prodId);
					
					DescParagraphManager paraManager = new DescParagraphManager(path);
					paraManager.deleteDescParaProduct(prodId);
					
					AliasManager manager = new AliasManager(path);
					manager.deleteAlias(prodId);
					
					UtilityManager utilManager = new UtilityManager();
					String imageFolderPath = getServletContext().getRealPath(UPLOAD_DIR);
					
					GalleryImageManager galleryManager = new GalleryImageManager(path);
					String image1 = galleryManager.checkExistingGalleryImage(prodId, "Image 1");
				    String image2 = galleryManager.checkExistingGalleryImage(prodId, "Image 2");
				    String image3 = galleryManager.checkExistingGalleryImage(prodId, "Image 3");
				    galleryManager.deleteGallery(prodId);
				    if(image1 != "")
				    {
				    	utilManager.deleteOldImageFile(imageFolderPath, image1);
				    }
				    if(image2 != "")
				    {
				    	utilManager.deleteOldImageFile(imageFolderPath, image2);
				    }
				    if(image3 != "")
				    {
				    	utilManager.deleteOldImageFile(imageFolderPath, image3);
				    }
				    
				    BannerImageManager bannerManager = new BannerImageManager(path);
					String bannerName = bannerManager.checkExistingBannerImage(prodId);
					
					utilManager.deleteOldImageFile(imageFolderPath, bannerName);
					bannerManager.deleteBanner(prodId);
	            	
					
				}
				
				
				
				ProductManager prodManager = new ProductManager(path);
				JsonArray addedProdNames = prodManager.delProducts(recvNames);
				JsonObject resObj = new JsonObject();
				resObj.add("DelProductNames",addedProdNames);
				logger.info(" Before sending result json obj "+resObj.toString());
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				out.print(resObj.toString());
				out.flush();
			}
		}
	}
		catch(Exception e) {
			logger.error("Exception in Deleteproducthandler",e);
		}
}
}