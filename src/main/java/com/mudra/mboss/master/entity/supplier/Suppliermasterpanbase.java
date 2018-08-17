package com.mudra.mboss.master.entity.supplier;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Suppliermasterpanbase entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SUPPLIERMASTERPANBASE", schema = "MUDRA")

public class Suppliermasterpanbase implements java.io.Serializable {

	// Fields

	private String pannumber;
	private String nsdlsuppliername;
	private String type;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private Integer pin;
	private String state;
	private String emailid;
	private String telephonenumbers;
	private String country;
	private String contactperson;
	private String faxnumbers;
	private String stdcode;
	private String telephoneextension;
	private String tdssectionid;
	private String servicetaxnumber;
	private Date servicetaxeffectivedate;
	private String isregistrationcopyreceived;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String isdatavarified;
	private String gstVendorType;
	private String lstnumber;
	private String cstnumber;
	private String tinnumber;
	private Integer sacHsnId;
	private Short taxSlabPer;
	private String smSuppliername;
	private String constitutionbusiness;
	private String designation;
	private String gstregistrationstatus;
	private String gstunregisteredreason;
	private String businessaddress1;
	private String businessaddress2;
	private String businessaddress3;
	private String businesscity;
	private String businessstate;
	private Integer businesspin;
	private String businesscountry;
	private String financeemailid;
	private String remarks;
	private String isgstapplicable;
	private String statecode;
	private String internalSupplierType;

	// Constructors

	/** default constructor */
	public Suppliermasterpanbase() {
	}

	/** minimal constructor */
	public Suppliermasterpanbase(String pannumber) {
		this.pannumber = pannumber;
	}

	/** full constructor */
	public Suppliermasterpanbase(String pannumber, String nsdlsuppliername, String type, String address1,
			String address2, String address3, String city, Integer pin, String state, String emailid,
			String telephonenumbers, String country, String contactperson, String faxnumbers, String stdcode,
			String telephoneextension, String tdssectionid, String servicetaxnumber, Date servicetaxeffectivedate,
			String isregistrationcopyreceived, String createdby, Date createdon, Date modifiedon, String modifiedby,
			String ipaddress, String macaddress, String isdatavarified, String gstVendorType, String lstnumber,
			String cstnumber, String tinnumber, Integer sacHsnId, Short taxSlabPer, String smSuppliername,
			String constitutionbusiness, String designation, String gstregistrationstatus, String gstunregisteredreason,
			String businessaddress1, String businessaddress2, String businessaddress3, String businesscity,
			String businessstate, Integer businesspin, String businesscountry, String financeemailid, String remarks,
			String isgstapplicable, String statecode, String internalSupplierType) {
		this.pannumber = pannumber;
		this.nsdlsuppliername = nsdlsuppliername;
		this.type = type;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.city = city;
		this.pin = pin;
		this.state = state;
		this.emailid = emailid;
		this.telephonenumbers = telephonenumbers;
		this.country = country;
		this.contactperson = contactperson;
		this.faxnumbers = faxnumbers;
		this.stdcode = stdcode;
		this.telephoneextension = telephoneextension;
		this.tdssectionid = tdssectionid;
		this.servicetaxnumber = servicetaxnumber;
		this.servicetaxeffectivedate = servicetaxeffectivedate;
		this.isregistrationcopyreceived = isregistrationcopyreceived;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.isdatavarified = isdatavarified;
		this.gstVendorType = gstVendorType;
		this.lstnumber = lstnumber;
		this.cstnumber = cstnumber;
		this.tinnumber = tinnumber;
		this.sacHsnId = sacHsnId;
		this.taxSlabPer = taxSlabPer;
		this.smSuppliername = smSuppliername;
		this.constitutionbusiness = constitutionbusiness;
		this.designation = designation;
		this.gstregistrationstatus = gstregistrationstatus;
		this.gstunregisteredreason = gstunregisteredreason;
		this.businessaddress1 = businessaddress1;
		this.businessaddress2 = businessaddress2;
		this.businessaddress3 = businessaddress3;
		this.businesscity = businesscity;
		this.businessstate = businessstate;
		this.businesspin = businesspin;
		this.businesscountry = businesscountry;
		this.financeemailid = financeemailid;
		this.remarks = remarks;
		this.isgstapplicable = isgstapplicable;
		this.statecode = statecode;
		this.internalSupplierType = internalSupplierType;
	}

	// Property accessors
	@Id

