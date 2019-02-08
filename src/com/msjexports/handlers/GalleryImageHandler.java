package com.msjexports.handlers;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import com.msjexports.db.GalleryImageManager;
import com.msjexports.util.UtilityManager;


@MultipartConfig(fileSizeThreshold=1024*1024*10,maxFileSize=1024*1024*50,maxRequestSize=1024*1024*100)
public class GalleryImageHandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	

    private static final String UPLOAD_DIR = "uploads";

	private String fileName = "";

	private String prodId = "";

	private String galleryName = "";

	private GalleryImageManager galleryManager;

	final static Logger logger = LoggerFactory.getLogger(GalleryImageHandler.class);
    
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	try {
    	HttpSession session = request.getSession(false);
		if(session == null)
		{
			logger.info("Session expired when user clicked on upload gallery image button from admin page");
			RequestDispatcher rd = request.getRequestDispatcher("adminlogout/sessionexp_logout.jsp");
			rd.include(request, response);
		}
		else
		{
    	try {
    	// gets absolute path of the web application
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        logger.info("Gallery Upload File Directory="+fileSaveDir.getAbsolutePath());
        
       
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            logger.info("imagePos : "+request.getHeader("imagePos"));
	        logger.info("Product Type : "+request.getHeader("productType"));
	        String path = getServletContext().getRealPath("db/data.db");
	        galleryManager = new GalleryImageManager(path);
	        prodId = galleryManager.getProductId(request.getHeader("productType"));
	        logger.info("Prod id for the given prod name"+prodId);
	        galleryName = galleryManager.checkExistingGalleryImage(prodId,request.getHeader("imagePos"));
	        
	        logger.info("Gallery name"+galleryName +" Gallery Ref "+request.getHeader("imagePos"));
            part.write(uploadFilePath + File.separator + fileName);
            if(galleryName != "") 
            {
            	galleryManager.deleteOldGallery(request.getHeader("imagePos"),galleryName,prodId);
            	UtilityManager utilManager = new UtilityManager();
            	String imageFolderPath = getServletContext().getRealPath(UPLOAD_DIR);
            	utilManager.deleteOldImageFile(imageFolderPath, galleryName);
            	
            }
            galleryManager.insertNewGallery(request.getHeader("imagePos"),fileName, prodId);
        }
 
	        request.setAttribute("message", fileName + " File uploaded successfully!");
	       	JsonObject jsonImgResp= new JsonObject();
        	jsonImgResp.addProperty("fileName", fileName);
        	jsonImgResp.addProperty("ImagePosition",request.getHeader("imagePos"));
        	PrintWriter out = response.getWriter();
        	response.setContentType("application/json");
        	response.setCharacterEncoding("UTF-8");
			out.print(jsonImgResp.toString());
			out.flush();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		JsonObject jsonImgResp= new JsonObject();
    		jsonImgResp.addProperty("fileName", fileName);
        	jsonImgResp.addProperty("ImagePosition",request.getHeader("imagePos"));
        	PrintWriter out = response.getWriter();
        	response.setContentType("application/json");
        	response.setCharacterEncoding("UTF-8");
			out.print(jsonImgResp.toString());
			out.flush();
    	}
		}
    	}
    	catch(Exception e)
    	{
    		logger.error("Exception in GalleryImageHandler",e);
    	}
        
    }
 

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        logger.info("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }

}