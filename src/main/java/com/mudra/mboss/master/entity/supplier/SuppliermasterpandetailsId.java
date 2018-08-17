package com.mudra.mboss.master.entity.supplier;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SuppliermasterpandetailsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class SuppliermasterpandetailsId implements java.io.Serializable {

	// Fields

	private Integer uniqueid;
	private String supplierid;
	private String pannumber;

	// Constructors

	/** default constructor */
	public SuppliermasterpandetailsId() {
	}

	/** full constructor */
	public SuppliermasterpandetailsId(Integer uniqueid, String supplierid, String pannumber) {
		this.uniqueid = uniqueid;
		this.supplierid = supplierid;
		this.pannumber = pannumber;
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

	@Column(name = "PANNUMBER", nullable = false, length = 30)

	public String getPannumber() {
		return this.pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SuppliermasterpandetailsId))
			return false;
		SuppliermasterpandetailsId castOther = (SuppliermasterpandetailsId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getSupplierid() == castOther.getSupplierid()) || (this.getSupplierid() != null
						&& castOther.getSupplierid() != null && this.getSupplierid().equals(castOther.getSupplierid())))
				&& ((this.getPannumber() == castOther.getPannumber()) || (this.getPannumber() != null
						&& castOther.getPannumber() != null && this.getPannumber().equals(castOther.getPannumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getSupplierid() == null ? 0 : this.getSupplierid().hashCode());
		result = 37 * result + (getPannumber() == null ? 0 : this.getPannumber().hashCode());
		return result;
	}

}