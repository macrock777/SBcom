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
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.services.supplier.SupplierBankDetailService;


@Service
public class SupplierBankDetailServiceImpl implements SupplierBankDetailService{

	@Autowired
	EntityManagerFactory emf;
	
	@Value("${supplierdetail.getSupplierBankDataListQuery}")
	private String getSupplierBankDataListQuery;
	
	@Value("${supplierdetail.getsupplierBankDetailEditableQuery}")
	private String getsupplierBankDetailEditableQuery;
	
	@Override
	public List<Map<String, Object>> getSupplierBankDetailData(String supplierid, String uniqueid) {
		List<Map<String, Object>> list = null;
		Session session = emf.createEntityManager().unwrap(Session.class);
		try(Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getSupplierBankDataListQuery,uniqueid,supplierid)){
				String supplierBankdetailQuery = getSupplierBankDataListQuery;
				supplierBankdetailQuery += " AND supplierid = '"+supplierid+"' AND UNIQUEID = "+uniqueid+" ";
				list = new QueryRunner().query(connection, supplierBankdetailQuery, new MapListHandler());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Map<String, Object> getIfSupplierBankDetailisEditable(String mastercode) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = null;
		
		try(Session session = emf.createEntityManager().unwrap(Session.class);) {
			if(MasterCommon.checkNullAndEmpty(getsupplierBankDetailEditableQuery,mastercode)){
				String query = getsupplierBankDetailEditableQuery + " and mastercode='"+mastercode+"'";
					Query query1 = session.createNativeQuery(query);
					list  = query1.getResultList();
				if(list.size()>0){
					map.put("editable", "Yes");
					return map;
				}
				else{
					map.put("editable", "No");
					return map;
				}
			}
		} catch (Exception e) {
			map.put("editable", "Error Occur Please Contact IT");
			e.printStackTrace();
		}
		return map;
	}
}
