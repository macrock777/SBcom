package com.mudra.mboss.master.restcontroller.supplier;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mudra.mboss.master.bean.supplier.SupplierHSNSACBean;
import com.mudra.mboss.master.bean.supplier.SupplierPanbaseBean;
import com.mudra.mboss.master.bean.supplier.SupplierPanbaseheaderBean;
import com.mudra.mboss.master.services.supplier.SupplierPANBaseService;


@RestController
@RequestMapping("/supplierpandetail/*")
public class SupplierPANBaseRestController {
	
	@Autowired
	SupplierPANBaseService panservice;

	
	
	@RequestMapping(value= "gethsnsac/{sactype}",method=RequestMethod.POST)
	public List<Map<String, Object>> getHSNSAC(@PathVariable("sactype") String sactype){
		return panservice.gethsnsac(sactype);
	}
	
	@RequestMapping(value= "getsupplierdateForpan/{uniqueid}/{supplierid}",method=RequestMethod.GET)
	public List<Map<String, Object>> getSupplierDateForPan(@PathVariable("uniqueid") String uniqueid,@PathVariable("supplierid") String supplierid){
		return panservice.getSupplierData(uniqueid, supplierid);
	}
	
	@RequestMapping(value= "getsupplierdateForpan1/{pannumber}",method=RequestMethod.GET)
	public List<Map<String, Object>> getSupplierDateForPan1(@PathVariable("pannumber") String pannumber){
		return panservice.getSupplierData1(pannumber);
	}
	
	
	
	
	@RequestMapping(value= "getgstdetail/{pannumber}",method=RequestMethod.GET)
	public List<Map<String, Object>> getSupplierDateForPan(@PathVariable("pannumber") String pannumber){
		return panservice.getgstdetail(pannumber);
	}
	
	@RequestMapping(value = "/savesuppliermastergstin", method = RequestMethod.POST)
	public Map<String, Object> savesuppliermastergstin(@RequestBody SupplierPanbaseBean bean){
		return panservice.savePanBaseDetailData(bean);
	} 

	@RequestMapping(value = "savesuppliermastergstinheader", method = RequestMethod.POST)
	public Map<String, Object> savesuppliermastergstinheader(@RequestBody SupplierPanbaseheaderBean  bean){
		return panservice.savePanBaseDetailDataHeader(bean);
	}
	
	@RequestMapping(value= {"/getgstiondetail/{srno}/{pannumber}/{gstin}"},method=RequestMethod.GET)
	public List<Map<String,Object>> getGstionDetail(@PathVariable("srno") String srno,@PathVariable("pannumber") String pannumber,@PathVariable("gstin") String gstin ) {
		return panservice.getGstionDetailList(srno,pannumber,gstin);
	}
	
	@RequestMapping(value= "getsachsngrid/{pannumber}",method=RequestMethod.GET)
	public List<Map<String, Object>> getsachsngrid(@PathVariable("pannumber") String pannumber){
		return panservice.getsachsngrid(pannumber);
	}

	@RequestMapping(value= "getperslab/{sactype}/{sachsn}",method=RequestMethod.GET)
	public List<Map<String, Object>> getperslab(@PathVariable("sactype") String sactype,@PathVariable("sachsn") String sachsn){
		return panservice.getperslab(sactype,sachsn);
	}
	
	
	@RequestMapping(value = "/savesachsndata", method = RequestMethod.POST)
	public Map<String, Object> savesachsndata(@RequestBody SupplierHSNSACBean bean){
		return panservice.savesachsndata(bean);
	} 
	

	@RequestMapping(value= "/geteditdateforsachsn/{srno}/{pannumber}",method=RequestMethod.GET)
	public List<Map<String, Object>> geteditdateforsachsn(@PathVariable("srno") String srno ,@PathVariable("pannumber") String pannumber){
		return panservice.geteditdateforsachsn(srno, pannumber);
	}

	
	
	
}
