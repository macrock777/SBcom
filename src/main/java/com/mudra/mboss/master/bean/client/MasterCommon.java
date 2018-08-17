package com.mudra.mboss.master.bean.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create For Master Common Methods
 * @author Emerging Five
 *
 */
public class MasterCommon {

	/**
	 * Return a true false boolean.
	 * 
	 * @param s
	 *           Any String
	 * @return The string passed in or empty string if it is null.
	 */
	public static boolean checkNullAndEmpty(String... var){
		boolean flag = false;
		if(var.length>0){
			
			for (int i = 0; i < var.length; i++) {
				String string = var[i];
				if(null!=string && string.trim().length()>0){
					flag = true;
				}else{
					flag = false;
					return flag;
				}
			}
			
		}
		return flag;
	}
	
	/**
	 * Return a true false boolean.
	 * 
	 * @param s
	 *           Any String
	 * @return The string passed in or empty string if it is null.
	 */
	public static boolean isNumeric(String str){
		if(null!=str && str.matches("\\d*\\.?\\d+")){
			return true;
		}else{
			return false;
		}
	}
	
	public static String uploadFile(File fileObj, String currentFilename ,String dirName, String  filenameSaveAs,String serverPath){
		  try{
				  File theDir =null;
				  String extention  =null;
				  String uploadpath=null;
				  
				  	if(null!=fileObj  && fileObj.length()>0){
					  		extention = currentFilename.substring(currentFilename.lastIndexOf("."));
					  		uploadpath = "/"+dirName+"/"+filenameSaveAs+ extention;
					  		
					  	// Now Check Is Dir   Exist  
					  		theDir =  new File(serverPath+"/"+dirName+"/");
					  		if (!theDir.exists()) 
					  			theDir.mkdirs();	 	// It will create Directories according to  'theDir' path 
					  		
					  		// Now Check is File already Exist
						  		File  f = new File(serverPath+"/"+uploadpath);
						  		if(f.exists()){	// if File is Exist   then  Existing  file will be delete
									f.delete();			
								}
						  		
						  		//Now File Copy in Dir 
						  		File srcFile = new File(serverPath+"/"+uploadpath);
						  		try {	
						  				Files.copy(new FileInputStream(fileObj),srcFile.toPath());
						  				//FileUtils.copyFile(fileObj,srcFile);		// File will copy source obj  to Destination Dir
						  				return uploadpath;
									} catch (IOException e) {
										e.printStackTrace();
									}
				  	}
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return null;
	}
	
	public static File convert(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}
	
	public static List<Map<String, Object>> queryRunner(Connection connection,String sqlQuery) {
		List<Map<String, Object>> list = null; 
		try{
			if(checkNullAndEmpty(sqlQuery)) { 
				System.out.println(sqlQuery);
				list = new QueryRunner().query(connection, sqlQuery,new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
