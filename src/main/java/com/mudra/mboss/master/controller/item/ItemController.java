package com.mudra.mboss.master.controller.item;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mudra.mboss.master.services.MasterCommonService;



@Controller
@RequestMapping("/itemmaster*")
public class ItemController {

	@Autowired
	HttpSession httpsession;
	
	@Autowired
	MasterCommonService masterCommonService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String itemmaster() {
		httpsession.setAttribute("serverpath", masterCommonService.getServerUrl());
		System.out.println(masterCommonService.getServerUrl());
		return "/master/item/itemmasterlist";
	}
}
