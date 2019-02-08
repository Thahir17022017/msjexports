package com.msjexports.util;
import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class UtilityManager {
	
	final static Logger logger = LoggerFactory.getLogger(UtilityManager.class);
	
	public void deleteOldImageFile(String imageFodlerPath,String imageName)
	{
		try{
    		String imageFilePath = imageFodlerPath+File.separator+imageName;
    		logger.info(" Image file path : "+imageFilePath);
    		File file = new File(imageFilePath);
        	
    		if(file.delete()){
    			logger.info(file.getName() + " is deleted!");
    		}else{
    			logger.info("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){
    		
    		logger.error("Exception in Utility Manager",e);
    		
    	}
	}

}