	@Column(name = "PANNUMBER", unique = true, nullable = false, length = 10)

	public String getPannumber() {
		return this.pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	@Column(name = "NSDLSUPPLIERNAME", length = 70)

	public String getNsdlsuppliername() {
		return this.nsdlsuppliername;
	}

	public void setNsdlsuppliername(String nsdlsuppliername) {
		this.nsdlsuppliername = nsdlsuppliername;
	}

	@Column(name = "TYPE", length = 20)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "ADDRESS1", length = 256)

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "ADDRESS2", length = 256)

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "ADDRESS3", length = 256)

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@Column(name = "CITY", length = 20)

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "PIN", precision = 8, scale = 0)

	public Integer getPin() {
		return this.pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	@Column(name = "STATE", length = 70)

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "EMAILID", length = 512)

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "TELEPHONENUMBERS", length = 64)

	public String getTelephonenumbers() {
		return this.telephonenumbers;
	}

	public void setTelephonenumbers(String telephonenumbers) {
		this.telephonenumbers = telephonenumbers;
	}

	@Column(name = "COUNTRY", length = 32)

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "CONTACTPERSON", length = 32)

	public String getContactperson() {
		return this.contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	@Column(name = "FAXNUMBERS", length = 32)

	public String getFaxnumbers() {
		return this.faxnumbers;
	}

	public void setFaxnumbers(String faxnumbers) {
		this.faxnumbers = faxnumbers;
	}

	@Column(name = "STDCODE", length = 80)

	public String getStdcode() {
		return this.stdcode;
	}

	public void setStdcode(String stdcode) {
		this.stdcode = stdcode;
	}

	@Column(name = "TELEPHONEEXTENSION", length = 24)

	public String getTelephoneextension() {
		return this.telephoneextension;
	}

	public void setTelephoneextension(String telephoneextension) {
		this.telephoneextension = telephoneextension;
	}

	@Column(name = "TDSSECTIONID", length = 32)

	public String getTdssectionid() {
		return this.tdssectionid;
	}

	public void setTdssectionid(String tdssectionid) {
		this.tdssectionid = tdssectionid;
	}

	@Column(name = "SERVICETAXNUMBER", length = 50)

	public String getServicetaxnumber() {
		return this.servicetaxnumber;
	}

	public void setServicetaxnumber(String servicetaxnumber) {
		this.servicetaxnumber = servicetaxnumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SERVICETAXEFFECTIVEDATE", length = 7)

	public Date getServicetaxeffectivedate() {
		return this.servicetaxeffectivedate;
	}

	public void setServicetaxeffectivedate(Date servicetaxeffectivedate) {
		this.servicetaxeffectivedate = servicetaxeffectivedate;
	}

	@Column(name = "ISREGISTRATIONCOPYRECEIVED", length = 1)

	public String getIsregistrationcopyreceived() {
		return this.isregistrationcopyreceived;
	}

	public void setIsregistrationcopyreceived(String isregistrationcopyreceived) {
		this.isregistrationcopyreceived = isregistrationcopyreceived;
	}

	@Column(name = "CREATEDBY", length = 20)

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDON", length = 7)

	public Date getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIEDON", length = 7)

	public Date getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}

	@Column(name = "MODIFIEDBY", length = 20)

	public String getModifiedby() {
		return this.modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	@Column(name = "IPADDRESS", length = 16)

	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Column(name = "MACADDRESS", length = 32)

	public String getMacaddress() {
		return this.macaddress;
	}

	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}

	@Column(name = "ISDATAVARIFIED", length = 1)

	public String getIsdatavarified() {
		return this.isdatavarified;
	}

	public void setIsdatavarified(String isdatavarified) {
		this.isdatavarified = isdatavarified;
	}

	@Column(name = "GST_VENDOR_TYPE", length = 64)

	public String getGstVendorType() {
		return this.gstVendorType;
	}

	public void setGstVendorType(String gstVendorType) {
		this.gstVendorType = gstVendorType;
	}

	@Column(name = "LSTNUMBER", length = 30)

	public String getLstnumber() {
		return this.lstnumber;
	}

	public void setLstnumber(String lstnumber) {
		this.lstnumber = lstnumber;
	}

	@Column(name = "CSTNUMBER", length = 30)

	public String getCstnumber() {
		return this.cstnumber;
	}

	public void setCstnumber(String cstnumber) {
		this.cstnumber = cstnumber;
	}

	@Column(name = "TINNUMBER", length = 64)

	public String getTinnumber() {
		return this.tinnumber;
	}

	public void setTinnumber(String tinnumber) {
		this.tinnumber = tinnumber;
	}

	@Column(name = "SAC_HSN_ID", precision = 8, scale = 0)

	public Integer getSacHsnId() {
		return this.sacHsnId;
	}

	public void setSacHsnId(Integer sacHsnId) {
		this.sacHsnId = sacHsnId;
	}

	@Column(name = "TAX_SLAB_PER", precision = 4, scale = 0)

	public Short getTaxSlabPer() {
		return this.taxSlabPer;
	}

	public void setTaxSlabPer(Short taxSlabPer) {
		this.taxSlabPer = taxSlabPer;
	}

	@Column(name = "SM_SUPPLIERNAME", length = 64)

	public String getSmSuppliername() {
		return this.smSuppliername;
	}

	public void setSmSuppliername(String smSuppliername) {
		this.smSuppliername = smSuppliername;
	}

	@Column(name = "CONSTITUTIONBUSINESS", length = 64)

	public String getConstitutionbusiness() {
		return this.constitutionbusiness;
	}

	public void setConstitutionbusiness(String constitutionbusiness) {
		this.constitutionbusiness = constitutionbusiness;
	}

	@Column(name = "DESIGNATION", length = 64)

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "GSTREGISTRATIONSTATUS", length = 64)

	public String getGstregistrationstatus() {
		return this.gstregistrationstatus;
	}

	public void setGstregistrationstatus(String gstregistrationstatus) {
		this.gstregistrationstatus = gstregistrationstatus;
	}

	@Column(name = "GSTUNREGISTEREDREASON", length = 512)

	public String getGstunregisteredreason() {
		return this.gstunregisteredreason;
	}

	public void setGstunregisteredreason(String gstunregisteredreason) {
		this.gstunregisteredreason = gstunregisteredreason;
	}

	@Column(name = "BUSINESSADDRESS1", length = 256)

	public String getBusinessaddress1() {
		return this.businessaddress1;
	}

	public void setBusinessaddress1(String businessaddress1) {
		this.businessaddress1 = businessaddress1;
	}

	@Column(name = "BUSINESSADDRESS2", length = 256)

	public String getBusinessaddress2() {
		return this.businessaddress2;
	}

	public void setBusinessaddress2(String businessaddress2) {
		this.businessaddress2 = businessaddress2;
	}

	@Column(name = "BUSINESSADDRESS3", length = 256)

	public String getBusinessaddress3() {
		return this.businessaddress3;
	}

	public void setBusinessaddress3(String businessaddress3) {
		this.businessaddress3 = businessaddress3;
	}

	@Column(name = "BUSINESSCITY", length = 20)

	public String getBusinesscity() {
		return this.businesscity;
	}

	public void setBusinesscity(String businesscity) {
		this.businesscity = businesscity;
	}

	@Column(name = "BUSINESSSTATE", length = 70)

	public String getBusinessstate() {
		return this.businessstate;
	}

	public void setBusinessstate(String businessstate) {
		this.businessstate = businessstate;
	}

	@Column(name = "BUSINESSPIN", precision = 8, scale = 0)

	public Integer getBusinesspin() {
		return this.businesspin;
	}

	public void setBusinesspin(Integer businesspin) {
		this.businesspin = businesspin;
	}

	@Column(name = "BUSINESSCOUNTRY", length = 32)

	public String getBusinesscountry() {
		return this.businesscountry;
	}

	public void setBusinesscountry(String businesscountry) {
		this.businesscountry = businesscountry;
	}

	@Column(name = "FINANCEEMAILID")

	public String getFinanceemailid() {
		return this.financeemailid;
	}

	public void setFinanceemailid(String financeemailid) {
		this.financeemailid = financeemailid;
	}

	@Column(name = "REMARKS", length = 512)

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "ISGSTAPPLICABLE", length = 1)

	public String getIsgstapplicable() {
		return this.isgstapplicable;
	}

	public void setIsgstapplicable(String isgstapplicable) {
		this.isgstapplicable = isgstapplicable;
	}

	@Column(name = "STATECODE", length = 3)

	public String getStatecode() {
		return this.statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	@Column(name = "INTERNAL_SUPPLIER_TYPE", length = 128)

	public String getInternalSupplierType() {
		return this.internalSupplierType;
	}

	public void setInternalSupplierType(String internalSupplierType) {
		this.internalSupplierType = internalSupplierType;
	}

}