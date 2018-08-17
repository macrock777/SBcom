package com.mudra.mboss.master.services.impl.supplier;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.bean.supplier.SupplierHSNSACBean;
import com.mudra.mboss.master.bean.supplier.SupplierPanbaseBean;
import com.mudra.mboss.master.bean.supplier.SupplierPanbaseheaderBean;
import com.mudra.mboss.master.entity.supplier.GstSacHsnDetail;
import com.mudra.mboss.master.entity.supplier.GstSacHsnDetailId;
import com.mudra.mboss.master.entity.supplier.Suppliermastergstindetail;
import com.mudra.mboss.master.entity.supplier.SuppliermastergstindetailId;
import com.mudra.mboss.master.entity.supplier.Suppliermasterpanbase;
import com.mudra.mboss.master.services.supplier.SupplierPANBaseService;


@Service
public class SupplierPANBaseServiceImpl implements SupplierPANBaseService {

	@Autowired
	EntityManagerFactory emf;
	
	@Value("${supplierpandetail.sachsnquery}")
	private String sachsnquery;
	
	@Value("${supplierpandetail.getSupplierQuery}")
	private String getSupplierQuery;
	
	@Value("${supplierpandetail.getgstindetail}")
	private String getgstindetail;
	
	
	@Value("${supplierpandetail.getpandetailQuery}")
	private String getpandetailQuery;
	
	
	
