package com.mudra.mboss.master.entity.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ClientmastertandetailId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class ClientmastertandetailId implements java.io.Serializable {

	// Fields

	private Integer uniqueid;
	private String clientid;
	private Short srno;

	// Constructors

	/** default constructor */
	public ClientmastertandetailId() {
	}

	/** full constructor */
	public ClientmastertandetailId(Integer uniqueid, String clientid, Short srno) {
		this.uniqueid = uniqueid;
		this.clientid = clientid;
		this.srno = srno;
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

	@Column(name = "SRNO", nullable = false, precision = 3, scale = 0)

	public Short getSrno() {
		return this.srno;
	}

	public void setSrno(Short srno) {
		this.srno = srno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ClientmastertandetailId))
			return false;
		ClientmastertandetailId castOther = (ClientmastertandetailId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getClientid() == castOther.getClientid()) || (this.getClientid() != null
						&& castOther.getClientid() != null && this.getClientid().equals(castOther.getClientid())))
				&& ((this.getSrno() == castOther.getSrno()) || (this.getSrno() != null && castOther.getSrno() != null
						&& this.getSrno().equals(castOther.getSrno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getClientid() == null ? 0 : this.getClientid().hashCode());
		result = 37 * result + (getSrno() == null ? 0 : this.getSrno().hashCode());
		return result;
	}

}