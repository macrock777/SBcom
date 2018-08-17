package com.mudra.mboss.master.services.impl.client;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.ClientSearchBean;
import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.services.client.ClientmasterService;
import com.mudra.security.bean.UserdetailBean;

@Service
public class ClientmasterServiceImpl implements ClientmasterService {
	
	@Autowired
	EntityManagerFactory emf;
	
	@Value("${clientmaster.getClientSearchList}") 
	private String getClientSearchListQuery;
	
	@Value("${clientmaster.getServiceType}") 
	private String getServiceTypeQuery;
	
	@Value("${clientmaster.getClientType}") 
	private String getClientTypeQuery;
	
	@Value("${clientmaster.getGSTClientType}") 
	private String getGSTClientTypeQuery;
	
	@Value("${clientmaster.getClientGroup}") 
	private String getClientGroupQuery;
	
	@Value("${clientmaster.getGlcode}")
	private String getGlcodeQuery;
	
	@Value("${clientmaster.statelist}")
	private String getstatelistQuery;
	
	@Value("${clientmaster.checkduplicatedClientid}")
	private String checkduplicatedClientidQuery;
	
	@Value("${clientmaster.getClientDetail}")
	private String getClientDetailQuery;
	
	@Value("${clientmaster.getContractDetail}")
	private String getContractDetailQuery;
	
	@Value("${clientmaster.getClientList}")
	private String getClientListQuery;
	
	@Value("${clientmaster.getStatePinMask}")
	private String getStatePinMaskQuery;
	
