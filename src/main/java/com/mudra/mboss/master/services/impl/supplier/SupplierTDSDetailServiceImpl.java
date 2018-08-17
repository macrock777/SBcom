package com.mudra.mboss.master.services.impl.supplier;

import java.sql.Connection;
import java.text.SimpleDateFormat;
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
import com.mudra.mboss.master.bean.supplier.TdsDetailBean;
import com.mudra.mboss.master.entity.supplier.Suppliermaster;
import com.mudra.mboss.master.entity.supplier.SuppliermasterId;
import com.mudra.mboss.master.entity.supplier.Suppliermastertdsdetail;
import com.mudra.mboss.master.entity.supplier.SuppliermastertdsdetailId;
import com.mudra.mboss.master.services.supplier.SupplierTDSDetailService;
import com.mudra.security.bean.UserdetailBean;

@Service
public class SupplierTDSDetailServiceImpl implements SupplierTDSDetailService {

	@Value("${supplierdetail.tdssetionquery}")
	private String tdssetionquery;

	@Value("${supplierdetail.tdsgriddetail}")
	private String tdsgriddetail;

	@Value("${supplierdetail.gettdseditdata}")
	private String gettdseditdata;

	@Autowired
	EntityManagerFactory emf;

	public SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	public SimpleDateFormat dateFormatSecond = new SimpleDateFormat("dd/MM/yyyy");


	@Override
	public List<Map<String, Object>> getTDSSectionDate(String startdate, String enddate) {
		List<Map<String, Object>> list = null;
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if (MasterCommon.checkNullAndEmpty(tdssetionquery)) {
				String str = tdssetionquery + " and (NVL (EFFECTIVETODATE, To_DATE('" + startdate
						+ "','YYYY-MM-DD'))) >= To_date('" + enddate + "','YYYY-MM-DD')  and nvl(isactive,'Y')='Y' ";
				list = new QueryRunner().query(connection, str, new MapListHandler());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> gettdsdetail(String supplierid, UserdetailBean bean) {
		List<Map<String, Object>> list = null;
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if (MasterCommon.checkNullAndEmpty(tdsgriddetail)) {
				String str = tdsgriddetail + " and sm.supplierid= '" + supplierid + "' and sm.Uniqueid =" + bean.getUniqueid()
						+ "";
				list = new QueryRunner().query(connection, str, new MapListHandler());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}




public List<?> getDataFromQuery(String strQuery,Session session) {
		
		try{
			//logger.error(strQuery);
			Query query = session.createNativeQuery(strQuery);
			List<?> dataList = query.getResultList();
			return dataList;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	

	public String getMaxValue(String tablename,  String columnname, String whereClause,Session session){	 //  if  where cluse is null then pass as  ->  "" or  null
		try{
		String strQuery ="SELECT  NVL(MAX("+columnname+") ,0)+1 FROM  "+tablename; 
		if(null!=whereClause &&  whereClause.trim().length()>0)
		strQuery += " "+whereClause;
		List<?> maxPlusValList = getDataFromQuery(strQuery,session);
		if(null!=maxPlusValList && !maxPlusValList.isEmpty())
		return maxPlusValList.get(0).toString();
		}catch(Exception e){
		e.printStackTrace();
		}
		return "0";
		}
	
}
