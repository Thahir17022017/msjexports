package com.msjexports.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AliasManager 
{
	private DbHelper helper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	final static Logger logger = LoggerFactory.getLogger(AliasManager.class);
	
	public AliasManager(String path)
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
				logger.error("Exception in rolling back in Alias manager",e1);
			}
			logger.error("Exception in getProductId of Alias manager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return prodId;
	}
	
	public String addAlias(String addAlias,String prodId) {
		// TODO Auto-generated method stub
		
		String listId = "";
		try {
			String insertAlias = "INSERT INTO TCOLKP_PRODUCT_ALIAS(ALIAS_NAME,PRODUCT_ID) values(?,?)";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(insertAlias);
			pstmt.setString(1,addAlias);
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
				
				logger.error("Exception in rolling back addAlias",e1);
			}
			logger.error("Exception in addAlias",e);
		}
		finally {
			
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
			
		}
		return listId;
	}

	public void deleteAlias(String prodId) {
		// TODO Auto-generated method stub
		try {
			String deleteAlias = "DELETE FROM TCOLKP_PRODUCT_ALIAS WHERE PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(deleteAlias);
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
				logger.error("Exception in rolling back deleteAlias",e1);
			}
			logger.error("Exception in deleteAlias",e);
		}
		finally {
			
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
			
		}
	}
	
	public String getAlias(String prodId)
	{
		String aliasName = "";
		try {
			String getAlias = "SELECT ALIAS_NAME FROM TCOLKP_PRODUCT_ALIAS WHERE PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(getAlias);
			pstmt.setString(1,prodId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				aliasName = rs.getString("ALIAS_NAME");
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rolling back of getAlias",e1);
			}
			logger.error("Exception in getAlias",e);
		}
		finally {
			
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
			
		}
		return aliasName;
	}
}