package com.mudra.mboss.master.entity.item;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ItemmasterId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class ItemmasterId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8524252393301869843L;
	private String groupitemcode;
	private String itemcode;

	// Constructors

	/** default constructor */
	public ItemmasterId() {
	}

	/** full constructor */
	public ItemmasterId(String groupitemcode, String itemcode) {
		this.groupitemcode = groupitemcode;
		this.itemcode = itemcode;
	}

	// Property accessors

	@Column(name = "GROUPITEMCODE", nullable = false, length = 16)

	public String getGroupitemcode() {
		return this.groupitemcode;
	}

	public void setGroupitemcode(String groupitemcode) {
		this.groupitemcode = groupitemcode;
	}

	@Column(name = "ITEMCODE", nullable = false, length = 32)

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ItemmasterId))
			return false;
		ItemmasterId castOther = (ItemmasterId) other;

		return ((this.getGroupitemcode() == castOther.getGroupitemcode())
				|| (this.getGroupitemcode() != null && castOther.getGroupitemcode() != null
						&& this.getGroupitemcode().equals(castOther.getGroupitemcode())))
				&& ((this.getItemcode() == castOther.getItemcode()) || (this.getItemcode() != null
						&& castOther.getItemcode() != null && this.getItemcode().equals(castOther.getItemcode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getGroupitemcode() == null ? 0 : this.getGroupitemcode().hashCode());
		result = 37 * result + (getItemcode() == null ? 0 : this.getItemcode().hashCode());
		return result;
	}

}