	package com.mudra.mboss.master.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mudra.mboss.master.services.client.ClientGroupmasterService;

@RestController
@RequestMapping("/clientgroupmaster/*")
public class ClientGroupmasterRestcontroller {
	
	@Autowired
	ClientGroupmasterService cgms;
	
	@RequestMapping(value= {"/getclientgrouplist/{uniqueid}/{clientgroupid}"},method=RequestMethod.GET)
	public List<Map<String,Object>> getClientGroupList(@PathVariable("uniqueid") String uniqueid,@PathVariable("clientgroupid") String clientgroupid) {
		System.out.println("==>"+clientgroupid); 
		return cgms.getClientGroupList(uniqueid,clientgroupid);
	}
	


}
