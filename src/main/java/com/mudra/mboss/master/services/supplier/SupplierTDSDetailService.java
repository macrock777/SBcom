package com.mudra.mboss.master.services.supplier;

import java.util.List;
import java.util.Map;

import com.mudra.mboss.master.bean.supplier.TdsDetailBean;
import com.mudra.security.bean.UserdetailBean;

public interface SupplierTDSDetailService {
	
	public List<Map<String,Object>> getTDSSectionDate(String startdate, String enddate);
	public List<Map<String,Object>> gettdsdetail(String supplierid,UserdetailBean bean);
	/*public Map<String, Object> saveTDSdetail(String supplierid,TdsDetailBean bean);
	public List<Map<String,Object>> gettdseditdata(String srno,String supplierid,UserdetailBean bean);*/
	
	
}
