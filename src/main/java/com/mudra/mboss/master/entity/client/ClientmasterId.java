package com.mudra.mboss.master.entity.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ClientmasterId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class ClientmasterId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uniqueid;
	private String clientid;

	// Constructors

	/** default constructor */
	public ClientmasterId() {
	}

	/** full constructor */
	public ClientmasterId(Integer uniqueid, String clientid) {
		this.uniqueid = uniqueid;
		this.clientid = clientid;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ClientmasterId))
			return false;
		ClientmasterId castOther = (ClientmasterId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getClientid() == castOther.getClientid()) || (this.getClientid() != null
						&& castOther.getClientid() != null && this.getClientid().equals(castOther.getClientid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getClientid() == null ? 0 : this.getClientid().hashCode());
		return result;
	}

}