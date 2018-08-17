package com.mudra.mboss.master.services.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.services.MasterCommonService;

@Service
public class MasterCommonServiceImpl implements MasterCommonService {

	@Autowired
	Environment env;
	
	@Autowired
	EntityManagerFactory emf;
	
	@Override
	public String getServerUrl() {
		try(Session session = emf.createEntityManager().unwrap(Session.class);) {
			String serverurlQuery = env.getProperty("master.serverurlQuery");
			if(null!=serverurlQuery && serverurlQuery.trim().length()>0) {
				NativeQuery<?> query = session.createNativeQuery(serverurlQuery);
				if(null!=query) {
					List<?> list = query.list();
					if(null!=list && !list.isEmpty())
						return null!=list.get(0)?(String)list.get(0):null;
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
