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
 * Suppliergroupmaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SUPPLIERGROUPMASTER", schema = "MUDRA")

public class Suppliergroupmaster implements java.io.Serializable {

	// Fields

	private SuppliergroupmasterId id;
	private String suppliergroupname;
	private String suppliertype;
	private Integer jobtypeid;
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

	// Constructors

	/** default constructor */
	public Suppliergroupmaster() {
	}

	/** minimal constructor */
	public Suppliergroupmaster(SuppliergroupmasterId id, String suppliergroupname, Byte companyid, Byte divisionid,
			Byte subdivisionid, Byte locationid, String createdby, Date createdon) {
		this.id = id;
		this.suppliergroupname = suppliergroupname;
		this.companyid = companyid;
		this.divisionid = divisionid;
		this.subdivisionid = subdivisionid;
		this.locationid = locationid;
		this.createdby = createdby;
		this.createdon = createdon;
	}

	/** full constructor */
	public Suppliergroupmaster(SuppliergroupmasterId id, String suppliergroupname, String suppliertype,
			Integer jobtypeid, Byte companyid, Byte divisionid, Byte subdivisionid, Byte locationid, String createdby,
			Date createdon, Date modifiedon, String modifiedby, String ipaddress, String macaddress) {
		this.id = id;
		this.suppliergroupname = suppliergroupname;
		this.suppliertype = suppliertype;
		this.jobtypeid = jobtypeid;
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
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "suppliergroupid", column = @Column(name = "SUPPLIERGROUPID", nullable = false, length = 10)) })

	public SuppliergroupmasterId getId() {
		return this.id;
	}

	public void setId(SuppliergroupmasterId id) {
		this.id = id;
	}

	@Column(name = "SUPPLIERGROUPNAME", nullable = false, length = 64)

	public String getSuppliergroupname() {
		return this.suppliergroupname;
	}

	public void setSuppliergroupname(String suppliergroupname) {
		this.suppliergroupname = suppliergroupname;
	}

	@Column(name = "SUPPLIERTYPE", length = 16)

	public String getSuppliertype() {
		return this.suppliertype;
	}

	public void setSuppliertype(String suppliertype) {
		this.suppliertype = suppliertype;
	}

	@Column(name = "JOBTYPEID", precision = 6, scale = 0)

	public Integer getJobtypeid() {
		return this.jobtypeid;
	}

	public void setJobtypeid(Integer jobtypeid) {
		this.jobtypeid = jobtypeid;
	}

	@Column(name = "COMPANYID", nullable = false, precision = 2, scale = 0)

	public Byte getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Byte companyid) {
		this.companyid = companyid;
	}

	@Column(name = "DIVISIONID", nullable = false, precision = 2, scale = 0)

	public Byte getDivisionid() {
		return this.divisionid;
	}

	public void setDivisionid(Byte divisionid) {
		this.divisionid = divisionid;
	}

	@Column(name = "SUBDIVISIONID", nullable = false, precision = 2, scale = 0)

	public Byte getSubdivisionid() {
		return this.subdivisionid;
	}

	public void setSubdivisionid(Byte subdivisionid) {
		this.subdivisionid = subdivisionid;
	}

	@Column(name = "LOCATIONID", nullable = false, precision = 2, scale = 0)

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

}