package com.mudra.mboss.master.restcontroller.supplier;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mudra.mboss.master.bean.supplier.SupplierBankDetailBean;
import com.mudra.mboss.master.services.supplier.SupplierBankDetailSaveService;
import com.mudra.mboss.master.services.supplier.SupplierBankDetailService;


@RestController
public class SupplierBankDetailRestController 
{
	@Autowired
	SupplierBankDetailSaveService bankDetailSaveService;
	
	@Autowired
	SupplierBankDetailService supplierBankDetailService;
	
	@RequestMapping(value= {"/supplierMastersaveBankDetail"},method=RequestMethod.POST)
	public Map<String, Object> saveSupplierBankdetailData(@RequestBody SupplierBankDetailBean bean) 
	{
		return bankDetailSaveService.saveSupplierBankdetailData(bean);
	}
	
	
	@RequestMapping(value= {"/getsupplierbankdetails/{supplierid}/{uniqueid}"},method=RequestMethod.GET)
	public List<Map<String, Object>> getSupplierBankDetailData(@PathVariable("uniqueid") String uniqueid,@PathVariable("supplierid") String supplierid)
	{
		return supplierBankDetailService.getSupplierBankDetailData(supplierid,uniqueid);
	}
	
	@RequestMapping(value= {"/getifsupplierbankdetailiseditable/{mastercode}"},method=RequestMethod.GET)
	public Map<String, Object> getIfSupplierBankDetailisEditable(@PathVariable("mastercode") String mastercode)
	{
		return supplierBankDetailService.getIfSupplierBankDetailisEditable(mastercode);
	}
}
