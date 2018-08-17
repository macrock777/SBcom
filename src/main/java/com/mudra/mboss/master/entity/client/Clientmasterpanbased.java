package com.mudra.mboss.master.entity.client;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clientmasterpanbased entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENTMASTERPANBASED", schema = "MUDRA")

public class Clientmasterpanbased implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pannumber;
	private String nsdlclientname;
	private String typeofclient;
	private String registeredaddress1;
	private String registeredaddress2;
	private String registeredaddress3;
	private String registeredcity;
	private String registeredpin;
	private String registeredstate;
	private String rocnumber;
	private String natureOfService;
	private String clientgroupid;
	private String emailid;
	private String telephonenumbers;
	private String country;
	private String contactperson;
	private String contactpersonposition;
	private String contactpersondetail;
	private String faxnumbers;
	private String telephoneextension;
	private String isdataverified;
	private String verifiedDetails;
	private String clientgroupname;
	private String isinsured;
	private Date policyStartdate;
	private Date policyEnddate;
	private Double creditlimitInsurancecompany;
	private Double creditlimitManagement;
	private Double totalCreditLimit;
	private Double exposureBilling;
	private Double exposureAllocated;
	private Double exposureEstimate;
	private Double exposureBilled;
	private Double totalExposure;
	private String isclientLocked;
	private String isintimationInsurerReq;
	private String isintimationInternalReq;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String verifiedby;
	private Date verifiedon;
	private String tannumber;
	private String isCurrentlyActive;

	// Constructors

	/** default constructor */
	public Clientmasterpanbased() {
	}

	/** minimal constructor */
	public Clientmasterpanbased(String pannumber) {
		this.pannumber = pannumber;
	}

	/** full constructor */
	public Clientmasterpanbased(String pannumber, String nsdlclientname, String typeofclient, String registeredaddress1,
			String registeredaddress2, String registeredaddress3, String registeredcity, String registeredpin,
			String registeredstate, String rocnumber, String natureOfService, String clientgroupid, String emailid,
			String telephonenumbers, String country, String contactperson, String contactpersonposition,
			String contactpersondetail, String faxnumbers, String telephoneextension, String isdataverified,
			String verifiedDetails, String clientgroupname, String isinsured, Date policyStartdate, Date policyEnddate,
			Double creditlimitInsurancecompany, Double creditlimitManagement, Double totalCreditLimit,
			Double exposureBilling, Double exposureAllocated, Double exposureEstimate, Double exposureBilled,
			Double totalExposure, String isclientLocked, String isintimationInsurerReq, String isintimationInternalReq,
			String createdby, Date createdon, Date modifiedon, String modifiedby, String ipaddress, String macaddress,
			String verifiedby, Date verifiedon, String tannumber, String isCurrentlyActive) {
		this.pannumber = pannumber;
		this.nsdlclientname = nsdlclientname;
		this.typeofclient = typeofclient;
		this.registeredaddress1 = registeredaddress1;
		this.registeredaddress2 = registeredaddress2;
		this.registeredaddress3 = registeredaddress3;
		this.registeredcity = registeredcity;
		this.registeredpin = registeredpin;
		this.registeredstate = registeredstate;
		this.rocnumber = rocnumber;
		this.natureOfService = natureOfService;
		this.clientgroupid = clientgroupid;
		this.emailid = emailid;
		this.telephonenumbers = telephonenumbers;
		this.country = country;
		this.contactperson = contactperson;
		this.contactpersonposition = contactpersonposition;
		this.contactpersondetail = contactpersondetail;
		this.faxnumbers = faxnumbers;
		this.telephoneextension = telephoneextension;
		this.isdataverified = isdataverified;
		this.verifiedDetails = verifiedDetails;
		this.clientgroupname = clientgroupname;
		this.isinsured = isinsured;
		this.policyStartdate = policyStartdate;
		this.policyEnddate = policyEnddate;
		this.creditlimitInsurancecompany = creditlimitInsurancecompany;
		this.creditlimitManagement = creditlimitManagement;
		this.totalCreditLimit = totalCreditLimit;
		this.exposureBilling = exposureBilling;
		this.exposureAllocated = exposureAllocated;
		this.exposureEstimate = exposureEstimate;
		this.exposureBilled = exposureBilled;
		this.totalExposure = totalExposure;
		this.isclientLocked = isclientLocked;
		this.isintimationInsurerReq = isintimationInsurerReq;
		this.isintimationInternalReq = isintimationInternalReq;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.verifiedby = verifiedby;
		this.verifiedon = verifiedon;
		this.tannumber = tannumber;
		this.isCurrentlyActive = isCurrentlyActive;
	}

	// Property accessors
	@Id

	@Column(name = "PANNUMBER", unique = true, nullable = false, length = 30)

	public String getPannumber() {
		return this.pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	@Column(name = "NSDLCLIENTNAME", length = 70)

	public String getNsdlclientname() {
		return this.nsdlclientname;
	}

	public void setNsdlclientname(String nsdlclientname) {
		this.nsdlclientname = nsdlclientname;
	}

	@Column(name = "TYPEOFCLIENT", length = 64)

	public String getTypeofclient() {
		return this.typeofclient;
	}

	public void setTypeofclient(String typeofclient) {
		this.typeofclient = typeofclient;
	}

	@Column(name = "REGISTEREDADDRESS1", length = 128)

	public String getRegisteredaddress1() {
		return this.registeredaddress1;
	}

	public void setRegisteredaddress1(String registeredaddress1) {
		this.registeredaddress1 = registeredaddress1;
	}

	@Column(name = "REGISTEREDADDRESS2", length = 128)

	public String getRegisteredaddress2() {
		return this.registeredaddress2;
	}

	public void setRegisteredaddress2(String registeredaddress2) {
		this.registeredaddress2 = registeredaddress2;
	}

	@Column(name = "REGISTEREDADDRESS3", length = 128)

	public String getRegisteredaddress3() {
		return this.registeredaddress3;
	}

	public void setRegisteredaddress3(String registeredaddress3) {
		this.registeredaddress3 = registeredaddress3;
	}

	@Column(name = "REGISTEREDCITY", length = 64)

	public String getRegisteredcity() {
		return this.registeredcity;
	}

	public void setRegisteredcity(String registeredcity) {
		this.registeredcity = registeredcity;
	}

	@Column(name = "REGISTEREDPIN", length = 16)

	public String getRegisteredpin() {
		return this.registeredpin;
	}

	public void setRegisteredpin(String registeredpin) {
		this.registeredpin = registeredpin;
	}

	@Column(name = "REGISTEREDSTATE", length = 20)

	public String getRegisteredstate() {
		return this.registeredstate;
	}

	public void setRegisteredstate(String registeredstate) {
		this.registeredstate = registeredstate;
	}

	@Column(name = "ROCNUMBER", length = 20)

	public String getRocnumber() {
		return this.rocnumber;
	}

	public void setRocnumber(String rocnumber) {
		this.rocnumber = rocnumber;
	}

	@Column(name = "NATURE_OF_SERVICE", length = 20)

	public String getNatureOfService() {
		return this.natureOfService;
	}

	public void setNatureOfService(String natureOfService) {
		this.natureOfService = natureOfService;
	}

	@Column(name = "CLIENTGROUPID", length = 10)

	public String getClientgroupid() {
		return this.clientgroupid;
	}

	public void setClientgroupid(String clientgroupid) {
		this.clientgroupid = clientgroupid;
	}

	@Column(name = "EMAILID")

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

	@Column(name = "CONTACTPERSONPOSITION", length = 32)

	public String getContactpersonposition() {
		return this.contactpersonposition;
	}

	public void setContactpersonposition(String contactpersonposition) {
		this.contactpersonposition = contactpersonposition;
	}

	@Column(name = "CONTACTPERSONDETAIL", length = 32)

	public String getContactpersondetail() {
		return this.contactpersondetail;
	}

	public void setContactpersondetail(String contactpersondetail) {
		this.contactpersondetail = contactpersondetail;
	}

	@Column(name = "FAXNUMBERS", length = 32)

	public String getFaxnumbers() {
		return this.faxnumbers;
	}

	public void setFaxnumbers(String faxnumbers) {
		this.faxnumbers = faxnumbers;
	}

	@Column(name = "TELEPHONEEXTENSION", length = 24)

	public String getTelephoneextension() {
		return this.telephoneextension;
	}

	public void setTelephoneextension(String telephoneextension) {
		this.telephoneextension = telephoneextension;
	}

	@Column(name = "ISDATAVERIFIED", length = 1)

	public String getIsdataverified() {
		return this.isdataverified;
	}

	public void setIsdataverified(String isdataverified) {
		this.isdataverified = isdataverified;
	}

	@Column(name = "VERIFIED_DETAILS", length = 50)

	public String getVerifiedDetails() {
		return this.verifiedDetails;
	}

	public void setVerifiedDetails(String verifiedDetails) {
		this.verifiedDetails = verifiedDetails;
	}

	@Column(name = "CLIENTGROUPNAME", length = 64)

	public String getClientgroupname() {
		return this.clientgroupname;
	}

	public void setClientgroupname(String clientgroupname) {
		this.clientgroupname = clientgroupname;
	}

	@Column(name = "ISINSURED", length = 1)

	public String getIsinsured() {
		return this.isinsured;
	}

	public void setIsinsured(String isinsured) {
		this.isinsured = isinsured;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_STARTDATE", length = 7)

	public Date getPolicyStartdate() {
		return this.policyStartdate;
	}

	public void setPolicyStartdate(Date policyStartdate) {
		this.policyStartdate = policyStartdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_ENDDATE", length = 7)

	public Date getPolicyEnddate() {
		return this.policyEnddate;
	}

	public void setPolicyEnddate(Date policyEnddate) {
		this.policyEnddate = policyEnddate;
	}

	@Column(name = "CREDITLIMIT_INSURANCECOMPANY", precision = 14)

	public Double getCreditlimitInsurancecompany() {
		return this.creditlimitInsurancecompany;
	}

	public void setCreditlimitInsurancecompany(Double creditlimitInsurancecompany) {
		this.creditlimitInsurancecompany = creditlimitInsurancecompany;
	}

	@Column(name = "CREDITLIMIT_MANAGEMENT", precision = 14)

	public Double getCreditlimitManagement() {
		return this.creditlimitManagement;
	}

	public void setCreditlimitManagement(Double creditlimitManagement) {
		this.creditlimitManagement = creditlimitManagement;
	}

	@Column(name = "TOTAL_CREDIT_LIMIT", precision = 14)

	public Double getTotalCreditLimit() {
		return this.totalCreditLimit;
	}

	public void setTotalCreditLimit(Double totalCreditLimit) {
		this.totalCreditLimit = totalCreditLimit;
	}

	@Column(name = "EXPOSURE_BILLING", precision = 14)

	public Double getExposureBilling() {
		return this.exposureBilling;
	}

	public void setExposureBilling(Double exposureBilling) {
		this.exposureBilling = exposureBilling;
	}

	@Column(name = "EXPOSURE_ALLOCATED", precision = 14)

	public Double getExposureAllocated() {
		return this.exposureAllocated;
	}

	public void setExposureAllocated(Double exposureAllocated) {
		this.exposureAllocated = exposureAllocated;
	}

	@Column(name = "EXPOSURE_ESTIMATE", precision = 14)

	public Double getExposureEstimate() {
		return this.exposureEstimate;
	}

	public void setExposureEstimate(Double exposureEstimate) {
		this.exposureEstimate = exposureEstimate;
	}

	@Column(name = "EXPOSURE_BILLED", precision = 14)

	public Double getExposureBilled() {
		return this.exposureBilled;
	}

	public void setExposureBilled(Double exposureBilled) {
		this.exposureBilled = exposureBilled;
	}

	@Column(name = "TOTAL_EXPOSURE", precision = 14)

	public Double getTotalExposure() {
		return this.totalExposure;
	}

	public void setTotalExposure(Double totalExposure) {
		this.totalExposure = totalExposure;
	}

	@Column(name = "ISCLIENT_LOCKED", length = 1)

	public String getIsclientLocked() {
		return this.isclientLocked;
	}

	public void setIsclientLocked(String isclientLocked) {
		this.isclientLocked = isclientLocked;
	}

	@Column(name = "ISINTIMATION_INSURER_REQ", length = 1)

	public String getIsintimationInsurerReq() {
		return this.isintimationInsurerReq;
	}

	public void setIsintimationInsurerReq(String isintimationInsurerReq) {
		this.isintimationInsurerReq = isintimationInsurerReq;
	}

	@Column(name = "ISINTIMATION_INTERNAL_REQ", length = 1)

	public String getIsintimationInternalReq() {
		return this.isintimationInternalReq;
	}

	public void setIsintimationInternalReq(String isintimationInternalReq) {
		this.isintimationInternalReq = isintimationInternalReq;
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

	@Column(name = "VERIFIEDBY", length = 64)

	public String getVerifiedby() {
		return this.verifiedby;
	}

	public void setVerifiedby(String verifiedby) {
		this.verifiedby = verifiedby;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VERIFIEDON", length = 7)

	public Date getVerifiedon() {
		return this.verifiedon;
	}

	public void setVerifiedon(Date verifiedon) {
		this.verifiedon = verifiedon;
	}

	@Column(name = "TANNUMBER", length = 32)

	public String getTannumber() {
		return this.tannumber;
	}

	public void setTannumber(String tannumber) {
		this.tannumber = tannumber;
	}

	@Column(name = "IS_CURRENTLY_ACTIVE", length = 1)

	public String getIsCurrentlyActive() {
		return this.isCurrentlyActive;
	}

	public void setIsCurrentlyActive(String isCurrentlyActive) {
		this.isCurrentlyActive = isCurrentlyActive;
	}

}