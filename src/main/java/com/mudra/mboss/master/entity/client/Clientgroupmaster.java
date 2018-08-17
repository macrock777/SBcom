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
 * Clientgroupmaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENTGROUPMASTER", schema = "MUDRA")

public class Clientgroupmaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientgroupmasterId id;
	private String clientgroupname;
	private String clienttype;
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
	private String ishoclientgroup;
	private String ddbclientcode;
	private String region;
	private String ddbclientname;

	// Constructors

	/** default constructor */
	public Clientgroupmaster() {
	}

	/** minimal constructor */
	public Clientgroupmaster(ClientgroupmasterId id, String clientgroupname, String clienttype, String createdby,
			Date createdon) {
		this.id = id;
		this.clientgroupname = clientgroupname;
		this.clienttype = clienttype;
		this.createdby = createdby;
		this.createdon = createdon;
	}

	/** full constructor */
	public Clientgroupmaster(ClientgroupmasterId id, String clientgroupname, String clienttype, Byte companyid,
			Byte divisionid, Byte subdivisionid, Byte locationid, String createdby, Date createdon, Date modifiedon,
			String modifiedby, String ipaddress, String macaddress, String ishoclientgroup, String ddbclientcode,
			String region, String ddbclientname) {
		this.id = id;
		this.clientgroupname = clientgroupname;
		this.clienttype = clienttype;
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
		this.ishoclientgroup = ishoclientgroup;
		this.ddbclientcode = ddbclientcode;
		this.region = region;
		this.ddbclientname = ddbclientname;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "clientgroupid", column = @Column(name = "CLIENTGROUPID", nullable = false, length = 10)) })

	public ClientgroupmasterId getId() {
		return this.id;
	}

	public void setId(ClientgroupmasterId id) {
		this.id = id;
	}

	@Column(name = "CLIENTGROUPNAME", nullable = false, length = 64)

	public String getClientgroupname() {
		return this.clientgroupname;
	}

	public void setClientgroupname(String clientgroupname) {
		this.clientgroupname = clientgroupname;
	}

	@Column(name = "CLIENTTYPE", nullable = false, length = 16)

	public String getClienttype() {
		return this.clienttype;
	}

	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
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

	@Column(name = "ISHOCLIENTGROUP", length = 1)

	public String getIshoclientgroup() {
		return this.ishoclientgroup;
	}

	public void setIshoclientgroup(String ishoclientgroup) {
		this.ishoclientgroup = ishoclientgroup;
	}

	@Column(name = "DDBCLIENTCODE", length = 16)

	public String getDdbclientcode() {
		return this.ddbclientcode;
	}

	public void setDdbclientcode(String ddbclientcode) {
		this.ddbclientcode = ddbclientcode;
	}

	@Column(name = "REGION", length = 16)

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "DDBCLIENTNAME", length = 80)

	public String getDdbclientname() {
		return this.ddbclientname;
	}

	public void setDdbclientname(String ddbclientname) {
		this.ddbclientname = ddbclientname;
	}

}