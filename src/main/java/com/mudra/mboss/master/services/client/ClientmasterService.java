package com.mudra.mboss.master.services.client;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.ClientSearchBean;
import com.mudra.security.bean.UserdetailBean;

@Service
public interface ClientmasterService {

	public List<Map<String, Object>> getClientSearchList(ClientSearchBean clientSearchBean);
	
	public List<Map<String, Object>> getServiceType();
	
	public List<Map<String, Object>> getClientType();
	
	public List<Map<String, Object>> getGSTClientType();
	
	public List<Map<String, Object>> getClientGrpList(UserdetailBean userdetailBean);
	
	public Map<String, Object> getGlCode(UserdetailBean userdetailBean);
	
	public List<Map<String, Object>> getStateList();
	
	public Map<String,Object> checkDupliacteClientId(String clientid,UserdetailBean userdetailBean);
	
	public Map<String,Object> checkDupliacteClientName(String clientname,UserdetailBean userdetailBean);
	
	public Map<String,Object> getClientDetail(String clientidhd,UserdetailBean userdetailBean);
	
	public List<Map<String,Object>> getBranches(String clientid);
	
	public List<Map<String,Object>> getClientList(String loginid,String uniqueid);
	
	public Map<String,Object> getStatePinMask(String statename);
	
	public Map<String,Object> getStatePinMaskUsingCode(String statecode);
}
