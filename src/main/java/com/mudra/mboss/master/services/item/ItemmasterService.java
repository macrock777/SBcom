package com.mudra.mboss.master.services.item;

import java.util.List;
import java.util.Map;
import com.mudra.mboss.master.bean.item.Itemsearchbean;

public interface ItemmasterService {

	List<Map<String, Object>> getgroupItemcodeList();

	List<Map<String, Object>> getitemtypeList();

	List<Map<String, Object>> getunitList();

	List<Map<String, Object>> getincomeglcodeList(String uniqueid);

	List<Map<String, Object>> getexpenseglcodeList(String uniqueid);

	List<Map<String, Object>> getitemsearchList(Itemsearchbean itemsearchbean);

}
