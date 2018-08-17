package com.mudra.mboss.master.entity.supplier;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SuppliermasterrtgsdetailId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class SuppliermasterrtgsdetailId implements java.io.Serializable {

	// Fields

	private Integer uniqueid;
	private String supplierid;

	// Constructors

	/** default constructor */
	public SuppliermasterrtgsdetailId() {
	}

	/** full constructor */
	public SuppliermasterrtgsdetailId(Integer uniqueid, String supplierid) {
		this.uniqueid = uniqueid;
		this.supplierid = supplierid;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SuppliermasterrtgsdetailId))
			return false;
		SuppliermasterrtgsdetailId castOther = (SuppliermasterrtgsdetailId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getSupplierid() == castOther.getSupplierid())
						|| (this.getSupplierid() != null && castOther.getSupplierid() != null
								&& this.getSupplierid().equals(castOther.getSupplierid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getSupplierid() == null ? 0 : this.getSupplierid().hashCode());
		return result;
	}

}