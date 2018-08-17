package com.mudra.mboss.master.restcontroller.supplier;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mudra.mboss.master.bean.supplier.SupplierChangePanBean;
import com.mudra.mboss.master.bean.supplier.SupplierDetailFileBean;
import com.mudra.mboss.master.bean.supplier.SupplierDetailmasterbean;
import com.mudra.mboss.master.bean.supplier.SuppliersearchBean;
import com.mudra.mboss.master.services.impl.supplier.SupplierDetailSavaServiceImpl;
import com.mudra.mboss.master.services.supplier.SupplierDetailmasterService;
import com.mudra.security.bean.UserdetailBean;

@RestController
@RequestMapping("/suppliermaster/*")
public class SupplierDetailRestcontroller {
	
	@Autowired 
	SupplierDetailmasterService supplierser;
	
	@Autowired 
	ServletContext context; 
	
	
	@Autowired 
	SupplierDetailSavaServiceImpl saveSupplierService;
	
	
	@RequestMapping(value= {"getsuppliertype"},method=RequestMethod.POST)
	public List<Map<String, Object>> getSuppliertype(){
		return supplierser.getSuppliertype();
	}
	
	@RequestMapping(value= {"getstatelist"},method=RequestMethod.POST)
	public List<Map<String, Object>> getStateList(){
		return supplierser.getStateList();
	}
	
	@RequestMapping(value= {"getgstvendertype"},method=RequestMethod.POST)
	public List<Map<String, Object>> getGstvenderType(){
		return supplierser.getGstVenterType();
	}
	
	@RequestMapping(value= {"duplicateSupplierId/{supplierid}"},method=RequestMethod.POST)
	public Map<String, Object> getDuplicateClientid(@PathVariable("supplierid") String supplierid,@RequestBody UserdetailBean userdetailBean){
		return supplierser.checkDupliacteSupplierId(supplierid, userdetailBean);
	}
	
	@RequestMapping(value= {"duplicateSupplierName/{suppliername}"},method=RequestMethod.POST)
	public Map<String, Object> getDuplicateClientName(@PathVariable("suppliername") String suppliername,@RequestBody UserdetailBean userdetailBean){
		return supplierser.checkDupliacteSupplierName(suppliername, userdetailBean);
	}
	
	@RequestMapping(value = "saveSupplierDatail", method = RequestMethod.POST,consumes = {"multipart/form-data"})
	public Map<String, Object> saveClient(@RequestPart("supplierdetaildate") SupplierDetailmasterbean bean,
		   @RequestPart(name="uploadziprarfile",required=false) MultipartFile uploadziprarfile,
		   @RequestPart(name="uploadpanfile",required=false) MultipartFile uploadpanfile){
		   SupplierDetailFileBean fileBean = new SupplierDetailFileBean(uploadziprarfile, uploadpanfile,  context.getRealPath(""));
		   return saveSupplierService.saveSupplierDatail(bean, fileBean);
	}
	
	@RequestMapping(value= {"getglcode"},method=RequestMethod.POST)
	public Map<String, Object> getGlcode(@RequestBody UserdetailBean userdetailBean){
		return supplierser.getGlCode(userdetailBean);
	}

	
	@RequestMapping(value="getbranches",method=RequestMethod.POST)
	public List<Map<String,Object>> getBranches(@PathVariable("supplierid") String supplierid){
		return supplierser.getBranches(supplierid);
	}
	
	@RequestMapping(value= {"duplicateSupplierGrpId/{suppliergrpid}"},method=RequestMethod.POST)
	public Map<String, Object> getDuplicatesuppliergrpid(@PathVariable("suppliergrpid") String suppliergrpid,@RequestBody UserdetailBean userdetailBean){
		return supplierser.checkDuplicateNewGroupid(suppliergrpid, userdetailBean);
	}
	
	@RequestMapping(value= {"duplicateSupplierGrpName/{suppliergrpname}"},method=RequestMethod.POST)
	public Map<String, Object> getDuplicatesuppliergrpName(@PathVariable("suppliergrpname") String suppliergrpname,@RequestBody UserdetailBean userdetailBean){
		return supplierser.checkDuplicateNewGroupName(suppliergrpname, userdetailBean);
	}
	
	
	// LIST GRID SUPPLIER
	
	@RequestMapping(value= {"getsupplierlist/{uniqueid}/{suppliergroupid}"},method=RequestMethod.POST)
	public  List<Map<String, Object>>  getsupplierlist(@PathVariable("uniqueid") String uniqueid,@PathVariable("suppliergroupid") String suppliergroupid  ){
		return supplierser.getsupplierlist(uniqueid,suppliergroupid);
	}
	
	@RequestMapping(value= "getsupplierlist",method=RequestMethod.POST)
	public  List<Map<String, Object>>  getsuppliersearchlist(@RequestBody SuppliersearchBean bean){
		return supplierser.getsupplierserchlist(bean);
	}
	
	@RequestMapping(value= "getsupplieredit/{supplierid}/{uniqueid}",method=RequestMethod.GET)
	public  List<Map<String, Object>>  getsuppliersearchlist(@PathVariable("supplierid") String supplierid,@PathVariable("uniqueid") String uniqueid){
		return supplierser.getsupplieridforedit(supplierid,uniqueid);
	}
	
	
	@RequestMapping(value = "savechangpandata", method = RequestMethod.POST,consumes = {"multipart/form-data"})
	public Map<String, Object> savechangpandata(@RequestPart("changepandata") SupplierChangePanBean bean,
		   @RequestPart(name="newuploadpan",required=false) MultipartFile newuploadpan){
		   return supplierser.savechangepan(bean,newuploadpan);
	}

	@RequestMapping(value="getstatepinmask/{statename}",method=RequestMethod.POST)
	public Map<String,Object> getStatePinMask(@PathVariable("statename") String statename){
		return supplierser.getStatePinMask(statename);
	}
	
	@RequestMapping(value="getsupplierchange/{loginid}",method=RequestMethod.GET)
	public Map<String,Object> getsupplierchange(@PathVariable("loginid") String loginid){
		return supplierser.getSupplierchange(loginid);
	}
	

	@RequestMapping(value="uploadsupplierexcel",method=RequestMethod.POST)
	public Map<String,Object> uploadSupplierExcel(@RequestPart(name="uploadopenexceldata") MultipartFile uploadopenexceldata){
		return supplierser.uploadSupplierExcel(uploadopenexceldata);
	}
	
	@RequestMapping(value="downloadfiles/{uniqueid}/{supplierid}/{filetype}",method=RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, 
			@PathVariable("uniqueid") String uniqueid,
			@PathVariable("supplierid") String supplierid,
			@PathVariable("filetype") String filetype) {
		
		try {
			InputStream inputStream = supplierser.downloadFile(response,uniqueid, supplierid, filetype,context.getRealPath(""));
			//Copy bytes from source to destination(outputstream in this example), closes both streams.
			if(null!=inputStream){
				IOUtils.copy(inputStream, response.getOutputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
