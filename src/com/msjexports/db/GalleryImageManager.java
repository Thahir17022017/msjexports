package com.msjexports.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GalleryImageManager {
	
	private DbHelper helper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	final static Logger logger = LoggerFactory.getLogger(GalleryImageManager.class);
	
	public GalleryImageManager(String path)
	{
		helper = new DbHelper(path);
	}
	
	public String getProductId(String prodName)
	{
		String prodId="";
		try {
			String readProducts = "SELECT DISTINCT PRODUCT_ID FROM TCOLKP_PRODUCTS where PRODUCT_NAME=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(readProducts);
			pstmt.setString(1,prodName);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				prodId = rs.getString("PRODUCT_ID");
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in getProductId GalleryImageManager",e1);
			}
			logger.error("Exception in getProductId GalleryImageManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return prodId;
	}

	public String checkExistingGalleryImage(String prodId,String galleryRef)
	{
		String galleryName="";
		try {
			String checkGallery = "SELECT DISTINCT GALLERY_NAME FROM TCOLKP_GALLERY where PRODUCT_ID=? and GALLERY_REF=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(checkGallery);
			pstmt.setString(1,prodId);
			pstmt.setString(2,galleryRef);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				galleryName = rs.getString("GALLERY_NAME");
				logger.info("Inside Gallery Name "+galleryName);
				
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback checkExistingGalleryImage GalleryImageManager",e1);
			}
			logger.error("Exception in checkExistingGalleryImage GalleryImageManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return galleryName;
	}
	
	
	
	public void insertNewGallery(String galleryRef,String fileName,String prodId)
	{
		try {
			String insertNewBanner = "INSERT INTO TCOLKP_GALLERY(GALLERY_REF,GALLERY_NAME,PRODUCT_ID) values(?,?,?)";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(insertNewBanner);
			pstmt.setString(1,galleryRef);
			pstmt.setString(2,fileName);
			pstmt.setString(3,prodId);
			int cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback insertNewGallery GalleryImageManager",e1);
			}
			logger.error("Exception in insertNewGallery GalleryImageManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		
	}

	public void deleteOldGallery(String galleryRef,String galleryName,String prodId)
	{
		
		try {
			String deleteOldGallery = "DELETE FROM TCOLKP_GALLERY where GALLERY_REF=? and GALLERY_NAME=? and PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(deleteOldGallery);
			pstmt.setString(1,galleryRef);
			pstmt.setString(2,galleryName);
			pstmt.setString(3,prodId);
			int cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback deleteOldGallery GalleryImageManager",e1);
			}
			logger.error("Exception in deleteOldGallery GalleryImageManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		
		
	}

	public void deleteGallery(String prodId) {
		// TODO Auto-generated method stub
		try {
			String deleteOldGallery = "DELETE FROM TCOLKP_GALLERY where PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(deleteOldGallery);
			pstmt.setString(1,prodId);
			int cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback deleteGallery GalleryImageManager",e1);
			}
			logger.error("Exception in deleteGallery GalleryImageManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
	}

	public String readGalleryImages(String prodId,String galleryRef)
	{
		String readGallery = "";
		try {
			String selectGallery = "SELECT GALLERY_NAME FROM TCOLKP_GALLERY where PRODUCT_ID=? and GALLERY_REF=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(selectGallery);
			pstmt.setString(1,prodId);
			pstmt.setString(2,galleryRef);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				readGallery = rs.getString("GALLERY_NAME");
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback readGalleryImages GalleryImageManager",e1);
			}
			logger.error("Exception in readGalleryImages GalleryImageManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return readGallery;
	}
}