	@Override
	public List<Map<String, Object>> getClientList(String loginid,String uniqueid) {
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(getClientListQuery,loginid,uniqueid)) {
				String sqlQuery = getClientListQuery;
				sqlQuery += " AND uniqueid = "+uniqueid+" "
						+ " ORDER BY CLIENTNAME ";
				return MasterCommon.queryRunner(connection, sqlQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> getBranches(String clientid) {
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(null!=clientid && clientid.trim().length()>0) {
				//String clientdetailQuery = " select to_char(uniqueid) AS uniqueid,branchname from mudra.branchmaster WHERE  ";
				String clientdetailQuery = " select to_char(uniqueid) AS uniqueid,branchname from MUDRA.branchmaster where uniqueid in (select distinct uniqueid from MUDRA.useraccessdetail where loginid='45' and formid=5102) and UNIQUEID NOT IN (SELECT UNIQUEID FROM MUDRA.CLIENTMASTER WHERE CLIENTID = '"+clientid+"' GROUP BY UNIQUEID,CLIENTID ) and nvl(isOperational,'Y')='Y' ";
				System.out.println(clientdetailQuery);
				return new QueryRunner().query(connection, clientdetailQuery, new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	public Map<String, Object> getClientDetail(String clientidhd,UserdetailBean userdetailBean) {
		Map<String, Object> map = null;
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(MasterCommon.checkNullAndEmpty(getClientDetailQuery,getContractDetailQuery,
					clientidhd,uniqueid)) {
				String clientdetailQuery = getClientDetailQuery;
				clientdetailQuery += " AND cm.clientid = '"+clientidhd+"' AND cm.UNIQUEID = "+uniqueid+" ";
				System.out.println(clientdetailQuery);
				List<Map<String, Object>> list = new QueryRunner().query(connection, clientdetailQuery, new MapListHandler());
				
				if(null!=list && !list.isEmpty()) {
					map = list.get(0);
				}
				
				clientdetailQuery = getContractDetailQuery;
				clientdetailQuery += " AND UNIQUEID = "+uniqueid+" AND CLIENTID = '"+clientidhd+"' ORDER BY SRNO DESC ";
				List<Map<String, Object>> list1 = new QueryRunner().query(connection, clientdetailQuery, new MapListHandler());
				if(null!=list1 && !list1.isEmpty()) {
					map = (map==null)?new HashMap<String, Object>():map;
					map.put("contractdetail",list1.get(0));
				}
				
				map = (map==null)?new HashMap<String, Object>():map;
				String sqlQuery = " SELECT UNIQUEID FROM MUDRA.CLIENTMASTER WHERE CLIENTID = '"+clientidhd+"' ";
				map.put("branchesopen",MasterCommon.queryRunner(connection, sqlQuery));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Map<String, Object>> getClientSearchList(ClientSearchBean clientSearchBean) {
		List<Map<String, Object>> list = null;
		String clientid = clientSearchBean.getClientid();
		String clientgroupid = clientSearchBean.getClientgroupid();
		String status = clientSearchBean.getStatus();
		String branchid = clientSearchBean.getBranchid();
		String uniqueid = clientSearchBean.getUniqueid();
		String pannumber = clientSearchBean.getPannumber();
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(MasterCommon.checkNullAndEmpty(getClientSearchListQuery,uniqueid)) {
				String clientListQuery = getClientSearchListQuery; 
				clientListQuery += " AND cm.UNIQUEID = "+uniqueid+" ";
				
				if(null!=clientgroupid && clientgroupid.trim().length()>0)
					clientListQuery += " AND UPPER(CM.CLIENTGROUPID) = UPPER('"+clientgroupid+"') ";
				
				if(null!=status && status.trim().length()>0)
					clientListQuery += " AND COALESCE(CM.ISACTIVE,'N') = '"+status+"' ";
				
				if(null!=branchid && branchid.trim().length()>0)
					clientListQuery += " AND CM.UNIQUEID = "+branchid+" ";
				
				if(null!=clientid && clientid.trim().length()>0)
					clientListQuery += " AND UPPER(CM.CLIENTID) = UPPER('"+clientid+"') ";
				
				if(null!=pannumber && pannumber.trim().length()>0)
					clientListQuery += " AND UPPER(CM.PANNUMBER) LIKE UPPER('%"+pannumber+"%') ";
				
				clientListQuery += " ORDER BY CM.CREATEDON DESC ";
				
				list = MasterCommon.queryRunner(connection, clientListQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> getServiceType() {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(MasterCommon.checkNullAndEmpty(getServiceTypeQuery)) {
				System.out.println(getServiceTypeQuery);
				list = new QueryRunner().query(connection, getServiceTypeQuery,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> getClientType() {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(MasterCommon.checkNullAndEmpty(getClientTypeQuery)) {
				System.out.println(getClientTypeQuery);
				list = new QueryRunner().query(connection, getClientTypeQuery,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getGSTClientType() {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(MasterCommon.checkNullAndEmpty(getGSTClientTypeQuery)) {
				System.out.println(getGSTClientTypeQuery);
				list = new QueryRunner().query(connection, getGSTClientTypeQuery,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getClientGrpList(UserdetailBean userdetailBean) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			String loginid = userdetailBean.getLoginid();
			if(MasterCommon.checkNullAndEmpty(getClientGroupQuery,uniqueid,loginid)) {
				String clientGroupQuery = getClientGroupQuery;
				clientGroupQuery += " AND uniqueid = "+uniqueid+" "
						+ " ORDER BY Clientgroupname ";
				System.out.println(clientGroupQuery);
				list = new QueryRunner().query(connection, clientGroupQuery,new MapListHandler());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Map<String, Object> getGlCode(UserdetailBean userdetailBean) {
		Map<String, Object> map = null;
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(MasterCommon.checkNullAndEmpty(getGlcodeQuery,uniqueid)) {
				String getGlcode = getGlcodeQuery;
				getGlcode += " AND UNIQUEID = "+uniqueid+" ";
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
	public Map<String, Object> checkDupliacteClientId(String clientid, UserdetailBean userdetailBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CLIENTID_AVAILABLE", "YES");
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(MasterCommon.checkNullAndEmpty(checkduplicatedClientidQuery,uniqueid)) {
				String checkduplicateclientid = checkduplicatedClientidQuery;
				checkduplicateclientid += " WHERE CLIENTID= '"+clientid+"' ";
				System.out.println(checkduplicateclientid);
				List<Map<String, Object>> list = new QueryRunner().query(connection, checkduplicateclientid,new MapListHandler());
				if(null==list || list.isEmpty()) {
					map.put("CLIENTID_AVAILABLE", "NO");
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> checkDupliacteClientName(String clientname,UserdetailBean userdetailBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CLIENTNAME_AVAILABLE", "YES");
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String uniqueid = userdetailBean.getUniqueid();
			if(MasterCommon.checkNullAndEmpty(checkduplicatedClientidQuery,uniqueid)) {
				String checkduplicateclientid = checkduplicatedClientidQuery;
				checkduplicateclientid += " WHERE CLIENTNAME= '"+clientname+"' ";
				System.out.println(checkduplicateclientid);
				List<Map<String, Object>> list = new QueryRunner().query(connection, checkduplicateclientid,new MapListHandler());
				if(null==list || list.isEmpty()) {
					map.put("CLIENTNAME_AVAILABLE", "NO");
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getStatePinMaskUsingCode(String statecode) {
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			if(MasterCommon.checkNullAndEmpty(statecode,getStatePinMaskQuery)) {
				String sqlQuery = getStatePinMaskQuery;
				sqlQuery += " AND CHARVALUE2 = '"+statecode+"' ";
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
}
