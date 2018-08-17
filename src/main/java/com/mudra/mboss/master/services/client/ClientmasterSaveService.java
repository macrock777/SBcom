package com.mudra.mboss.master.services.client;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.ClientMasterFileBean;
import com.mudra.mboss.master.bean.client.ClientmasterBean;

@Service
public interface ClientmasterSaveService {

	public Map<String,Object> saveClient(ClientmasterBean bean,ClientMasterFileBean fileBean);
	
}
