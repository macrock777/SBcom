package com.mudra.mboss.master.services.supplier;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface SupplierBankDetailService 
{
	public List<Map<String, Object>> getSupplierBankDetailData(String supplierid, String uniqueid);
	public Map<String, Object> getIfSupplierBankDetailisEditable(String mastercode);
}
