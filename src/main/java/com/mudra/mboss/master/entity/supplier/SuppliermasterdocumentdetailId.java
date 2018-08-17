package com.mudra.mboss.master.entity.supplier;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SuppliermasterdocumentdetailId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class SuppliermasterdocumentdetailId implements java.io.Serializable {

	// Fields

	private Integer uniqueid;
	private String supplierid;
	private String type;

	// Constructors

	/** default constructor */
	public SuppliermasterdocumentdetailId() {
	}

	/** full constructor */
	public SuppliermasterdocumentdetailId(Integer uniqueid, String supplierid, String type) {
		this.uniqueid = uniqueid;
		this.supplierid = supplierid;
		this.type = type;
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

	@Column(name = "TYPE", nullable = false, length = 32)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SuppliermasterdocumentdetailId))
			return false;
		SuppliermasterdocumentdetailId castOther = (SuppliermasterdocumentdetailId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getSupplierid() == castOther.getSupplierid()) || (this.getSupplierid() != null
						&& castOther.getSupplierid() != null && this.getSupplierid().equals(castOther.getSupplierid())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null && castOther.getType() != null
						&& this.getType().equals(castOther.getType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getSupplierid() == null ? 0 : this.getSupplierid().hashCode());
		result = 37 * result + (getType() == null ? 0 : this.getType().hashCode());
		return result;
	}

}