package com.msjexports.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbHelper {
	
private Connection conn;
private String path;
	
final static Logger logger = LoggerFactory.getLogger(DbHelper.class);

		public DbHelper(String path)
		{
			this.path = path;
		}


	public Connection DbConnector()
	{
		try
		{
			
			
			Class.forName("org.sqlite.JDBC");
			//Class.forName("org.sqlite.jdbc");
			conn=DriverManager.getConnection("jdbc:sqlite:"+path);
			logger.info("Connection success");
			
		}
		catch(Exception e)
		{
			
			logger.error("Exception in getting db connection",e);
		}
		return conn;
	}
	
	public boolean DbConnectorClose(Connection conn)
	{
		
		try
		{
			if(conn!=null)
			{
				conn.close();
				return true;
			}
			
			//Class.forName("org.sqlite.jdbc");
			
			
		}
		catch(Exception e)
		{
			logger.error("Exception in closing db connection",e);
		}
		return false;
	}
	
	public void resultSetClose(ResultSet rs)
	{
		try {
		if(rs!=null)
    	{
    		rs.close();
    	}
		}
		catch(Exception e)
		{
			logger.error("Exception in closing db result set",e);
		}
	}
	
	public void stmtClose(PreparedStatement pstmt)
	{
		try {
		if(pstmt!=null)
    	{
    		pstmt.close();
    	}
		}
		catch(Exception e)
		{
			logger.error("Exception in closing db statement",e);
		}
	}

}