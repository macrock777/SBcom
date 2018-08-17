package com.mudra.mboss.master.entity.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DocumentseriesmasterId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class DocumentseriesmasterId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uniqueid;
	private Long documentid;

	// Constructors

	/** default constructor */
	public DocumentseriesmasterId() {
	}

	/** full constructor */
	public DocumentseriesmasterId(Integer uniqueid, Long documentid) {
		this.uniqueid = uniqueid;
		this.documentid = documentid;
	}

	// Property accessors

	@Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)

	public Integer getUniqueid() {
		return this.uniqueid;
	}

	public void setUniqueid(Integer uniqueid) {
		this.uniqueid = uniqueid;
	}

	@Column(name = "DOCUMENTID", nullable = false, precision = 14, scale = 0)

	public Long getDocumentid() {
		return this.documentid;
	}

	public void setDocumentid(Long documentid) {
		this.documentid = documentid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DocumentseriesmasterId))
			return false;
		DocumentseriesmasterId castOther = (DocumentseriesmasterId) other;

		return ((this.getUniqueid() == castOther.getUniqueid()) || (this.getUniqueid() != null
				&& castOther.getUniqueid() != null && this.getUniqueid().equals(castOther.getUniqueid())))
				&& ((this.getDocumentid() == castOther.getDocumentid())
						|| (this.getDocumentid() != null && castOther.getDocumentid() != null
								&& this.getDocumentid().equals(castOther.getDocumentid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUniqueid() == null ? 0 : this.getUniqueid().hashCode());
		result = 37 * result + (getDocumentid() == null ? 0 : this.getDocumentid().hashCode());
		return result;
	}

}