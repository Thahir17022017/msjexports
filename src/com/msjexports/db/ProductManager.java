package com.msjexports.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;


public class ProductManager {
	
	private DbHelper helper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	final static Logger logger = LoggerFactory.getLogger(ProductManager.class);
	
	public ProductManager(String path)
	{
		helper = new DbHelper(path);
	}
	
	public List<String> readProductNames()
	{
		List<String> prodNames = new ArrayList<String>();
		try {
			String readProducts = "select * from TCOLKP_PRODUCTS";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(readProducts);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				prodNames.add(rs.getString("PRODUCT_NAME"));
				logger.info("Read indv prod names "+prodNames);
			}
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback readProductNames",e1);
			}
			logger.error("Exception in readProductNames",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return prodNames;
	}
	
	public String addProduct(String productName)
	{
		
		try {
			String addProduct = "INSERT INTO TCOLKP_PRODUCTS(PRODUCT_NAME) VALUES(?)";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(addProduct);
			pstmt.setString(1,productName);
			int cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback addProduct",e1);
			}
			logger.error("Exception in addProduct",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return productName;
	}
	
	public JsonArray addProducts(JsonArray recNamesArr)
	{
		
		try {
			String addProducts = "INSERT INTO TCOLKP_PRODUCTS(PRODUCT_NAME) VALUES(?)";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(addProducts);
			
			Iterator<JsonElement> itr = recNamesArr.iterator();
			while(itr.hasNext())
			{
				pstmt.setString(1,itr.next().getAsString());
				int cnt = pstmt.executeUpdate();
				conn.commit();
			}
			
			
//			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback addProducts",e1);
			}
			logger.error("Exception in addProducts",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return recNamesArr;
	}

	public String delProduct(String productName)
	{
		
		try {
			String delProduct = "Delete FROM TCOLKP_PRODUCTS where PRODUCT_NAME=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(delProduct);
			pstmt.setString(1,productName);
			int cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback delProduct",e1);
			}
			logger.error("Exception in delProduct",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return productName;
	}
	
	public JsonArray delProducts(JsonArray productNames)
	{
		
		try {
			String delProduct = "Delete FROM TCOLKP_PRODUCTS where PRODUCT_NAME=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(delProduct);
			Iterator<JsonElement> itr = productNames.iterator();
			while(itr.hasNext())
			{
				pstmt.setString(1,itr.next().getAsString());
				int cnt = pstmt.executeUpdate();
				conn.commit();
			}
//			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback delProducts",e1);
			}
			logger.error("Exception in delProducts",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return productNames;
	}

	public String delAllProducts(String delProdName) {
		// TODO Auto-generated method stub
		try {
			String delProducts = "Delete FROM TCOLKP_PRODUCTS";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(delProducts);
			int cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback delAllProducts",e1);
			}
			logger.error("Exception in delAllProducts",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		return delProdName;
	}
	
	public JsonArray updateProduct(String fromName,String toName)
	{
		JsonArray resArray = new JsonArray();
		try {
			String updateProduct = "Update TCOLKP_PRODUCTS set PRODUCT_NAME=? where PRODUCT_NAME=?";
			conn = helper.DbConnector();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(updateProduct);
			pstmt.setString(1,toName);
			pstmt.setString(2,fromName);
			int cnt = pstmt.executeUpdate();
			conn.commit();
		}
		catch(Exception e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Exception in rollback updateProduct",e1);
			}
			logger.error("Exception in updateProduct",e);
		}
		finally {
			helper.resultSetClose(rs);
			helper.stmtClose(pstmt);
			helper.DbConnectorClose(conn);
		}
		resArray.add(fromName);
		resArray.add(toName);
		return resArray;
		
	}
}