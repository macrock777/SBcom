package com.mudra.mboss.master.restcontroller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mudra.mboss.master.bean.client.OtherDetailMasterBean;
import com.mudra.mboss.master.services.client.OtherDetailmasterService;

@RestController
@RequestMapping("/clientmaster/*")
public class OtherDetailmasterRestcontroller {
	
	@Autowired
	OtherDetailmasterService otherservice;
	
	@RequestMapping(value= {"/saveclientotherdetail"},method=RequestMethod.POST)
	public Map<String,Object>  saveOtherClientDetail(@RequestBody OtherDetailMasterBean bean) {
		System.out.println(bean);
		return otherservice.saveOtherClientMasterData(bean);
	}
	
	@RequestMapping(value= {"/getclientotherdetail/{uniqueid}/{clientid}"},method=RequestMethod.GET)
	public Map<String,Object>  getOtherClientDetail(@PathVariable("uniqueid") String uniqueid,@PathVariable("clientid") String clientid) {
		return otherservice.getOtherClientMasterData(uniqueid,clientid);
	}
	
}
