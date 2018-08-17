package com.mudra.mboss.master.services.impl.client;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.services.client.ClientGroupmasterService;

@Service
public class ClientGroupmasterServiceImpl implements ClientGroupmasterService {
	@Autowired
	EntityManagerFactory emf;
	
	@Value("${clientgroup.getClientGroupListQuery}") 
	private String getClientGroupListQuery;
	
	
	public ClientGroupmasterServiceImpl() {
		System.out.println(getClientGroupListQuery);
	}

	@Override
	public List<Map<String, Object>> getClientGroupList(String uniqueid,String clientgroupid) {
		List<Map<String,Object>> list =null;
		try(Session session = emf.createEntityManager().unwrap(Session.class);
				Connection connection = ((SessionImpl) session).connection();) {
			String query = getClientGroupListQuery +""+" where uniqueid = "+uniqueid+" and clientgroupid ='"+clientgroupid+"'";
			System.out.println(query);
			list = new QueryRunner().query(connection,query,new MapListHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	


}
