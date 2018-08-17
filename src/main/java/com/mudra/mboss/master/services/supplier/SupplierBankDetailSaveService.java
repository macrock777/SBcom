package com.mudra.mboss.master.services.supplier;

import java.util.Map;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.supplier.SupplierBankDetailBean;


@Service
public interface SupplierBankDetailSaveService {

	public Map<String, Object> saveSupplierBankdetailData(SupplierBankDetailBean bean);
	
}
