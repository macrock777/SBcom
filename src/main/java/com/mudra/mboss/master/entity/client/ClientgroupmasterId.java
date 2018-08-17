package com.mudra.mboss.master.entity.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ClientgroupmasterId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class ClientgroupmasterId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uniqueid;
	private String clientgroupid;

	// Constructors

	/** default constructor */
	public ClientgroupmasterId() {
	}

	/** full constructor */
	public ClientgroupmasterId(Integer uniqueid, String clientgroupid) {
		this.uniqueid = uniqueid;
		this.clientgroupid = clientgroupid;
	}

	// Property accessors

	@Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)

	public Integer getUniqueid() {
		return this.uniqueid;
	}

	public void setUniqueid(Integer uniqueid) {
		this.uniqueid = uniqueid;
	}

	@Column(name = "CLIENTGROUPID", nullable = false, length = 10)

	public String getClientgroupid() {
		return this.clientgroupid;
	}

	public void setClientgroupid(String clientgroupid) {
		this.clientgroupid = clientgroupid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ClientgroupmasterId))
			return false;
		ClientgroupmasterId castOther = (ClientgroupmasterId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getClientgroupid() == castOther.getClientgroupid())
						|| (this.getClientgroupid() != null && castOther.getClientgroupid() != null
								&& this.getClientgroupid().equals(castOther.getClientgroupid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getClientgroupid() == null ? 0 : this.getClientgroupid().hashCode());
		return result;
	}

}