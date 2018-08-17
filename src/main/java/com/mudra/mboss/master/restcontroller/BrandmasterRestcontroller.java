package com.mudra.mboss.master.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mudra.mboss.master.bean.client.BrandMasterBean;
import com.mudra.mboss.master.services.client.BrandmasterSaveService;
import com.mudra.mboss.master.services.client.BrandmasterService;
import com.mudra.security.bean.UserdetailBean;

@RestController
@RequestMapping("/brandmaster/*")
public class BrandmasterRestcontroller {

	@Autowired
	BrandmasterService brandmasterService;
	
	@Autowired
	BrandmasterSaveService brandmasterSaveService;
	
	
	@RequestMapping(value={"sectorlist"},method=RequestMethod.GET)
	public List<Map<String, Object>> getSectorList(){
		return brandmasterService.getSectorList();
	}
	
	@RequestMapping(value={"productlist/{sectorid}"},method=RequestMethod.POST)
	public List<Map<String, Object>> getProductList(@PathVariable("sectorid") String sectorid){
		return brandmasterService.getProductList(sectorid);
	}
	
	@RequestMapping(value={"branches/{clientid}"},method=RequestMethod.POST)
	public List<Map<String, Object>> getBranchList(@PathVariable("clientid") String clientid){
		return brandmasterService.getBranchList(clientid);
	}
	
	@RequestMapping(value={"duplicateBrandId/{clientid}/{brandid}"},method=RequestMethod.POST)
	public Map<String, Object> getDuplicateBrandId(@PathVariable("clientid") String clientid,
			@PathVariable("brandid") String brandid,@RequestBody UserdetailBean userdetailBean){
		return brandmasterService.checkDuplicateBrandList(clientid,brandid,userdetailBean);
	}
	
	@RequestMapping(value={"statelist"},method=RequestMethod.POST)
	public List<Map<String, Object>> getDuplicateBrandId(){
		return brandmasterService.getStateList();
	}
	
	@RequestMapping(value={"saveBrand"},method=RequestMethod.POST)
	public Map<String, Object> saveBrand(@RequestBody BrandMasterBean brandMasterBean){
		return brandmasterSaveService.saveBrand(brandMasterBean);
	}
	
	@RequestMapping(value={"brandlist/{clientid}"},method=RequestMethod.POST)
	public List<Map<String, Object>> saveBrand(@PathVariable("clientid") String clientid,
			@RequestBody UserdetailBean userdetailBean){
		return brandmasterService.getBrandList(clientid,userdetailBean);
	}
	
	@RequestMapping(value= {"showbranddetail/{clientid}/{brandid}"},method=RequestMethod.POST)
	public Map<String, Object> showBrandDetail(@PathVariable("clientid") String clientid,@PathVariable("brandid") String brandid,
			@RequestBody UserdetailBean userdetailBean){
		return brandmasterService.showBrandDetail(clientid,brandid,userdetailBean);
	}
	
	@RequestMapping(value= {"completesavebrand/{clientid}"},method=RequestMethod.POST)
	public Map<String, Object> completeSaveBrand(@PathVariable("clientid") String clientid,
			@RequestBody UserdetailBean userdetailBean){
		return brandmasterSaveService.completeSaveBrand(clientid,userdetailBean);
	}
}
