package com.mudra.mboss.master.services.supplier;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.supplier.SupplierDetailFileBean;
import com.mudra.mboss.master.bean.supplier.SupplierDetailmasterbean;



@Service
public interface SupplierDetailSavaService {
	
	public  Map<String, Object> saveSupplierDatail (SupplierDetailmasterbean bean,SupplierDetailFileBean fileBean);

}
