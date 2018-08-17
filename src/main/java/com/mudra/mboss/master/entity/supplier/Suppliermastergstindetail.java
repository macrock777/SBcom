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
 * Suppliermastergstindetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SUPPLIERMASTERGSTINDETAIL", schema = "MUDRA")

public class Suppliermastergstindetail implements java.io.Serializable {

	// Fields

	private SuppliermastergstindetailId id;
	private String address;
	private String city;
	private String statecode;
	private Long pincode;
	private String country;
	private String sac;
	private String hsncode;
	private String isSezStpi;
	private String isdefault;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String isactive;
	private String emailid;
	private String telephonenumber;
	private String gstinUidnType;
	private Date gstregistrationdate;
	private String authorizedperson;

	// Constructors

	/** default constructor */
	public Suppliermastergstindetail() {
	}

	/** minimal constructor */
	public Suppliermastergstindetail(SuppliermastergstindetailId id) {
		this.id = id;
	}

	/** full constructor */
	public Suppliermastergstindetail(SuppliermastergstindetailId id, String address, String city, String statecode,
			Long pincode, String country, String sac, String hsncode, String isSezStpi, String isdefault,
			String createdby, Date createdon, Date modifiedon, String modifiedby, String ipaddress, String macaddress,
			String isactive, String emailid, String telephonenumber, String gstinUidnType, Date gstregistrationdate,
			String authorizedperson) {
		this.id = id;
		this.address = address;
		this.city = city;
		this.statecode = statecode;
		this.pincode = pincode;
		this.country = country;
		this.sac = sac;
		this.hsncode = hsncode;
		this.isSezStpi = isSezStpi;
		this.isdefault = isdefault;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.isactive = isactive;
		this.emailid = emailid;
		this.telephonenumber = telephonenumber;
		this.gstinUidnType = gstinUidnType;
		this.gstregistrationdate = gstregistrationdate;
		this.authorizedperson = authorizedperson;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pannumber", column = @Column(name = "PANNUMBER", nullable = false, length = 10)),
			@AttributeOverride(name = "gstin", column = @Column(name = "GSTIN", nullable = false, length = 18)),
			@AttributeOverride(name = "srno", column = @Column(name = "SRNO", nullable = false, precision = 2, scale = 0)) })

	public SuppliermastergstindetailId getId() {
		return this.id;
	}

	public void setId(SuppliermastergstindetailId id) {
		this.id = id;
	}

	@Column(name = "ADDRESS", length = 1024)

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "CITY", length = 64)

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATECODE", length = 64)

	public String getStatecode() {
		return this.statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	@Column(name = "PINCODE", precision = 10, scale = 0)

	public Long getPincode() {
		return this.pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@Column(name = "COUNTRY", length = 64)

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "SAC", length = 500)

	public String getSac() {
		return this.sac;
	}

	public void setSac(String sac) {
		this.sac = sac;
	}

	@Column(name = "HSNCODE", length = 500)

	public String getHsncode() {
		return this.hsncode;
	}

	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}

	@Column(name = "IS_SEZ_STPI", length = 1)

	public String getIsSezStpi() {
		return this.isSezStpi;
	}

	public void setIsSezStpi(String isSezStpi) {
		this.isSezStpi = isSezStpi;
	}

	@Column(name = "ISDEFAULT", length = 1)

	public String getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
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

	@Column(name = "ISACTIVE", length = 1)

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	@Column(name = "EMAILID")

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "TELEPHONENUMBER", length = 64)

	public String getTelephonenumber() {
		return this.telephonenumber;
	}

	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}

	@Column(name = "GSTIN_UIDN_TYPE", length = 16)

	public String getGstinUidnType() {
		return this.gstinUidnType;
	}

	public void setGstinUidnType(String gstinUidnType) {
		this.gstinUidnType = gstinUidnType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GSTREGISTRATIONDATE", length = 7)

	public Date getGstregistrationdate() {
		return this.gstregistrationdate;
	}

	public void setGstregistrationdate(Date gstregistrationdate) {
		this.gstregistrationdate = gstregistrationdate;
	}

	@Column(name = "AUTHORIZEDPERSON", length = 64)

	public String getAuthorizedperson() {
		return this.authorizedperson;
	}

	public void setAuthorizedperson(String authorizedperson) {
		this.authorizedperson = authorizedperson;
	}

}