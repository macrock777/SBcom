package com.mudra.mboss.master.services.impl.item;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.mudra.mboss.master.bean.MasterCommon;
import com.mudra.mboss.master.bean.item.Itemsearchbean;
import com.mudra.mboss.master.services.item.ItemmasterService;

@Service
public class ItemmasterServiceImpl implements ItemmasterService {

	@Autowired
	EntityManagerFactory emf;

	@Autowired
	private Environment env;

	@Override
	public List<Map<String, Object>> getitemsearchList(Itemsearchbean itemsearchbean) {

		String groupitemcodeid = itemsearchbean.getGroupitemcodeid();
		String itemtypeid = itemsearchbean.getItemtypeid();
		String itemstatus = itemsearchbean.getItemstatus();
		String itemcode = itemsearchbean.getItemcode();
		String whereclause = "";

		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String sqlQuery = env.getProperty("itemmaster.getitemlist");
			if (MasterCommon.checkNullAndEmpty(sqlQuery)) {
				if (MasterCommon.checkNullAndEmpty(groupitemcodeid))
					whereclause += " AND im.GROUPITEMCODE = '" + groupitemcodeid + "'";
				if (MasterCommon.checkNullAndEmpty(itemtypeid))
					whereclause += " AND im.STOCKORSERVICE = '" + itemtypeid + "'";
				if (MasterCommon.checkNullAndEmpty(itemstatus))
					whereclause += " AND im.ISACTIVE = '" + itemstatus + "'";
				if (MasterCommon.checkNullAndEmpty(itemcode))
					whereclause += " AND im.itemcode = '" + itemcode + "'";
				sqlQuery += whereclause +" ORDER BY im.CREATEDON desc";
				return MasterCommon.queryRunner(connection, sqlQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> getgroupItemcodeList() {
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String sqlQuery = env.getProperty("itemmaster.getgroupitemlist");
			return MasterCommon.queryRunner(connection, sqlQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> getitemtypeList() {
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String sqlQuery = env.getProperty("itemmaster.getgroupitemlist");
			return MasterCommon.queryRunner(connection, sqlQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> getunitList() {
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String sqlQuery = env.getProperty("itemmaster.getunitlist");
			return MasterCommon.queryRunner(connection, sqlQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> getincomeglcodeList(String uniqueid) {
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String sqlQuery = env.getProperty("itemmaster.getincomeglcodelist");
			if (MasterCommon.checkNullAndEmpty(sqlQuery, uniqueid)) {
				if(!uniqueid.substring(2, 4).equals("01") && !uniqueid.substring(2,4).equals("03"))
					sqlQuery += " AND  SUBSTR(GLCODE,1,2)=SUBSTR('\" + uniqueid + \"',1,2)"; 
				sqlQuery += " AND LENGTH(GLCODE)=" + getLengthdiv(uniqueid)
						+ "  ORDER BY GLNAME";
				return MasterCommon.queryRunner(connection, sqlQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> getexpenseglcodeList(String uniqueid) {
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String sqlQuery = env.getProperty("itemmaster.getexpenseglcode");
			if (MasterCommon.checkNullAndEmpty(sqlQuery, uniqueid)) {
				if(!uniqueid.substring(2, 4).equals("01") && !uniqueid.substring(2,4).equals("03"))
					sqlQuery += " AND  SUBSTR(GLCODE,1,2)=SUBSTR('\" + uniqueid + \"',1,2)";
				sqlQuery += " AND LENGTH(GLCODE)=" + getLengthdiv(uniqueid)
						+ "  ORDER BY GLNAME";
				return MasterCommon.queryRunner(connection, sqlQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getLengthdiv(String uniqueid){
		int lengthdiv = 5;
		System.out.println(uniqueid);
		int divcode = Integer.parseInt(uniqueid.substring(2, 4));
		if(divcode != 1 && divcode !=3){
			lengthdiv = lengthdiv + String.valueOf(divcode).length();
		}
		return lengthdiv;
	}
}
