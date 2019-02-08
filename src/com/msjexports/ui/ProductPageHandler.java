package com.msjexports.ui;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msjexports.db.AliasManager;
import com.msjexports.db.BannerImageManager;
import com.msjexports.db.DescListManager;
import com.msjexports.db.DescParagraphManager;
import com.msjexports.db.GalleryImageManager;
import com.msjexports.db.ProductManager;
import com.msjexports.db.UsesListManager;


public class ProductPageHandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(ProductPageHandler.class);
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		
		logger.info(" I'm Running in Get Method of ProductUIhandler");
		logger.info("The requested products "+req.getParameter("value"));
		String prodName = req.getParameter("value");
		logger.info(" Length of the product "+prodName.length());
		if(prodName.equalsIgnoreCase("Nutmeg "))
		{
			prodName = prodName+"& Mace";
		}
		
		String path = getServletContext().getRealPath("db/data.db");
		
		//read data for alias from table
		AliasManager aliasManager = new AliasManager(path);
		String prodId = aliasManager.getProductId(prodName);
		String aliasName = aliasManager.getAlias(prodId);
		logger.info("The product id for the product name : "+prodName+" prodId : "+prodId+" aliasName : "+aliasName);
		logger.info("Alias"+aliasName);
		req.setAttribute("Alias",aliasName);
		
		BannerImageManager bannerManager = new BannerImageManager(path);
		String bannerImage = bannerManager.readBannerImage(prodId);
		req.setAttribute("bannerImage",bannerImage);
		
		
		GalleryImageManager galleryManager = new GalleryImageManager(path);
		String galleryImage1 = galleryManager.readGalleryImages(prodId,"Image 1");
		String galleryImage2 = galleryManager.readGalleryImages(prodId,"Image 2");
		String galleryImage3 = galleryManager.readGalleryImages(prodId,"Image 3");
		logger.info("selected gallery image1 "+galleryImage1);
		logger.info("selected gallery image2 "+galleryImage2);
		logger.info("selected gallery image3 "+galleryImage3);
		
		req.setAttribute("galleryImage1",galleryImage1);
		req.setAttribute("galleryImage2",galleryImage2);
		req.setAttribute("galleryImage3",galleryImage3);
		
		
		
		DescParagraphManager paraManager = new DescParagraphManager(path);
		List<String> paraText = paraManager.getUIParagraphs(prodId);
		logger.info("paraText"+paraText);
		req.setAttribute("ProdDescPara",paraText);
		
		DescListManager listManager = new DescListManager(path);
		List<String> paraItems = listManager.getUIListItems(prodId);
		logger.info("ProdDescList"+paraItems);
		req.setAttribute("ProdDescList",paraItems);
		
		UsesListManager usesListManager = new UsesListManager(path);
		List<String> listItems = usesListManager.getUIUsesListItems(prodId);
		logger.info("UsesDescList"+listItems);
		req.setAttribute("UsesDescList",listItems);
		
		ProductManager prodManager = new ProductManager(path);
	    List<String> prodNames = prodManager.readProductNames();
	    logger.info("About page product names "+prodNames);
		req.setAttribute("IndexList",prodManager.readProductNames());
		
		RequestDispatcher rd = req.getRequestDispatcher("products/products.jsp");
		rd.forward(req, resp);
		
		}
		catch(Exception e)
		{
			logger.error("Exception in Product Page",e);
		}
	}

	
}