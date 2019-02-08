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



public class DescListManager {

	private DbHelper helper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn2;
	private PreparedStatement pstmt2;
	private ResultSet rs2;
	
	final static Logger logger = LoggerFactory.getLogger(DescListManager.class);
	
	public DescListManager(String path)
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
				logger.error("Exception in rollback getProductId DescListManager",e1);
			}
			logger.error("Exception in getProductId DescListManager",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return prodId;
	}

	

	public String addDescList(String addList,String prodId) {
		// TODO Auto-generated method stub
		
		String listId = "";
		try {
			String insertList = "INSERT INTO TCOODS_DESC_LIST(LIST_TEXT,PRODUCT_ID) values(?,?)";
			String selectList = "SELECT DISTINCT LIST_ID FROM TCOODS_DESC_LIST WHERE LIST_TEXT=? AND PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn2 = helper.DbConnector();
			conn.setAutoCommit(false);
			conn2.setAutoCommit(false);
			
			
			pstmt = conn.prepareStatement(insertList);
			pstmt.setString(1,addList);
			pstmt.setString(2,prodId);
			int cnt = pstmt.executeUpdate();
			conn.commit();
			
			pstmt2 = conn2.prepareStatement(selectList);
			pstmt2.setString(1,addList);
			pstmt2.setString(2,prodId);
			rs2=pstmt2.executeQuery();
			while(rs2.next())
			{
				listId = rs2.getString("LIST_ID");
				logger.info("new List id of inserted col "+listId);
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
				logger.error("Exception in rollback addDescList",e1);
			}
			logger.error("Exception in addDescList",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.resultSetClose(rs2);
			helper.stmtClose(pstmt);
			helper.stmtClose(pstmt2);
			helper.DbConnectorClose(conn);
			helper.DbConnectorClose(conn2);
		}
		return listId;
	}

	public int updateDescList(String editListId, String editListValue) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			String updateProdList = "UPDATE TCOODS_DESC_LIST SET LIST_TEXT=? where LIST_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(updateProdList);
			pstmt.setString(1,editListValue);
			pstmt.setString(2,editListId);
			cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback updateDescList",e1);
			}
			logger.error("Exception in updateDescList",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return cnt;
	}

	public int deleteDescList(String deleteListId) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			String deleteProdList = "DELETE FROM TCOODS_DESC_LIST where LIST_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(deleteProdList);
			pstmt.setString(1,deleteListId);
			cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback deleteDescList",e1);
			}
			logger.error("Exception in deleteDescList",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return cnt;
	}
	
	
	public int deleteDescListProduct(String prodId) {
		// TODO Auto-generated method stub
		int cnt = 0;
		try {
			String deleteProdList = "DELETE FROM TCOODS_DESC_LIST where PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(deleteProdList);
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
				logger.error("Exception in rollback deleteDescListProduct",e1);
			}
			logger.error("Exception in deleteDescListProduct",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return cnt;
	}

	public Map<String,String>  getListItems(String prodId) {
		// TODO Auto-generated method stub
		Map<String,String> listItems = new HashMap<String,String>();
		try {
			String readProdLists = "SELECT LIST_ID,LIST_TEXT FROM TCOODS_DESC_LIST where PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(readProdLists);
			pstmt.setString(1,prodId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				listItems.put(rs.getString("LIST_ID"),rs.getString("LIST_TEXT"));
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback getListItems",e1);
			}
			logger.error("Exception in getListItems",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return listItems;
	}
	
	public List<String>  getUIListItems(String prodId) {
		// TODO Auto-generated method stub
		List<String> listItems = new ArrayList<String>();
		try {
			String readProdLists = "SELECT LIST_TEXT FROM TCOODS_DESC_LIST where PRODUCT_ID=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(readProdLists);
			pstmt.setString(1,prodId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				listItems.add(rs.getString("LIST_TEXT"));
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback getUIListItems",e1);
			}
			logger.error("Exception in getUIListItems",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return listItems;
	}
}