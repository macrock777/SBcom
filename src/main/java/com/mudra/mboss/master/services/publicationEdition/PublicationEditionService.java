package com.mudra.mboss.master.services.publicationEdition;

import java.util.List;
import java.util.Map;

import com.mudra.mboss.master.bean.publicationEdition.PublicationEditionSearchBean;

public interface PublicationEditionService {

	List<Map<String, Object>> getpublicationsearchlist(PublicationEditionSearchBean publicationEditionSearchBean);

	List<Map<String, Object>> geteditionsearchlist(String uniqueid, String supplierid);

	Map<String, Object> getmaxeditionid(String uniqueid);

}
