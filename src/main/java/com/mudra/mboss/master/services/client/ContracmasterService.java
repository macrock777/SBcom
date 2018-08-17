package com.mudra.mboss.master.services.client;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mudra.mboss.master.bean.client.ClientContracBean;

@Service
public interface ContracmasterService {
	
	public List<Map<String ,Object>> getClientContracDetail(String uniqueid,String clientid);
	
	public Map<String, Object>  saveClientContracData(ClientContracBean bean,MultipartFile file);

	public List<Map<String ,Object>> getEditClientContracDetail(String uniqueid,String clientid,String srno);

}
