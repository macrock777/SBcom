package com.mudra.mboss.master.restcontroller.item;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mudra.mboss.master.bean.item.ItemMasterBean;
import com.mudra.mboss.master.bean.item.Itemsearchbean;
import com.mudra.mboss.master.services.item.ItemmasterSaveService;
import com.mudra.mboss.master.services.item.ItemmasterService;

@RestController
@RequestMapping("/itemmaster/*")
public class ItemmasterRestcontroller {

	@Autowired
	ItemmasterService itemmasterService;

	@Autowired
	ItemmasterSaveService itemmasterSaveService;

	@RequestMapping(value = { "saveitemmasterdata" }, method = RequestMethod.POST)
	public Map<String, Object> saveItemMaster(@RequestBody ItemMasterBean itemMasterBean) {
		return itemmasterSaveService.saveItemMaster(itemMasterBean);
	}

	@RequestMapping(value = { "groupitemcodelist" }, method = RequestMethod.GET)
	public List<Map<String, Object>> getgroupItemcodeList() {
		return itemmasterService.getgroupItemcodeList();
	}

	@RequestMapping(value = { "itemsearchlist" }, method = RequestMethod.POST)
	public List<Map<String, Object>> getitemsearchList(@RequestBody Itemsearchbean itemsearchbean) {
		return itemmasterService.getitemsearchList(itemsearchbean);
	}

	@RequestMapping(value = { "itemtypelist" }, method = RequestMethod.GET)
	public List<Map<String, Object>> getitemtypeList() {
		return itemmasterService.getitemtypeList();
	}

	@RequestMapping(value = { "unitlist" }, method = RequestMethod.GET)
	public List<Map<String, Object>> getunitList() {
		return itemmasterService.getunitList();
	}

	@RequestMapping(value = { "incomeglcodelist/{uniqueid}" }, method = RequestMethod.GET)
	public List<Map<String, Object>> getincomeglcodeList(@PathVariable("uniqueid") String uniqueid) {
		return itemmasterService.getincomeglcodeList(uniqueid);
	}

	@RequestMapping(value = { "expenseglcodelist/{uniqueid}" }, method = RequestMethod.GET)
	public List<Map<String, Object>> getexpenseglcodeList(@PathVariable("uniqueid") String uniqueid) {
		return itemmasterService.getexpenseglcodeList(uniqueid);
	}
}
