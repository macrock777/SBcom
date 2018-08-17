package com.mudra.mboss.master.services.impl.client;

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
import com.mudra.mboss.master.bean.client.PanbaseBean;
import com.mudra.mboss.master.bean.client.PanbaseheaderBean;
import com.mudra.mboss.master.entity.client.Clientmastergstindetail;
import com.mudra.mboss.master.entity.client.ClientmastergstindetailId;
import com.mudra.mboss.master.entity.client.Clientmasterpanbased;
import com.mudra.mboss.master.services.client.PanBaseDetailService;

@Service
public class PanBaseDetailServiceImpl implements PanBaseDetailService {
	@Autowired
	EntityManagerFactory emf;

	@Value("${clientmasterpanbase.getpandetail}")
	private String getpandetailQuery;
	
	@Override
	public Map<String, Object> savePanBaseDetailData(PanbaseBean bean) {
			Map<String, Object> map = null ;
			try {
				map = new HashMap<String, Object>();
				if(saveClientMasterGstin(bean)) {
					map.put("SAVE", "SUCCESSFULLY");
					return map;
				}
				else {
					map.put("SAVE", "FAILED");
					return map;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return map;
		}
	
	
	@Override
	public Map<String, Object> savePanBaseDetailDataHeader(PanbaseheaderBean bean) {
		Map<String, Object> map = null ;
		try {
			map = new HashMap<String, Object>();
			if(saveClientMasterHeader(bean)) {
				map.put("SAVE", "SUCCESSFULLY");
				return map;
			}
			else {
				map.put("SAVE", "FAILED");
				return map;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	public boolean saveClientMasterHeader(PanbaseheaderBean headerdata) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			Clientmasterpanbased panbase = new Clientmasterpanbased();
			
			panbase = (Clientmasterpanbased)session.get(Clientmasterpanbased.class, headerdata.getPanpannumber());
			
			if(null!=headerdata.getPannsdlclientname() && headerdata.getPannsdlclientname().trim().length()>0)
				panbase.setNsdlclientname(headerdata.getPannsdlclientname());
			
			if(null!=headerdata.getPanregisteredaddress1() && headerdata.getPanregisteredaddress1().trim().length()>0)
				panbase.setRegisteredaddress1(headerdata.getPanregisteredaddress1());
			
			if(null!=headerdata.getPanregisteredaddress2() && headerdata.getPanregisteredaddress2().trim().length()>0)
				panbase.setRegisteredaddress2(headerdata.getPanregisteredaddress2());
			
			if(null!=headerdata.getPanregisteredaddress3() && headerdata.getPanregisteredaddress3().trim().length()>0)
				panbase.setRegisteredaddress3(headerdata.getPanregisteredaddress3());
			
			if(null!=headerdata.getPanregisteredcity() && headerdata.getPanregisteredcity().trim().length()>0)
				panbase.setRegisteredcity(headerdata.getPanregisteredcity());
			
			if(null!=headerdata.getPanpannumber() && headerdata.getPanpannumber().trim().length()>0)
				panbase.setRegisteredpin(headerdata.getPanpannumber());
			
			if(null!=headerdata.getPanregisteredstate() && headerdata.getPanregisteredstate().trim().length()>0)
				panbase.setRegisteredstate(headerdata.getPanregisteredstate());
			
			if(null!=headerdata.getPancountry() && headerdata.getPancountry().trim().length()>0)
				panbase.setTelephonenumbers(headerdata.getPantelephonenumbers());
			
			if(null!=headerdata.getPanfaxnumbers() && headerdata.getPanfaxnumbers().trim().length()>0)
				panbase.setFaxnumbers(headerdata.getPanfaxnumbers());
			
			if(null!=headerdata.getPanemailid() && headerdata.getPanemailid().trim().length()>0)
				panbase.setEmailid(headerdata.getPanemailid());
			
			if(null!=headerdata.getPancontactperson() && headerdata.getPancontactperson().trim().length()>0)
				panbase.setContactperson(headerdata.getPancontactperson());
			
			if(null!=panbase)
				session.update(panbase);
			
			session.flush();
			transaction.commit();
			return true;
		} catch (Exception e) {
			if(null!=transaction)
				transaction.rollback();
			e.printStackTrace();
			return false;
		}finally {
			if(null!=session) {
				session.clear();
				session.close();
			}	
		}
	}
	
	public boolean saveClientMasterGstin(PanbaseBean bean) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		Transaction transaction = null;
		try{
			
			Clientmastergstindetail gstd = new Clientmastergstindetail();
			ClientmastergstindetailId id = new ClientmastergstindetailId();
			String gstindetailsrno = bean.getGstindetailsrno();
			
			if(MasterCommon.checkNullAndEmpty(bean.getGstdetailgstin())) {
				transaction = session.beginTransaction();
				String getMax = getMaxValue("mudra.clientmastergstindetail", "srno", 
						"where pannumber='"+bean.getGstdetailgstin()+"' and gstin='"+bean.getGstdetailgstin()+"'");
				id.setGstin(bean.getGstdetailgstin());
				id.setPannumber(bean.getGstdetailgstin().substring(2,12));
					
				if(null==gstindetailsrno || gstindetailsrno.trim().length()==0) {
					id.setSrno(Byte.parseByte(getMax));
					gstd.setId(id);
				}else{
					id.setSrno(Byte.parseByte(gstindetailsrno));
					gstd = (Clientmastergstindetail)session.get(Clientmastergstindetail.class, id);
				}
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
				String active = bean.getGstdetailisactive();
				if(null!=gstd && null!=gstindetailsrno && gstindetailsrno.trim().length()>0) {
					if(null!=active && active.trim().length()>0)
						gstd.setIsactive(active);
					
					session.update(gstd);
				}else if(null!=gstd) {
					gstd.setIsactive("Y");
					session.save(gstd);
				}
				
				session.flush();
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			if(null!=transaction)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(null!=session) {
				session.clear();
				session.close();
			}	
		}
		return false;
	}
	
	
	
	public List<?> getDataFromQuery(String strQuery) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		try{
			//logger.error(strQuery);
			//SQLQuery query = session.createSQLQuery(strQuery);
			Query query = session.createNamedQuery(strQuery);
			List<?> dataList = query.getResultList();
			return dataList;
		}catch(Exception ex){
			if(ex.getMessage().toLowerCase().equals("could not execute query"))
			ex.printStackTrace();
		}finally{
			if(null!=session)
				session.clear();
		}
		return null;
	}    

	public String getMaxValue(String tablename,  String columnname, String whereClause){		//  if  where cluse is null then pass as  ->  "" or  null
		try{
				String strQuery ="SELECT  NVL(MAX("+columnname+") ,0)+1 FROM  "+tablename; 
				if(null!=whereClause &&  whereClause.trim().length()>0)
					strQuery += " "+whereClause;
				
				System.out.println(strQuery);
				List<?> maxPlusValList = getDataFromQuery(strQuery);
				if(null!=maxPlusValList && !maxPlusValList.isEmpty()) {
					return maxPlusValList.get(0).toString();
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "0";
	}

	@Override
	public List<Map<String, Object>> getClientMastergstindetailList(String pannumber) {
		
		System.out.println(pannumber);
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getpandetailQuery)) {
				String query = getpandetailQuery + " and pannumber ='"+pannumber+"'";
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getGstionDetailList(String srno, String pannumber,String gstin) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getpandetailQuery)) {
				String query = getpandetailQuery + " and pannumber ='"+pannumber+"' and srno="+srno+" and gstin = '"+gstin+"' ";
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}




		



