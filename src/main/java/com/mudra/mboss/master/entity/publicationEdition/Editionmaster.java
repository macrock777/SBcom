package com.mudra.mboss.master.entity.publicationEdition;

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
 * Editionmaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EDITIONMASTER", schema = "MUDRA")

public class Editionmaster implements java.io.Serializable {

	// Fields

	private EditionmasterId id;
	private String editionname;
	private String supplierid;
	private String editiondisplayname;
	private Byte companyid;
	private Byte divisionid;
	private Byte subdivisionid;
	private Byte locationid;
	private String createdby;
	private Date createdon;
	private Date modifiedon;
	private String modifiedby;
	private String ipaddress;
	private String macaddress;
	private String editionaddress1;
	private String editionaddress2;
	private String editionaddress3;
	private String editioncity;
	private String editionstate;
	private String editionpin;
	private String editionstdcode;
	private String editionphone;
	private String editionextension;
	private String editionfax;
	private String editionemail;
	private String isactive;
	private String branchcontactperson;
	private String branchcontactemail;
	private String editionformat;
	private String editionfrequency;
	private Short editionnoofpages;
	private String editionregion;
	private Long pubcirculation;
	private Long abccirculation;
	private Long nrscirculation;
	private String iensmembershipnumber;
	private String abcmembershipnnumber;
	private String mrvnumber;
	private Short establishedin;
	private Byte newsstanddate;
	private Byte coverdate;
	private String region;
	private String publicationtype;
	private String oldPubCode;
	private String language;
	private String paytosupplierid;
	private String editionshortname;
	private String editionstateshortname;
	private String statequalifier;
	private String issplitediton;

	// Constructors

	/** default constructor */
	public Editionmaster() {
	}

	/** minimal constructor */
	public Editionmaster(EditionmasterId id) {
		this.id = id;
	}

