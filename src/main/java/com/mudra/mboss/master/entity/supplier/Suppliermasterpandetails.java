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
 * Suppliermasterpandetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SUPPLIERMASTERPANDETAILS", schema = "MUDRA")

public class Suppliermasterpandetails implements java.io.Serializable {

	// Fields

	private SuppliermasterpandetailsId id;
	private Date effectivefromdate;
	private Date effectivetodate;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;

	// Constructors

	/** default constructor */
	public Suppliermasterpandetails() {
	}

	/** minimal constructor */
	public Suppliermasterpandetails(SuppliermasterpandetailsId id) {
		this.id = id;
	}

	/** full constructor */
	public Suppliermasterpandetails(SuppliermasterpandetailsId id, Date effectivefromdate, Date effectivetodate,
			String createdby, Date createdon, Date modifiedon, String modifiedby, String ipaddress, String macaddress) {
		this.id = id;
		this.effectivefromdate = effectivefromdate;
		this.effectivetodate = effectivetodate;
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
			@AttributeOverride(name = "pannumber", column = @Column(name = "PANNUMBER", nullable = false, length = 30)) })

	public SuppliermasterpandetailsId getId() {
		return this.id;
	}

	public void setId(SuppliermasterpandetailsId id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVEFROMDATE", length = 7)

	public Date getEffectivefromdate() {
		return this.effectivefromdate;
	}

	public void setEffectivefromdate(Date effectivefromdate) {
		this.effectivefromdate = effectivefromdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVETODATE", length = 7)

	public Date getEffectivetodate() {
		return this.effectivetodate;
	}

	public void setEffectivetodate(Date effectivetodate) {
		this.effectivetodate = effectivetodate;
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