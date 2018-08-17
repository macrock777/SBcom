package com.mudra.mboss.master.services.client;

import java.util.Map;

import com.mudra.mboss.master.bean.client.BrandMasterBean;
import com.mudra.security.bean.UserdetailBean;

public interface BrandmasterSaveService {
	
	public Map<String, Object> saveBrand(BrandMasterBean brandMasterBean);

	public Map<String, Object> completeSaveBrand(String clientid,UserdetailBean userdetailBean);
}
