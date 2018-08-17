package com.mudra.mboss.master.entity.publicationEdition;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EditionmasterId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class EditionmasterId implements java.io.Serializable {

	// Fields

	private Integer uniqueid;
	private Integer editionid;

	// Constructors

	/** default constructor */
	public EditionmasterId() {
	}

	/** full constructor */
	public EditionmasterId(Integer uniqueid, Integer editionid) {
		this.uniqueid = uniqueid;
		this.editionid = editionid;
	}

	// Property accessors

	@Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)

	public Integer getUniqueid() {
		return this.uniqueid;
	}

	public void setUniqueid(Integer uniqueid) {
		this.uniqueid = uniqueid;
	}

	@Column(name = "EDITIONID", nullable = false, precision = 8, scale = 0)

	public Integer getEditionid() {
		return this.editionid;
	}

	public void setEditionid(Integer editionid) {
		this.editionid = editionid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EditionmasterId))
			return false;
		EditionmasterId castOther = (EditionmasterId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getEditionid() == castOther.getEditionid()) || (this.getEditionid() != null
						&& castOther.getEditionid() != null && this.getEditionid().equals(castOther.getEditionid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getEditionid() == null ? 0 : this.getEditionid().hashCode());
		return result;
	}

}