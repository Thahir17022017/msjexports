package com.msjexports.handlers;
import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msjexports.db.BannerImageManager;
import com.msjexports.db.DescListManager;
import com.msjexports.db.DescParagraphManager;
import com.msjexports.db.GalleryImageManager;
import com.msjexports.db.UsesListManager;


public class ProductDetailViewhandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private String bannerName="";
	private String image1 = "",image2="",image3="";
	private Map<String,String> descPara;
	private Map<String,String> descList;
	private Map<String,String> usesList;
	
	final static Logger logger = LoggerFactory.getLogger(ProductDetailViewhandler.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			logger.info("Session expired when user clicked on products detail link from admin page");
			RequestDispatcher rd = req.getRequestDispatcher("adminlogout/sessionexp_logout.jsp");
			rd.include(req, resp);
		}
		else
		{
			resp.setHeader("resultfor", "configureDetail");
			logger.info("Detail page loading for "+req.getHeader("detailType"));
			String path = getServletContext().getRealPath("db/data.db");
		    BannerImageManager bannerManager = new BannerImageManager(path);
		    String prodId = bannerManager.getProductId(req.getHeader("detailType"));  
		    bannerName = bannerManager.checkExistingBannerImage(prodId);
		    req.setAttribute("bannerName",bannerName);
		    GalleryImageManager galleryManager = new GalleryImageManager(path);
//		    String prodId2 = galleryManager.getProductId(req.getHeader("detailType"));
		    image1 = galleryManager.checkExistingGalleryImage(prodId, "Image 1");
		    image2 = galleryManager.checkExistingGalleryImage(prodId, "Image 2");
		    image3 = galleryManager.checkExistingGalleryImage(prodId, "Image 3");
		    
		    DescParagraphManager descParaManager = new DescParagraphManager(path);
		    descPara = descParaManager.getParagraphs(prodId);
		    req.setAttribute("descPara",descPara);
		    
		    DescListManager descListManager = new DescListManager(path);
		    descList = descListManager.getListItems(prodId);
		    req.setAttribute("descList",descList);
		    
		    UsesListManager usesListManager = new UsesListManager(path);
		    usesList = usesListManager.getUsesListItems(prodId);
		    req.setAttribute("usesList",usesList);
		    
		    req.setAttribute("Image1", image1);
		    req.setAttribute("Image2", image2);
		    req.setAttribute("Image3", image3);
		    
		    req.setAttribute("detailType", req.getHeader("detailType"));
			RequestDispatcher rd = req.getRequestDispatcher("jsps/productdetail.jsp");
			rd.include(req, resp);
		}
		
	}
		catch(Exception e)
		{
			logger.error("Exception in ProductDetailViewhandler",e);
		}
	}

}