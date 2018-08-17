package com.mudra.mboss.master.services.client;

import java.util.List;
import java.util.Map;

import com.mudra.mboss.master.bean.client.PanbaseBean;
import com.mudra.mboss.master.bean.client.PanbaseheaderBean;

public interface PanBaseDetailService {
	public  Map<String, Object>  savePanBaseDetailData(PanbaseBean bean);
	public  Map<String, Object>  savePanBaseDetailDataHeader(PanbaseheaderBean bean);
	public List<Map<String ,Object>> getClientMastergstindetailList(String pannumber);
	public List<Map<String ,Object>> getGstionDetailList(String srno,String pannumber,String gstin);
	
	
	
	
}
