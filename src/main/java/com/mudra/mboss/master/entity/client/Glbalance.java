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
 * Glbalance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "GLBALANCE", schema = "MUDRA")

public class Glbalance implements java.io.Serializable {

	// Fields

	private GlbalanceId id;
	private Double openingbalance;
	private Double april;
	private Double may;
	private Double june;
	private Double july;
	private Double august;
	private Double september;
	private Double october;
	private Double november;
	private Double december;
	private Double january;
	private Double february;
	private Double march;
	private Double closingbalance;
	private Long bsgroupid;
	private Long debittransactions;
	private Long credittransactions;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private Double previousyearbalance;
	private String trialbalancecategory;
	private Double originalclosingbalance;
	private Double originalclosingbalanceDec;
	private Double auditorBalance;

	// Constructors

	/** default constructor */
	public Glbalance() {
	}

	/** minimal constructor */
	public Glbalance(GlbalanceId id, Double openingbalance, Double april, Double may, Double june, Double july,
			Double august, Double september, Double october, Double november, Double december, Double january,
			Double february, Double march, Double closingbalance, Long bsgroupid) {
		this.id = id;
		this.openingbalance = openingbalance;
		this.april = april;
		this.may = may;
		this.june = june;
		this.july = july;
		this.august = august;
		this.september = september;
		this.october = october;
		this.november = november;
		this.december = december;
		this.january = january;
		this.february = february;
		this.march = march;
		this.closingbalance = closingbalance;
		this.bsgroupid = bsgroupid;
	}

