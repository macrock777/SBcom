package com.mudra.mboss.master.entity.supplier;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Suppliermaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SUPPLIERMASTER", schema = "MUDRA")

public class Suppliermaster implements java.io.Serializable {

	// Fields

	private SuppliermasterId id;
	private Byte companyid;
	private Byte divisionid;
	private Byte subdivisionid;
	private Byte locationid;
	private String suppliergroupid;
	private Integer glcode;
	private String suppliername;
	private String displayname;
	private String clientid;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private Integer pin;
	private String state;
	private String isactive;
	private String isblacklisted;
	private String pannumber;
	private String servicetaxnumber;
	private String cstnumber;
	private String lstnumber;
	private String emailid;
	private String tdscertificaterequirement;
	private Short creditdays;
	private String stdcode;
	private String telephonenumbers;
	private String telephoneextension;
	private String country;
	private String contactperson;
	private String mrv;
	private Integer jobtypeid;
	private String tdscompanytype;
	private String suppliertype;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String faxnumbers;
	private String oldcode;
	private String supplierdisplayname;
	private String suppliercategory;
	private String paytoname;
	private String telephonextension;
	private String tdssectionid;
	private Date servicetaxeffectivedate;
	private String servicetaxregistrationno;
	private String isregistrationcopyreceived;
	private String services;
	private String issquarecentimeter;
	private Integer printuniqueid;
	private String ismember;
	private Double commissionpercentage;
	private String language;
	private String isdataverified;
	private String panSuppliername;
	private String ispanverify;
	private String advertisingtax;
	private Integer copyuniqueid;
	private String isforeignvendor;
	private String ismsmedvendor;
	private String tinnumber;
	private String isacknowledgement;
	private String isonlineservice;
	private String gstVendorType;
	private String isnewlycreated;

	// Constructors

	/** default constructor */
	public Suppliermaster() {
	}

	/** minimal constructor */
	public Suppliermaster(SuppliermasterId id, Integer glcode, String suppliername) {
		this.id = id;
		this.glcode = glcode;
		this.suppliername = suppliername;
	}