	@Value("${supplierpandetail.getSACHSNgridQuary}")
	private String getSACHSNgridQuary;
	 
	
	@Override
	public List<Map<String, Object>> gethsnsac(String sactype) {
		
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getSACHSNgridQuary,sactype)) {
				String query  = getSACHSNgridQuary+" and gstsachsndetail.type='"+sactype+"' ";
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	
	}

	// NEW 
	
	@Override
	public List<Map<String, Object>> getSupplierData1(String pannumber) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(pannumber)) {
				String query = "select * from MUDRA.SUPPLIERMASTERPANBASE where pannumber = '"+pannumber+"'"; 
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Map<String, Object>> getSupplierData(String uniqueid,String supplierid) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getSupplierQuery,uniqueid,supplierid)) {
				String query = getSupplierQuery+" and uniqueid = "+uniqueid+" and supplierid='"+supplierid+"'"; 
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// new 
	
	@Override
	public List<Map<String, Object>> getgstdetail(String pannumber) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getgstindetail)) {
				String query = getgstindetail + " and pannumber ='"+pannumber+"'";
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	public String getMaxValue(String tablename,  String columnname, String whereClause){	 //  if  where cluse is null then pass as  ->  "" or  null
		try{
		String strQuery ="SELECT  NVL(MAX("+columnname+") ,0)+1 FROM  "+tablename; 
		if(null!=whereClause &&  whereClause.trim().length()>0)
		strQuery += " "+whereClause;
		List<?> maxPlusValList = getDataFromQuery(strQuery);
		if(null!=maxPlusValList && !maxPlusValList.isEmpty())
		return maxPlusValList.get(0).toString();
		}catch(Exception e){
		e.printStackTrace();
		}
		return "0";
		}


		public List<?> getDataFromQuery(String strQuery) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		try {		
		Query query = session.createNativeQuery(strQuery);
		List<?> dataList = query.getResultList();
		return dataList;
		}catch(Exception ex){
		if(ex.getMessage().toLowerCase().equals("could not execute query"))
		ex.printStackTrace();
		}finally {
		if(null!=session) {
		session.clear();
		}
		}
		return null;
		}
	
	
	
	
	@Override
	public Map<String, Object> savePanBaseDetailData(SupplierPanbaseBean bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		Transaction transaction = null;
		
		
		Session session = emf.createEntityManager().unwrap(Session.class);
		try(Connection connection = ((SessionImpl) session).connection();) {
			Suppliermastergstindetail gstd = new Suppliermastergstindetail();
			SuppliermastergstindetailId id = new SuppliermastergstindetailId();
			transaction = session.beginTransaction();
		if(MasterCommon.checkNullAndEmpty(bean.getGstdetailgstin())) {
			String getMax = getMaxValue("mudra.Suppliermastergstindetail", "srno", "where pannumber='"+bean.getGstdetailgstin()+"' and gstin='"+bean.getGstdetailgstin()+"'");
				id.setGstin(bean.getGstdetailgstin());
				id.setPannumber(bean.getGstdetailgstin().substring(2,12));
				
			if(null==bean.getGstindetailsrno() || bean.getGstindetailsrno().trim().length()==0) {
				
				List<Map<String, Object>> list = null; 
				String query = "SELECT * FROM MUDRA.Suppliermastergstindetail WHERE gstin='"+bean.getGstdetailgstin()+"' AND pannumber='"+bean.getGstdetailgstin().substring(2,12)+"'";
				list = new QueryRunner().query(connection, query,new MapListHandler());
				
				if(list.size()>0)
				{
					map.put("DUPLICATE", "GSTN Number Already Exist");
					return map;
				}
				
				id.setSrno(Byte.parseByte(getMax));
				gstd.setId(id);
			}
			else {
				id.setSrno(Byte.parseByte(bean.getGstindetailsrno().toString()));
				gstd = (Suppliermastergstindetail)session.get(Suppliermastergstindetail.class, id);
			}
			
			//PanbaseheaderBean bean2 = bean.header;
			
			if(null!=bean.getGstdetailgstin() && bean.getGstdetailgstin().trim().length()>0)
				gstd.setStatecode((bean.getGstdetailtatecode()));
			
			if(null!=bean.getGstdetailaddress() && bean.getGstdetailaddress().trim().length()>0)
				gstd.setAddress(bean.getGstdetailaddress());
			
			if(null!=bean.getGstdetailcity() && bean.getGstdetailcity().trim().length()>0)
				gstd.setCity(bean.getGstdetailcity());
				
			if(null!=bean.getGstdetailpincode() && bean.getGstdetailpincode().trim().length()>0)
				gstd.setPincode(Long.parseLong(bean.getGstdetailpincode()));
			
			if(null!=bean.getGstdetailcountry() && bean.getGstdetailcountry().trim().length()>0)
				gstd.setCountry(bean.getGstdetailcountry());
			
			if(null!=bean.getGstdetailauthorizedperson() && bean.getGstdetailauthorizedperson().trim().length()>0)
				gstd.setAuthorizedperson(bean.getGstdetailauthorizedperson());
			
			if(null!=bean.getGstdetailemailid() && bean.getGstdetailemailid().trim().length()>0)
				gstd.setEmailid(bean.getGstdetailemailid());
			
			if(null!=bean.getGstdetailtelephonenumber() && bean.getGstdetailtelephonenumber().trim().length()>0)
				gstd.setTelephonenumber(bean.getGstdetailtelephonenumber());
			
			if(null!=bean.getGstdetailisactive() && bean.getGstdetailisactive().trim().length()>0)
				gstd.setIsactive(bean.getGstdetailisactive());
			
			if(null!=bean.getGstdetailgstin_uidn_type() && bean.getGstdetailgstin_uidn_type().trim().length()>0)
				gstd.setGstinUidnType(bean.getGstdetailgstin_uidn_type());
			
			if(null!=bean.getGstdetailisdefault() && bean.getGstdetailisdefault().trim().length()>0)
				gstd.setIsdefault(bean.getGstdetailisdefault());
			
			session.save(gstd); 
			session.flush();
			transaction.commit();
			map.put("save_gstdata", "Saved Data Successfully");
			return map;
		}
		}catch (Exception e) {
			if (null != transaction) {
				transaction.rollback();
				map.put("error", e.getMessage());
			}
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.clear();
				session.close();
			}
		}
	 return map;
	}
	
	
	
	
	

	@Override
	public Map<String, Object> savePanBaseDetailDataHeader(SupplierPanbaseheaderBean headerdata) {
		Map<String, Object> map = new HashMap<String, Object>();
		Transaction transaction = null;
		Session session = emf.createEntityManager().unwrap(Session.class);
		try{
			transaction = session.beginTransaction();
			Suppliermasterpanbase panbase = new Suppliermasterpanbase();
			
			panbase = (Suppliermasterpanbase)session.get(Suppliermasterpanbase.class, headerdata.getPanpannumber());
			if(null!=headerdata.getPannsdlsuppliername() && headerdata.getPannsdlsuppliername().trim().length()>0)
				panbase.setNsdlsuppliername(headerdata.getPannsdlsuppliername());
			
			if(null!=headerdata.getPanregisteredaddress1() && headerdata.getPanregisteredaddress1().trim().length()>0)
				panbase.setAddress1(headerdata.getPanregisteredaddress1());
			
			if(null!=headerdata.getPanregisteredaddress2() && headerdata.getPanregisteredaddress2().trim().length()>0)
				panbase.setAddress2(headerdata.getPanregisteredaddress2());
			
			if(null!=headerdata.getPanregisteredaddress3() && headerdata.getPanregisteredaddress3().trim().length()>0)
				panbase.setAddress3(headerdata.getPanregisteredaddress3());
			
			if(null!=headerdata.getPanregisteredcity() && headerdata.getPanregisteredcity().trim().length()>0)
				panbase.setCity(headerdata.getPanregisteredcity());
			
			if(null!=headerdata.getPanregisteredpin() && headerdata.getPanregisteredpin().trim().length()>0)
				panbase.setPin(Integer.parseInt(headerdata.getPanregisteredpin()));
			
			if(null!=headerdata.getPanregisteredstate() && headerdata.getPanregisteredstate().trim().length()>0)
				panbase.setState(headerdata.getPanregisteredstate());
			
			if(null!=headerdata.getPancountry() && headerdata.getPancountry().trim().length()>0)
				panbase.setTelephonenumbers(headerdata.getPantelephonenumbers());
			
			if(null!=headerdata.getPanfaxnumbers() && headerdata.getPanfaxnumbers().trim().length()>0)
				panbase.setFaxnumbers(headerdata.getPanfaxnumbers());
			
			if(null!=headerdata.getPanemailid() && headerdata.getPanemailid().trim().length()>0)
				panbase.setEmailid(headerdata.getPanemailid());
			
			if(null!=headerdata.getPancontactperson() && headerdata.getPancontactperson().trim().length()>0)
				panbase.setContactperson(headerdata.getPancontactperson());
			
			
			session.save(panbase);
			session.flush();
			transaction.commit();
			map.put("saveheader", "SAVED Header DATA Successfully");
		   return map;
		}catch (Exception e) {
			if (null != transaction) {
				transaction.rollback();
				map.put("error","Error Occur During Save Data Please Contact IT");
			}
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.clear();
				session.close();
			}
		}
		 return map;
	}
	
	@Override
	public List<Map<String, Object>> getGstionDetailList(String srno, String pannumber,String gstin) {
		System.out.println(pannumber);
		List<Map<String, Object>> list = null; 
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getpandetailQuery)) {
				String query = getpandetailQuery + " and pannumber ='"+pannumber+"' and srno="+srno+" and gstin = '"+gstin+"' ";
				System.out.println(query);
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getsachsngrid(String pannumber) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getSACHSNgridQuary)) {
				String query = getSACHSNgridQuary + " and pannumber ='"+pannumber+"' ";
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getperslab(String type, String sachsn) {
		List<Map<String, Object>> list = null; 
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getSACHSNgridQuary,type,sachsn)) {
				String query  = getSACHSNgridQuary+" and gstsachsndetail.type='"+type+"' and gstsachsndetail.typecode ='"+sachsn+"' ";
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Map<String, Object> savesachsndata(SupplierHSNSACBean bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		Transaction transaction = null;
		Session session = emf.createEntityManager().unwrap(Session.class);
		try(Connection connection = ((SessionImpl) session).connection();) {
			transaction = session.beginTransaction();
			GstSacHsnDetail detail = new GstSacHsnDetail();
			GstSacHsnDetailId id = new GstSacHsnDetailId();
			String getMax = getMaxValue("mudra.gst_sac_hsn_detail", "srno", "where pannumber='"+bean.getPannumber()+"'");
			id.setPannumber(bean.getPannumber());
			
			String query ;
			if(MasterCommon.checkNullAndEmpty(bean.getSachsnsrno())) {
				query = getSACHSNgridQuary+" and pannumber = '"+bean.getPannumber()+"' and  typecode = '"+bean.getSachsncombo()+"' and typename='"+bean.getTypename()+"' and srno="+bean.getSachsnsrno()+" ";
			}
			else {
				query = getSACHSNgridQuary+" and pannumber = '"+bean.getPannumber()+"' and  typecode = '"+bean.getSachsncombo()+"' and typename='"+bean.getTypename()+"' ";
			}
				List<Map<String, Object>> list = null; 
				list = new QueryRunner().query(connection, query,new MapListHandler());
				if(list.size()>0)
				{
					map.put("DUPLICATE", "SAC/HSN Details Already Exist");
					return map;
				}
			
			
			if(null!=bean.getSachsnsrno() && bean.getSachsnsrno().trim().length()>0) {
				id.setSrno(Short.parseShort(bean.getSachsnsrno()));
				detail = (GstSacHsnDetail)session.get(GstSacHsnDetail.class, id);
			}
			else {
				id.setSrno(Short.parseShort(getMax));
				detail.setId(id);
			}
		
			detail.setCategory("E");
			
			
			if(null!=bean.getSactype() && bean.getSactype().trim().length()>0)
				detail.setType(bean.getSactype());
			
			if(null!=bean.getSachsncombo() && bean.getSachsncombo().trim().length()>0)
				detail.setTypecode(bean.getSachsncombo());
			
			if(null!=bean.getTypename() && bean.getTypename().trim().length()>0)
				detail.setTypename(bean.getTypename());
			/*
			if(bean.get){
				
			}*/
			detail.setIsactive("Y");
			
			session.save(detail);
			session.flush();
			transaction.commit();
			map.put("SAVE", "Save Data Successfully");
		   return map;
		}catch (Exception e) {
			if (null != transaction) {
				transaction.rollback();
				map.put("ERROR", e.getMessage());
			}
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.clear();
				session.close();
			}
		}
		 return map;
	}
	
	
	@Override
	public List<Map<String, Object>> geteditdateforsachsn(String srno, String pannumber) {
		List<Map<String, Object>> list = null; 
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getSACHSNgridQuary,srno,pannumber)) {
				String query  = getSACHSNgridQuary+" and gstsachsndetail.srno="+srno+" and gstsachsndetail.pannumber ='"+pannumber+"' ";
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
}







