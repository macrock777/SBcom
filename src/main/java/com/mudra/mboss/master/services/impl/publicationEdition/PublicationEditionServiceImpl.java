package com.mudra.mboss.master.services.impl.publicationEdition;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.MasterCommon;
import com.mudra.mboss.master.bean.publicationEdition.PublicationEditionSearchBean;
import com.mudra.mboss.master.services.publicationEdition.PublicationEditionService;

@Service
public class PublicationEditionServiceImpl implements PublicationEditionService{
	
	@Autowired
	EntityManagerFactory emf;

	@Autowired
	private Environment env;

	@Override
	public List<Map<String, Object>> getpublicationsearchlist(PublicationEditionSearchBean publicationEditionSearchBean) {
		String uniqueid = publicationEditionSearchBean.getUniqueid();
		String supplierGroup = publicationEditionSearchBean.getSuppliergroup();
		String publication = publicationEditionSearchBean.getPublication();
		String edition = publicationEditionSearchBean.getEdition();
		String language = publicationEditionSearchBean.getLanguage();
		String isActive = publicationEditionSearchBean.getIsactive();
		
		String whereclause = "";
		
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String sqlQuery = env.getProperty("publicationEdition.getpublicationList");
			if (MasterCommon.checkNullAndEmpty(sqlQuery,uniqueid)) {
				if (MasterCommon.checkNullAndEmpty(uniqueid))
					whereclause += " AND a.uniqueid = '" + uniqueid + "'";
				if (MasterCommon.checkNullAndEmpty(supplierGroup))
					whereclause += " AND a.suppliergroupid = '" + supplierGroup + "'";
				
				if (MasterCommon.checkNullAndEmpty(publication))
					whereclause += " AND b.supplierid = '" + publication + "'";
				if (MasterCommon.checkNullAndEmpty(edition))
					whereclause += " AND c.editionid = '" + edition + "'";
				if (MasterCommon.checkNullAndEmpty(language))
					whereclause += " AND c.LANGUAGE = '" + language + "'";
				if (MasterCommon.checkNullAndEmpty(isActive))
					whereclause += " AND b.isactive = '" + isActive + "'";
				sqlQuery += whereclause +" ORDER BY a.CREATEDON desc";
				return MasterCommon.queryRunner(connection, sqlQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> geteditionsearchlist(String uniqueid, String supplierid) {
		try (Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String sqlQuery = env.getProperty("publicationEdition.geteditionList");
			if (MasterCommon.checkNullAndEmpty(sqlQuery,uniqueid,supplierid)) {
				sqlQuery += "and uniqueid ="+uniqueid+" and supplierid ='"+supplierid+"' ORDER BY CREATEDON desc";
				return MasterCommon.queryRunner(connection, sqlQuery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> getmaxeditionid(String uniqueid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try (Session session = emf.createEntityManager().unwrap(Session.class);) {
			if(MasterCommon.checkNullAndEmpty(uniqueid))
			{
				String sqlQuery = "select max(editionid)+1 maxnumber from mudra.editionmaster where uniqueid ="+uniqueid;
				Query query = session.createNativeQuery(sqlQuery);
				List<?> list = query.getResultList();
				int Maxnumber = Integer.parseInt(list.get(0).toString());
				map.put("maxnumber", Maxnumber);
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("maxnumber", null);
		return map;
	}


}
