package com.mudra.mboss.master.services.client;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.OtherDetailMasterBean;

@Service
public interface OtherDetailmasterService {
	public  Map<String, Object> saveOtherClientMasterData(OtherDetailMasterBean bean); 
	public  Map<String, Object> getOtherClientMasterData(String uniqueid,String clientid); 
}
