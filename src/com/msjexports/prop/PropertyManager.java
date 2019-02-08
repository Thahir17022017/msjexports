package com.msjexports.prop;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class PropertyManager {
	
	private Properties readProps;
	final static Logger logger = LoggerFactory.getLogger(PropertyManager.class);
	
	public void loadProps(String path)
	{
		FileInputStream fis =null;
		try {
		readProps = new Properties();
		fis = new FileInputStream(path);
		readProps.load(fis);
		}
		catch(Exception e)
		{
			logger.error("Exception in reading  property file",e);
		}
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("Exception in closing  property file",e);
			}
		}
		
		
	}
	
	public void updateUserCount(String path)
	{
		FileOutputStream fos=null;
		try {
			synchronized (this) {
			 fos= new FileOutputStream(path);
			 String currentCount = readProps.getProperty("com.msjexports.usercount");
			 logger.info("Current User Count : "+currentCount);
			 int totalCount = Integer.parseInt(currentCount)+1;
			 logger.info("Calculated total User count "+totalCount);
			 readProps.replace("com.msjexports.usercount", String.valueOf(totalCount));
			 readProps.store(fos,null);
			}
		}
		catch(Exception e)
		{
			logger.error("Exception in update user count",e);
		}
		finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("Exception in update user count close",e);
			}
		}
		 
	}
	
	public String readUserCount()
	{
		 return readProps.getProperty("com.msjexports.usercount");
	}
	
	public String readSpecProp(String name)
	{
		return readProps.getProperty(name);
	}
	
}