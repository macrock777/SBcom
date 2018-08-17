package com.mudra.mboss.master.services.impl.client;

import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletContext;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mudra.mboss.master.bean.client.ClientContracBean;
import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.entity.client.Clientmastercontractdetail;
import com.mudra.mboss.master.entity.client.ClientmastercontractdetailId;
import com.mudra.mboss.master.services.client.ContracmasterService;

@Service
public class ContracmasterServiceImpl implements ContracmasterService {
	
	@Value("${clientcontract.getContracListQuery}") 
	private String getContracListQuery;
	
	@Value("${clientcontractmaster.contractFileLocation}")
	private String contractFileLocation;
	
	@Value("${clientcontractmaster.editContracListQuery}")
	private String editContracListQuery;
	
	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	ServletContext context; 
	
	public SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	public SimpleDateFormat dateFormatSecond = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public List<Map<String, Object>> getClientContracDetail(String uniqueid, String clientid) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(MasterCommon.checkNullAndEmpty(getContracListQuery)) {
				System.out.println(getContracListQuery);
				String query = getContracListQuery + "and cmc.uniqueid ="+uniqueid+" and cmc.clientid ='"+clientid+"'";
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public List<Map<String, Object>> getEditClientContracDetail(String uniqueid, String clientid, String srno) {
		List<Map<String, Object>> list = null; 
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			
			if(MasterCommon.checkNullAndEmpty(editContracListQuery)) {
				System.out.println(editContracListQuery);
				String query = editContracListQuery + " and cmc.uniqueid ="+uniqueid+" and cmc.clientid ='"+clientid+"' and srno="+srno+" ";
				list = new QueryRunner().query(connection, query,new MapListHandler());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Map<String, Object> saveClientContracData(ClientContracBean bean, MultipartFile file) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("SAVE", "FAILED");
		String getMax ="";
		Session session = emf.createEntityManager().unwrap(Session.class);
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			ClientmastercontractdetailId id = new ClientmastercontractdetailId();
			Clientmastercontractdetail clientcontracd = new Clientmastercontractdetail();
			String uniqueid = bean.getUniqueid();
			String clientid = bean.getClientid();
			String srno = bean.getSrno();
			if(MasterCommon.checkNullAndEmpty(uniqueid,clientid)) {
				getMax = getMaxValue("mudra.clientmastercontractdetail", "srno", 
						"where clientid='"+clientid+"' and uniqueid = "+uniqueid+" ");
				
				id.setClientid(clientid);
				id.setUniqueid(Integer.parseInt(uniqueid));
				if(null!=srno && srno.trim().length()>0) {
					id.setSrno(Short.parseShort(srno));
					clientcontracd = (Clientmastercontractdetail)session.get(Clientmastercontractdetail.class, id); 
					getMax = bean.getSrno();
				} else {
					id.setSrno(Short.parseShort(getMax));
					clientcontracd.setId(id);
				}
					
					if(null!=bean.getContractype() && bean.getContractype().trim().length()>0)
						clientcontracd.setType(bean.getContractype());
					
					if(null!=bean.getBrandidcontrac() && bean.getBrandidcontrac().trim().length()>0)
						clientcontracd.setBrandid(bean.getBrandidcontrac());
					
					if(null!=bean.getContracdesc() && bean.getContracdesc().trim().length()>0)
						clientcontracd.setContractdesc(bean.getContracdesc());
					
				
					if(null!=bean.getStartenddate() && bean.getStartenddate().trim().length()>0) {
						String[] date = bean.getStartenddate().split("-");
						clientcontracd.setStartdate(dateFormat.parse(date[0].trim().toString()));
						clientcontracd.setEnddate(dateFormat.parse(date[1].trim().toString()));
					}
					
					if(null!=bean.getTerminationclause() && bean.getTerminationclause().trim().length()>0)
						clientcontracd.setTerminationclause(bean.getTerminationclause());
					
					if(null!=bean.getRevenuefees() && bean.getRevenuefees().trim().length()>0)
						clientcontracd.setRevenuefees(Double.parseDouble(bean.getRevenuefees()));
					
					if(null!=bean.getIsalertrequired() && bean.getIsalertrequired().trim().length()>0)
						clientcontracd.setIsalertrequired(bean.getIsalertrequired());
					
					if(null!=bean.getAlertinterval() && bean.getAlertinterval().trim().length()>0)
						clientcontracd.setAlertinterval(bean.getAlertinterval());
					
					if(null!=bean.getAlertenddate() && bean.getAlertenddate().trim().length()>0) {
						clientcontracd.setAlertenddate(dateFormatSecond.parse(bean.getAlertenddate()));
					}
					
					if(null!=bean.getContracisactive() && bean.getContracisactive().trim().length()>0)
						clientcontracd.setIsactive(bean.getContracisactive());
					
					if(null!=bean.getRevenuesupervision() && bean.getRevenuesupervision().length()>0) 
						clientcontracd.setRevenuesupervision(Double.parseDouble(bean.getRevenuesupervision()));
					
					if(null!=bean.getRevenueothers() && bean.getRevenueothers().length()>0) 
						clientcontracd.setRevenueothers(Double.parseDouble(bean.getRevenueothers()));
					
					clientcontracd.setIsactive("Y");
					
					if(null!=file) {
					File contrfilefile = MasterCommon.convert(file);					
						String path = MasterCommon.uploadFile(contrfilefile,contrfilefile.getName(),contractFileLocation,uniqueid+"_"+bean.clientid+"CONTR"+getMax,context.getRealPath(""));
						clientcontracd.setContractfile(path);
					}
					
					if(null!=srno && srno.trim().length()>0)
						session.update(clientcontracd);
					else
						session.save(clientcontracd);
					
					session.flush();
					transaction.commit();
					map.put("SAVE", "SUCCESSFULLY");
			}
				
		} catch (Exception e) {
			if(null!=transaction) {
				System.out.println("Transaction Rollback");
				transaction.rollback();
			}
			map.put("REASON", e.getMessage());
			e.printStackTrace();
		}finally {
			if(null!=session) {
				session.clear();
				session.close();
			}	
		}
		return map;
	}
	
	
	//Max+1 Query 
			public String getMaxValue(String tablename,  String columnname, String whereClause){		//  if  where cluse is null then pass as  ->  "" or  null
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
				try{
					//logger.error(strQuery);
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
	
	
}
