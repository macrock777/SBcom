package com.mudra.mboss.master.controller.supplier;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.mudra.mboss.master.services.MasterCommonService;

@RequestMapping("/suppliermaster/*")
@SessionAttributes("serverpath")
@Controller
public class SuppliermasterController {
	
	@Autowired
	MasterCommonService masterCommonService;
	
	public SimpleDateFormat dateFormatSecond = new SimpleDateFormat("dd/MM/yyyy");
	public SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	//String serverurl = "http://192.168.168.27:8080/mboss";
	
	
	@RequestMapping(value="addsuppliermaster",method=RequestMethod.POST)
	public String addSuppliermaster(WebRequest request,@RequestParam(required=false,name="supplieridhd") String supplieridhd,@RequestParam(required=false,name="suppliereditflag") String suppliereditflag ,@RequestParam(required=false,name="uniqueidhd") String uniqueidhd,ModelMap map) {
		Object serverpath = (String) request.getAttribute("serverpath", WebRequest.SCOPE_SESSION);
		
		if(null==serverpath || serverpath.toString().trim().length()==0) {
			serverpath = masterCommonService.getServerUrl();
			map.put("serverpath", serverpath.toString());
			//map.put("serverpath", serverurl);
			
		}
		map.put("supplieridhd", supplieridhd);
		map.put("suppliereditflag",suppliereditflag);
		map.put("systemdate",dateFormat.format(new Date()));
		return "/master/supplier/add_supplier";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String suppliermaster(WebRequest request,ModelMap map) {
		Object serverpath = (String) request.getAttribute("serverpath", WebRequest.SCOPE_SESSION);
		System.out.println(serverpath);
		if(null==serverpath || serverpath.toString().trim().length()==0) {
			serverpath = masterCommonService.getServerUrl();
			map.put("serverpath", serverpath.toString());
			//map.put("serverpath", serverurl);
		}
		return "/master/supplier/list_supplier";
	}
	
}
