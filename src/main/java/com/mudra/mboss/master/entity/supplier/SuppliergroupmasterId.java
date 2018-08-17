package com.mudra.mboss.master.entity.supplier;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SuppliergroupmasterId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class SuppliergroupmasterId implements java.io.Serializable {

	// Fields

	private Integer uniqueid;
	private String suppliergroupid;

	// Constructors

	/** default constructor */
	public SuppliergroupmasterId() {
	}

	/** full constructor */
	public SuppliergroupmasterId(Integer uniqueid, String suppliergroupid) {
		this.uniqueid = uniqueid;
		this.suppliergroupid = suppliergroupid;
	}

	// Property accessors

	@Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)

	public Integer getUniqueid() {
		return this.uniqueid;
	}

	public void setUniqueid(Integer uniqueid) {
		this.uniqueid = uniqueid;
	}

	@Column(name = "SUPPLIERGROUPID", nullable = false, length = 10)

	public String getSuppliergroupid() {
		return this.suppliergroupid;
	}

	public void setSuppliergroupid(String suppliergroupid) {
		this.suppliergroupid = suppliergroupid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SuppliergroupmasterId))
			return false;
		SuppliergroupmasterId castOther = (SuppliergroupmasterId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getSuppliergroupid() == castOther.getSuppliergroupid())
						|| (this.getSuppliergroupid() != null && castOther.getSuppliergroupid() != null
								&& this.getSuppliergroupid().equals(castOther.getSuppliergroupid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getSuppliergroupid() == null ? 0 : this.getSuppliergroupid().hashCode());
		return result;
	}

}