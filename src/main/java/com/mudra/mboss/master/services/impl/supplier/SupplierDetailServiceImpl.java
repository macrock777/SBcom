package com.mudra.mboss.master.services.impl.supplier;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.bean.supplier.ReadXlsx;
import com.mudra.mboss.master.bean.supplier.SupplierChangePanBean;
import com.mudra.mboss.master.bean.supplier.SuppliersearchBean;
import com.mudra.mboss.master.entity.supplier.Suppliermasterpandetails;
import com.mudra.mboss.master.entity.supplier.SuppliermasterpandetailsId;
import com.mudra.mboss.master.services.supplier.SupplierDetailmasterService;
import com.mudra.security.bean.UserdetailBean;


@Service
public class SupplierDetailServiceImpl implements SupplierDetailmasterService {
	
	@Autowired
	EntityManagerFactory emf;
	
	@Value("${supplierdetail.getsuppliertypeQuery}")
	private String getsuppliertypeQuery;
	
	
	@Value("${supplierdetail.statelist}")
	private String getstatelistQuery;
	
	@Value("${supplierdetail.gstvendortype}")
	private String gstvendortypeQuery;
	
	@Value("${supplierdetail.checkDuplicateSupplierIdQuery}")
	private String checkDuplicateSupplierIdQuery;
	
	@Value("${supplierdetail.checkDuplicateSupplierNameQuery}")
	private String checkDuplicateSupplierNameQuery;
	
	@Value("${supplierdetail.getglcodequery}")
	private String getglcodequery;
	
	
	@Value("${supplierdetail.checkDuplicateSupplierGrpIdQuery}")
	private String checkDuplicateSupplierGrpIdQuery;
	
	@Value("${supplierdetail.checkDuplicateSupplierGrpNameQuery}")
	private String checkDuplicateSupplierGrpNameQuery;
	
	
	@Value("${suppliermaster.getsupplierlistquery}")
	private String getsupplierlistquery;
	
	@Value("${suppliermaster.getserchlist}")
	private String getserchlist;
	
	
	@Value("${suppliermaster.getSupplierQuery}")
	private String getSupplierQuery;
	
	
	@Value("${suppliermaster.uploadpanfilelocation}")
	private String uploadpanfilelocation;
	
	@Value("${suppliermaster.uploadzipfilelocation}")
	private String uploadzipfilelocation;
	
	@Value("${clientmaster.getStatePinMask}")
	private String getStatePinMaskQuery;
	
	@Value("${suppliermaster.getpanchangedetail}")
	private String getpanchangedetail;
	

	
	
