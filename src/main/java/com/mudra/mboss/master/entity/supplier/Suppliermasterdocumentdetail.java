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
 * Suppliermasterdocumentdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SUPPLIERMASTERDOCUMENTDETAIL", schema = "MUDRA")

public class Suppliermasterdocumentdetail implements java.io.Serializable {

	// Fields

	private SuppliermasterdocumentdetailId id;
	private String filepath;
	private String isactive;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;

	// Constructors

	/** default constructor */
	public Suppliermasterdocumentdetail() {
	}

	/** minimal constructor */
	public Suppliermasterdocumentdetail(SuppliermasterdocumentdetailId id) {
		this.id = id;
	}

	/** full constructor */
	public Suppliermasterdocumentdetail(SuppliermasterdocumentdetailId id, String filepath, String isactive,
			String createdby, Date createdon, Date modifiedon, String modifiedby, String ipaddress, String macaddress) {
		this.id = id;
		this.filepath = filepath;
		this.isactive = isactive;
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
			@AttributeOverride(name = "supplierid", column = @Column(name = "SUPPLIERID", nullable = false, length = 10)),
			@AttributeOverride(name = "type", column = @Column(name = "TYPE", nullable = false, length = 32)) })

	public SuppliermasterdocumentdetailId getId() {
		return this.id;
	}

	public void setId(SuppliermasterdocumentdetailId id) {
		this.id = id;
	}

	@Column(name = "FILEPATH", length = 128)

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@Column(name = "ISACTIVE", length = 1)

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
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

}