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
 * GstSacHsnMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "GST_SAC_HSN_MASTER", schema = "MUDRA")

public class GstSacHsnMaster implements java.io.Serializable {

	// Fields

	private GstSacHsnMasterId id;
	private String categoryName;
	private Short taxSlabPer;
	private Date effectiveEndDate;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String isAgencyCommssion;
	private String displayOnForm;
	private String isRcmApplicable;
	private String isexempted;
	private String isInputEligible;

	// Constructors

	/** default constructor */
	public GstSacHsnMaster() {
	}

	/** minimal constructor */
	public GstSacHsnMaster(GstSacHsnMasterId id) {
		this.id = id;
	}

	/** full constructor */
	public GstSacHsnMaster(GstSacHsnMasterId id, String categoryName, Short taxSlabPer, Date effectiveEndDate,
			String createdby, Date createdon, Date modifiedon, String modifiedby, String ipaddress, String macaddress,
			String isAgencyCommssion, String displayOnForm, String isRcmApplicable, String isexempted,
			String isInputEligible) {
		this.id = id;
		this.categoryName = categoryName;
		this.taxSlabPer = taxSlabPer;
		this.effectiveEndDate = effectiveEndDate;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.isAgencyCommssion = isAgencyCommssion;
		this.displayOnForm = displayOnForm;
		this.isRcmApplicable = isRcmApplicable;
		this.isexempted = isexempted;
		this.isInputEligible = isInputEligible;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "categoryType", column = @Column(name = "CATEGORY_TYPE", nullable = false, length = 3)),
			@AttributeOverride(name = "sacHsnId", column = @Column(name = "SAC_HSN_ID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "clientSupplier", column = @Column(name = "CLIENT_SUPPLIER", nullable = false, length = 1)),
			@AttributeOverride(name = "effectiveStartDate", column = @Column(name = "EFFECTIVE_START_DATE", nullable = false, length = 7)) })

	public GstSacHsnMasterId getId() {
		return this.id;
	}

	public void setId(GstSacHsnMasterId id) {
		this.id = id;
	}

	@Column(name = "CATEGORY_NAME", length = 512)

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "TAX_SLAB_PER", precision = 4, scale = 0)

	public Short getTaxSlabPer() {
		return this.taxSlabPer;
	}

	public void setTaxSlabPer(Short taxSlabPer) {
		this.taxSlabPer = taxSlabPer;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVE_END_DATE", length = 7)

	public Date getEffectiveEndDate() {
		return this.effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
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

	@Column(name = "IS_AGENCY_COMMSSION", length = 1)

	public String getIsAgencyCommssion() {
		return this.isAgencyCommssion;
	}

	public void setIsAgencyCommssion(String isAgencyCommssion) {
		this.isAgencyCommssion = isAgencyCommssion;
	}

	@Column(name = "DISPLAY_ON_FORM", length = 1)

	public String getDisplayOnForm() {
		return this.displayOnForm;
	}

	public void setDisplayOnForm(String displayOnForm) {
		this.displayOnForm = displayOnForm;
	}

	@Column(name = "IS_RCM_APPLICABLE", length = 1)

	public String getIsRcmApplicable() {
		return this.isRcmApplicable;
	}

	public void setIsRcmApplicable(String isRcmApplicable) {
		this.isRcmApplicable = isRcmApplicable;
	}

	@Column(name = "ISEXEMPTED", length = 1)

	public String getIsexempted() {
		return this.isexempted;
	}

	public void setIsexempted(String isexempted) {
		this.isexempted = isexempted;
	}

	@Column(name = "IS_INPUT_ELIGIBLE", length = 1)

	public String getIsInputEligible() {
		return this.isInputEligible;
	}

	public void setIsInputEligible(String isInputEligible) {
		this.isInputEligible = isInputEligible;
	}

}