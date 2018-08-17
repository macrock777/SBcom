package com.mudra.mboss.master.entity.supplier;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GstSacHsnMasterId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class GstSacHsnMasterId implements java.io.Serializable {

	// Fields

	private String categoryType;
	private Integer sacHsnId;
	private String clientSupplier;
	private Date effectiveStartDate;

	// Constructors

	/** default constructor */
	public GstSacHsnMasterId() {
	}

	/** full constructor */
	public GstSacHsnMasterId(String categoryType, Integer sacHsnId, String clientSupplier, Date effectiveStartDate) {
		this.categoryType = categoryType;
		this.sacHsnId = sacHsnId;
		this.clientSupplier = clientSupplier;
		this.effectiveStartDate = effectiveStartDate;
	}

	// Property accessors

	@Column(name = "CATEGORY_TYPE", nullable = false, length = 3)

	public String getCategoryType() {
		return this.categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	@Column(name = "SAC_HSN_ID", nullable = false, precision = 8, scale = 0)

	public Integer getSacHsnId() {
		return this.sacHsnId;
	}

	public void setSacHsnId(Integer sacHsnId) {
		this.sacHsnId = sacHsnId;
	}

	@Column(name = "CLIENT_SUPPLIER", nullable = false, length = 1)

	public String getClientSupplier() {
		return this.clientSupplier;
	}

	public void setClientSupplier(String clientSupplier) {
		this.clientSupplier = clientSupplier;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVE_START_DATE", nullable = false, length = 7)

	public Date getEffectiveStartDate() {
		return this.effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GstSacHsnMasterId))
			return false;
		GstSacHsnMasterId castOther = (GstSacHsnMasterId) other;

		return ((this.getCategoryType() == castOther.getCategoryType()) || (this.getCategoryType() != null
				&& castOther.getCategoryType() != null && this.getCategoryType().equals(castOther.getCategoryType())))
				&& ((this.getSacHsnId() == castOther.getSacHsnId()) || (this.getSacHsnId() != null
						&& castOther.getSacHsnId() != null && this.getSacHsnId().equals(castOther.getSacHsnId())))
				&& ((this.getClientSupplier() == castOther.getClientSupplier())
						|| (this.getClientSupplier() != null && castOther.getClientSupplier() != null
								&& this.getClientSupplier().equals(castOther.getClientSupplier())))
				&& ((this.getEffectiveStartDate() == castOther.getEffectiveStartDate())
						|| (this.getEffectiveStartDate() != null && castOther.getEffectiveStartDate() != null
								&& this.getEffectiveStartDate().equals(castOther.getEffectiveStartDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCategoryType() == null ? 0 : this.getCategoryType().hashCode());
		result = 37 * result + (getSacHsnId() == null ? 0 : this.getSacHsnId().hashCode());
		result = 37 * result + (getClientSupplier() == null ? 0 : this.getClientSupplier().hashCode());
		result = 37 * result + (getEffectiveStartDate() == null ? 0 : this.getEffectiveStartDate().hashCode());
		return result;
	}

}