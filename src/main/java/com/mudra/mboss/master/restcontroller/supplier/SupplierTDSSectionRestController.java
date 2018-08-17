package com.mudra.mboss.master.restcontroller.supplier;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mudra.mboss.master.bean.supplier.TdsDetailBean;
import com.mudra.mboss.master.services.supplier.SupplierTDSDetailService;
import com.mudra.security.bean.UserdetailBean;

@RestController
@RequestMapping("/supplierTDSDetail/*")
public class SupplierTDSSectionRestController {
	
	@Autowired
	SupplierTDSDetailService service ;

	@RequestMapping(value= {"gettdssectiondate/{startdate}/{enddate}"},method=RequestMethod.POST)
	public List<Map<String, Object>> getSuppliertype(@PathVariable("startdate") String startdate,@PathVariable("enddate") String enddate){
		return service.getTDSSectionDate(startdate, enddate);
	}
	
	@RequestMapping(value="gettdsdetail/{supplierid}",method=RequestMethod.POST)
	public List<Map<String,Object>> gettdsdetail(@PathVariable("supplierid") String supplierid,@RequestBody UserdetailBean bean){
		return service.gettdsdetail(supplierid, bean);
		
	}

}
