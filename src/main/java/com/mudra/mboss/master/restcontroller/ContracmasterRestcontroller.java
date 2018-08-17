package com.mudra.mboss.master.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mudra.mboss.master.bean.client.ClientContracBean;
import com.mudra.mboss.master.services.client.ContracmasterService;
@RestController
@RequestMapping("/clientmaster/*")
public class ContracmasterRestcontroller {
	
	@Autowired
	ContracmasterService conservice;
	
	@RequestMapping(value= {"/getclientcontraclist/{clientid}/{uniqueid}"},method=RequestMethod.GET)
	public List<Map<String,Object>> getClientContracList(@PathVariable("clientid") String clientid,
			@PathVariable("uniqueid") String uniqueid) {
		return conservice.getClientContracDetail(uniqueid,clientid);
	}
	
	@RequestMapping(value = "/saveclientcontrac", method = RequestMethod.POST,consumes = {"multipart/form-data"})
	public Map<String, Object> saveClientContrac(@RequestPart("clientcontracdata") ClientContracBean bean,
			@RequestPart(name="contracfile",required=false) MultipartFile contracfile){
		return conservice.saveClientContracData(bean, contracfile);
	}
	
	@RequestMapping(value= {"/getEditClientContracList/{uniqueid}/{clientid}/{srno}"},method=RequestMethod.GET)
	public List<Map<String,Object>> getEditClientContracList(@PathVariable("uniqueid") String uniqueid,
			@PathVariable("clientid") String clientid,@PathVariable("srno") String srno) {
		return conservice.getEditClientContracDetail(uniqueid, clientid, srno);
	}

}
