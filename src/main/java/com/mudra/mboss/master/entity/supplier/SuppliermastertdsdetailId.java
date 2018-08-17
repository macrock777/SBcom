package com.mudra.mboss.master.entity.supplier;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SuppliermastertdsdetailId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class SuppliermastertdsdetailId implements java.io.Serializable {

	// Fields

	private Integer uniqueid;
	private String supplierid;
	private Short serialno;

	// Constructors

	/** default constructor */
	public SuppliermastertdsdetailId() {
	}

	/** full constructor */
	public SuppliermastertdsdetailId(Integer uniqueid, String supplierid, Short serialno) {
		this.uniqueid = uniqueid;
		this.supplierid = supplierid;
		this.serialno = serialno;
	}

	// Property accessors

	@Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)

	public Integer getUniqueid() {
		return this.uniqueid;
	}

	public void setUniqueid(Integer uniqueid) {
		this.uniqueid = uniqueid;
	}

	@Column(name = "SUPPLIERID", nullable = false, length = 10)

	public String getSupplierid() {
		return this.supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	@Column(name = "SERIALNO", nullable = false, precision = 3, scale = 0)

	public Short getSerialno() {
		return this.serialno;
	}

	public void setSerialno(Short serialno) {
		this.serialno = serialno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SuppliermastertdsdetailId))
			return false;
		SuppliermastertdsdetailId castOther = (SuppliermastertdsdetailId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getSupplierid() == castOther.getSupplierid()) || (this.getSupplierid() != null
						&& castOther.getSupplierid() != null && this.getSupplierid().equals(castOther.getSupplierid())))
				&& ((this.getSerialno() == castOther.getSerialno()) || (this.getSerialno() != null
						&& castOther.getSerialno() != null && this.getSerialno().equals(castOther.getSerialno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getSupplierid() == null ? 0 : this.getSupplierid().hashCode());
		result = 37 * result + (getSerialno() == null ? 0 : this.getSerialno().hashCode());
		return result;
	}

}