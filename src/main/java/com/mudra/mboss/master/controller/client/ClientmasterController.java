package com.mudra.mboss.master.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/clientmaster*")
public class ClientmasterController {
	
	@RequestMapping(value="addclientmaster",method=RequestMethod.POST)
	public String addclientmaster(@RequestParam(required=false,name="clientid") String clientidhd,@RequestParam(required=false,name="uniqueidhd") String uniqueidhd,ModelMap map) {
		map.put("clientidhd", clientidhd);
		map.put("uniqueidhd", uniqueidhd);
		return "/master/add_client";
	}
	
	@RequestMapping(value= {"/"},method=RequestMethod.GET)
	public String clientmaster(ModelMap map) {
		return "/master/list_client";
	}
	
}
