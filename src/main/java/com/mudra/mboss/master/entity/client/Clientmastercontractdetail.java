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
 * Clientmastercontractdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENTMASTERCONTRACTDETAIL", schema = "MUDRA")

public class Clientmastercontractdetail implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientmastercontractdetailId id;
	private String contractdesc;
	private String contractfile;
	private Date startdate;
	private Date enddate;
	private String isalertrequired;
	private String alertinterval;
	private Date alertenddate;
	private String isactive;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String brandid;
	private String type;
	private Double revenuefees;
	private Double revenuesupervision;
	private Double revenueothers;
	private String terminationclause;

	// Constructors

	/** default constructor */
	public Clientmastercontractdetail() {
	}

	/** minimal constructor */
	public Clientmastercontractdetail(ClientmastercontractdetailId id) {
		this.id = id;
	}

	/** full constructor */
	public Clientmastercontractdetail(ClientmastercontractdetailId id, String contractdesc, String contractfile,
			Date startdate, Date enddate, String isalertrequired, String alertinterval, Date alertenddate,
			String isactive, String createdby, Date createdon, Date modifiedon, String modifiedby, String ipaddress,
			String macaddress, String brandid, String type, Double revenuefees, Double revenuesupervision,
			Double revenueothers, String terminationclause) {
		this.id = id;
		this.contractdesc = contractdesc;
		this.contractfile = contractfile;
		this.startdate = startdate;
		this.enddate = enddate;
		this.isalertrequired = isalertrequired;
		this.alertinterval = alertinterval;
		this.alertenddate = alertenddate;
		this.isactive = isactive;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.brandid = brandid;
		this.type = type;
		this.revenuefees = revenuefees;
		this.revenuesupervision = revenuesupervision;
		this.revenueothers = revenueothers;
		this.terminationclause = terminationclause;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "clientid", column = @Column(name = "CLIENTID", nullable = false, length = 10)),
			@AttributeOverride(name = "srno", column = @Column(name = "SRNO", nullable = false, precision = 3, scale = 0)) })

	public ClientmastercontractdetailId getId() {
		return this.id;
	}

	public void setId(ClientmastercontractdetailId id) {
		this.id = id;
	}

	@Column(name = "CONTRACTDESC", length = 128)

	public String getContractdesc() {
		return this.contractdesc;
	}

	public void setContractdesc(String contractdesc) {
		this.contractdesc = contractdesc;
	}

	@Column(name = "CONTRACTFILE", length = 128)

	public String getContractfile() {
		return this.contractfile;
	}

	public void setContractfile(String contractfile) {
		this.contractfile = contractfile;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", length = 7)

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE", length = 7)

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Column(name = "ISALERTREQUIRED", length = 1)

	public String getIsalertrequired() {
		return this.isalertrequired;
	}

	public void setIsalertrequired(String isalertrequired) {
		this.isalertrequired = isalertrequired;
	}

	@Column(name = "ALERTINTERVAL", length = 32)

	public String getAlertinterval() {
		return this.alertinterval;
	}

	public void setAlertinterval(String alertinterval) {
		this.alertinterval = alertinterval;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ALERTENDDATE", length = 7)

	public Date getAlertenddate() {
		return this.alertenddate;
	}

	public void setAlertenddate(Date alertenddate) {
		this.alertenddate = alertenddate;
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

	@Column(name = "BRANDID", length = 14)

	public String getBrandid() {
		return this.brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

	@Column(name = "TYPE", length = 32)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Column(name = "TERMINATIONCLAUSE", length = 64)

	public String getTerminationclause() {
		return this.terminationclause;
	}

	public void setTerminationclause(String terminationclause) {
		this.terminationclause = terminationclause;
	}

}