	/** full constructor */
	public Suppliermaster(SuppliermasterId id, Byte companyid, Byte divisionid, Byte subdivisionid, Byte locationid,
			String suppliergroupid, Integer glcode, String suppliername, String displayname, String clientid,
			String address1, String address2, String address3, String city, Integer pin, String state, String isactive,
			String isblacklisted, String pannumber, String servicetaxnumber, String cstnumber, String lstnumber,
			String emailid, String tdscertificaterequirement, Short creditdays, String stdcode, String telephonenumbers,
			String telephoneextension, String country, String contactperson, String mrv, Integer jobtypeid,
			String tdscompanytype, String suppliertype, String createdby, Date createdon, Date modifiedon,
			String modifiedby, String ipaddress, String macaddress, String faxnumbers, String oldcode,
			String supplierdisplayname, String suppliercategory, String paytoname, String telephonextension,
			String tdssectionid, Date servicetaxeffectivedate, String servicetaxregistrationno,
			String isregistrationcopyreceived, String services, String issquarecentimeter, Integer printuniqueid,
			String ismember, Double commissionpercentage, String language, String isdataverified,
			String panSuppliername, String ispanverify, String advertisingtax, Integer copyuniqueid,
			String isforeignvendor, String ismsmedvendor, String tinnumber, String isacknowledgement,
			String isonlineservice, String gstVendorType, String isnewlycreated) {
		this.id = id;
		this.companyid = companyid;
		this.divisionid = divisionid;
		this.subdivisionid = subdivisionid;
		this.locationid = locationid;
		this.suppliergroupid = suppliergroupid;
		this.glcode = glcode;
		this.suppliername = suppliername;
		this.displayname = displayname;
		this.clientid = clientid;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.city = city;
		this.pin = pin;
		this.state = state;
		this.isactive = isactive;
		this.isblacklisted = isblacklisted;
		this.pannumber = pannumber;
		this.servicetaxnumber = servicetaxnumber;
		this.cstnumber = cstnumber;
		this.lstnumber = lstnumber;
		this.emailid = emailid;
		this.tdscertificaterequirement = tdscertificaterequirement;
		this.creditdays = creditdays;
		this.stdcode = stdcode;
		this.telephonenumbers = telephonenumbers;
		this.telephoneextension = telephoneextension;
		this.country = country;
		this.contactperson = contactperson;
		this.mrv = mrv;
		this.jobtypeid = jobtypeid;
		this.tdscompanytype = tdscompanytype;
		this.suppliertype = suppliertype;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.faxnumbers = faxnumbers;
		this.oldcode = oldcode;
		this.supplierdisplayname = supplierdisplayname;
		this.suppliercategory = suppliercategory;
		this.paytoname = paytoname;
		this.telephonextension = telephonextension;
		this.tdssectionid = tdssectionid;
		this.servicetaxeffectivedate = servicetaxeffectivedate;
		this.servicetaxregistrationno = servicetaxregistrationno;
		this.isregistrationcopyreceived = isregistrationcopyreceived;
		this.services = services;
		this.issquarecentimeter = issquarecentimeter;
		this.printuniqueid = printuniqueid;
		this.ismember = ismember;
		this.commissionpercentage = commissionpercentage;
		this.language = language;
		this.isdataverified = isdataverified;
		this.panSuppliername = panSuppliername;
		this.ispanverify = ispanverify;
		this.advertisingtax = advertisingtax;
		this.copyuniqueid = copyuniqueid;
		this.isforeignvendor = isforeignvendor;
		this.ismsmedvendor = ismsmedvendor;
		this.tinnumber = tinnumber;
		this.isacknowledgement = isacknowledgement;
		this.isonlineservice = isonlineservice;
		this.gstVendorType = gstVendorType;
		this.isnewlycreated = isnewlycreated;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "supplierid", column = @Column(name = "SUPPLIERID", nullable = false, length = 10)) })

	public SuppliermasterId getId() {
		return this.id;
	}

	public void setId(SuppliermasterId id) {
		this.id = id;
	}

	@Column(name = "COMPANYID", precision = 2, scale = 0)

	public Byte getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Byte companyid) {
		this.companyid = companyid;
	}

	@Column(name = "DIVISIONID", precision = 2, scale = 0)

	public Byte getDivisionid() {
		return this.divisionid;
	}

	public void setDivisionid(Byte divisionid) {
		this.divisionid = divisionid;
	}

	@Column(name = "SUBDIVISIONID", precision = 2, scale = 0)

	public Byte getSubdivisionid() {
		return this.subdivisionid;
	}

	public void setSubdivisionid(Byte subdivisionid) {
		this.subdivisionid = subdivisionid;
	}

	@Column(name = "LOCATIONID", precision = 2, scale = 0)

	public Byte getLocationid() {
		return this.locationid;
	}

	public void setLocationid(Byte locationid) {
		this.locationid = locationid;
	}

	@Column(name = "SUPPLIERGROUPID", length = 10)

	public String getSuppliergroupid() {
		return this.suppliergroupid;
	}

	public void setSuppliergroupid(String suppliergroupid) {
		this.suppliergroupid = suppliergroupid;
	}

	@Column(name = "GLCODE", nullable = false, precision = 7, scale = 0)

	public Integer getGlcode() {
		return this.glcode;
	}

	public void setGlcode(Integer glcode) {
		this.glcode = glcode;
	}

	@Column(name = "SUPPLIERNAME", nullable = false, length = 70)

	public String getSuppliername() {
		return this.suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	@Column(name = "DISPLAYNAME", length = 20)

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	@Column(name = "CLIENTID", length = 10)

	public String getClientid() {
		return this.clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
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

	@Column(name = "ISACTIVE", length = 1)

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	@Column(name = "ISBLACKLISTED", length = 1)

	public String getIsblacklisted() {
		return this.isblacklisted;
	}

	public void setIsblacklisted(String isblacklisted) {
		this.isblacklisted = isblacklisted;
	}

	@Column(name = "PANNUMBER", length = 30)

	public String getPannumber() {
		return this.pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	@Column(name = "SERVICETAXNUMBER", length = 50)

	public String getServicetaxnumber() {
		return this.servicetaxnumber;
	}

	public void setServicetaxnumber(String servicetaxnumber) {
		this.servicetaxnumber = servicetaxnumber;
	}

	@Column(name = "CSTNUMBER", length = 30)

	public String getCstnumber() {
		return this.cstnumber;
	}

	public void setCstnumber(String cstnumber) {
		this.cstnumber = cstnumber;
	}

	@Column(name = "LSTNUMBER", length = 30)

	public String getLstnumber() {
		return this.lstnumber;
	}

	public void setLstnumber(String lstnumber) {
		this.lstnumber = lstnumber;
	}

	@Column(name = "EMAILID")

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "TDSCERTIFICATEREQUIREMENT", length = 1)

	public String getTdscertificaterequirement() {
		return this.tdscertificaterequirement;
	}

	public void setTdscertificaterequirement(String tdscertificaterequirement) {
		this.tdscertificaterequirement = tdscertificaterequirement;
	}

	@Column(name = "CREDITDAYS", precision = 3, scale = 0)

	public Short getCreditdays() {
		return this.creditdays;
	}

	public void setCreditdays(Short creditdays) {
		this.creditdays = creditdays;
	}

	@Column(name = "STDCODE", length = 8)

	public String getStdcode() {
		return this.stdcode;
	}

	public void setStdcode(String stdcode) {
		this.stdcode = stdcode;
	}

	@Column(name = "TELEPHONENUMBERS", length = 64)

	public String getTelephonenumbers() {
		return this.telephonenumbers;
	}

	public void setTelephonenumbers(String telephonenumbers) {
		this.telephonenumbers = telephonenumbers;
	}

	@Column(name = "TELEPHONEEXTENSION", length = 24)

	public String getTelephoneextension() {
		return this.telephoneextension;
	}

	public void setTelephoneextension(String telephoneextension) {
		this.telephoneextension = telephoneextension;
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

	@Column(name = "MRV", length = 32)

	public String getMrv() {
		return this.mrv;
	}

	public void setMrv(String mrv) {
		this.mrv = mrv;
	}

	@Column(name = "JOBTYPEID", precision = 6, scale = 0)

	public Integer getJobtypeid() {
		return this.jobtypeid;
	}

	public void setJobtypeid(Integer jobtypeid) {
		this.jobtypeid = jobtypeid;
	}

	@Column(name = "TDSCOMPANYTYPE", length = 1)

	public String getTdscompanytype() {
		return this.tdscompanytype;
	}

	public void setTdscompanytype(String tdscompanytype) {
		this.tdscompanytype = tdscompanytype;
	}

	@Column(name = "SUPPLIERTYPE", length = 20)

	public String getSuppliertype() {
		return this.suppliertype;
	}

	public void setSuppliertype(String suppliertype) {
		this.suppliertype = suppliertype;
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

	@Column(name = "FAXNUMBERS", length = 32)

	public String getFaxnumbers() {
		return this.faxnumbers;
	}

	public void setFaxnumbers(String faxnumbers) {
		this.faxnumbers = faxnumbers;
	}

	@Column(name = "OLDCODE", length = 10)

	public String getOldcode() {
		return this.oldcode;
	}

	public void setOldcode(String oldcode) {
		this.oldcode = oldcode;
	}

	@Column(name = "SUPPLIERDISPLAYNAME", length = 32)

	public String getSupplierdisplayname() {
		return this.supplierdisplayname;
	}

	public void setSupplierdisplayname(String supplierdisplayname) {
		this.supplierdisplayname = supplierdisplayname;
	}

	@Column(name = "SUPPLIERCATEGORY", length = 16)

	public String getSuppliercategory() {
		return this.suppliercategory;
	}

	public void setSuppliercategory(String suppliercategory) {
		this.suppliercategory = suppliercategory;
	}

	@Column(name = "PAYTONAME", length = 80)

	public String getPaytoname() {
		return this.paytoname;
	}

	public void setPaytoname(String paytoname) {
		this.paytoname = paytoname;
	}

	@Column(name = "TELEPHONEXTENSION", length = 24)

	public String getTelephonextension() {
		return this.telephonextension;
	}

	public void setTelephonextension(String telephonextension) {
		this.telephonextension = telephonextension;
	}

	@Column(name = "TDSSECTIONID", length = 32)

	public String getTdssectionid() {
		return this.tdssectionid;
	}

	public void setTdssectionid(String tdssectionid) {
		this.tdssectionid = tdssectionid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SERVICETAXEFFECTIVEDATE", length = 7)

	public Date getServicetaxeffectivedate() {
		return this.servicetaxeffectivedate;
	}

	public void setServicetaxeffectivedate(Date servicetaxeffectivedate) {
		this.servicetaxeffectivedate = servicetaxeffectivedate;
	}

	@Column(name = "SERVICETAXREGISTRATIONNO", length = 40)

	public String getServicetaxregistrationno() {
		return this.servicetaxregistrationno;
	}

	public void setServicetaxregistrationno(String servicetaxregistrationno) {
		this.servicetaxregistrationno = servicetaxregistrationno;
	}

	@Column(name = "ISREGISTRATIONCOPYRECEIVED", length = 1)

	public String getIsregistrationcopyreceived() {
		return this.isregistrationcopyreceived;
	}

	public void setIsregistrationcopyreceived(String isregistrationcopyreceived) {
		this.isregistrationcopyreceived = isregistrationcopyreceived;
	}

	@Column(name = "SERVICES", length = 50)

	public String getServices() {
		return this.services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	@Column(name = "ISSQUARECENTIMETER", length = 1)

	public String getIssquarecentimeter() {
		return this.issquarecentimeter;
	}

	public void setIssquarecentimeter(String issquarecentimeter) {
		this.issquarecentimeter = issquarecentimeter;
	}

	@Column(name = "PRINTUNIQUEID", precision = 8, scale = 0)

	public Integer getPrintuniqueid() {
		return this.printuniqueid;
	}

	public void setPrintuniqueid(Integer printuniqueid) {
		this.printuniqueid = printuniqueid;
	}

	@Column(name = "ISMEMBER", length = 1)

	public String getIsmember() {
		return this.ismember;
	}

	public void setIsmember(String ismember) {
		this.ismember = ismember;
	}

	@Column(name = "COMMISSIONPERCENTAGE", precision = 5)

	public Double getCommissionpercentage() {
		return this.commissionpercentage;
	}

	public void setCommissionpercentage(Double commissionpercentage) {
		this.commissionpercentage = commissionpercentage;
	}

	@Column(name = "LANGUAGE", length = 10)

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "ISDATAVERIFIED", length = 1)

	public String getIsdataverified() {
		return this.isdataverified;
	}

	public void setIsdataverified(String isdataverified) {
		this.isdataverified = isdataverified;
	}

	@Column(name = "PAN_SUPPLIERNAME", length = 70)

	public String getPanSuppliername() {
		return this.panSuppliername;
	}

	public void setPanSuppliername(String panSuppliername) {
		this.panSuppliername = panSuppliername;
	}

	@Column(name = "ISPANVERIFY", length = 1)

	public String getIspanverify() {
		return this.ispanverify;
	}

	public void setIspanverify(String ispanverify) {
		this.ispanverify = ispanverify;
	}

	@Column(name = "ADVERTISINGTAX", length = 30)

	public String getAdvertisingtax() {
		return this.advertisingtax;
	}

	public void setAdvertisingtax(String advertisingtax) {
		this.advertisingtax = advertisingtax;
	}

	@Column(name = "COPYUNIQUEID", precision = 8, scale = 0)

	public Integer getCopyuniqueid() {
		return this.copyuniqueid;
	}

	public void setCopyuniqueid(Integer copyuniqueid) {
		this.copyuniqueid = copyuniqueid;
	}

	@Column(name = "ISFOREIGNVENDOR", length = 1)

	public String getIsforeignvendor() {
		return this.isforeignvendor;
	}

	public void setIsforeignvendor(String isforeignvendor) {
		this.isforeignvendor = isforeignvendor;
	}

	@Column(name = "ISMSMEDVENDOR", length = 1)

	public String getIsmsmedvendor() {
		return this.ismsmedvendor;
	}

	public void setIsmsmedvendor(String ismsmedvendor) {
		this.ismsmedvendor = ismsmedvendor;
	}

	@Column(name = "TINNUMBER", length = 64)

	public String getTinnumber() {
		return this.tinnumber;
	}

	public void setTinnumber(String tinnumber) {
		this.tinnumber = tinnumber;
	}

	@Column(name = "ISACKNOWLEDGEMENT", length = 1)

	public String getIsacknowledgement() {
		return this.isacknowledgement;
	}

	public void setIsacknowledgement(String isacknowledgement) {
		this.isacknowledgement = isacknowledgement;
	}

	@Column(name = "ISONLINESERVICE", length = 1)

	public String getIsonlineservice() {
		return this.isonlineservice;
	}

	public void setIsonlineservice(String isonlineservice) {
		this.isonlineservice = isonlineservice;
	}

	@Column(name = "GST_VENDOR_TYPE", length = 64)

	public String getGstVendorType() {
		return this.gstVendorType;
	}

	public void setGstVendorType(String gstVendorType) {
		this.gstVendorType = gstVendorType;
	}

	@Column(name = "ISNEWLYCREATED", length = 1)

	public String getIsnewlycreated() {
		return this.isnewlycreated;
	}

	public void setIsnewlycreated(String isnewlycreated) {
		this.isnewlycreated = isnewlycreated;
	}

}