	/** full constructor */
	public Glbalance(GlbalanceId id, Double openingbalance, Double april, Double may, Double june, Double july,
			Double august, Double september, Double october, Double november, Double december, Double january,
			Double february, Double march, Double closingbalance, Long bsgroupid, Long debittransactions,
			Long credittransactions, String createdby, Date createdon, Date modifiedon, String modifiedby,
			String ipaddress, String macaddress, Double previousyearbalance, String trialbalancecategory,
			Double originalclosingbalance, Double originalclosingbalanceDec, Double auditorBalance) {
		this.id = id;
		this.openingbalance = openingbalance;
		this.april = april;
		this.may = may;
		this.june = june;
		this.july = july;
		this.august = august;
		this.september = september;
		this.october = october;
		this.november = november;
		this.december = december;
		this.january = january;
		this.february = february;
		this.march = march;
		this.closingbalance = closingbalance;
		this.bsgroupid = bsgroupid;
		this.debittransactions = debittransactions;
		this.credittransactions = credittransactions;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.previousyearbalance = previousyearbalance;
		this.trialbalancecategory = trialbalancecategory;
		this.originalclosingbalance = originalclosingbalance;
		this.originalclosingbalanceDec = originalclosingbalanceDec;
		this.auditorBalance = auditorBalance;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "glcode", column = @Column(name = "GLCODE", nullable = false, precision = 7, scale = 0)),
			@AttributeOverride(name = "accountingyear", column = @Column(name = "ACCOUNTINGYEAR", nullable = false, precision = 4, scale = 0)) })

	public GlbalanceId getId() {
		return this.id;
	}

	public void setId(GlbalanceId id) {
		this.id = id;
	}

	@Column(name = "OPENINGBALANCE", nullable = false, precision = 15)

	public Double getOpeningbalance() {
		return this.openingbalance;
	}

	public void setOpeningbalance(Double openingbalance) {
		this.openingbalance = openingbalance;
	}

	@Column(name = "APRIL", nullable = false, precision = 15)

	public Double getApril() {
		return this.april;
	}

	public void setApril(Double april) {
		this.april = april;
	}

	@Column(name = "MAY", nullable = false, precision = 15)

	public Double getMay() {
		return this.may;
	}

	public void setMay(Double may) {
		this.may = may;
	}

	@Column(name = "JUNE", nullable = false, precision = 15)

	public Double getJune() {
		return this.june;
	}

	public void setJune(Double june) {
		this.june = june;
	}

	@Column(name = "JULY", nullable = false, precision = 15)

	public Double getJuly() {
		return this.july;
	}

	public void setJuly(Double july) {
		this.july = july;
	}

	@Column(name = "AUGUST", nullable = false, precision = 15)

	public Double getAugust() {
		return this.august;
	}

	public void setAugust(Double august) {
		this.august = august;
	}

	@Column(name = "SEPTEMBER", nullable = false, precision = 15)

	public Double getSeptember() {
		return this.september;
	}

	public void setSeptember(Double september) {
		this.september = september;
	}

	@Column(name = "OCTOBER", nullable = false, precision = 15)

	public Double getOctober() {
		return this.october;
	}

	public void setOctober(Double october) {
		this.october = october;
	}

	@Column(name = "NOVEMBER", nullable = false, precision = 15)

	public Double getNovember() {
		return this.november;
	}

	public void setNovember(Double november) {
		this.november = november;
	}

	@Column(name = "DECEMBER", nullable = false, precision = 15)

	public Double getDecember() {
		return this.december;
	}

	public void setDecember(Double december) {
		this.december = december;
	}

	@Column(name = "JANUARY", nullable = false, precision = 15)

	public Double getJanuary() {
		return this.january;
	}

	public void setJanuary(Double january) {
		this.january = january;
	}

	@Column(name = "FEBRUARY", nullable = false, precision = 15)

	public Double getFebruary() {
		return this.february;
	}

	public void setFebruary(Double february) {
		this.february = february;
	}

	@Column(name = "MARCH", nullable = false, precision = 15)

	public Double getMarch() {
		return this.march;
	}

	public void setMarch(Double march) {
		this.march = march;
	}

	@Column(name = "CLOSINGBALANCE", nullable = false, precision = 15)

	public Double getClosingbalance() {
		return this.closingbalance;
	}

	public void setClosingbalance(Double closingbalance) {
		this.closingbalance = closingbalance;
	}

	@Column(name = "BSGROUPID", nullable = false, precision = 10, scale = 0)

	public Long getBsgroupid() {
		return this.bsgroupid;
	}

	public void setBsgroupid(Long bsgroupid) {
		this.bsgroupid = bsgroupid;
	}

	@Column(name = "DEBITTRANSACTIONS", precision = 15, scale = 0)

	public Long getDebittransactions() {
		return this.debittransactions;
	}

	public void setDebittransactions(Long debittransactions) {
		this.debittransactions = debittransactions;
	}

	@Column(name = "CREDITTRANSACTIONS", precision = 15, scale = 0)

	public Long getCredittransactions() {
		return this.credittransactions;
	}

	public void setCredittransactions(Long credittransactions) {
		this.credittransactions = credittransactions;
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

	@Column(name = "PREVIOUSYEARBALANCE", precision = 15)

	public Double getPreviousyearbalance() {
		return this.previousyearbalance;
	}

	public void setPreviousyearbalance(Double previousyearbalance) {
		this.previousyearbalance = previousyearbalance;
	}

	@Column(name = "TRIALBALANCECATEGORY", length = 2)

	public String getTrialbalancecategory() {
		return this.trialbalancecategory;
	}

	public void setTrialbalancecategory(String trialbalancecategory) {
		this.trialbalancecategory = trialbalancecategory;
	}

	@Column(name = "ORIGINALCLOSINGBALANCE", precision = 15)

	public Double getOriginalclosingbalance() {
		return this.originalclosingbalance;
	}

	public void setOriginalclosingbalance(Double originalclosingbalance) {
		this.originalclosingbalance = originalclosingbalance;
	}

	@Column(name = "ORIGINALCLOSINGBALANCE_DEC", precision = 15)

	public Double getOriginalclosingbalanceDec() {
		return this.originalclosingbalanceDec;
	}

	public void setOriginalclosingbalanceDec(Double originalclosingbalanceDec) {
		this.originalclosingbalanceDec = originalclosingbalanceDec;
	}

	@Column(name = "AUDITOR_BALANCE", precision = 15)

	public Double getAuditorBalance() {
		return this.auditorBalance;
	}

	public void setAuditorBalance(Double auditorBalance) {
		this.auditorBalance = auditorBalance;
	}

}