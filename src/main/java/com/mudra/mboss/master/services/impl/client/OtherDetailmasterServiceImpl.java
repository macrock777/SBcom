package com.mudra.mboss.master.services.impl.client;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.bean.client.OtherDetailMasterBean;
import com.mudra.mboss.master.entity.client.Clientmaster;
import com.mudra.mboss.master.entity.client.ClientmasterId;
import com.mudra.mboss.master.services.client.OtherDetailmasterService;

@Service
public class OtherDetailmasterServiceImpl implements OtherDetailmasterService {
	@Autowired
	EntityManagerFactory emf;
	
	@Value("${clientmaster.getOtherDetail}")
	private String getOtherDetailQuery;
	
	@Override
	public  Map<String, Object>  saveOtherClientMasterData(OtherDetailMasterBean bean) {
		Map<String, Object> map = null ;
		try {
			map = new HashMap<String, Object>();
			if(saveclientOtherData(bean)) {
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
	
	
	public boolean saveclientOtherData(OtherDetailMasterBean bean) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		Transaction transaction = session.beginTransaction();
		try{
			Clientmaster client = new Clientmaster(); 
			ClientmasterId id = new ClientmasterId();
			String clientid = bean.getClientid();
			String uniqueid = bean.getUniqueid();
			
			if(null!=clientid && clientid.trim().length()>0 && MasterCommon.isNumeric(uniqueid)) {
				
				id.setClientid(clientid);
				id.setUniqueid(Integer.parseInt(uniqueid));
				
				client = (Clientmaster)session.get(Clientmaster.class, id);
				
				if(null!=client) {
					
					if(null!=bean.getSupplierid() && bean.getSupplierid().trim().length()>0)
						client.setSupplierid(bean.getSupplierid());
					
					if(null!=bean.getChequebank() && bean.getChequebank().trim().length()>0)
						client.setChequebank(bean.getChequebank());
					
					if(null!=bean.getChequebranch() && bean.getChequebranch().trim().length()>0)
						client.setChequebranch(bean.getChequebranch());
					
					if(null!=bean.getTimesheetdisplay() && bean.getTimesheetdisplay().trim().length()>0)
						client.setTimesheetdisplay(bean.getTimesheetdisplay());
					
					if(null!=bean.getStampdutyapplicable() && bean.getTimesheetdisplay().trim().length()>0)
						client.setStampdutyapplicable(bean.getStampdutyapplicable());
					
					if(null!=bean.getIsapprovalinsertiondate() && bean.getIsapprovalinsertiondate().trim().length()>0)
						client.setIsapprovalinsertiondate(bean.getIsapprovalinsertiondate());
					
					if(null!=bean.getStampcharg() && bean.getStampcharg().trim().length()>0)
						client.setStampcharg(Double.parseDouble(bean.getStampcharg()));
					
					if(null!=bean.getPannumber() && bean.getPannumber().trim().length()>0)
						client.setPannumber(bean.getPannumber());
	
					if(null!=bean.getClientcountry() && bean.getClientcountry().trim().length()>0)
						client.setCountry(bean.getClientcountry());
					
					session.update(client);
					session.flush();
					transaction.commit();
					return true;
					
				}
			}
		
		} catch (Exception e) {
			if(null!=transaction) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if(null!=session)
				session.clear();
		}
		return false;
	}

	@Override
	public Map<String, Object> getOtherClientMasterData(String uniqueid, String clientid) {
		Map<String, Object> map = null;
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(MasterCommon.checkNullAndEmpty(uniqueid,clientid,getOtherDetailQuery)) {
				String sqlQuery = getOtherDetailQuery;
				sqlQuery += " AND CLIENTID = '"+clientid+"' AND UNIQUEID = "+uniqueid+" ";
				List<Map<String, Object>> list = MasterCommon.queryRunner(connection, sqlQuery);
				
				if(null!=list && !list.isEmpty()) {
					map = list.get(0);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