	SimpleDateFormat datformate1 = new SimpleDateFormat("dd/MM/yyyy");
    private static final DateTimeFormatter patten = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
	@Autowired 
	ServletContext context; 
	
	
	
	
	@Override
	public List<Map<String, Object>> getSuppliertype() {
		
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(checkNullAndEmpty(getsuppliertypeQuery)) {
				System.out.println(getsuppliertypeQuery);
				list = new QueryRunner().query(connection, getsuppliertypeQuery,new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> getStateList() {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(checkNullAndEmpty(getstatelistQuery)) {
				System.out.println(getstatelistQuery);
				list = new QueryRunner().query(connection, getstatelistQuery,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> getGstVenterType() {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(checkNullAndEmpty(gstvendortypeQuery)) {
				System.out.println(gstvendortypeQuery);
				list = new QueryRunner().query(connection, gstvendortypeQuery,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean checkNullAndEmpty(String... var){
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

	@Override
	public Map<String, Object> checkDupliacteSupplierId(String supplierid, UserdetailBean userdetailBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(checkNullAndEmpty(checkDuplicateSupplierIdQuery,uniqueid)) {
				String checkduplicateSupplierid = checkDuplicateSupplierIdQuery;
				checkduplicateSupplierid += " AND UNIQUEID = "+uniqueid+" AND SUPPLIERID= '"+supplierid+"' ";
				System.out.println(checkduplicateSupplierid);
				List<Map<String, Object>> list = new QueryRunner().query(connection, checkduplicateSupplierid,new MapListHandler());
				if(null==list || list.isEmpty()) {
					map.put("SUPPLIERID_AVAILABLE", "NO");
					return map;
				}
				else {
					map.put("SUPPLIERID_AVAILABLE", "YES");
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> checkDupliacteSupplierName(String suppliername, UserdetailBean userdetailBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(checkNullAndEmpty(checkDuplicateSupplierNameQuery,uniqueid)) {
				String checkduplicatesupplierName = checkDuplicateSupplierNameQuery;
				checkduplicatesupplierName += " AND UNIQUEID = "+uniqueid+" AND SUPPLIERNAME = '"+suppliername+"' ";
				System.out.println(checkduplicatesupplierName);
				List<Map<String, Object>> list = new QueryRunner().query(connection, checkduplicatesupplierName,new MapListHandler());
				if(null==list || list.isEmpty()) {
					map.put("SUPPLIERNAME_AVAILABLE", "NO");
					return map;
				}
				else {
					map.put("SUPPLIERNAME_AVAILABLE", "YES");
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getGlCode(UserdetailBean userdetailBean) {
		Map<String, Object> map = null;
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(MasterCommon.checkNullAndEmpty(getglcodequery,uniqueid)) {
				
				String getGlcode = getglcodequery;
				
				//s.substring(0,2)
				
				uniqueid = uniqueid.substring(0,4);
				
				getGlcode += " AND UNIQUEID = "+uniqueid+"";
				
				System.out.println(getGlcode);
				
				map = new QueryRunner().query(connection, getGlcode,new MapHandler());
				
				if(null!=map && !map.isEmpty()) {
					
					Integer numvalue1 = Integer.parseInt(null==map.get("CHECKGLCODE")?"0":map.get("CHECKGLCODE").toString());
					Integer numvalue2 = Integer.parseInt(null==map.get("NUMVALUE2")?"0":map.get("NUMVALUE2").toString());
					Integer numvalue3 = Integer.parseInt(null==map.get("NUMVALUE3")?"0":map.get("NUMVALUE3").toString());
					map.put("glavailable", "YES");
					numvalue1 = (numvalue1+1);
					if(numvalue1>=numvalue2 && numvalue1<=numvalue3){
						map.put("glvalid", "YES");
						map.put("NUMVALUE1",(numvalue1));
					}else{
						map.put("glvalid", "NO");
					}
				}else{
					map = new HashMap<String,Object>();
					map.put("glavailable", "NO");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	

	
	@Override
	public List<Map<String, Object>> getBranches(String supplierid) {
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			/*if(null!=supplierid && supplierid.trim().length()>0) {*/
				//String clientdetailQuery = " select to_char(uniqueid) AS uniqueid,branchname from mudra.branchmaster WHERE  ";
				String supplierdetailQuery = " select to_char(uniqueid),branchname from mudra.branchmaster where uniqueid in(select distinct uniqueid  from mudra.useraccessdetail where loginid='45'  and formid=5102) and nvl(isOperational,'Y')='Y' and substr(Uniqueid,1,4) = substr(10010011,1,4)  and Uniqueid Not In (10010011)  order by uniqueid ";
				System.out.println(supplierdetailQuery);
				return new QueryRunner().query(connection, supplierdetailQuery, new MapListHandler());
			/*}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@Override
	public Map<String, Object> checkDuplicateNewGroupid(String suppliergrpid, UserdetailBean userdetailBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(checkNullAndEmpty(checkDuplicateSupplierGrpIdQuery,uniqueid)) {
				String checkduplicateSupplierGRPid = checkDuplicateSupplierGrpIdQuery;
				checkduplicateSupplierGRPid += " AND UNIQUEID = "+uniqueid+" AND SUPPLIERGROUPID= '"+suppliergrpid+"' ";
				System.out.println(checkduplicateSupplierGRPid);
				List<Map<String, Object>> list = new QueryRunner().query(connection, checkduplicateSupplierGRPid,new MapListHandler());
				if(null==list || list.isEmpty()) {
					map.put("SUPPLIERGRPID_AVAILABLE", "NO");
					return map;
				}
				else {
					map.put("SUPPLIERGRPID_AVAILABLE", "YES");
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> checkDuplicateNewGroupName(String suppliegrprname, UserdetailBean userdetailBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(checkNullAndEmpty(checkDuplicateSupplierNameQuery,uniqueid)) {
				String checkduplicatesupplierGRPName = checkDuplicateSupplierGrpNameQuery;
				checkduplicatesupplierGRPName += " AND UNIQUEID = "+uniqueid+" AND SUPPLIERGROUPNAME = '"+suppliegrprname+"' ";
				System.out.println(checkduplicatesupplierGRPName);
				List<Map<String, Object>> list = new QueryRunner().query(connection, checkduplicatesupplierGRPName,new MapListHandler());
				if(null==list || list.isEmpty()) {
					map.put("SUPPLIERGRPNAME_AVAILABLE", "NO");
					return map;
				}
				else {
					map.put("SUPPLIERGRPNAME_AVAILABLE", "YES");
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return map;
	}

	@Override
	public List<Map<String, Object>> getsupplierlist(String uniqueid,String suppliergroupid) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			String query = getSupplierQuery +"and uniqueid ="+uniqueid+" "; 
			if(checkNullAndEmpty(getSupplierQuery,uniqueid)) {
				if(null!=suppliergroupid && suppliergroupid.trim().length()>0 && !suppliergroupid.equals("NA")) {
					query+= " and suppliergroupid='"+suppliergroupid+"'";
				}
				
				query+="order by suppliername ";
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getsupplierserchlist(SuppliersearchBean bean) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(checkNullAndEmpty(getserchlist)) {
				String query = getserchlist ;
				
				if(null!=bean.getSupplierid() && bean.getSupplierid().trim().length()>0) {
					query+=" and sm.supplierid ='"+bean.getSupplierid() +"' ";
				}
				
				if(null!=bean.getSuppliergrp() && bean.getSuppliergrp().trim().length()>0) {
					query+=" and sm.suppliergroupid ='"+bean.getSuppliergrp() +"'";
				}
				
				//if(null!=bean.getBranchid() && bean.getBranchid().trim().length()>0) {
					query+=" and sm.uniqueid ="+bean.getUniqueid()+" ";
				//}
				
				if(null!=bean.getStatus() && bean.getStatus().trim().length()>0) {
					query+=" and nvl(sm.isactive,'N') ='"+bean.getStatus()+"' ";
				}
				
				if(null!=bean.getPannumber() && bean.getPannumber().trim().length()>0) {
					query+=" and upper(sm.pannumber) like upper('%"+bean.getPannumber()+"%') ";
				}
				
				System.out.println(query);
				
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	@Override
	public List<Map<String, Object>> getsupplieridforedit(String supplierid,String unqueid) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(checkNullAndEmpty(getSupplierQuery,supplierid,unqueid)) {
				String query = getSupplierQuery +"and supplierid ='"+supplierid+"' and uniqueid ="+unqueid+" ";
				list = new QueryRunner().query(connection, query,new MapListHandler());
				Map<String, Object> map = new HashMap<>();
				if(null!=list && !list.isEmpty()) {
					String sqlQuery = " SELECT UNIQUEID FROM mudra.suppliermaster WHERE supplierid='"+supplierid+"' ";
					map.put("branchesopen",MasterCommon.queryRunner(connection, sqlQuery));
					//list.add(map);
				
				
				String str ="select uniqueid,supplierid,type,filepath from MUDRA.SUPPLIERMASTERDOCUMENTDETAIL  where  uniqueid="+unqueid+" and supplierid='"+supplierid+"'";
				List<?> list1 = getDataFromQuery(str, session);
				String setpanfile="";
				String setzipfile="";
				if(null!=list1 && !list1.isEmpty()) {
					for(int i = 0;i<list1.size(); i++) {
						Object[] obj = (Object[])list1.get(i);
						if(null!=obj[2] && obj[2].toString().equals("PAN"))
							setpanfile=obj[3].toString();
						if(null!=obj[2] && obj[2].toString().equals("ZIP"))
							setzipfile = obj[3].toString();
					}
				}
				
				File file = null;
				String filePath = null;
				filePath = context.getRealPath("")+setpanfile;
				file = new File(filePath);
				System.out.println("zip file path ==> "+filePath);
				if(file.exists()) {
					map.put("pan_file", "yes");
					map.put("pan_url", "/downloadfiles/"+unqueid+"/"+supplierid+"/PAN");
				}else{
					map.put("pan_file", "no");
				}
				
				filePath = context.getRealPath("")+setzipfile;
				System.out.println("zip file path ==> "+filePath);
				file = new File(filePath);
				if(file.exists()){
					map.put("zip_file", "yes");
					map.put("zip_url", "/downloadfiles/"+unqueid+"/"+supplierid+"/ZIP");
				}else{
					map.put("zip_file", "no");
				}
				list.add(map);
			}
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Map<String, Object> savechangepan(SupplierChangePanBean bean,MultipartFile newpanfile) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = emf.createEntityManager().unwrap(Session.class);
		Transaction transaction = null;
		try(Connection connection = ((SessionImpl) session).connection();){
			 transaction =  session.beginTransaction();
			Suppliermasterpandetails detail = new Suppliermasterpandetails();
			SuppliermasterpandetailsId id = new SuppliermasterpandetailsId();
			
			if(checkNullAndEmpty(bean.getUniqueid(),bean.getOldpannumber(),bean.getNewpannumber())) {
				
				String checkpan = "SELECT * FROM MUDRA.SUPPLIERMASTERPANDETAILS where uniqueid="+bean.getUniqueid()+" and  pannumber='"+bean.getNewpannumber()+"' and  supplierid ='"+bean.getSupplierid()+"'";
				List list = getDataFromQuery(checkpan,session);
				if(null!=list && list.size()>0) {
					map.put("NEWPANNUMBER","YES");
					return map;
				}
				else 
					map.put("NEWPANNUMBER","NO");
				
				
				String checkpannumber = "SELECT * FROM MUDRA.suppliermaster where uniqueid="+bean.getUniqueid()+" and  pannumber='"+bean.getNewpannumber()+"' and  supplierid ='"+bean.getSupplierid()+"'";
				List list1 = getDataFromQuery(checkpannumber,session);
				if(null!=list1 && list1.size()>0) {
					map.put("NEWSUPPLIEREXIST","YES");
					return map;
				}
				else 
					map.put("NEWSUPPLIEREXIST","NO");
				
				
				 id.setUniqueid(Integer.parseInt(bean.getUniqueid()));
				 id.setSupplierid(bean.getSupplierid());
				 id.setPannumber(bean.getNewpannumber());
				 detail.setId(id);

				 LocalDateTime localDate = LocalDateTime.now();
			     String Datestr  = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDate);

				 if(null!=bean.getEffactivetodate() && bean.getEffactivetodate().trim().length()>0) 
					detail.setEffectivetodate(dateFormat.parse(bean.getEffactivetodate()));
				 else 
					detail.setEffectivetodate(dateFormat.parse(Datestr));
				
				 if(null!=bean.getEffactivefromdate() && bean.getEffactivefromdate().trim().length()>0) 
					detail.setEffectivefromdate(dateFormat.parse(bean.getEffactivefromdate()));
				 else 
					detail.setEffectivefromdate(dateFormat.parse(Datestr));
				 
				 	if(null!=newpanfile) {
				 		File updaloadpanfile = MasterCommon.convert(newpanfile);
				 		String filepath;
				 		String str ="select * from MUDRA.SUPPLIERMASTERDOCUMENTDETAIL where uniqueid="+bean.getUniqueid()+" and SUPPLIERID='"+bean.getSupplierid()+"' AND ISACTIVE='Y' and type='PAN' ";
				 		List list2 = getDataFromQuery(str,session);
					if(null!=list2 && list2.size()>0) {
						filepath = MasterCommon.uploadFile(updaloadpanfile,updaloadpanfile.getName(),uploadpanfilelocation,bean.getUniqueid()+"_"+bean.getSupplierid()+"PAN",context.getRealPath(""));
						if(null!=filepath) {
								String uploaddoc = " update MUDRA.SUPPLIERMASTERDOCUMENTDETAIL set filepath='"+filepath+"' where type='PAN' and uniqueid="+bean.getUniqueid()+" and SUPPLIERID='"+bean.getSupplierid()+"' AND ISACTIVE='Y' ";
									NativeQuery<?> query = session.createNativeQuery(uploaddoc);
									query.executeUpdate();
								map.put("UPLOADZIPRARFILE", "SUCCESSFULLY");
						}else {
								map.put("UPLOADZIPRARFILE", "FAILED");
						}
					}
					else 
						{
						filepath = MasterCommon.uploadFile(updaloadpanfile,updaloadpanfile.getName(),uploadpanfilelocation,bean.getUniqueid()+"_"+bean.getSupplierid()+"_PAN",context.getRealPath(""));
							if(null!=filepath) {
								String uploaddoc = "insert into mudra.SUPPLIERMASTERDOCUMENTDETAIL(uniqueid,supplierid,type,filepath,isactive)"
										+ " values("+bean.getUniqueid()+",'"+bean.getSupplierid()+"','PAN','"+filepath+"','Y')";
									NativeQuery<?> query = session.createNativeQuery(uploaddoc);
									query.executeUpdate();
									map.put("UPLOADZIPRARFILE", "SUCCESSFULLY");
							}else {
									map.put("UPLOADZIPRARFILE", "FAILED");
					  }
					 }
					}
				 	
				 	
					String updatepan = "update mudra.suppliermaster set pannumber = '"+bean.getNewpannumber()+"' where  uniqueid= "+bean.getUniqueid()+" and pannumber = '"+bean.getOldpannumber()+"' and supplierid = '"+bean.getSupplierid()+"' ";
						NativeQuery<?> query = session.createNativeQuery(updatepan);
						query.executeUpdate();
						
					}
			
				session.save(detail);			
				session.flush();
				transaction.commit();
				map.put("SUCCESS", "UPDATE PAN SUCCESSFULLY");
				
				
		}catch (Exception e) {
			if(null!=transaction) {
				System.out.println("Transaction Rollback");
				transaction.rollback();
			}
			map.put("ERRORMASSAGE",e.getMessage());
			e.printStackTrace();
		}finally{
			if(null!=session) {
				session.clear();
				session.close();
			}	
		}
		return map;
	}
	
	public List<?> getDataFromQuery(String strQuery,Session session) {
	
		try{
			//logger.error(strQuery);
			Query query = session.createNativeQuery(strQuery);
			List<?> dataList = query.getResultList();
			return dataList;
		}catch(Exception ex){
			if(ex.getMessage().toLowerCase().equals("could not execute query"))
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Map<String, Object> getStatePinMask(String statename) {
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(statename,getStatePinMaskQuery)) {
				String sqlQuery = getStatePinMaskQuery;
				sqlQuery += " AND LOWER(CHARVALUE1) = LOWER('"+statename+"') ";
				List<Map<String, Object>> list = MasterCommon.queryRunner(connection, sqlQuery);
				if(null!=list && !list.isEmpty()) {
					return list.get(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> getSupplierchange(String loginid) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(checkNullAndEmpty(getpanchangedetail,loginid)) {
				String query = getpanchangedetail +" and MASTERCODE = "+loginid+" ";
				System.out.println(getpanchangedetail);
				List<Map<String, Object>> list = new QueryRunner().query(connection, query,new MapListHandler());
				if(null==list || list.isEmpty()) {
						map.put("ACCESS", "You Are Not Authorize Person to Change Pandetail...");
					return map;
				}
				else {
						map.put("ACCESS", "");
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return map;
	}
	
	@Override
	public Map<String, Object> uploadSupplierExcel(MultipartFile uploadopenexceldata) {
		try {
			File uploadedFile = MasterCommon.convert(uploadopenexceldata);
			String contextPath = context.getRealPath("");
			if(null!=uploadedFile) {
				String filePath = MasterCommon.uploadFile(uploadedFile, uploadedFile.getName(), uploadpanfilelocation, 
						uploadedFile.getName(), contextPath);
				filePath = contextPath +"\\"+filePath;
				if(null!=filePath && filePath.trim().length()>0) {
					Map<String, ArrayList<String>> excelData = 
							ReadXlsx.readExcel(filePath);
					
					
					return setExcelDataValue(excelData);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public InputStream downloadFile(HttpServletResponse response,String uniqueid, String supplierid, String filetype, String serverUrl) {
		InputStream inputStream = null;
		try (Session session = emf.createEntityManager().unwrap(Session.class);){
			if(MasterCommon.checkNullAndEmpty(uniqueid,supplierid,filetype,serverUrl,uploadzipfilelocation,uploadpanfilelocation)) {
				
				String str ="select uniqueid,supplierid,type,filepath from MUDRA.SUPPLIERMASTERDOCUMENTDETAIL  where  uniqueid="+uniqueid+" and supplierid='"+supplierid+"'";
				List<?> list1 = getDataFromQuery(str, session);
				String setpanfile="";
				String setzipfile="";
				if(null!=list1 && !list1.isEmpty()) {
					for(int i = 0;i<list1.size(); i++) {
						Object[] obj = (Object[])list1.get(i);
						if(null!=obj[2] && obj[2].toString().equals("PAN"))
							setpanfile=obj[3].toString();
						if(null!=obj[2] && obj[2].toString().equals("ZIP"))
							setzipfile = obj[3].toString();
					}
				}
				
				File file = null;
				String filePath = null;
				if("PAN".equalsIgnoreCase(filetype)) {
					filePath = serverUrl+setpanfile;
					file = new File(filePath);
				}
				else if("ZIP".equalsIgnoreCase(filetype)){
					filePath = serverUrl+setzipfile;
					file = new File(filePath);
				}
				
		        if(!file.exists()){
		            String errorMessage = "Sorry. The file you are looking for does not exist";
		            OutputStream outputStream = response.getOutputStream();
		            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
		            outputStream.close();
		            return null;
		        }
		         
		        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
		        if(mimeType==null){
		            System.out.println("mimetype is not detectable, will take default");
		            mimeType = "application/octet-stream";
		        }
		         
		        System.out.println("mimetype : "+mimeType);
		         
		        response.setContentType(mimeType);
		         
		        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
		            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
		        //response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
		 
		         
		        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
		        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		        response.setContentLength((int)file.length());
		        inputStream = new BufferedInputStream(new FileInputStream(file));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStream;
	}
	
	
	
	public Map<String, Object> setExcelDataValue(Map<String, ArrayList<String>> map1){
		Map<String, Object> map = new HashMap<>();
		try {
			int indexData = 0;
			for(Map.Entry<String, ArrayList<String>> sheetData : 
				map1.entrySet()) {
				ArrayList<String> list = sheetData.getValue();
				if(null!=list && !list.isEmpty()) {
					for (String string : list) {
						string = string!=null?string.trim():"";
						
						if(null!=string && string.trim().length()>0) {
							switch (indexData) {
							case 1:
								map.put("suppliername", string);
								indexData = 0;
								break;
							case 2:
								map.put("paytoname", string);
								indexData = 0;
								break;
							case 3:
								map.put("supplieraddress1", string);
								indexData = 0;
								break;
							case 4:
								map.put("supplieraddress2", string);
								indexData = 0;
								break;
							case 5:
								map.put("supplieraddress3", string);
								indexData = 0;
								break;
							case 6:
								map.put("supplierpincode", string);
								indexData = 0;
								break;
							case 7:
								map.put("suppliercity", string);
								indexData = 0;
								break;
							case 8:
								System.out.println("-------------------------------------------------------------------------->"+string);
								map.put("pannumber", string);
								indexData = 0;
								break;
							case 9:
								map.put("suppliertype", string);
								indexData = 0;
								break;
							case 10:
								map.put("state", string);
								indexData = 0;
								break;
							case 11:
								map.put("suppliercountry", string);
								indexData = 0;
								break;
							case 12:
								map.put("suppliercontactperson", string);
								indexData = 0;
								break;
							case 13:
								map.put("gst_vendor_type", string);
								indexData = 0;
								break;
							case 14:
								map.put("supplierphoneno", string);
								indexData = 0;
								break;
							case 15:
								map.put("supplierphoneno", string);
								indexData = 0;
								break;
							case 16:
								map.put("supplierfax", string);
								indexData = 0;
								break;
							case 17:
								map.put("supplieremail", string);
								indexData = 0;
								break;
						}
							if(indexData == 0) {
								
								
								System.out.println("PAN No. :".trim().equalsIgnoreCase(string.trim())+"======>"+string.trim());
								
								if("Vendor Name".equalsIgnoreCase(string)) {
									indexData = 1;
								}else if("Payee Name".equalsIgnoreCase(string)) {
									indexData = 2;
								}else if(string.indexOf("Line 1")!=-1) {
									indexData = 3;
								}else if(string.indexOf("Line 2")!=-1) {
									indexData = 4;
								}else if(string.indexOf("Line 3")!=-1) {
									indexData = 5;
								}else if("Postal/Zip Code".equalsIgnoreCase(string)) {
									indexData = 6;
								}else if("City".equalsIgnoreCase(string)) {
									indexData = 7;
								}else if("PAN No. :".trim().equals(string.trim())) {
									indexData = 8;
								}else if("Vendor Type".equalsIgnoreCase(string)) {
									indexData = 9;
								}else if("State/Region".equalsIgnoreCase(string)) {
									indexData = 10;
								}else if("Country".equalsIgnoreCase(string)) {
									indexData = 11;
								}else if("Contact Name".equalsIgnoreCase(string)) {
									indexData = 12;
								}else if("Vendor type for GST".trim().equalsIgnoreCase(string.trim())) {
									indexData = 13;
								}else if(string.indexOf("Telephone")!=-1) {
									indexData = 14;
								}else if(string.indexOf("Mobile No.")!=-1) {
									indexData = 15;
								}else if(string.indexOf("FAX")!=-1) {
									indexData = 16;
								}else if(string.indexOf("E-Mail Address")!=-1) {
									indexData = 17;
								}
								
							}
							
							
						}
					}
				}
			}
			
		System.out.println("====>"+map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	/*public Map<String, Object> getClientDetail(String clientidhd,UserdetailBean userdetailBean,String serverPath) {
		Map<String, Object> map = null;
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			String bankFileLocation = env.getProperty("clientmaster.bankFileLocation");
			String panFileLocation = env.getProperty("clientmaster.panFileLocation");
			String getClientDetailQuery = env.getProperty("clientmaster.getClientDetail");
			String getContractDetailQuery = env.getProperty("clientmaster.getContractDetail");
			if(MasterCommon.checkNullAndEmpty(getClientDetailQuery,getContractDetailQuery,
					clientidhd,uniqueid,bankFileLocation)) {
				String clientdetailQuery = getClientDetailQuery;
				clientdetailQuery += " AND cm.clientid = '"+clientidhd+"' AND cm.UNIQUEID = "+uniqueid+" ";
				System.out.println(clientdetailQuery);
				List<Map<String, Object>> list = new QueryRunner().query(connection, clientdetailQuery, new MapListHandler());
				String glcode = null;
				if(null!=list && !list.isEmpty()) {
					map = list.get(0);
					if(null!=map && !map.isEmpty()) {
						Object glcodeObj = map.get("glcode");
						glcode = (null==glcodeObj?null:glcodeObj.toString());
					}
				}
				
				clientdetailQuery = getContractDetailQuery;
				clientdetailQuery += " AND UNIQUEID = "+uniqueid+" AND CLIENTID = '"+clientidhd+"' ORDER BY SRNO DESC ";
				List<Map<String, Object>> list1 = new QueryRunner().query(connection, clientdetailQuery, new MapListHandler());
				map = (map==null)?new HashMap<String, Object>():map;
				if(null!=list1 && !list1.isEmpty()) {
					map.put("contractdetail",list1.get(0));
				}
				
				String sqlQuery = " SELECT UNIQUEID FROM MUDRA.CLIENTMASTER WHERE CLIENTID = '"+clientidhd+"' ";
				map.put("branchesopen",MasterCommon.queryRunner(connection, sqlQuery));
				
				if(MasterCommon.isNumeric(glcode)) {
					String glcodesqlQuery = " SELECT OPENINGBALANCE,CLOSINGBALANCE FROM MUDRA.GLBALANCE WHERE GLCODE = "+glcode+" ";
					map.put("GLBALANCE_DATA",MasterCommon.queryRunner(connection, glcodesqlQuery));
				}
				
				File file = null;
				String filePath = null;
				filePath = serverPath+"/"+panFileLocation+"/"+uniqueid+"_"+clientidhd+"_PAN.pdf";
				System.out.println("pan file path ==> "+filePath);
				file = new File(filePath);
				
				if(file.exists()) {
					map.put("pan_file", "yes");
					map.put("pan_url", "/downloadfiles/"+uniqueid+"/"+clientidhd+"/PAN");
				}else{
					map.put("pan_file", "no");
				}
				
				filePath = serverPath+"/"+bankFileLocation+"/"+uniqueid+"_"+clientidhd+"_BANK.pdf";
				System.out.println("bank file path ==> "+filePath);
				file = new File(filePath);
				if(file.exists()){
					map.put("bank_file", "yes");
					map.put("bank_url", "/downloadfiles/"+uniqueid+"/"+clientidhd+"/BANK");
				}else{
					map.put("bank_file", "no");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}*/
	
	

	
	
}
