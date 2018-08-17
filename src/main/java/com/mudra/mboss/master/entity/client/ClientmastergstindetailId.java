package com.mudra.mboss.master.entity.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ClientmastergstindetailId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class ClientmastergstindetailId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pannumber;
	private String gstin;
	private Byte srno;

	// Constructors

	/** default constructor */
	public ClientmastergstindetailId() {
	}

	/** full constructor */
	public ClientmastergstindetailId(String pannumber, String gstin, Byte srno) {
		this.pannumber = pannumber;
		this.gstin = gstin;
		this.srno = srno;
	}

	// Property accessors

	@Column(name = "PANNUMBER", nullable = false, length = 10)

	public String getPannumber() {
		return this.pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	@Column(name = "GSTIN", nullable = false, length = 16)

	public String getGstin() {
		return this.gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	@Column(name = "SRNO", nullable = false, precision = 2, scale = 0)

	public Byte getSrno() {
		return this.srno;
	}

	public void setSrno(Byte srno) {
		this.srno = srno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ClientmastergstindetailId))
			return false;
		ClientmastergstindetailId castOther = (ClientmastergstindetailId) other;

		return ((this.getPannumber() == castOther.getPannumber()) || (this.getPannumber() != null
				&& castOther.getPannumber() != null && this.getPannumber().equals(castOther.getPannumber())))
				&& ((this.getGstin() == castOther.getGstin()) || (this.getGstin() != null
						&& castOther.getGstin() != null && this.getGstin().equals(castOther.getGstin())))
				&& ((this.getSrno() == castOther.getSrno()) || (this.getSrno() != null && castOther.getSrno() != null
						&& this.getSrno().equals(castOther.getSrno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPannumber() == null ? 0 : this.getPannumber().hashCode());
		result = 37 * result + (getGstin() == null ? 0 : this.getGstin().hashCode());
		result = 37 * result + (getSrno() == null ? 0 : this.getSrno().hashCode());
		return result;
	}

}