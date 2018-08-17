package com.mudra.mboss.master.entity.supplier;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GstSacHsnDetailId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class GstSacHsnDetailId implements java.io.Serializable {

	// Fields

	private String pannumber;
	private Short srno;

	// Constructors

	/** default constructor */
	public GstSacHsnDetailId() {
	}

	/** full constructor */
	public GstSacHsnDetailId(String pannumber, Short srno) {
		this.pannumber = pannumber;
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

	@Column(name = "SRNO", nullable = false, precision = 4, scale = 0)

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
		if (!(other instanceof GstSacHsnDetailId))
			return false;
		GstSacHsnDetailId castOther = (GstSacHsnDetailId) other;

		return ((this.getPannumber() == castOther.getPannumber()) || (this.getPannumber() != null
				&& castOther.getPannumber() != null && this.getPannumber().equals(castOther.getPannumber())))
				&& ((this.getSrno() == castOther.getSrno()) || (this.getSrno() != null && castOther.getSrno() != null
						&& this.getSrno().equals(castOther.getSrno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPannumber() == null ? 0 : this.getPannumber().hashCode());
		result = 37 * result + (getSrno() == null ? 0 : this.getSrno().hashCode());
		return result;
	}

}