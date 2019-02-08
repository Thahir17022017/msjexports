package com.msjexports.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class DescParagraphManager {

	private DbHelper helper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn2;
	private PreparedStatement pstmt2;
	private ResultSet rs2;
	
	final static Logger logger = LoggerFactory.getLogger(DescParagraphManager.class);
	
	public DescParagraphManager(String path)
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
				logger.error("Exception in rollback getProductId DescParagraphManager",e1);
			}
			logger.error("Exception in getProductId DescParagraphManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return prodId;
	}

	

	public String addDescPara(String addPara,String prodId) {
		// TODO Auto-generated method stub
		
		String paraId = "";
		try {
			String insertPara = "INSERT INTO TCOODS_DESC_PARAGRAPH(PARA_TEXT,PRODUCT_ID) values(?,?)";
			String selectPara = "SELECT DISTINCT PARA_ID FROM TCOODS_DESC_PARAGRAPH WHERE PARA_TEXT=? AND PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn2 = helper.DbConnector();
			conn.setAutoCommit(false);
			conn2.setAutoCommit(false);
			
			
			pstmt = conn.prepareStatement(insertPara);
			pstmt.setString(1,addPara);
			pstmt.setString(2,prodId);
			int cnt = pstmt.executeUpdate();
			conn.commit();
			
			pstmt2 = conn2.prepareStatement(selectPara);
			pstmt2.setString(1,addPara);
			pstmt2.setString(2,prodId);
			rs2=pstmt2.executeQuery();
			while(rs2.next())
			{
				paraId = rs2.getString("PARA_ID");
				logger.info("new para id of inserted col "+paraId);
			}
			
			conn2.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
				conn2.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback addDescPara DescParagraphManager",e1);
			}
			logger.error("Exception in addDescPara DescParagraphManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.resultSetClose(rs2);
			helper.stmtClose(pstmt);
			helper.stmtClose(pstmt2);
			helper.DbConnectorClose(conn);
			helper.DbConnectorClose(conn2);
		}
		return paraId;
	}

	public int updateDescPara(String editParaId, String editParaValue) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			String updateProdPara = "UPDATE TCOODS_DESC_PARAGRAPH SET PARA_TEXT=? where PARA_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(updateProdPara);
			pstmt.setString(1,editParaValue);
			pstmt.setString(2,editParaId);
			cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback updateDescPara DescParagraphManager",e1);
			}
			logger.error("Exception in updateDescPara DescParagraphManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return cnt;
	}

	public int deleteDescPara(String deleteParaId) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			String deleteProdPara = "DELETE FROM TCOODS_DESC_PARAGRAPH where PARA_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(deleteProdPara);
			pstmt.setString(1,deleteParaId);
			cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback deleteDescPara DescParagraphManager",e1);
			}
			logger.error("Exception in deleteDescPara DescParagraphManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return cnt;
	}
	
	public int deleteDescParaProduct(String prodId) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			String deleteProdPara = "DELETE FROM TCOODS_DESC_PARAGRAPH where PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(deleteProdPara);
			pstmt.setString(1,prodId);
			cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback deleteDescParaProduct DescParagraphManager",e1);
			}
			logger.error("Exception in deleteDescParaProduct DescParagraphManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return cnt;
	}

	public Map<String,String> getParagraphs(String prodId) {
		// TODO Auto-generated method stub
		Map<String,String> paraText = new HashMap<String,String>();
		try {
			String readProdPara = "SELECT PARA_ID,PARA_TEXT FROM TCOODS_DESC_PARAGRAPH where PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(readProdPara);
			pstmt.setString(1,prodId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				paraText.put(rs.getString("PARA_ID"),rs.getString("PARA_TEXT"));
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback getParagraphs DescParagraphManager",e1);
			}
			logger.error("Exception in getParagraphs DescParagraphManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return paraText;
	}
	
	public List<String> getUIParagraphs(String prodId) {
		// TODO Auto-generated method stub
		List<String> paraText = new ArrayList<String>();
		try {
			String readProdPara = "SELECT PARA_TEXT FROM TCOODS_DESC_PARAGRAPH where PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(readProdPara);
			pstmt.setString(1,prodId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				paraText.add(rs.getString("PARA_TEXT"));
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback getUIParagraphs DescParagraphManager",e1);
			}
			logger.error("Exception in getUIParagraphs DescParagraphManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return paraText;
	}
}