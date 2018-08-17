package com.mudra.mboss.master.entity.supplier;



import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GstSacHsnDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "GST_SAC_HSN_DETAIL", schema = "MUDRA")

public class GstSacHsnDetail implements java.io.Serializable {

	// Fields

	private GstSacHsnDetailId id;
	private String gstin;
	private String category;
	private String type;
	private String typecode;
	private String typename;
	private String isactive;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String isdefault;

	// Constructors

	/** default constructor */
	public GstSacHsnDetail() {
	}

	/** minimal constructor */
	public GstSacHsnDetail(GstSacHsnDetailId id) {
		this.id = id;
	}

	/** full constructor */
	public GstSacHsnDetail(GstSacHsnDetailId id, String gstin, String category, String type, String typecode,
			String typename, String isactive, String createdby, Date createdon, Date modifiedon, String modifiedby,
			String ipaddress, String macaddress, String isdefault) {
		this.id = id;
		this.gstin = gstin;
		this.category = category;
		this.type = type;
		this.typecode = typecode;
		this.typename = typename;
		this.isactive = isactive;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.isdefault = isdefault;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pannumber", column = @Column(name = "PANNUMBER", nullable = false, length = 10)),
			@AttributeOverride(name = "srno", column = @Column(name = "SRNO", nullable = false, precision = 4, scale = 0)) })

	public GstSacHsnDetailId getId() {
		return this.id;
	}

	public void setId(GstSacHsnDetailId id) {
		this.id = id;
	}

	@Column(name = "GSTIN", length = 18)

	public String getGstin() {
		return this.gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	@Column(name = "CATEGORY", length = 1)

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "TYPE", length = 1)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "TYPECODE", length = 16)

	public String getTypecode() {
		return this.typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	@Column(name = "TYPENAME", length = 512)

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Column(name = "ISACTIVE", length = 1)

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	@Column(name = "CREATEDBY", length = 20)

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDON", length = 7)

	public Date getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIEDON", length = 7)

	public Date getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}

	@Column(name = "MODIFIEDBY", length = 20)

	public String getModifiedby() {
		return this.modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	@Column(name = "IPADDRESS", length = 16)

	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Column(name = "MACADDRESS", length = 32)

	public String getMacaddress() {
		return this.macaddress;
	}

	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}

	@Column(name = "ISDEFAULT", length = 1)

	public String getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

}