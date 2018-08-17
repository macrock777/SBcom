package com.mudra.mboss.master.restcontroller.publicationEdition;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mudra.mboss.master.bean.publicationEdition.PublicationEditionSearchBean;
import com.mudra.mboss.master.services.publicationEdition.PublicationEditionService;

@RestController
@RequestMapping("/publication_editionmaster/*")
public class PublicationEditionMasterRestcontroller {
	
	@Autowired
	PublicationEditionService publicationEditionService; 
	
	@RequestMapping(value = { "publicationsearchlist" }, method = RequestMethod.POST)
	public List<Map<String, Object>> getpublicationsearchlist(@RequestBody PublicationEditionSearchBean publicationEditionSearchBean) {
		return publicationEditionService.getpublicationsearchlist(publicationEditionSearchBean);
	}
	
	@RequestMapping(value = { "editionsearchlist" }, method = RequestMethod.POST)
	public List<Map<String, Object>> geteditionsearchlist(HttpServletRequest request) {
		String uniqueid = request.getParameter("uniqueid");
		String supplierid = request.getParameter("supplieridhd");
		return publicationEditionService.geteditionsearchlist(uniqueid,supplierid);
	}

	@RequestMapping(value = { "getmaxeditionid" }, method = RequestMethod.POST)
	public Map<String, Object> getmaxeditionid(HttpServletRequest request) {
		String uniqueid = request.getParameter("uniqueid"); 
		return publicationEditionService.getmaxeditionid(uniqueid);
	}
}
