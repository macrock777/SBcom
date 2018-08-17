package com.mudra.mboss.master.entity.supplier;


import java.math.BigDecimal;
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
 * Suppliermasterrtgsdetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SUPPLIERMASTERRTGSDETAIL", schema = "MUDRA")

public class Suppliermasterrtgsdetail implements java.io.Serializable {

	// Fields

	private SuppliermasterrtgsdetailId id;
	private String beneficiaryname;
	private String accountnumber;
	private String bankname;
	private String branchname;
	private String ifsccode;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private BigDecimal customerid;
	private String benedescription;
	private Long mobilenumber;
	private Long transactionlimit;
	private BigDecimal dailylimit;
	private Date expirydate;
	private String pannumber;
	private Boolean updateFlag;

	// Constructors

	/** default constructor */
	public Suppliermasterrtgsdetail() {
	}

	/** minimal constructor */
	public Suppliermasterrtgsdetail(SuppliermasterrtgsdetailId id) {
		this.id = id;
	}

	/** full constructor */
	public Suppliermasterrtgsdetail(SuppliermasterrtgsdetailId id, String beneficiaryname, String accountnumber,
			String bankname, String branchname, String ifsccode, String createdby, Date createdon, Date modifiedon,
			String modifiedby, String ipaddress, String macaddress, BigDecimal customerid, String benedescription,
			Long mobilenumber, Long transactionlimit, BigDecimal dailylimit, Date expirydate, String pannumber,
			Boolean updateFlag) {
		this.id = id;
		this.beneficiaryname = beneficiaryname;
		this.accountnumber = accountnumber;
		this.bankname = bankname;
		this.branchname = branchname;
		this.ifsccode = ifsccode;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.customerid = customerid;
		this.benedescription = benedescription;
		this.mobilenumber = mobilenumber;
		this.transactionlimit = transactionlimit;
		this.dailylimit = dailylimit;
		this.expirydate = expirydate;
		this.pannumber = pannumber;
		this.updateFlag = updateFlag;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "supplierid", column = @Column(name = "SUPPLIERID", nullable = false, length = 10)) })

	public SuppliermasterrtgsdetailId getId() {
		return this.id;
	}

	public void setId(SuppliermasterrtgsdetailId id) {
		this.id = id;
	}

	@Column(name = "BENEFICIARYNAME", length = 70)

	public String getBeneficiaryname() {
		return this.beneficiaryname;
	}

	public void setBeneficiaryname(String beneficiaryname) {
		this.beneficiaryname = beneficiaryname;
	}

	@Column(name = "ACCOUNTNUMBER", length = 34)

	public String getAccountnumber() {
		return this.accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	@Column(name = "BANKNAME", length = 80)

	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	@Column(name = "BRANCHNAME", length = 35)

	public String getBranchname() {
		return this.branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	@Column(name = "IFSCCODE", length = 11)

	public String getIfsccode() {
		return this.ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
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

	@Column(name = "CUSTOMERID", precision = 30, scale = 0)

	public BigDecimal getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(BigDecimal customerid) {
		this.customerid = customerid;
	}

	@Column(name = "BENEDESCRIPTION")

	public String getBenedescription() {
		return this.benedescription;
	}

	public void setBenedescription(String benedescription) {
		this.benedescription = benedescription;
	}

	@Column(name = "MOBILENUMBER", precision = 12, scale = 0)

	public Long getMobilenumber() {
		return this.mobilenumber;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Column(name = "TRANSACTIONLIMIT", precision = 12, scale = 0)

	public Long getTransactionlimit() {
		return this.transactionlimit;
	}

	public void setTransactionlimit(Long transactionlimit) {
		this.transactionlimit = transactionlimit;
	}

	@Column(name = "DAILYLIMIT", precision = 22, scale = 0)

	public BigDecimal getDailylimit() {
		return this.dailylimit;
	}

	public void setDailylimit(BigDecimal dailylimit) {
		this.dailylimit = dailylimit;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRYDATE", length = 7)

	public Date getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	@Column(name = "PANNUMBER", length = 30)

	public String getPannumber() {
		return this.pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	@Column(name = "UPDATE_FLAG", precision = 1, scale = 0)

	public Boolean getUpdateFlag() {
		return this.updateFlag;
	}

	public void setUpdateFlag(Boolean updateFlag) {
		this.updateFlag = updateFlag;
	}

}