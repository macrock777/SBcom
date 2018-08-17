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
 * Suppliermastertdsdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SUPPLIERMASTERTDSDETAIL", schema = "MUDRA")

public class Suppliermastertdsdetail implements java.io.Serializable {

	// Fields

	private SuppliermastertdsdetailId id;
	private String services;
	private String tdssectionid;
	private Date effectivefrom;
	private Date effectiveto;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String isdefaulttds;

	// Constructors

	/** default constructor */
	public Suppliermastertdsdetail() {
	}

	/** minimal constructor */
	public Suppliermastertdsdetail(SuppliermastertdsdetailId id) {
		this.id = id;
	}

	/** full constructor */
	public Suppliermastertdsdetail(SuppliermastertdsdetailId id, String services, String tdssectionid,
			Date effectivefrom, Date effectiveto, String createdby, Date createdon, Date modifiedon, String modifiedby,
			String ipaddress, String macaddress, String isdefaulttds) {
		this.id = id;
		this.services = services;
		this.tdssectionid = tdssectionid;
		this.effectivefrom = effectivefrom;
		this.effectiveto = effectiveto;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.isdefaulttds = isdefaulttds;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "supplierid", column = @Column(name = "SUPPLIERID", nullable = false, length = 10)),
			@AttributeOverride(name = "serialno", column = @Column(name = "SERIALNO", nullable = false, precision = 3, scale = 0)) })

	public SuppliermastertdsdetailId getId() {
		return this.id;
	}

	public void setId(SuppliermastertdsdetailId id) {
		this.id = id;
	}

	@Column(name = "SERVICES", length = 50)

	public String getServices() {
		return this.services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	@Column(name = "TDSSECTIONID", length = 32)

	public String getTdssectionid() {
		return this.tdssectionid;
	}

	public void setTdssectionid(String tdssectionid) {
		this.tdssectionid = tdssectionid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVEFROM", length = 7)

	public Date getEffectivefrom() {
		return this.effectivefrom;
	}

	public void setEffectivefrom(Date effectivefrom) {
		this.effectivefrom = effectivefrom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVETO", length = 7)

	public Date getEffectiveto() {
		return this.effectiveto;
	}

	public void setEffectiveto(Date effectiveto) {
		this.effectiveto = effectiveto;
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

	@Column(name = "ISDEFAULTTDS", length = 1)

	public String getIsdefaulttds() {
		return this.isdefaulttds;
	}

	public void setIsdefaulttds(String isdefaulttds) {
		this.isdefaulttds = isdefaulttds;
	}

}