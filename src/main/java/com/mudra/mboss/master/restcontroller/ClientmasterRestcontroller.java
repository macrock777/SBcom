package com.mudra.mboss.master.restcontroller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mudra.mboss.master.bean.client.ClientMasterFileBean;
import com.mudra.mboss.master.bean.client.ClientSearchBean;
import com.mudra.mboss.master.bean.client.ClientmasterBean;
import com.mudra.mboss.master.services.client.ClientmasterSaveService;
import com.mudra.mboss.master.services.client.ClientmasterService;
import com.mudra.security.bean.UserdetailBean;

@RestController
@RequestMapping("/clientmaster/*")
public class ClientmasterRestcontroller {

	@Autowired
	ClientmasterService clientmasterService;
	
	@Autowired
	ClientmasterSaveService clientmasterSaveService; 
	
	@Autowired
	ServletContext context; 
	
	@Value("${clientmaster.panFileLocation}")
	private String panFileLocation;
	
	@Value("${clientmaster.bankFileLocation}")
	private String bankFileLocation;
	
	@Value("${clientmaster.contractFileLocation}")
	private String contractFileLocation;
	
	@RequestMapping(value={"clientsearchlist"},method=RequestMethod.POST)
	public List<Map<String, Object>> getClientSearchList(@RequestBody ClientSearchBean clientSearchBean){
		return clientmasterService.getClientSearchList(clientSearchBean);
	}
	
	@RequestMapping(value={"clientlist/{loginid}/{uniqueid}"},method=RequestMethod.POST)
	public List<Map<String, Object>> getClientList(@PathVariable("loginid") String loginid,
			@PathVariable("uniqueid") String uniqueid){
		return clientmasterService.getClientList(loginid,uniqueid);
	}
	
	@RequestMapping(value= {"servicetypelist"},method=RequestMethod.POST)
	public List<Map<String, Object>> getServiceType(){
		return clientmasterService.getServiceType();
	}
	
	@RequestMapping(value= {"cliettypelist"},method=RequestMethod.POST)
	public List<Map<String, Object>> getClientType(){
		return clientmasterService.getClientType();
	}
	
	@RequestMapping(value= {"gstclienttypelist"},method=RequestMethod.POST)
	public List<Map<String, Object>> getGSTClientType(){
		return clientmasterService.getGSTClientType();
	}
	
	@RequestMapping(value= {"clientgrouplist"},method=RequestMethod.POST)
	public List<Map<String, Object>> getClientGrpList(@RequestBody UserdetailBean userdetailBean){
		return clientmasterService.getClientGrpList(userdetailBean);
	}
	
	@RequestMapping(value= {"getglcode"},method=RequestMethod.POST)
	public Map<String, Object> getGlcode(@RequestBody UserdetailBean userdetailBean){
		return clientmasterService.getGlCode(userdetailBean);
	}
	
	@RequestMapping(value= {"statelist"},method=RequestMethod.POST)
	public List<Map<String, Object>> getStateList(){
		return clientmasterService.getStateList();
	}
	
	@RequestMapping(value= {"duplicateClientId/{clientid}"},method=RequestMethod.POST)
	public Map<String, Object> getDuplicateClientid(@PathVariable("clientid") String clientid,@RequestBody UserdetailBean userdetailBean){
		return clientmasterService.checkDupliacteClientId(clientid, userdetailBean);
	}
	
	@RequestMapping(value= {"duplicateClientName/{clientname}"},method=RequestMethod.POST)
	public Map<String, Object> getDuplicateClientName(@PathVariable("clientname") String clientname,@RequestBody UserdetailBean userdetailBean){
		return clientmasterService.checkDupliacteClientName(clientname, userdetailBean);
	}
	
	@RequestMapping(value = "saveclient", method = RequestMethod.POST,consumes = {"multipart/form-data"})
	public Map<String, Object> saveClient(@RequestPart("clientdata") ClientmasterBean bean,
			@RequestPart(name="panfile",required=false) MultipartFile panfile,
			@RequestPart(name="bankfile",required=false) MultipartFile bankfile,@RequestPart(name="clientcontractfile",required=false) MultipartFile clientcontractfile){
		ClientMasterFileBean fileBean = new ClientMasterFileBean(panfile, bankfile, clientcontractfile, context.getRealPath(""));
		return clientmasterSaveService.saveClient(bean,fileBean);
	}
	
	@RequestMapping(value="getclientdetail/{clientidhd}",method=RequestMethod.POST)
	public Map<String,Object> getClientDetail(@PathVariable("clientidhd") String clientidhd,@RequestBody UserdetailBean userdetailBean){
		return clientmasterService.getClientDetail(clientidhd,userdetailBean);
	}
	
	@RequestMapping(value="getbranches/{clientid}",method=RequestMethod.POST)
	public List<Map<String,Object>> getBranches(@PathVariable("clientid") String clientid){
		return clientmasterService.getBranches(clientid);
	}
	
	@RequestMapping(value="getstatepinmask/{statename}",method=RequestMethod.POST)
	public Map<String,Object> getStatePinMask(@PathVariable("statename") String statename){
		return clientmasterService.getStatePinMask(statename);
	}
	
	@RequestMapping(value="getstatepinmaskusingstatecode/{statecode}",method=RequestMethod.POST)
	public Map<String,Object> getStatePinMaskUsingCode(@PathVariable("statecode") String statecode){
		return clientmasterService.getStatePinMaskUsingCode(statecode);
	}
}
