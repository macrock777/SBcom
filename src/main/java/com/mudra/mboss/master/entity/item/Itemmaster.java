package com.mudra.mboss.master.entity.item;

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
 * Itemmaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ITEMMASTER", schema = "MUDRA")

public class Itemmaster implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2385175795635631363L;
	// Fields

	private ItemmasterId id;
	private String itemdescription;
	private String isservicetaxapplicable;
	private String isvatapplicable;
	private String iscstapplicable;
	private String stockorservice;
	private String servicetaxglcode;
	private String vatglcode;
	private String cstglcode;
	private String inputvatglcode;
	private String localvatglcode;
	private String defaultunit;
	private String isactive;
	private String vattype;
	private String incomeglcode;
	private String expenseglcode;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String categoryType;
	private Integer sacHsnId;
	private String isHsnidRequired;

	// Constructors

	/** default constructor */
	public Itemmaster() {
	}

	/** minimal constructor */
	public Itemmaster(ItemmasterId id, String servicetaxglcode, String vatglcode, String cstglcode,
			String inputvatglcode, String localvatglcode) {
		this.id = id;
		this.servicetaxglcode = servicetaxglcode;
		this.vatglcode = vatglcode;
		this.cstglcode = cstglcode;
		this.inputvatglcode = inputvatglcode;
		this.localvatglcode = localvatglcode;
	}

	/** full constructor */
	public Itemmaster(ItemmasterId id, String itemdescription, String isservicetaxapplicable, String isvatapplicable,
			String iscstapplicable, String stockorservice, String servicetaxglcode, String vatglcode, String cstglcode,
			String inputvatglcode, String localvatglcode, String defaultunit, String isactive, String vattype,
			String incomeglcode, String expenseglcode, String createdby, Date createdon, Date modifiedon,
			String modifiedby, String ipaddress, String macaddress, String categoryType, Integer sacHsnId,
			String isHsnidRequired) {
		this.id = id;
		this.itemdescription = itemdescription;
		this.isservicetaxapplicable = isservicetaxapplicable;
		this.isvatapplicable = isvatapplicable;
		this.iscstapplicable = iscstapplicable;
		this.stockorservice = stockorservice;
		this.servicetaxglcode = servicetaxglcode;
		this.vatglcode = vatglcode;
		this.cstglcode = cstglcode;
		this.inputvatglcode = inputvatglcode;
		this.localvatglcode = localvatglcode;
		this.defaultunit = defaultunit;
		this.isactive = isactive;
		this.vattype = vattype;
		this.incomeglcode = incomeglcode;
		this.expenseglcode = expenseglcode;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.categoryType = categoryType;
		this.sacHsnId = sacHsnId;
		this.isHsnidRequired = isHsnidRequired;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "groupitemcode", column = @Column(name = "GROUPITEMCODE", nullable = false, length = 16)),
			@AttributeOverride(name = "itemcode", column = @Column(name = "ITEMCODE", nullable = false, length = 32)) })

	public ItemmasterId getId() {
		return this.id;
	}

	public void setId(ItemmasterId id) {
		this.id = id;
	}

	@Column(name = "ITEMDESCRIPTION", length = 64)

	public String getItemdescription() {
		return this.itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	@Column(name = "ISSERVICETAXAPPLICABLE", length = 1)

	public String getIsservicetaxapplicable() {
		return this.isservicetaxapplicable;
	}

	public void setIsservicetaxapplicable(String isservicetaxapplicable) {
		this.isservicetaxapplicable = isservicetaxapplicable;
	}

	@Column(name = "ISVATAPPLICABLE", length = 1)

	public String getIsvatapplicable() {
		return this.isvatapplicable;
	}

	public void setIsvatapplicable(String isvatapplicable) {
		this.isvatapplicable = isvatapplicable;
	}

	@Column(name = "ISCSTAPPLICABLE", length = 1)

	public String getIscstapplicable() {
		return this.iscstapplicable;
	}

	public void setIscstapplicable(String iscstapplicable) {
		this.iscstapplicable = iscstapplicable;
	}

	@Column(name = "STOCKORSERVICE", length = 3)

	public String getStockorservice() {
		return this.stockorservice;
	}

	public void setStockorservice(String stockorservice) {
		this.stockorservice = stockorservice;
	}

	@Column(name = "SERVICETAXGLCODE", nullable = false, length = 7)

	public String getServicetaxglcode() {
		return this.servicetaxglcode;
	}

	public void setServicetaxglcode(String servicetaxglcode) {
		this.servicetaxglcode = servicetaxglcode;
	}

	@Column(name = "VATGLCODE", nullable = false, length = 7)

	public String getVatglcode() {
		return this.vatglcode;
	}

	public void setVatglcode(String vatglcode) {
		this.vatglcode = vatglcode;
	}

	@Column(name = "CSTGLCODE", nullable = false, length = 7)

	public String getCstglcode() {
		return this.cstglcode;
	}

	public void setCstglcode(String cstglcode) {
		this.cstglcode = cstglcode;
	}

	@Column(name = "INPUTVATGLCODE", nullable = false, length = 7)

	public String getInputvatglcode() {
		return this.inputvatglcode;
	}

	public void setInputvatglcode(String inputvatglcode) {
		this.inputvatglcode = inputvatglcode;
	}

	@Column(name = "LOCALVATGLCODE", nullable = false, length = 7)

	public String getLocalvatglcode() {
		return this.localvatglcode;
	}

	public void setLocalvatglcode(String localvatglcode) {
		this.localvatglcode = localvatglcode;
	}

	@Column(name = "DEFAULTUNIT", length = 8)

	public String getDefaultunit() {
		return this.defaultunit;
	}

	public void setDefaultunit(String defaultunit) {
		this.defaultunit = defaultunit;
	}

	@Column(name = "ISACTIVE", length = 1)

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	@Column(name = "VATTYPE", length = 5)

	public String getVattype() {
		return this.vattype;
	}

	public void setVattype(String vattype) {
		this.vattype = vattype;
	}

	@Column(name = "INCOMEGLCODE", length = 7)

	public String getIncomeglcode() {
		return this.incomeglcode;
	}

	public void setIncomeglcode(String incomeglcode) {
		this.incomeglcode = incomeglcode;
	}

	@Column(name = "EXPENSEGLCODE", length = 7)

	public String getExpenseglcode() {
		return this.expenseglcode;
	}

	public void setExpenseglcode(String expenseglcode) {
		this.expenseglcode = expenseglcode;
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

	@Column(name = "CATEGORY_TYPE", length = 3)

	public String getCategoryType() {
		return this.categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	@Column(name = "SAC_HSN_ID", precision = 8, scale = 0)

	public Integer getSacHsnId() {
		return this.sacHsnId;
	}

	public void setSacHsnId(Integer sacHsnId) {
		this.sacHsnId = sacHsnId;
	}

	@Column(name = "IS_HSNID_REQUIRED", length = 1)

	public String getIsHsnidRequired() {
		return this.isHsnidRequired;
	}

	public void setIsHsnidRequired(String isHsnidRequired) {
		this.isHsnidRequired = isHsnidRequired;
	}

}