package com.mudra.mboss.master.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mudra.mboss.master.bean.client.PanbaseBean;
import com.mudra.mboss.master.bean.client.PanbaseheaderBean;
import com.mudra.mboss.master.services.client.PanBaseDetailService;

@RestController
@RequestMapping("/clientmaster/*")
public class PanBaseDetailmasterRestcontroller {
	
	@Autowired
	PanBaseDetailService psnserv;

	@RequestMapping(value= {"/clientmastergstindetailList/{pannumber}"},method=RequestMethod.GET)
	public List<Map<String,Object>> getPanbaseList(@PathVariable("pannumber") String pannumber) {
		return psnserv.getClientMastergstindetailList(pannumber);
	}

	@RequestMapping(value = "/saveclientmastergstin", method = RequestMethod.POST)
	public Map<String, Object> saveClientmastergstin(@RequestBody PanbaseBean bean){
		return psnserv.savePanBaseDetailData(bean);
	}

	@RequestMapping(value= {"/getgstiondetail/{srno}/{pannumber}/{gstin}"},method=RequestMethod.GET)
	public List<Map<String,Object>> getGstionDetail(@PathVariable("srno") String srno,@PathVariable("pannumber") String pannumber,@PathVariable("gstin") String gstin ) {
		return psnserv.getGstionDetailList(srno,pannumber,gstin);
	}

	@RequestMapping(value = "/saveclientmastergstinheader", method = RequestMethod.POST)
	public Map<String, Object> saveclientmastergstinheader(@RequestBody PanbaseheaderBean bean){
		return psnserv.savePanBaseDetailDataHeader(bean);
	}

}

