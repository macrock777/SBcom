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
 * Generalmaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "GENERALMASTER", schema = "MUDRA")

public class Generalmaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GeneralmasterId id;
	private String masterdescription;
	private Double numvalue1;
	private Double numvalue2;
	private Double numvalue3;
	private String charvalue1;
	private String charvalue2;
	private String charvalue3;
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
	private String isbranchspecific;

	// Constructors

	/** default constructor */
	public Generalmaster() {
	}

	/** minimal constructor */
	public Generalmaster(GeneralmasterId id, String masterdescription, Byte companyid, Byte divisionid,
			Byte subdivisionid, Byte locationid, String createdby, Date createdon) {
		this.id = id;
		this.masterdescription = masterdescription;
		this.companyid = companyid;
		this.divisionid = divisionid;
		this.subdivisionid = subdivisionid;
		this.locationid = locationid;
		this.createdby = createdby;
		this.createdon = createdon;
	}

	/** full constructor */
	public Generalmaster(GeneralmasterId id, String masterdescription, Double numvalue1, Double numvalue2,
			Double numvalue3, String charvalue1, String charvalue2, String charvalue3, Byte companyid, Byte divisionid,
			Byte subdivisionid, Byte locationid, String createdby, Date createdon, Date modifiedon, String modifiedby,
			String ipaddress, String macaddress, String isbranchspecific) {
		this.id = id;
		this.masterdescription = masterdescription;
		this.numvalue1 = numvalue1;
		this.numvalue2 = numvalue2;
		this.numvalue3 = numvalue3;
		this.charvalue1 = charvalue1;
		this.charvalue2 = charvalue2;
		this.charvalue3 = charvalue3;
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
		this.isbranchspecific = isbranchspecific;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "mastertype", column = @Column(name = "MASTERTYPE", nullable = false, length = 10)),
			@AttributeOverride(name = "mastercode", column = @Column(name = "MASTERCODE", nullable = false, length = 10)) })

	public GeneralmasterId getId() {
		return this.id;
	}

	public void setId(GeneralmasterId id) {
		this.id = id;
	}

	@Column(name = "MASTERDESCRIPTION", nullable = false, length = 64)

	public String getMasterdescription() {
		return this.masterdescription;
	}

	public void setMasterdescription(String masterdescription) {
		this.masterdescription = masterdescription;
	}

	@Column(name = "NUMVALUE1", precision = 21, scale = 9)

	public Double getNumvalue1() {
		return this.numvalue1;
	}

	public void setNumvalue1(Double numvalue1) {
		this.numvalue1 = numvalue1;
	}

	@Column(name = "NUMVALUE2", precision = 21, scale = 9)

	public Double getNumvalue2() {
		return this.numvalue2;
	}

	public void setNumvalue2(Double numvalue2) {
		this.numvalue2 = numvalue2;
	}

	@Column(name = "NUMVALUE3", precision = 14)

	public Double getNumvalue3() {
		return this.numvalue3;
	}

	public void setNumvalue3(Double numvalue3) {
		this.numvalue3 = numvalue3;
	}

	@Column(name = "CHARVALUE1", length = 64)

	public String getCharvalue1() {
		return this.charvalue1;
	}

	public void setCharvalue1(String charvalue1) {
		this.charvalue1 = charvalue1;
	}

	@Column(name = "CHARVALUE2", length = 64)

	public String getCharvalue2() {
		return this.charvalue2;
	}

	public void setCharvalue2(String charvalue2) {
		this.charvalue2 = charvalue2;
	}

	@Column(name = "CHARVALUE3", length = 64)

	public String getCharvalue3() {
		return this.charvalue3;
	}

	public void setCharvalue3(String charvalue3) {
		this.charvalue3 = charvalue3;
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

	@Column(name = "ISBRANCHSPECIFIC", length = 1)

	public String getIsbranchspecific() {
		return this.isbranchspecific;
	}

	public void setIsbranchspecific(String isbranchspecific) {
		this.isbranchspecific = isbranchspecific;
	}

}