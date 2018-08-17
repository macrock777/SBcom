package com.mudra.mboss.master.services.supplier;

import java.util.List;
import java.util.Map;

import com.mudra.mboss.master.bean.supplier.SupplierHSNSACBean;
import com.mudra.mboss.master.bean.supplier.SupplierPanbaseBean;
import com.mudra.mboss.master.bean.supplier.SupplierPanbaseheaderBean;



public interface SupplierPANBaseService {
	public List<Map<String,Object>> gethsnsac(String stype);
	public List<Map<String,Object>> getSupplierData(String uniqueid,String supplieid);
	public List<Map<String,Object>> getSupplierData1(String pannumber);
	public List<Map<String,Object>> getgstdetail(String pannumber);
	public  Map<String, Object>  savePanBaseDetailData(SupplierPanbaseBean bean);
	public  Map<String, Object>  savePanBaseDetailDataHeader(SupplierPanbaseheaderBean bean);
	public List<Map<String ,Object>> getGstionDetailList(String srno,String pannumber,String gstin);
	public List<Map<String ,Object>> getsachsngrid(String pannumber);
	public List<Map<String ,Object>> getperslab(String type,String sachsn);
	public  Map<String, Object>  savesachsndata(SupplierHSNSACBean bean);
	public List<Map<String ,Object>> geteditdateforsachsn(String srno,String pannumber);
	
	
	
	
	
	
	
}
