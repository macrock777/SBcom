package com.mudra.mboss.master.bean.supplier;

import com.mudra.security.bean.UserdetailBean;

public class SupplierDetailmasterbean {
	
	String uniqueid;
	String newgroupid;
	String newgroupname;
	
	
	String suppliereditflag;
	String  supplierid;
	String  suppliername;
	String  displayname;
	String  suppliergroupid;
	String  supplierjobtype;
	String  paytoname;
	String  ismsmedvendor;
	String  issquarecentimeter;
	String  isblacklisted;
	String  isactive;
	String  isforeignvendor;
	String  isonlineservice;
	String  isacknowledgement;
	
	String  glcode;
	String  supplierbranches;
	String  suppliercategory;
	String  creditdays;
	String  commissionpercentage;
	
	String  suppliertype;
	String  gst_vendor_type;
	String  pannumber;
	String  pan_suppliername;
	String  suppliercontactperson;
	String  supplieraddress1;
	String  supplieraddress2;
	String  supplieraddress3;
	String  suppliercity;
	String  supplierpincode;
	String  state;
	String  suppliercountry;
	String  supplierphoneno;
	String  suppliermobileno;
	String  supplierfax;
	String  supplieremail;
	String existingrdbtn;
	String newgrouprdbtn;
	UserdetailBean userdetailbean;
	TdsDetailBean tdsdetailbean;
	SupplierBankDetailBean bankDetails;

	
	public TdsDetailBean getTdsdetailbean() {
		return tdsdetailbean;
	}

	public SupplierBankDetailBean getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(SupplierBankDetailBean bankDetails) {
		this.bankDetails = bankDetails;
	}

	public void setTdsdetailbean(TdsDetailBean tdsdetailbean) {
		this.tdsdetailbean = tdsdetailbean;
	}

	public String getNewgroupid() {
		return newgroupid;
	}

	public void setNewgroupid(String newgroupid) {
		this.newgroupid = newgroupid;
	}

	public String getNewgroupname() {
		return newgroupname;
	}

	public void setNewgroupname(String newgroupname) {
		this.newgroupname = newgroupname;
	}

	public String getSuppliereditflag() {
		return suppliereditflag;
	}

	public void setSuppliereditflag(String suppliereditflag) {
		this.suppliereditflag = suppliereditflag;
	}
	String branches[];
	public String[] getBranches() {
		return branches;
	}

	public void setBranches(String[] branches) {
		this.branches = branches;
	}
	
	
	public String getExistingrdbtn() {
		return existingrdbtn;
	}

	public void setExistingrdbtn(String existingrdbtn) {
		this.existingrdbtn = existingrdbtn;
	}

	public String getNewgrouprdbtn() {
		return newgrouprdbtn;
	}

	public void setNewgrouprdbtn(String newgrouprdbtn) {
		this.newgrouprdbtn = newgrouprdbtn;
	}

	
	public UserdetailBean getUserdetailbean() {
		return userdetailbean;
	}

	public void setUserdetailbean(UserdetailBean userdetailbean) {
		this.userdetailbean = userdetailbean;
	}

	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getSuppliergroupid() {
		return suppliergroupid;
	}

	public void setSuppliergroupid(String suppliergroupid) {
		this.suppliergroupid = suppliergroupid;
	}

	public String getSupplierjobtype() {
		return supplierjobtype;
	}

	public void setSupplierjobtype(String supplierjobtype) {
		this.supplierjobtype = supplierjobtype;
	}

	public String getPaytoname() {
		return paytoname;
	}

	public void setPaytoname(String paytoname) {
		this.paytoname = paytoname;
	}

	public String getIsmsmedvendor() {
		return ismsmedvendor;
	}

	public void setIsmsmedvendor(String ismsmedvendor) {
		this.ismsmedvendor = ismsmedvendor;
	}

	public String getIssquarecentimeter() {
		return issquarecentimeter;
	}

	public void setIssquarecentimeter(String issquarecentimeter) {
		this.issquarecentimeter = issquarecentimeter;
	}

	public String getIsblacklisted() {
		return isblacklisted;
	}

