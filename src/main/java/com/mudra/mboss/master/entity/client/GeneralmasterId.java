package com.mudra.mboss.master.entity.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GeneralmasterId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class GeneralmasterId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uniqueid;
	private String mastertype;
	private String mastercode;

	// Constructors

	/** default constructor */
	public GeneralmasterId() {
	}

	/** full constructor */
	public GeneralmasterId(Integer uniqueid, String mastertype, String mastercode) {
		this.uniqueid = uniqueid;
		this.mastertype = mastertype;
		this.mastercode = mastercode;
	}

	// Property accessors

	@Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)

	public Integer getUniqueid() {
		return this.uniqueid;
	}

	public void setUniqueid(Integer uniqueid) {
		this.uniqueid = uniqueid;
	}

	@Column(name = "MASTERTYPE", nullable = false, length = 10)

	public String getMastertype() {
		return this.mastertype;
	}

	public void setMastertype(String mastertype) {
		this.mastertype = mastertype;
	}

	@Column(name = "MASTERCODE", nullable = false, length = 10)

	public String getMastercode() {
		return this.mastercode;
	}

	public void setMastercode(String mastercode) {
		this.mastercode = mastercode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GeneralmasterId))
			return false;
		GeneralmasterId castOther = (GeneralmasterId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getMastertype() == castOther.getMastertype()) || (this.getMastertype() != null
						&& castOther.getMastertype() != null && this.getMastertype().equals(castOther.getMastertype())))
				&& ((this.getMastercode() == castOther.getMastercode())
						|| (this.getMastercode() != null && castOther.getMastercode() != null
								&& this.getMastercode().equals(castOther.getMastercode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getMastertype() == null ? 0 : this.getMastertype().hashCode());
		result = 37 * result + (getMastercode() == null ? 0 : this.getMastercode().hashCode());
		return result;
	}

}