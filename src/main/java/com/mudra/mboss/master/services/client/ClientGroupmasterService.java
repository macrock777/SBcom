package com.mudra.mboss.master.services.client;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface ClientGroupmasterService {
	
	public List<Map<String ,Object>> getClientGroupList(String uniqueid,String clientgroupid);

}