	public void setIsblacklisted(String isblacklisted) {
		this.isblacklisted = isblacklisted;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getIsforeignvendor() {
		return isforeignvendor;
	}

	public void setIsforeignvendor(String isforeignvendor) {
		this.isforeignvendor = isforeignvendor;
	}

	public String getIsonlineservice() {
		return isonlineservice;
	}

	public void setIsonlineservice(String isonlineservice) {
		this.isonlineservice = isonlineservice;
	}

	public String getIsacknowledgement() {
		return isacknowledgement;
	}

	public void setIsacknowledgement(String isacknowledgement) {
		this.isacknowledgement = isacknowledgement;
	}

	

	public String getGlcode() {
		return glcode;
	}

	public void setGlcode(String glcode) {
		this.glcode = glcode;
	}

	public String getSupplierbranches() {
		return supplierbranches;
	}

	public void setSupplierbranches(String supplierbranches) {
		this.supplierbranches = supplierbranches;
	}

	public String getSuppliercategory() {
		return suppliercategory;
	}

	public void setSuppliercategory(String suppliercategory) {
		this.suppliercategory = suppliercategory;
	}

	public String getCreditdays() {
		return creditdays;
	}

	public void setCreditdays(String creditdays) {
		this.creditdays = creditdays;
	}

	public String getCommissionpercentage() {
		return commissionpercentage;
	}

	public void setCommissionpercentage(String commissionpercentage) {
		this.commissionpercentage = commissionpercentage;
	}

	

	public String getSuppliertype() {
		return suppliertype;
	}

	public void setSuppliertype(String suppliertype) {
		this.suppliertype = suppliertype;
	}

	public String getGst_vendor_type() {
		return gst_vendor_type;
	}

	public void setGst_vendor_type(String gst_vendor_type) {
		this.gst_vendor_type = gst_vendor_type;
	}

	public String getPannumber() {
		return pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	

	public String getPan_suppliername() {
		return pan_suppliername;
	}

	public void setPan_suppliername(String pan_suppliername) {
		this.pan_suppliername = pan_suppliername;
	}

	public String getSuppliercontactperson() {
		return suppliercontactperson;
	}

	public void setSuppliercontactperson(String suppliercontactperson) {
		this.suppliercontactperson = suppliercontactperson;
	}

	public String getSupplieraddress1() {
		return supplieraddress1;
	}

	public void setSupplieraddress1(String supplieraddress1) {
		this.supplieraddress1 = supplieraddress1;
	}

	public String getSupplieraddress2() {
		return supplieraddress2;
	}

	public void setSupplieraddress2(String supplieraddress2) {
		this.supplieraddress2 = supplieraddress2;
	}

	public String getSupplieraddress3() {
		return supplieraddress3;
	}

	public void setSupplieraddress3(String supplieraddress3) {
		this.supplieraddress3 = supplieraddress3;
	}

	public String getSuppliercity() {
		return suppliercity;
	}

	public void setSuppliercity(String suppliercity) {
		this.suppliercity = suppliercity;
	}

	public String getSupplierpincode() {
		return supplierpincode;
	}

	public void setSupplierpincode(String supplierpincode) {
		this.supplierpincode = supplierpincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSuppliercountry() {
		return suppliercountry;
	}

	public void setSuppliercountry(String suppliercountry) {
		this.suppliercountry = suppliercountry;
	}

	public String getSupplierphoneno() {
		return supplierphoneno;
	}

	public void setSupplierphoneno(String supplierphoneno) {
		this.supplierphoneno = supplierphoneno;
	}

	public String getSuppliermobileno() {
		return suppliermobileno;
	}

	public void setSuppliermobileno(String suppliermobileno) {
		this.suppliermobileno = suppliermobileno;
	}

	public String getSupplierfax() {
		return supplierfax;
	}

	public void setSupplierfax(String supplierfax) {
		this.supplierfax = supplierfax;
	}

	public String getSupplieremail() {
		return supplieremail;
	}

	public void setSupplieremail(String supplieremail) {
		this.supplieremail = supplieremail;
	}

	

}





/*public String supplierid,suppliername,displayname,suppliergroupid,supplierjobtype,paytoname,ismsmedvendor,
issquarecentimeter,isblacklisted,isactive,isforeignvendor,isonlineservice,isacknowledgement,glcode,supplierbranches,
suppliercategory,creditdays,commissionpercentage,uploadziprarfile,suppliertype,gst_vendor_type,pannumber,uploadpanfile,
pan_suppliername,suppliercontactperson,supplieraddress1,supplieraddress2,supplieraddress3,suppliercity,supplierpincode,state,
suppliercountry,supplierphoneno,suppliermobileno,supplierfax,supplieremail;

UserdetailBean bean;*/