	/** full constructor */
	public Editionmaster(EditionmasterId id, String editionname, String supplierid, String editiondisplayname,
			Byte companyid, Byte divisionid, Byte subdivisionid, Byte locationid, String createdby, Date createdon,
			Date modifiedon, String modifiedby, String ipaddress, String macaddress, String editionaddress1,
			String editionaddress2, String editionaddress3, String editioncity, String editionstate, String editionpin,
			String editionstdcode, String editionphone, String editionextension, String editionfax, String editionemail,
			String isactive, String branchcontactperson, String branchcontactemail, String editionformat,
			String editionfrequency, Short editionnoofpages, String editionregion, Long pubcirculation,
			Long abccirculation, Long nrscirculation, String iensmembershipnumber, String abcmembershipnnumber,
			String mrvnumber, Short establishedin, Byte newsstanddate, Byte coverdate, String region,
			String publicationtype, String oldPubCode, String language, String paytosupplierid, String editionshortname,
			String editionstateshortname, String statequalifier, String issplitediton) {
		this.id = id;
		this.editionname = editionname;
		this.supplierid = supplierid;
		this.editiondisplayname = editiondisplayname;
		this.companyid = companyid;
		this.divisionid = divisionid;
		this.subdivisionid = subdivisionid;
		this.locationid = locationid;
		this.createdby = createdby;
		this.createdon = createdon;
		this.modifiedon = modifiedon;
		this.modifiedby = modifiedby;
		this.ipaddress = ipaddress;
		this.macaddress = macaddress;
		this.editionaddress1 = editionaddress1;
		this.editionaddress2 = editionaddress2;
		this.editionaddress3 = editionaddress3;
		this.editioncity = editioncity;
		this.editionstate = editionstate;
		this.editionpin = editionpin;
		this.editionstdcode = editionstdcode;
		this.editionphone = editionphone;
		this.editionextension = editionextension;
		this.editionfax = editionfax;
		this.editionemail = editionemail;
		this.isactive = isactive;
		this.branchcontactperson = branchcontactperson;
		this.branchcontactemail = branchcontactemail;
		this.editionformat = editionformat;
		this.editionfrequency = editionfrequency;
		this.editionnoofpages = editionnoofpages;
		this.editionregion = editionregion;
		this.pubcirculation = pubcirculation;
		this.abccirculation = abccirculation;
		this.nrscirculation = nrscirculation;
		this.iensmembershipnumber = iensmembershipnumber;
		this.abcmembershipnnumber = abcmembershipnnumber;
		this.mrvnumber = mrvnumber;
		this.establishedin = establishedin;
		this.newsstanddate = newsstanddate;
		this.coverdate = coverdate;
		this.region = region;
		this.publicationtype = publicationtype;
		this.oldPubCode = oldPubCode;
		this.language = language;
		this.paytosupplierid = paytosupplierid;
		this.editionshortname = editionshortname;
		this.editionstateshortname = editionstateshortname;
		this.statequalifier = statequalifier;
		this.issplitediton = issplitediton;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "editionid", column = @Column(name = "EDITIONID", nullable = false, precision = 8, scale = 0)) })

	public EditionmasterId getId() {
		return this.id;
	}

	public void setId(EditionmasterId id) {
		this.id = id;
	}

	@Column(name = "EDITIONNAME", length = 64)

	public String getEditionname() {
		return this.editionname;
	}

	public void setEditionname(String editionname) {
		this.editionname = editionname;
	}

	@Column(name = "SUPPLIERID", length = 10)

	public String getSupplierid() {
		return this.supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	@Column(name = "EDITIONDISPLAYNAME", length = 32)

	public String getEditiondisplayname() {
		return this.editiondisplayname;
	}

	public void setEditiondisplayname(String editiondisplayname) {
		this.editiondisplayname = editiondisplayname;
	}

	@Column(name = "COMPANYID", precision = 2, scale = 0)

	public Byte getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Byte companyid) {
		this.companyid = companyid;
	}

	@Column(name = "DIVISIONID", precision = 2, scale = 0)

	public Byte getDivisionid() {
		return this.divisionid;
	}

	public void setDivisionid(Byte divisionid) {
		this.divisionid = divisionid;
	}

	@Column(name = "SUBDIVISIONID", precision = 2, scale = 0)

	public Byte getSubdivisionid() {
		return this.subdivisionid;
	}

	public void setSubdivisionid(Byte subdivisionid) {
		this.subdivisionid = subdivisionid;
	}

	@Column(name = "LOCATIONID", precision = 2, scale = 0)

	public Byte getLocationid() {
		return this.locationid;
	}

	public void setLocationid(Byte locationid) {
		this.locationid = locationid;
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

	@Column(name = "EDITIONADDRESS1", length = 50)

	public String getEditionaddress1() {
		return this.editionaddress1;
	}

	public void setEditionaddress1(String editionaddress1) {
		this.editionaddress1 = editionaddress1;
	}

	@Column(name = "EDITIONADDRESS2", length = 50)

	public String getEditionaddress2() {
		return this.editionaddress2;
	}

	public void setEditionaddress2(String editionaddress2) {
		this.editionaddress2 = editionaddress2;
	}

	@Column(name = "EDITIONADDRESS3", length = 50)

	public String getEditionaddress3() {
		return this.editionaddress3;
	}

	public void setEditionaddress3(String editionaddress3) {
		this.editionaddress3 = editionaddress3;
	}

	@Column(name = "EDITIONCITY", length = 20)

	public String getEditioncity() {
		return this.editioncity;
	}

	public void setEditioncity(String editioncity) {
		this.editioncity = editioncity;
	}

	@Column(name = "EDITIONSTATE", length = 20)

	public String getEditionstate() {
		return this.editionstate;
	}

	public void setEditionstate(String editionstate) {
		this.editionstate = editionstate;
	}

	@Column(name = "EDITIONPIN", length = 10)

	public String getEditionpin() {
		return this.editionpin;
	}

	public void setEditionpin(String editionpin) {
		this.editionpin = editionpin;
	}

	@Column(name = "EDITIONSTDCODE", length = 8)

	public String getEditionstdcode() {
		return this.editionstdcode;
	}

	public void setEditionstdcode(String editionstdcode) {
		this.editionstdcode = editionstdcode;
	}

	@Column(name = "EDITIONPHONE", length = 64)

	public String getEditionphone() {
		return this.editionphone;
	}

	public void setEditionphone(String editionphone) {
		this.editionphone = editionphone;
	}

	@Column(name = "EDITIONEXTENSION", length = 8)

	public String getEditionextension() {
		return this.editionextension;
	}

	public void setEditionextension(String editionextension) {
		this.editionextension = editionextension;
	}

	@Column(name = "EDITIONFAX", length = 32)

	public String getEditionfax() {
		return this.editionfax;
	}

	public void setEditionfax(String editionfax) {
		this.editionfax = editionfax;
	}

	@Column(name = "EDITIONEMAIL", length = 32)

	public String getEditionemail() {
		return this.editionemail;
	}

	public void setEditionemail(String editionemail) {
		this.editionemail = editionemail;
	}

	@Column(name = "ISACTIVE", length = 1)

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	@Column(name = "BRANCHCONTACTPERSON", length = 50)

	public String getBranchcontactperson() {
		return this.branchcontactperson;
	}

	public void setBranchcontactperson(String branchcontactperson) {
		this.branchcontactperson = branchcontactperson;
	}

	@Column(name = "BRANCHCONTACTEMAIL", length = 32)

	public String getBranchcontactemail() {
		return this.branchcontactemail;
	}

	public void setBranchcontactemail(String branchcontactemail) {
		this.branchcontactemail = branchcontactemail;
	}

	@Column(name = "EDITIONFORMAT", length = 10)

	public String getEditionformat() {
		return this.editionformat;
	}

	public void setEditionformat(String editionformat) {
		this.editionformat = editionformat;
	}

	@Column(name = "EDITIONFREQUENCY", length = 16)

	public String getEditionfrequency() {
		return this.editionfrequency;
	}

	public void setEditionfrequency(String editionfrequency) {
		this.editionfrequency = editionfrequency;
	}

	@Column(name = "EDITIONNOOFPAGES", precision = 3, scale = 0)

	public Short getEditionnoofpages() {
		return this.editionnoofpages;
	}

	public void setEditionnoofpages(Short editionnoofpages) {
		this.editionnoofpages = editionnoofpages;
	}

	@Column(name = "EDITIONREGION", length = 16)

	public String getEditionregion() {
		return this.editionregion;
	}

	public void setEditionregion(String editionregion) {
		this.editionregion = editionregion;
	}

	@Column(name = "PUBCIRCULATION", precision = 10, scale = 0)

	public Long getPubcirculation() {
		return this.pubcirculation;
	}

	public void setPubcirculation(Long pubcirculation) {
		this.pubcirculation = pubcirculation;
	}

	@Column(name = "ABCCIRCULATION", precision = 10, scale = 0)

	public Long getAbccirculation() {
		return this.abccirculation;
	}

	public void setAbccirculation(Long abccirculation) {
		this.abccirculation = abccirculation;
	}

	@Column(name = "NRSCIRCULATION", precision = 10, scale = 0)

	public Long getNrscirculation() {
		return this.nrscirculation;
	}

	public void setNrscirculation(Long nrscirculation) {
		this.nrscirculation = nrscirculation;
	}

	@Column(name = "IENSMEMBERSHIPNUMBER", length = 16)

	public String getIensmembershipnumber() {
		return this.iensmembershipnumber;
	}

	public void setIensmembershipnumber(String iensmembershipnumber) {
		this.iensmembershipnumber = iensmembershipnumber;
	}

	@Column(name = "ABCMEMBERSHIPNNUMBER", length = 16)

	public String getAbcmembershipnnumber() {
		return this.abcmembershipnnumber;
	}

	public void setAbcmembershipnnumber(String abcmembershipnnumber) {
		this.abcmembershipnnumber = abcmembershipnnumber;
	}

	@Column(name = "MRVNUMBER", length = 16)

	public String getMrvnumber() {
		return this.mrvnumber;
	}

	public void setMrvnumber(String mrvnumber) {
		this.mrvnumber = mrvnumber;
	}

	@Column(name = "ESTABLISHEDIN", precision = 4, scale = 0)

	public Short getEstablishedin() {
		return this.establishedin;
	}

	public void setEstablishedin(Short establishedin) {
		this.establishedin = establishedin;
	}

	@Column(name = "NEWSSTANDDATE", precision = 2, scale = 0)

	public Byte getNewsstanddate() {
		return this.newsstanddate;
	}

	public void setNewsstanddate(Byte newsstanddate) {
		this.newsstanddate = newsstanddate;
	}

	@Column(name = "COVERDATE", precision = 2, scale = 0)

	public Byte getCoverdate() {
		return this.coverdate;
	}

	public void setCoverdate(Byte coverdate) {
		this.coverdate = coverdate;
	}

	@Column(name = "REGION", length = 5)

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "PUBLICATIONTYPE", length = 16)

	public String getPublicationtype() {
		return this.publicationtype;
	}

	public void setPublicationtype(String publicationtype) {
		this.publicationtype = publicationtype;
	}

	@Column(name = "OLD_PUB_CODE", length = 10)

	public String getOldPubCode() {
		return this.oldPubCode;
	}

	public void setOldPubCode(String oldPubCode) {
		this.oldPubCode = oldPubCode;
	}

	@Column(name = "LANGUAGE", length = 10)

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "PAYTOSUPPLIERID", length = 10)

	public String getPaytosupplierid() {
		return this.paytosupplierid;
	}

	public void setPaytosupplierid(String paytosupplierid) {
		this.paytosupplierid = paytosupplierid;
	}

	@Column(name = "EDITIONSHORTNAME", length = 3)

	public String getEditionshortname() {
		return this.editionshortname;
	}

	public void setEditionshortname(String editionshortname) {
		this.editionshortname = editionshortname;
	}

	@Column(name = "EDITIONSTATESHORTNAME", length = 3)

	public String getEditionstateshortname() {
		return this.editionstateshortname;
	}

	public void setEditionstateshortname(String editionstateshortname) {
		this.editionstateshortname = editionstateshortname;
	}

	@Column(name = "STATEQUALIFIER", length = 256)

	public String getStatequalifier() {
		return this.statequalifier;
	}

	public void setStatequalifier(String statequalifier) {
		this.statequalifier = statequalifier;
	}

	@Column(name = "ISSPLITEDITON", length = 1)

	public String getIssplitediton() {
		return this.issplitediton;
	}

	public void setIssplitediton(String issplitediton) {
		this.issplitediton = issplitediton;
	}

}