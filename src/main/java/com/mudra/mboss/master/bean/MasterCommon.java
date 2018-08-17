package com.mudra.mboss.master.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
	
	public static long getTxnnumber() {
		Calendar calendar = Calendar.getInstance();
		String year = "" + calendar.get(Calendar.YEAR);
		String month = "" + (calendar.get(Calendar.MONTH) + 1);
		String day = "" + calendar.get(Calendar.DATE);
		String hour = "" + calendar.get(Calendar.HOUR);
		String minutes = "" + calendar.get(Calendar.MINUTE);
		String second = "" + calendar.get(Calendar.SECOND);
		StringBuilder sbNumber = new StringBuilder("" + year);
		if (month.length() == 1)
			month = "0" + month;
		if (day.length() == 1)
			day = "0" + day;
		if (hour.length() == 1)
			hour = "0" + hour;
		if (minutes.length() == 1)
			minutes = "0" + minutes;
		if (second.length() == 1)
			second = "0" + second;
		sbNumber.append(month);
		sbNumber.append(day);
		sbNumber.append(hour);
		sbNumber.append(minutes);
		sbNumber.append(second);

		return Long.parseLong(sbNumber.toString());
	}
	
	public static List<?> getDataFromQuery(String strQuery, Session session) {

		try {
			// logger.error(strQuery);
			Query query = session.createNativeQuery(strQuery);
			List<?> dataList = query.getResultList();
			return dataList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	

	public static String getMaxValue(String tablename, String columnname, String whereClause, Session session) { // if where
																											// cluse is
																											// null then
																											// pass as
																											// -> "" or
																											// null
		try {
			String strQuery = "SELECT  NVL(MAX(" + columnname + ") ,0)+1 FROM  " + tablename;
			if (null != whereClause && whereClause.trim().length() > 0)
				strQuery += " " + whereClause;
			List<?> maxPlusValList = getDataFromQuery(strQuery, session);
			if (null != maxPlusValList && !maxPlusValList.isEmpty())
				return maxPlusValList.get(0).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

}
