package com.mudra.mboss.master.entity.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BrandmasterId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class BrandmasterId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uniqueid;
	private String clientid;
	private String brandid;

	// Constructors

	/** default constructor */
	public BrandmasterId() {
	}

	/** full constructor */
	public BrandmasterId(Integer uniqueid, String clientid, String brandid) {
		this.uniqueid = uniqueid;
		this.clientid = clientid;
		this.brandid = brandid;
	}

	// Property accessors

	@Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)

	public Integer getUniqueid() {
		return this.uniqueid;
	}

	public void setUniqueid(Integer uniqueid) {
		this.uniqueid = uniqueid;
	}

	@Column(name = "CLIENTID", nullable = false, length = 10)

	public String getClientid() {
		return this.clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	@Column(name = "BRANDID", nullable = false, length = 10)

	public String getBrandid() {
		return this.brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BrandmasterId))
			return false;
		BrandmasterId castOther = (BrandmasterId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getClientid() == castOther.getClientid()) || (this.getClientid() != null
						&& castOther.getClientid() != null && this.getClientid().equals(castOther.getClientid())))
				&& ((this.getBrandid() == castOther.getBrandid()) || (this.getBrandid() != null
						&& castOther.getBrandid() != null && this.getBrandid().equals(castOther.getBrandid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getClientid() == null ? 0 : this.getClientid().hashCode());
		result = 37 * result + (getBrandid() == null ? 0 : this.getBrandid().hashCode());
		return result;
	}

}