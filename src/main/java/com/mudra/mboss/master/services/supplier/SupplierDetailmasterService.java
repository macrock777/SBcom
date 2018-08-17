package com.mudra.mboss.master.services.supplier;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mudra.mboss.master.bean.supplier.SupplierChangePanBean;
import com.mudra.mboss.master.bean.supplier.SuppliersearchBean;
import com.mudra.security.bean.UserdetailBean;

@Service
public interface SupplierDetailmasterService {
	public List<Map<String, Object>> getSuppliertype();
	public List<Map<String, Object>> getStateList();
	public List<Map<String, Object>> getGstVenterType();
	public Map<String,Object> checkDupliacteSupplierId(String supplierid,UserdetailBean userdetailBean);
	public Map<String,Object> checkDupliacteSupplierName(String suppliername,UserdetailBean userdetailBean);
	public Map<String, Object> getGlCode(UserdetailBean userdetailBean);
	public List<Map<String,Object>> getBranches(String clientid);
	public Map<String,Object> checkDuplicateNewGroupid(String suppliergrpid,UserdetailBean userdetailBean);
	public Map<String,Object> checkDuplicateNewGroupName(String suppliergrpname,UserdetailBean userdetailBean);
	public List<Map<String,Object>> getsupplierlist(String uniqueid,String suppliergroupid);
	public List<Map<String,Object>> getsupplierserchlist(SuppliersearchBean bean);
	public List<Map<String,Object>> getsupplieridforedit(String supplierid,String unqueid);
	public Map<String,Object> savechangepan(SupplierChangePanBean bean,MultipartFile file);
	public Map<String,Object> getStatePinMask(String statename);
	public Map<String,Object> getSupplierchange(String loginid);
	public InputStream downloadFile(HttpServletResponse response,String uniqueid,String clientid,String filetype,String serverUrl);
	public Map<String,Object> uploadSupplierExcel(MultipartFile uploadopenexceldata);

}
