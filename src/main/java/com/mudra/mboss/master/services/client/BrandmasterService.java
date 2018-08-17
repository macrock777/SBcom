package com.mudra.mboss.master.services.client;

import java.util.List;
import java.util.Map;

import com.mudra.security.bean.UserdetailBean;

public interface BrandmasterService {

	public List<Map<String, Object>> getSectorList();
	
	public List<Map<String, Object>> getProductList(String sectorid);
	
	public List<Map<String,Object>> getBranchList(String clientid);
	
	public Map<String,Object> checkDuplicateBrandList(String clientid,String brandid, UserdetailBean userdetailBean);
	
	public List<Map<String, Object>> getStateList();
	
	public List<Map<String, Object>> getBrandList(String clientid,UserdetailBean userdetailBean);
	
	public Map<String, Object> showBrandDetail(String clientid,String brandid,UserdetailBean userdetailBean);
	
}
