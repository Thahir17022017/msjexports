package com.msjexports.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BannerImageManager {
	
	private DbHelper helper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	final static Logger logger = LoggerFactory.getLogger(BannerImageManager.class);
	
	public BannerImageManager(String path)
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
				logger.error("Exception in rolling back in BannerImageManager",e1);
			}
			logger.error("Exception in getProductId of BannerImageManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return prodId;
	}

	public String checkExistingBannerImage(String prodId)
	{
		String bannerName="";
		try {
			String checkBanner = "SELECT DISTINCT BANNER_NAME FROM TCOLKP_BANNER where PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(checkBanner);
			pstmt.setString(1,prodId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				bannerName = rs.getString("BANNER_NAME");
				
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback checkExistingBannerImage",e1);
			}
			logger.error("Exception in checkExistingBannerImage",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return bannerName;
	}
	
	public void insertNewBanner(String fileName,String prodId)
	{
		try {
			String insertNewBanner = "INSERT INTO TCOLKP_BANNER(BANNER_NAME,PRODUCT_ID) values(?,?)";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(insertNewBanner);
			pstmt.setString(1,fileName);
			pstmt.setString(2,prodId);
			int cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback insertNewBanner",e1);
			}
			logger.error("Exception in insertNewBanner",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		
	}

	public void deleteOldBanner(String bannerName,String prodId)
	{
		
		try {
			String deleteOldBanner = "DELETE FROM TCOLKP_BANNER where BANNER_NAME=? and PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(deleteOldBanner);
			pstmt.setString(1,bannerName);
			pstmt.setString(2,prodId);
			int cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback deleteOldBanner",e1);
			}
			logger.error("Exception in deleteOldBanner",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		
		
	}

	public void deleteBanner(String prodId) {
		// TODO Auto-generated method stub
		try {
			String deleteOldBanner = "DELETE FROM TCOLKP_BANNER where PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(deleteOldBanner);
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
				logger.error("Exception in rollback deleteBanner",e1);
			}
			logger.error("Exception in deleteBanner",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		
	}

	public String readBannerImage(String prodId) {
		// TODO Auto-generated method stub
		String bannerName = "";
		try {
			String readBanner = "SELECT BANNER_NAME FROM TCOLKP_BANNER where PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(readBanner);
			pstmt.setString(1,prodId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				bannerName = rs.getString("BANNER_NAME");
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback readBannerImage",e1);
			}
			logger.error("Exception in readBannerImage",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return bannerName;
	}
}