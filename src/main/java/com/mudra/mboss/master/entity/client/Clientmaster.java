package com.mudra.mboss.master.entity.client;

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
 * Clientmaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENTMASTER", schema = "MUDRA")

public class Clientmaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientmasterId id;
	private String clientname;
	private String clientdisplayname;
	private String clientgroupid;
	private String clienttype;
	private Integer glcode;
	private String supplierid;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String pin;
	private String country;
	private String stdcode;
	private String telephonenumbers;
	private String faxnumbers;
	private String emailid;
	private Short creditdays;
	private String isactive;
	private Double exposurelimit;
	private String pannumber;
	private String servicetaxnumber;
	private String cstnumber;
	private String lstnumber;
	private Byte companyid;
	private Byte divisionid;
	private Byte subdivisionid;
	private Byte locationid;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String bankguaranteenumber;
	private Date bankguaranteedate;
	private Double bankguaranteeamount;
	private Date expirydate;
	private String chequebank;
	private String chequebranch;
	private String isservicetaxrequired;
	private String isagency;
	private Double businesscommitment;
	private String hascaresponsibility;
	private Double unbookedliability;
	private Integer oldcode;
	private String trialbalancecategory;
	private String tdsacnumber;
	private String iscommissiononnetamt;
	private String isupdaterorate;
	private String printaddressfrombrand;
	private String passdiscount;
	private String timesheetdisplay;
	private String isestimateraterequiredpress;
	private String isestimateraterequiredtv;
	private String hoclientgroupid;
	private String isnationalglobal;
	private String isddbassociateclient;
	private String tmpclientname;
	private String stampdutyapplicable;
	private String industry;
	private String exclusivity;
	private String exclusivityparameter;
	private Double interestonunpaidbills;
	private String productcode;
	private Double revenuefees;
	private Double revenuesupervision;
	private Double revenueothers;
	private String clienttype1;
	private String website;
	private String ispanverified;
	private Double stampcharg;
	private Double ltcpercentage;
	private String tinnumber;
	private String unit;
	private String operatingState;
	private String iscontractcopyrequired;
	private String tdssectionid;
	private String isapprovalinsertiondate;
	private String isLost;
	private Long dbclientcode;
	private String isdbbankactintimatedtoclient;
	private String clientType;
	private String isCurrentlyActive;
	private String clientTan;

	// Constructors

	/** default constructor */
	public Clientmaster() {
	}

	/** minimal constructor */
	public Clientmaster(ClientmasterId id, String clientname, Date createdon) {
		this.id = id;
		this.clientname = clientname;
		this.createdon = createdon;
	}

	/** full constructor */
	public Clientmaster(ClientmasterId id, String clientname, String clientdisplayname, String clientgroupid,
			String clienttype, Integer glcode, String supplierid, String address1, String address2, String address3,
			String city, String state, String pin, String country, String stdcode, String telephonenumbers,
			String faxnumbers, String emailid, Short creditdays, String isactive, Double exposurelimit,
			String pannumber, String servicetaxnumber, String cstnumber, String lstnumber, Byte companyid,
			Byte divisionid, Byte subdivisionid, Byte locationid, String createdby, Date createdon, Date modifiedon,
			String modifiedby, String ipaddress, String macaddress, String bankguaranteenumber, Date bankguaranteedate,
			Double bankguaranteeamount, Date expirydate, String chequebank, String chequebranch,
			String isservicetaxrequired, String isagency, Double businesscommitment, String hascaresponsibility,
			Double unbookedliability, Integer oldcode, String trialbalancecategory, String tdsacnumber,
			String iscommissiononnetamt, String isupdaterorate, String printaddressfrombrand, String passdiscount,
			String timesheetdisplay, String isestimateraterequiredpress, String isestimateraterequiredtv,
			String hoclientgroupid, String isnationalglobal, String isddbassociateclient, String tmpclientname,
			String stampdutyapplicable, String industry, String exclusivity, String exclusivityparameter,
			Double interestonunpaidbills, String productcode, Double revenuefees, Double revenuesupervision,
			Double revenueothers, String clienttype1, String website, String ispanverified, Double stampcharg,
			Double ltcpercentage, String tinnumber, String unit, String operatingState, String iscontractcopyrequired,
			String tdssectionid, String isapprovalinsertiondate, String isLost, Long dbclientcode,
			String isdbbankactintimatedtoclient, String clientType, String isCurrentlyActive, String clientTan) {
		this.id = id;
		this.clientname = clientname;
		this.clientdisplayname = clientdisplayname;
		this.clientgroupid = clientgroupid;
		this.clienttype = clienttype;
		this.glcode = glcode;
		this.supplierid = supplierid;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
		this.stdcode = stdcode;
		this.telephonenumbers = telephonenumbers;
		this.faxnumbers = faxnumbers;
		this.emailid = emailid;
		this.creditdays = creditdays;
		this.isactive = isactive;
		this.exposurelimit = exposurelimit;
		this.pannumber = pannumber;
		this.servicetaxnumber = servicetaxnumber;
		this.cstnumber = cstnumber;
		this.lstnumber = lstnumber;
		this.companyid = companyid;
		this.divisionid = divisionid;
		this.subdivisionid = subdivisionid;
		this.locationid = locationid;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.bankguaranteenumber = bankguaranteenumber;
		this.bankguaranteedate = bankguaranteedate;
		this.bankguaranteeamount = bankguaranteeamount;
		this.expirydate = expirydate;
		this.chequebank = chequebank;
		this.chequebranch = chequebranch;
		this.isservicetaxrequired = isservicetaxrequired;
		this.isagency = isagency;
		this.businesscommitment = businesscommitment;
		this.hascaresponsibility = hascaresponsibility;
		this.unbookedliability = unbookedliability;
		this.oldcode = oldcode;
		this.trialbalancecategory = trialbalancecategory;
		this.tdsacnumber = tdsacnumber;
		this.iscommissiononnetamt = iscommissiononnetamt;
		this.isupdaterorate = isupdaterorate;
		this.printaddressfrombrand = printaddressfrombrand;
		this.passdiscount = passdiscount;
		this.timesheetdisplay = timesheetdisplay;
		this.isestimateraterequiredpress = isestimateraterequiredpress;
		this.isestimateraterequiredtv = isestimateraterequiredtv;
		this.hoclientgroupid = hoclientgroupid;
		this.isnationalglobal = isnationalglobal;
		this.isddbassociateclient = isddbassociateclient;
		this.tmpclientname = tmpclientname;
		this.stampdutyapplicable = stampdutyapplicable;
		this.industry = industry;
		this.exclusivity = exclusivity;
		this.exclusivityparameter = exclusivityparameter;
		this.interestonunpaidbills = interestonunpaidbills;
		this.productcode = productcode;
		this.revenuefees = revenuefees;
		this.revenuesupervision = revenuesupervision;
		this.revenueothers = revenueothers;
		this.clienttype1 = clienttype1;
		this.website = website;
		this.ispanverified = ispanverified;
		this.stampcharg = stampcharg;
		this.ltcpercentage = ltcpercentage;
		this.tinnumber = tinnumber;
		this.unit = unit;
		this.operatingState = operatingState;
		this.iscontractcopyrequired = iscontractcopyrequired;
		this.tdssectionid = tdssectionid;
		this.isapprovalinsertiondate = isapprovalinsertiondate;
		this.isLost = isLost;
		this.dbclientcode = dbclientcode;
		this.isdbbankactintimatedtoclient = isdbbankactintimatedtoclient;
		this.clientType = clientType;
		this.isCurrentlyActive = isCurrentlyActive;
		this.clientTan = clientTan;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "clientid", column = @Column(name = "CLIENTID", nullable = false, length = 10)) })

	public ClientmasterId getId() {
		return this.id;
	}

	public void setId(ClientmasterId id) {
		this.id = id;
	}

	@Column(name = "CLIENTNAME", nullable = false, length = 64)

	public String getClientname() {
		return this.clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	@Column(name = "CLIENTDISPLAYNAME", length = 32)

	public String getClientdisplayname() {
		return this.clientdisplayname;
	}

	public void setClientdisplayname(String clientdisplayname) {
		this.clientdisplayname = clientdisplayname;
	}

	@Column(name = "CLIENTGROUPID", length = 10)

	public String getClientgroupid() {
		return this.clientgroupid;
	}

	public void setClientgroupid(String clientgroupid) {
		this.clientgroupid = clientgroupid;
	}

	@Column(name = "CLIENTTYPE", length = 24)

	public String getClienttype() {
		return this.clienttype;
	}

	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
	}

	@Column(name = "GLCODE", precision = 7, scale = 0)

	public Integer getGlcode() {
		return this.glcode;
	}

	public void setGlcode(Integer glcode) {
		this.glcode = glcode;
	}

	@Column(name = "SUPPLIERID", length = 10)

	public String getSupplierid() {
		return this.supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	@Column(name = "ADDRESS1", length = 128)

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "ADDRESS2", length = 128)

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "ADDRESS3", length = 128)

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@Column(name = "CITY", length = 64)

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATE", length = 64)

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "PIN", length = 16)

	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Column(name = "COUNTRY", length = 64)

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	@Column(name = "FAXNUMBERS", length = 64)

	public String getFaxnumbers() {
		return this.faxnumbers;
	}

	public void setFaxnumbers(String faxnumbers) {
		this.faxnumbers = faxnumbers;
	}

	@Column(name = "EMAILID", length = 64)

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "CREDITDAYS", precision = 3, scale = 0)

	public Short getCreditdays() {
		return this.creditdays;
	}

	public void setCreditdays(Short creditdays) {
		this.creditdays = creditdays;
	}

	@Column(name = "ISACTIVE", length = 1)

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	@Column(name = "EXPOSURELIMIT", precision = 14)

	public Double getExposurelimit() {
		return this.exposurelimit;
	}

	public void setExposurelimit(Double exposurelimit) {
		this.exposurelimit = exposurelimit;
	}

	@Column(name = "PANNUMBER", length = 32)

	public String getPannumber() {
		return this.pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	@Column(name = "SERVICETAXNUMBER", length = 32)

	public String getServicetaxnumber() {
		return this.servicetaxnumber;
	}

	public void setServicetaxnumber(String servicetaxnumber) {
		this.servicetaxnumber = servicetaxnumber;
	}

	@Column(name = "CSTNUMBER", length = 32)

	public String getCstnumber() {
		return this.cstnumber;
	}

	public void setCstnumber(String cstnumber) {
		this.cstnumber = cstnumber;
	}

	@Column(name = "LSTNUMBER", length = 32)

	public String getLstnumber() {
		return this.lstnumber;
	}

	public void setLstnumber(String lstnumber) {
		this.lstnumber = lstnumber;
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

	@Column(name = "CREATEDBY", length = 20)

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDON", nullable = false, length = 7)

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

	@Column(name = "BANKGUARANTEENUMBER", length = 32)

	public String getBankguaranteenumber() {
		return this.bankguaranteenumber;
	}

	public void setBankguaranteenumber(String bankguaranteenumber) {
		this.bankguaranteenumber = bankguaranteenumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BANKGUARANTEEDATE", length = 7)

	public Date getBankguaranteedate() {
		return this.bankguaranteedate;
	}

	public void setBankguaranteedate(Date bankguaranteedate) {
		this.bankguaranteedate = bankguaranteedate;
	}

	@Column(name = "BANKGUARANTEEAMOUNT", precision = 14)

	public Double getBankguaranteeamount() {
		return this.bankguaranteeamount;
	}

	public void setBankguaranteeamount(Double bankguaranteeamount) {
		this.bankguaranteeamount = bankguaranteeamount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRYDATE", length = 7)

	public Date getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	@Column(name = "CHEQUEBANK", length = 40)

	public String getChequebank() {
		return this.chequebank;
	}

	public void setChequebank(String chequebank) {
		this.chequebank = chequebank;
	}

	@Column(name = "CHEQUEBRANCH", length = 20)

	public String getChequebranch() {
		return this.chequebranch;
	}

	public void setChequebranch(String chequebranch) {
		this.chequebranch = chequebranch;
	}

	@Column(name = "ISSERVICETAXREQUIRED", length = 1)

	public String getIsservicetaxrequired() {
		return this.isservicetaxrequired;
	}

	public void setIsservicetaxrequired(String isservicetaxrequired) {
		this.isservicetaxrequired = isservicetaxrequired;
	}

	@Column(name = "ISAGENCY", length = 1)

	public String getIsagency() {
		return this.isagency;
	}

	public void setIsagency(String isagency) {
		this.isagency = isagency;
	}

	@Column(name = "BUSINESSCOMMITMENT", precision = 14)

	public Double getBusinesscommitment() {
		return this.businesscommitment;
	}

	public void setBusinesscommitment(Double businesscommitment) {
		this.businesscommitment = businesscommitment;
	}

	@Column(name = "HASCARESPONSIBILITY", length = 1)

	public String getHascaresponsibility() {
		return this.hascaresponsibility;
	}

	public void setHascaresponsibility(String hascaresponsibility) {
		this.hascaresponsibility = hascaresponsibility;
	}

	@Column(name = "UNBOOKEDLIABILITY", precision = 14)

	public Double getUnbookedliability() {
		return this.unbookedliability;
	}

	public void setUnbookedliability(Double unbookedliability) {
		this.unbookedliability = unbookedliability;
	}

	@Column(name = "OLDCODE", precision = 7, scale = 0)

	public Integer getOldcode() {
		return this.oldcode;
	}

	public void setOldcode(Integer oldcode) {
		this.oldcode = oldcode;
	}

	@Column(name = "TRIALBALANCECATEGORY", length = 2)

	public String getTrialbalancecategory() {
		return this.trialbalancecategory;
	}

	public void setTrialbalancecategory(String trialbalancecategory) {
		this.trialbalancecategory = trialbalancecategory;
	}

	@Column(name = "TDSACNUMBER", length = 32)

	public String getTdsacnumber() {
		return this.tdsacnumber;
	}

	public void setTdsacnumber(String tdsacnumber) {
		this.tdsacnumber = tdsacnumber;
	}

	@Column(name = "ISCOMMISSIONONNETAMT", length = 1)

	public String getIscommissiononnetamt() {
		return this.iscommissiononnetamt;
	}

	public void setIscommissiononnetamt(String iscommissiononnetamt) {
		this.iscommissiononnetamt = iscommissiononnetamt;
	}

	@Column(name = "ISUPDATERORATE", length = 1)

	public String getIsupdaterorate() {
		return this.isupdaterorate;
	}

	public void setIsupdaterorate(String isupdaterorate) {
		this.isupdaterorate = isupdaterorate;
	}

	@Column(name = "PRINTADDRESSFROMBRAND", length = 1)

	public String getPrintaddressfrombrand() {
		return this.printaddressfrombrand;
	}

	public void setPrintaddressfrombrand(String printaddressfrombrand) {
		this.printaddressfrombrand = printaddressfrombrand;
	}

	@Column(name = "PASSDISCOUNT", length = 1)

	public String getPassdiscount() {
		return this.passdiscount;
	}

	public void setPassdiscount(String passdiscount) {
		this.passdiscount = passdiscount;
	}

	@Column(name = "TIMESHEETDISPLAY", length = 1)

	public String getTimesheetdisplay() {
		return this.timesheetdisplay;
	}

	public void setTimesheetdisplay(String timesheetdisplay) {
		this.timesheetdisplay = timesheetdisplay;
	}

	@Column(name = "ISESTIMATERATEREQUIREDPRESS", length = 1)

	public String getIsestimateraterequiredpress() {
		return this.isestimateraterequiredpress;
	}

	public void setIsestimateraterequiredpress(String isestimateraterequiredpress) {
		this.isestimateraterequiredpress = isestimateraterequiredpress;
	}

	@Column(name = "ISESTIMATERATEREQUIREDTV", length = 1)

	public String getIsestimateraterequiredtv() {
		return this.isestimateraterequiredtv;
	}

	public void setIsestimateraterequiredtv(String isestimateraterequiredtv) {
		this.isestimateraterequiredtv = isestimateraterequiredtv;
	}

	@Column(name = "HOCLIENTGROUPID", length = 10)

	public String getHoclientgroupid() {
		return this.hoclientgroupid;
	}

	public void setHoclientgroupid(String hoclientgroupid) {
		this.hoclientgroupid = hoclientgroupid;
	}

	@Column(name = "ISNATIONALGLOBAL", length = 1)

	public String getIsnationalglobal() {
		return this.isnationalglobal;
	}

	public void setIsnationalglobal(String isnationalglobal) {
		this.isnationalglobal = isnationalglobal;
	}

	@Column(name = "ISDDBASSOCIATECLIENT", length = 1)

	public String getIsddbassociateclient() {
		return this.isddbassociateclient;
	}

	public void setIsddbassociateclient(String isddbassociateclient) {
		this.isddbassociateclient = isddbassociateclient;
	}

	@Column(name = "TMPCLIENTNAME", length = 64)

	public String getTmpclientname() {
		return this.tmpclientname;
	}

	public void setTmpclientname(String tmpclientname) {
		this.tmpclientname = tmpclientname;
	}

	@Column(name = "STAMPDUTYAPPLICABLE", length = 1)

	public String getStampdutyapplicable() {
		return this.stampdutyapplicable;
	}

	public void setStampdutyapplicable(String stampdutyapplicable) {
		this.stampdutyapplicable = stampdutyapplicable;
	}

	@Column(name = "INDUSTRY", length = 64)

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Column(name = "EXCLUSIVITY", length = 1)

	public String getExclusivity() {
		return this.exclusivity;
	}

	public void setExclusivity(String exclusivity) {
		this.exclusivity = exclusivity;
	}

	@Column(name = "EXCLUSIVITYPARAMETER", length = 64)

	public String getExclusivityparameter() {
		return this.exclusivityparameter;
	}

	public void setExclusivityparameter(String exclusivityparameter) {
		this.exclusivityparameter = exclusivityparameter;
	}

	@Column(name = "INTERESTONUNPAIDBILLS", precision = 14)

	public Double getInterestonunpaidbills() {
		return this.interestonunpaidbills;
	}

	public void setInterestonunpaidbills(Double interestonunpaidbills) {
		this.interestonunpaidbills = interestonunpaidbills;
	}

	@Column(name = "PRODUCTCODE", length = 32)

	public String getProductcode() {
		return this.productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	@Column(name = "REVENUEFEES", precision = 14)

	public Double getRevenuefees() {
		return this.revenuefees;
	}

	public void setRevenuefees(Double revenuefees) {
		this.revenuefees = revenuefees;
	}

	@Column(name = "REVENUESUPERVISION", precision = 14)

	public Double getRevenuesupervision() {
		return this.revenuesupervision;
	}

	public void setRevenuesupervision(Double revenuesupervision) {
		this.revenuesupervision = revenuesupervision;
	}

	@Column(name = "REVENUEOTHERS", precision = 14)

	public Double getRevenueothers() {
		return this.revenueothers;
	}

	public void setRevenueothers(Double revenueothers) {
		this.revenueothers = revenueothers;
	}

	@Column(name = "CLIENTTYPE1", length = 24)

	public String getClienttype1() {
		return this.clienttype1;
	}

	public void setClienttype1(String clienttype1) {
		this.clienttype1 = clienttype1;
	}

	@Column(name = "WEBSITE", length = 64)

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "ISPANVERIFIED", length = 1)

	public String getIspanverified() {
		return this.ispanverified;
	}

	public void setIspanverified(String ispanverified) {
		this.ispanverified = ispanverified;
	}

	@Column(name = "STAMPCHARG", precision = 5)

	public Double getStampcharg() {
		return this.stampcharg;
	}

	public void setStampcharg(Double stampcharg) {
		this.stampcharg = stampcharg;
	}

	@Column(name = "LTCPERCENTAGE", precision = 5)

	public Double getLtcpercentage() {
		return this.ltcpercentage;
	}

	public void setLtcpercentage(Double ltcpercentage) {
		this.ltcpercentage = ltcpercentage;
	}

	@Column(name = "TINNUMBER", length = 32)

	public String getTinnumber() {
		return this.tinnumber;
	}

	public void setTinnumber(String tinnumber) {
		this.tinnumber = tinnumber;
	}

	@Column(name = "UNIT", length = 8)

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "OPERATING_STATE", length = 32)

	public String getOperatingState() {
		return this.operatingState;
	}

	public void setOperatingState(String operatingState) {
		this.operatingState = operatingState;
	}

	@Column(name = "ISCONTRACTCOPYREQUIRED", length = 1)

	public String getIscontractcopyrequired() {
		return this.iscontractcopyrequired;
	}

	public void setIscontractcopyrequired(String iscontractcopyrequired) {
		this.iscontractcopyrequired = iscontractcopyrequired;
	}

	@Column(name = "TDSSECTIONID", length = 16)

	public String getTdssectionid() {
		return this.tdssectionid;
	}

	public void setTdssectionid(String tdssectionid) {
		this.tdssectionid = tdssectionid;
	}

	@Column(name = "ISAPPROVALINSERTIONDATE", length = 1)

	public String getIsapprovalinsertiondate() {
		return this.isapprovalinsertiondate;
	}

	public void setIsapprovalinsertiondate(String isapprovalinsertiondate) {
		this.isapprovalinsertiondate = isapprovalinsertiondate;
	}

	@Column(name = "IS_LOST", length = 1)

	public String getIsLost() {
		return this.isLost;
	}

	public void setIsLost(String isLost) {
		this.isLost = isLost;
	}

	@Column(name = "DBCLIENTCODE", precision = 13, scale = 0)

	public Long getDbclientcode() {
		return this.dbclientcode;
	}

	public void setDbclientcode(Long dbclientcode) {
		this.dbclientcode = dbclientcode;
	}

	@Column(name = "ISDBBANKACTINTIMATEDTOCLIENT", length = 1)

	public String getIsdbbankactintimatedtoclient() {
		return this.isdbbankactintimatedtoclient;
	}

	public void setIsdbbankactintimatedtoclient(String isdbbankactintimatedtoclient) {
		this.isdbbankactintimatedtoclient = isdbbankactintimatedtoclient;
	}

	@Column(name = "CLIENT_TYPE", length = 64)

	public String getClientType() {
		return this.clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	@Column(name = "IS_CURRENTLY_ACTIVE", length = 1)

	public String getIsCurrentlyActive() {
		return this.isCurrentlyActive;
	}

	public void setIsCurrentlyActive(String isCurrentlyActive) {
		this.isCurrentlyActive = isCurrentlyActive;
	}

	@Column(name = "CLIENT_TAN", length = 12)

	public String getClientTan() {
		return this.clientTan;
	}

	public void setClientTan(String clientTan) {
		this.clientTan = clientTan;
	}

}