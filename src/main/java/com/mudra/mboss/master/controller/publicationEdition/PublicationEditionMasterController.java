package com.mudra.mboss.master.controller.publicationEdition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mudra.mboss.master.services.MasterCommonService;

@Controller
@RequestMapping("/publication_editionmaster*")
public class PublicationEditionMasterController {
	
	@Autowired
	HttpSession httpsession;
	
	@Autowired
	MasterCommonService masterCommonService;
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String publicationEditionMaster1() {
		httpsession.setAttribute("serverpath", masterCommonService.getServerUrl());
		System.out.println(masterCommonService.getServerUrl());
		return "/master/publication_edition/publicationeditionlist";
	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public String publicationEditionMaster() {
		httpsession.setAttribute("serverpath", masterCommonService.getServerUrl());
		System.out.println(masterCommonService.getServerUrl());
		return "/master/publication_edition/publicationeditionlist";
	}
	
	@RequestMapping(value = { "/addpublicationEdition" }, method = RequestMethod.POST)
	public String addPublicationEditionMaster(HttpServletRequest request) {
		httpsession.setAttribute("serverpath", masterCommonService.getServerUrl());
		System.out.println(masterCommonService.getServerUrl());
		String supplierid = request.getParameter("supplierid");
		String suppliername =  request.getParameter("suppliername");
		httpsession.setAttribute("supplierid", supplierid);
		httpsession.setAttribute("suppliername",suppliername);
		return "/master/publication_edition/publication_edition_master_add";
	}

}
