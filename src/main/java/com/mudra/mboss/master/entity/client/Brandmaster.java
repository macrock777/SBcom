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
 * Brandmaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BRANDMASTER", schema = "MUDRA")

public class Brandmaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BrandmasterId id;
	private String productcode;
	private String brandname;
	private String agencytype;
	private Double agencycommission;
	private Double clientcommission;
	private Double cacommission;
	private String contactperson;
	private String stdcode;
	private String telephonenumbers;
	private String emailid;
	private String mobilenumber;
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
	private String printprefix;
	private String iscommissionsharing;
	private String iscabreakuprequired;
	private Double hiddencommissionperc;
	private String supplierid;
	private String isomsclient;
	private Double omscommissionpercent;
	private String caautoporaised;
	private String clientautoporaised;
	private String casupplierid;
	private String clientsupplierid;
	private String caresponsible;
	private String clinetresposible;
	private Double billingperc;
	private Integer printuniqueid;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String pin;
	private String country;
	private String clientstdcode;
	private String clienttelephonenumbers;
	private String clientfaxnumbers;
	private String clientemailid;
	private String prnbrandnmclientnm;
	private String passdiscount;
	private String isactive;
	private String timesheetdisplay;
	private Double billingsharingpercentage;
	private String groupbrandid;
	private String sectorcode;
	private String tmpbrandname;
	private String exclusivity;
	private String exclusivityparameter;
	private Double interestonunpaidbills;
	private Date clientfirstsignon;
	private Double remuneration;
	private String ismediarequired;
	private String ddbBrandcode;
	private Double gstAgencyCommissionPer;
	private Double gstClientCommissionPer;
	private Double gstCaCommissionPer;
	private Double gstHiddenCommissionPer;
	private Double agencycommissionNet;
	private String hasBarterDeal;
	private Double barterDealAgencyPer;

	// Constructors

	/** default constructor */
	public Brandmaster() {
	}

	/** minimal constructor */
	public Brandmaster(BrandmasterId id, String productcode, String brandname, String agencytype,
			Double agencycommission, Double clientcommission, Double cacommission, String createdby, Date createdon) {
		this.id = id;
		this.productcode = productcode;
		this.brandname = brandname;
		this.agencytype = agencytype;
		this.agencycommission = agencycommission;
		this.clientcommission = clientcommission;
		this.cacommission = cacommission;
		this.createdby = createdby;
		this.createdon = createdon;
	}

	/** full constructor */
	public Brandmaster(BrandmasterId id, String productcode, String brandname, String agencytype,
			Double agencycommission, Double clientcommission, Double cacommission, String contactperson, String stdcode,
			String telephonenumbers, String emailid, String mobilenumber, Byte companyid, Byte divisionid,
			Byte subdivisionid, Byte locationid, String createdby, Date createdon, Date modifiedon, String modifiedby,
			String ipaddress, String macaddress, String printprefix, String iscommissionsharing,
			String iscabreakuprequired, Double hiddencommissionperc, String supplierid, String isomsclient,
			Double omscommissionpercent, String caautoporaised, String clientautoporaised, String casupplierid,
			String clientsupplierid, String caresponsible, String clinetresposible, Double billingperc,
			Integer printuniqueid, String address1, String address2, String address3, String city, String state,
			String pin, String country, String clientstdcode, String clienttelephonenumbers, String clientfaxnumbers,
			String clientemailid, String prnbrandnmclientnm, String passdiscount, String isactive,
			String timesheetdisplay, Double billingsharingpercentage, String groupbrandid, String sectorcode,
			String tmpbrandname, String exclusivity, String exclusivityparameter, Double interestonunpaidbills,
			Date clientfirstsignon, Double remuneration, String ismediarequired, String ddbBrandcode,
			Double gstAgencyCommissionPer, Double gstClientCommissionPer, Double gstCaCommissionPer,
			Double gstHiddenCommissionPer, Double agencycommissionNet, String hasBarterDeal,
			Double barterDealAgencyPer) {
		this.id = id;
		this.productcode = productcode;
		this.brandname = brandname;
		this.agencytype = agencytype;
		this.agencycommission = agencycommission;
		this.clientcommission = clientcommission;
		this.cacommission = cacommission;
		this.contactperson = contactperson;
		this.stdcode = stdcode;
		this.telephonenumbers = telephonenumbers;
		this.emailid = emailid;
		this.mobilenumber = mobilenumber;
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
		this.printprefix = printprefix;
		this.iscommissionsharing = iscommissionsharing;
		this.iscabreakuprequired = iscabreakuprequired;
		this.hiddencommissionperc = hiddencommissionperc;
		this.supplierid = supplierid;
		this.isomsclient = isomsclient;
		this.omscommissionpercent = omscommissionpercent;
		this.caautoporaised = caautoporaised;
		this.clientautoporaised = clientautoporaised;
		this.casupplierid = casupplierid;
		this.clientsupplierid = clientsupplierid;
		this.caresponsible = caresponsible;
		this.clinetresposible = clinetresposible;
		this.billingperc = billingperc;
		this.printuniqueid = printuniqueid;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
		this.clientstdcode = clientstdcode;
		this.clienttelephonenumbers = clienttelephonenumbers;
		this.clientfaxnumbers = clientfaxnumbers;
		this.clientemailid = clientemailid;
		this.prnbrandnmclientnm = prnbrandnmclientnm;
		this.passdiscount = passdiscount;
		this.isactive = isactive;
		this.timesheetdisplay = timesheetdisplay;
		this.billingsharingpercentage = billingsharingpercentage;
		this.groupbrandid = groupbrandid;
		this.sectorcode = sectorcode;
		this.tmpbrandname = tmpbrandname;
		this.exclusivity = exclusivity;
		this.exclusivityparameter = exclusivityparameter;
		this.interestonunpaidbills = interestonunpaidbills;
		this.clientfirstsignon = clientfirstsignon;
		this.remuneration = remuneration;
		this.ismediarequired = ismediarequired;
		this.ddbBrandcode = ddbBrandcode;
		this.gstAgencyCommissionPer = gstAgencyCommissionPer;
		this.gstClientCommissionPer = gstClientCommissionPer;
		this.gstCaCommissionPer = gstCaCommissionPer;
		this.gstHiddenCommissionPer = gstHiddenCommissionPer;
		this.agencycommissionNet = agencycommissionNet;
		this.hasBarterDeal = hasBarterDeal;
		this.barterDealAgencyPer = barterDealAgencyPer;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "clientid", column = @Column(name = "CLIENTID", nullable = false, length = 10)),
			@AttributeOverride(name = "brandid", column = @Column(name = "BRANDID", nullable = false, length = 10)) })

	public BrandmasterId getId() {
		return this.id;
	}

	public void setId(BrandmasterId id) {
		this.id = id;
	}

	@Column(name = "PRODUCTCODE", nullable = false, length = 64)

	public String getProductcode() {
		return this.productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	@Column(name = "BRANDNAME", nullable = false, length = 40)

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	@Column(name = "AGENCYTYPE", nullable = false, length = 1)

	public String getAgencytype() {
		return this.agencytype;
	}

	public void setAgencytype(String agencytype) {
		this.agencytype = agencytype;
	}

	@Column(name = "AGENCYCOMMISSION", nullable = false, precision = 5)

	public Double getAgencycommission() {
		return this.agencycommission;
	}

	public void setAgencycommission(Double agencycommission) {
		this.agencycommission = agencycommission;
	}

	@Column(name = "CLIENTCOMMISSION", nullable = false, precision = 5)

	public Double getClientcommission() {
		return this.clientcommission;
	}

	public void setClientcommission(Double clientcommission) {
		this.clientcommission = clientcommission;
	}

	@Column(name = "CACOMMISSION", nullable = false, precision = 5)

	public Double getCacommission() {
		return this.cacommission;
	}

	public void setCacommission(Double cacommission) {
		this.cacommission = cacommission;
	}

	@Column(name = "CONTACTPERSON", length = 64)

	public String getContactperson() {
		return this.contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
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

	@Column(name = "EMAILID", length = 64)

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "MOBILENUMBER", length = 32)

	public String getMobilenumber() {
		return this.mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
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

	@Column(name = "CREATEDBY", nullable = false, length = 20)

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

	@Column(name = "PRINTPREFIX", length = 5)

	public String getPrintprefix() {
		return this.printprefix;
	}

	public void setPrintprefix(String printprefix) {
		this.printprefix = printprefix;
	}

	@Column(name = "ISCOMMISSIONSHARING", length = 1)

	public String getIscommissionsharing() {
		return this.iscommissionsharing;
	}

	public void setIscommissionsharing(String iscommissionsharing) {
		this.iscommissionsharing = iscommissionsharing;
	}

	@Column(name = "ISCABREAKUPREQUIRED", length = 1)

	public String getIscabreakuprequired() {
		return this.iscabreakuprequired;
	}

	public void setIscabreakuprequired(String iscabreakuprequired) {
		this.iscabreakuprequired = iscabreakuprequired;
	}

	@Column(name = "HIDDENCOMMISSIONPERC", precision = 5)

	public Double getHiddencommissionperc() {
		return this.hiddencommissionperc;
	}

	public void setHiddencommissionperc(Double hiddencommissionperc) {
		this.hiddencommissionperc = hiddencommissionperc;
	}

	@Column(name = "SUPPLIERID", length = 10)

	public String getSupplierid() {
		return this.supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	@Column(name = "ISOMSCLIENT", length = 1)

	public String getIsomsclient() {
		return this.isomsclient;
	}

	public void setIsomsclient(String isomsclient) {
		this.isomsclient = isomsclient;
	}

	@Column(name = "OMSCOMMISSIONPERCENT", precision = 5)

	public Double getOmscommissionpercent() {
		return this.omscommissionpercent;
	}

	public void setOmscommissionpercent(Double omscommissionpercent) {
		this.omscommissionpercent = omscommissionpercent;
	}

	@Column(name = "CAAUTOPORAISED", length = 1)

	public String getCaautoporaised() {
		return this.caautoporaised;
	}

	public void setCaautoporaised(String caautoporaised) {
		this.caautoporaised = caautoporaised;
	}

	@Column(name = "CLIENTAUTOPORAISED", length = 1)

	public String getClientautoporaised() {
		return this.clientautoporaised;
	}

	public void setClientautoporaised(String clientautoporaised) {
		this.clientautoporaised = clientautoporaised;
	}

	@Column(name = "CASUPPLIERID", length = 10)

	public String getCasupplierid() {
		return this.casupplierid;
	}

	public void setCasupplierid(String casupplierid) {
		this.casupplierid = casupplierid;
	}

	@Column(name = "CLIENTSUPPLIERID", length = 10)

	public String getClientsupplierid() {
		return this.clientsupplierid;
	}

	public void setClientsupplierid(String clientsupplierid) {
		this.clientsupplierid = clientsupplierid;
	}

	@Column(name = "CARESPONSIBLE", length = 1)

	public String getCaresponsible() {
		return this.caresponsible;
	}

	public void setCaresponsible(String caresponsible) {
		this.caresponsible = caresponsible;
	}

	@Column(name = "CLINETRESPOSIBLE", length = 1)

	public String getClinetresposible() {
		return this.clinetresposible;
	}

	public void setClinetresposible(String clinetresposible) {
		this.clinetresposible = clinetresposible;
	}

	@Column(name = "BILLINGPERC", precision = 5)

	public Double getBillingperc() {
		return this.billingperc;
	}

	public void setBillingperc(Double billingperc) {
		this.billingperc = billingperc;
	}

	@Column(name = "PRINTUNIQUEID", precision = 8, scale = 0)

	public Integer getPrintuniqueid() {
		return this.printuniqueid;
	}

	public void setPrintuniqueid(Integer printuniqueid) {
		this.printuniqueid = printuniqueid;
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

	@Column(name = "CLIENTSTDCODE", length = 8)

	public String getClientstdcode() {
		return this.clientstdcode;
	}

	public void setClientstdcode(String clientstdcode) {
		this.clientstdcode = clientstdcode;
	}

	@Column(name = "CLIENTTELEPHONENUMBERS", length = 64)

	public String getClienttelephonenumbers() {
		return this.clienttelephonenumbers;
	}

	public void setClienttelephonenumbers(String clienttelephonenumbers) {
		this.clienttelephonenumbers = clienttelephonenumbers;
	}

	@Column(name = "CLIENTFAXNUMBERS", length = 64)

	public String getClientfaxnumbers() {
		return this.clientfaxnumbers;
	}

	public void setClientfaxnumbers(String clientfaxnumbers) {
		this.clientfaxnumbers = clientfaxnumbers;
	}

	@Column(name = "CLIENTEMAILID", length = 64)

	public String getClientemailid() {
		return this.clientemailid;
	}

	public void setClientemailid(String clientemailid) {
		this.clientemailid = clientemailid;
	}

	@Column(name = "PRNBRANDNMCLIENTNM", length = 1)

	public String getPrnbrandnmclientnm() {
		return this.prnbrandnmclientnm;
	}

	public void setPrnbrandnmclientnm(String prnbrandnmclientnm) {
		this.prnbrandnmclientnm = prnbrandnmclientnm;
	}

	@Column(name = "PASSDISCOUNT", length = 1)

	public String getPassdiscount() {
		return this.passdiscount;
	}

	public void setPassdiscount(String passdiscount) {
		this.passdiscount = passdiscount;
	}

	@Column(name = "ISACTIVE", length = 1)

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	@Column(name = "TIMESHEETDISPLAY", length = 1)

	public String getTimesheetdisplay() {
		return this.timesheetdisplay;
	}

	public void setTimesheetdisplay(String timesheetdisplay) {
		this.timesheetdisplay = timesheetdisplay;
	}

	@Column(name = "BILLINGSHARINGPERCENTAGE", precision = 5)

	public Double getBillingsharingpercentage() {
		return this.billingsharingpercentage;
	}

	public void setBillingsharingpercentage(Double billingsharingpercentage) {
		this.billingsharingpercentage = billingsharingpercentage;
	}

	@Column(name = "GROUPBRANDID", length = 10)

	public String getGroupbrandid() {
		return this.groupbrandid;
	}

	public void setGroupbrandid(String groupbrandid) {
		this.groupbrandid = groupbrandid;
	}

	@Column(name = "SECTORCODE", length = 64)

	public String getSectorcode() {
		return this.sectorcode;
	}

	public void setSectorcode(String sectorcode) {
		this.sectorcode = sectorcode;
	}

	@Column(name = "TMPBRANDNAME", length = 40)

	public String getTmpbrandname() {
		return this.tmpbrandname;
	}

	public void setTmpbrandname(String tmpbrandname) {
		this.tmpbrandname = tmpbrandname;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "CLIENTFIRSTSIGNON", length = 7)

	public Date getClientfirstsignon() {
		return this.clientfirstsignon;
	}

	public void setClientfirstsignon(Date clientfirstsignon) {
		this.clientfirstsignon = clientfirstsignon;
	}

	@Column(name = "REMUNERATION", precision = 14)

	public Double getRemuneration() {
		return this.remuneration;
	}

	public void setRemuneration(Double remuneration) {
		this.remuneration = remuneration;
	}

	@Column(name = "ISMEDIAREQUIRED", length = 1)

	public String getIsmediarequired() {
		return this.ismediarequired;
	}

	public void setIsmediarequired(String ismediarequired) {
		this.ismediarequired = ismediarequired;
	}

	@Column(name = "DDB_BRANDCODE", length = 10)

	public String getDdbBrandcode() {
		return this.ddbBrandcode;
	}

	public void setDdbBrandcode(String ddbBrandcode) {
		this.ddbBrandcode = ddbBrandcode;
	}

	@Column(name = "GST_AGENCY_COMMISSION_PER", precision = 8, scale = 5)

	public Double getGstAgencyCommissionPer() {
		return this.gstAgencyCommissionPer;
	}

	public void setGstAgencyCommissionPer(Double gstAgencyCommissionPer) {
		this.gstAgencyCommissionPer = gstAgencyCommissionPer;
	}

	@Column(name = "GST_CLIENT_COMMISSION_PER", precision = 8, scale = 5)

	public Double getGstClientCommissionPer() {
		return this.gstClientCommissionPer;
	}

	public void setGstClientCommissionPer(Double gstClientCommissionPer) {
		this.gstClientCommissionPer = gstClientCommissionPer;
	}

	@Column(name = "GST_CA_COMMISSION_PER", precision = 8, scale = 5)

	public Double getGstCaCommissionPer() {
		return this.gstCaCommissionPer;
	}

	public void setGstCaCommissionPer(Double gstCaCommissionPer) {
		this.gstCaCommissionPer = gstCaCommissionPer;
	}

	@Column(name = "GST_HIDDEN_COMMISSION_PER", precision = 8, scale = 5)

	public Double getGstHiddenCommissionPer() {
		return this.gstHiddenCommissionPer;
	}

	public void setGstHiddenCommissionPer(Double gstHiddenCommissionPer) {
		this.gstHiddenCommissionPer = gstHiddenCommissionPer;
	}

	@Column(name = "AGENCYCOMMISSION_NET", precision = 5)

	public Double getAgencycommissionNet() {
		return this.agencycommissionNet;
	}

	public void setAgencycommissionNet(Double agencycommissionNet) {
		this.agencycommissionNet = agencycommissionNet;
	}

	@Column(name = "HAS_BARTER_DEAL", length = 1)

	public String getHasBarterDeal() {
		return this.hasBarterDeal;
	}

	public void setHasBarterDeal(String hasBarterDeal) {
		this.hasBarterDeal = hasBarterDeal;
	}

	@Column(name = "BARTER_DEAL_AGENCY_PER", precision = 5)

	public Double getBarterDealAgencyPer() {
		return this.barterDealAgencyPer;
	}

	public void setBarterDealAgencyPer(Double barterDealAgencyPer) {
		this.barterDealAgencyPer = barterDealAgencyPer;
	}

}