package com.mudra.mboss.master.entity.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GlbalanceId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class GlbalanceId implements java.io.Serializable {

	// Fields

	private Integer uniqueid;
	private Integer glcode;
	private Short accountingyear;

	// Constructors

	/** default constructor */
	public GlbalanceId() {
	}

	/** full constructor */
	public GlbalanceId(Integer uniqueid, Integer glcode, Short accountingyear) {
		this.uniqueid = uniqueid;
		this.glcode = glcode;
		this.accountingyear = accountingyear;
	}

	// Property accessors

	@Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)

	public Integer getUniqueid() {
		return this.uniqueid;
	}

	public void setUniqueid(Integer uniqueid) {
		this.uniqueid = uniqueid;
	}

	@Column(name = "GLCODE", nullable = false, precision = 7, scale = 0)

	public Integer getGlcode() {
		return this.glcode;
	}

	public void setGlcode(Integer glcode) {
		this.glcode = glcode;
	}

	@Column(name = "ACCOUNTINGYEAR", nullable = false, precision = 4, scale = 0)

	public Short getAccountingyear() {
		return this.accountingyear;
	}

	public void setAccountingyear(Short accountingyear) {
		this.accountingyear = accountingyear;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GlbalanceId))
			return false;
		GlbalanceId castOther = (GlbalanceId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getGlcode() == castOther.getGlcode()) || (this.getGlcode() != null
						&& castOther.getGlcode() != null && this.getGlcode().equals(castOther.getGlcode())))
				&& ((this.getAccountingyear() == castOther.getAccountingyear())
						|| (this.getAccountingyear() != null && castOther.getAccountingyear() != null
								&& this.getAccountingyear().equals(castOther.getAccountingyear())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getGlcode() == null ? 0 : this.getGlcode().hashCode());
		result = 37 * result + (getAccountingyear() == null ? 0 : this.getAccountingyear().hashCode());
		return result;
	}

}