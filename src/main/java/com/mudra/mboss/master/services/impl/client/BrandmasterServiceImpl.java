package com.mudra.mboss.master.services.impl.client;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.services.client.BrandmasterService;
import com.mudra.security.bean.UserdetailBean;

@Service
public class BrandmasterServiceImpl implements BrandmasterService {

	@Autowired
	EntityManagerFactory emf;
	
	@Value("${brandmaster.sectorList}") 
	private String getSectorListQuery;
	
	@Value("${brandmaster.productList}")
	private String getProductListQuery;
	
	@Value("${brandmaster.branchList}")
	private String getBranchListQuery;
	
	@Value("${brandmaster.checkduplicatedBrandid}")
	private String checkduplicatedBrandidQuery;
	
	@Value("${brandmaster.statelist}")
	private String getstatelistQuery;
	
	@Value("${brandmaster.brandlist}")
	private String getbrandlistQuery;
	
	@Value("${brandmaster.branddetail}")
	private String getbranddetailQuery;
	
	@Override
	public List<Map<String, Object>> getSectorList() {
		List<Map<String, Object>> list = null;
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getSectorListQuery)) {
				String sqlQuery = getSectorListQuery;
				sqlQuery += " ORDER BY charvalue1 ";
				return MasterCommon.queryRunner(connection, sqlQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getProductList(String sectorid) {
		List<Map<String, Object>> list = null;
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getProductListQuery,sectorid)) {
				String listQuery = getProductListQuery;
				listQuery += " AND CHARVALUE1 = '"+sectorid+"' ";
				listQuery += " ORDER BY CHARVALUE2 ";
				list = new QueryRunner().query(connection, listQuery,new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> getBranchList(String clientid) {
		List<Map<String, Object>> list = null;
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getBranchListQuery,clientid)) {
				String listQuery = getBranchListQuery;
				//listQuery += " AND uniqueid = '"+uniqueid+"' ";
				listQuery += " and uniqueid IN (select distinct uniqueid from mudra.clientmaster where upper(clientid) = upper('"+clientid+"') ) ";
				System.out.println(listQuery);
				list = new QueryRunner().query(connection, listQuery,new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Map<String, Object> checkDuplicateBrandList(String clientid,String brandid, UserdetailBean userdetailBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("BRANDID_AVAILABLE", "YES");
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(MasterCommon.checkNullAndEmpty(checkduplicatedBrandidQuery,uniqueid,clientid,brandid)) {
				String checkduplicatebrandid = checkduplicatedBrandidQuery;
				checkduplicatebrandid += " AND BRANDID = '"+brandid+"' AND CLIENTID = '"+clientid+"' ";
				System.out.println(checkduplicatebrandid);
				BigDecimal count = new QueryRunner().query(connection, checkduplicatebrandid,new ScalarHandler<BigDecimal>());
				if(count.intValue() == 0) {
					map.put("BRANDID_AVAILABLE", "NO");
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getStateList() {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(MasterCommon.checkNullAndEmpty(getstatelistQuery)) {
				System.out.println(getstatelistQuery);
				list = new QueryRunner().query(connection, getstatelistQuery,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> getBrandList(String clientid,UserdetailBean userdetailBean) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(MasterCommon.checkNullAndEmpty(getbrandlistQuery)) {
				String brandlistQuery = getbrandlistQuery;
				System.out.println(brandlistQuery);
				brandlistQuery += " AND clientid = '"+clientid+"' AND uniqueid = "+uniqueid+" "; 
				list = new QueryRunner().query(connection, brandlistQuery,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

	@Override
	public Map<String, Object> showBrandDetail(String clientid, String brandid, UserdetailBean userdetailBean) {
		Map<String, Object> map = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(MasterCommon.checkNullAndEmpty(getbranddetailQuery,clientid,brandid,uniqueid)) {
				
				String brandlistQuery = getbranddetailQuery;
				brandlistQuery += " AND BRANDID = '"+brandid+"' AND uniqueid = "+uniqueid+" AND CLIENTID = '"+clientid+"' ";
				System.out.println(brandlistQuery);
				map = new QueryRunner().query(connection, brandlistQuery,new MapHandler());
				
				String sqlQuery = " SELECT UNIQUEID FROM MUDRA.BRANDMASTER WHERE BRANDID = '"+brandid+"' AND CLIENTID = '"+clientid+"' ";
				map.put("branchesopen",MasterCommon.queryRunner(connection, sqlQuery));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
