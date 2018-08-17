package com.mudra.mboss.master.entity.supplier;


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SuppliermastergstindetailId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class SuppliermastergstindetailId implements java.io.Serializable {

	// Fields

	private String pannumber;
	private String gstin;
	private Byte srno;

	// Constructors

	/** default constructor */
	public SuppliermastergstindetailId() {
	}

	/** full constructor */
	public SuppliermastergstindetailId(String pannumber, String gstin, Byte srno) {
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

	@Column(name = "GSTIN", nullable = false, length = 18)

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
		if (!(other instanceof SuppliermastergstindetailId))
			return false;
		SuppliermastergstindetailId castOther = (SuppliermastergstindetailId) other;

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