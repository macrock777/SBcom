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
 * Documentseriesmaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DOCUMENTSERIESMASTER", schema = "MUDRA")

public class Documentseriesmaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DocumentseriesmasterId id;
	private String documenttype;
	private Short accountingyear;
	private Integer jobtypeid;
	private String documentdescription;
	private Byte documentseries;
	private Long documentstartnumber;
	private String documentinitialize;
	private String uselocationid;
	private String useseries;
	private String useaccountingyear;
	private Long lastdocumentnumber;
	private Date lastdocumentdate;
	private String filler1;
	private String filler2;
	private String filler3;
	private String isclosed;
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
	private Date earliestdocumentdate;
	private Date dateofclosing;
	private Byte accountingmonth;
	private Long roleid;
	private Long deptseries;

	// Constructors

	/** default constructor */
	public Documentseriesmaster() {
	}

	/** minimal constructor */
	public Documentseriesmaster(DocumentseriesmasterId id, String documenttype, Short accountingyear, Integer jobtypeid,
			String documentdescription, Byte documentseries, Long documentstartnumber, String documentinitialize,
			String uselocationid, String useseries, String useaccountingyear, Long lastdocumentnumber,
			Date lastdocumentdate, String isclosed, Byte companyid, Byte divisionid, Byte subdivisionid,
			Byte locationid, String createdby, Date createdon) {
		this.id = id;
		this.documenttype = documenttype;
		this.accountingyear = accountingyear;
		this.jobtypeid = jobtypeid;
		this.documentdescription = documentdescription;
		this.documentseries = documentseries;
		this.documentstartnumber = documentstartnumber;
		this.documentinitialize = documentinitialize;
		this.uselocationid = uselocationid;
		this.useseries = useseries;
		this.useaccountingyear = useaccountingyear;
		this.lastdocumentnumber = lastdocumentnumber;
		this.lastdocumentdate = lastdocumentdate;
		this.isclosed = isclosed;
		this.companyid = companyid;
		this.divisionid = divisionid;
		this.subdivisionid = subdivisionid;
		this.locationid = locationid;
		this.createdby = createdby;
		this.createdon = createdon;
	}

	/** full constructor */
	public Documentseriesmaster(DocumentseriesmasterId id, String documenttype, Short accountingyear, Integer jobtypeid,
			String documentdescription, Byte documentseries, Long documentstartnumber, String documentinitialize,
			String uselocationid, String useseries, String useaccountingyear, Long lastdocumentnumber,
			Date lastdocumentdate, String filler1, String filler2, String filler3, String isclosed, Byte companyid,
			Byte divisionid, Byte subdivisionid, Byte locationid, String createdby, Date createdon, Date modifiedon,
			String modifiedby, String ipaddress, String macaddress, Date earliestdocumentdate, Date dateofclosing,
			Byte accountingmonth, Long roleid, Long deptseries) {
		this.id = id;
		this.documenttype = documenttype;
		this.accountingyear = accountingyear;
		this.jobtypeid = jobtypeid;
		this.documentdescription = documentdescription;
		this.documentseries = documentseries;
		this.documentstartnumber = documentstartnumber;
		this.documentinitialize = documentinitialize;
		this.uselocationid = uselocationid;
		this.useseries = useseries;
		this.useaccountingyear = useaccountingyear;
		this.lastdocumentnumber = lastdocumentnumber;
		this.lastdocumentdate = lastdocumentdate;
		this.filler1 = filler1;
		this.filler2 = filler2;
		this.filler3 = filler3;
		this.isclosed = isclosed;
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
		this.earliestdocumentdate = earliestdocumentdate;
		this.dateofclosing = dateofclosing;
		this.accountingmonth = accountingmonth;
		this.roleid = roleid;
		this.deptseries = deptseries;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "uniqueid", column = @Column(name = "UNIQUEID", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "documentid", column = @Column(name = "DOCUMENTID", nullable = false, precision = 14, scale = 0)) })

	public DocumentseriesmasterId getId() {
		return this.id;
	}

	public void setId(DocumentseriesmasterId id) {
		this.id = id;
	}

	@Column(name = "DOCUMENTTYPE", nullable = false, length = 16)

	public String getDocumenttype() {
		return this.documenttype;
	}

	public void setDocumenttype(String documenttype) {
		this.documenttype = documenttype;
	}

	@Column(name = "ACCOUNTINGYEAR", nullable = false, precision = 4, scale = 0)

	public Short getAccountingyear() {
		return this.accountingyear;
	}

	public void setAccountingyear(Short accountingyear) {
		this.accountingyear = accountingyear;
	}

	@Column(name = "JOBTYPEID", nullable = false, precision = 6, scale = 0)

	public Integer getJobtypeid() {
		return this.jobtypeid;
	}

	public void setJobtypeid(Integer jobtypeid) {
		this.jobtypeid = jobtypeid;
	}

	@Column(name = "DOCUMENTDESCRIPTION", nullable = false, length = 32)

	public String getDocumentdescription() {
		return this.documentdescription;
	}

	public void setDocumentdescription(String documentdescription) {
		this.documentdescription = documentdescription;
	}

	@Column(name = "DOCUMENTSERIES", nullable = false, precision = 2, scale = 0)

	public Byte getDocumentseries() {
		return this.documentseries;
	}

	public void setDocumentseries(Byte documentseries) {
		this.documentseries = documentseries;
	}

	@Column(name = "DOCUMENTSTARTNUMBER", nullable = false, precision = 14, scale = 0)

	public Long getDocumentstartnumber() {
		return this.documentstartnumber;
	}

	public void setDocumentstartnumber(Long documentstartnumber) {
		this.documentstartnumber = documentstartnumber;
	}

	@Column(name = "DOCUMENTINITIALIZE", nullable = false, length = 1)

	public String getDocumentinitialize() {
		return this.documentinitialize;
	}

	public void setDocumentinitialize(String documentinitialize) {
		this.documentinitialize = documentinitialize;
	}

	@Column(name = "USELOCATIONID", nullable = false, length = 1)

	public String getUselocationid() {
		return this.uselocationid;
	}

	public void setUselocationid(String uselocationid) {
		this.uselocationid = uselocationid;
	}

	@Column(name = "USESERIES", nullable = false, length = 1)

	public String getUseseries() {
		return this.useseries;
	}

	public void setUseseries(String useseries) {
		this.useseries = useseries;
	}

	@Column(name = "USEACCOUNTINGYEAR", nullable = false, length = 1)

	public String getUseaccountingyear() {
		return this.useaccountingyear;
	}

	public void setUseaccountingyear(String useaccountingyear) {
		this.useaccountingyear = useaccountingyear;
	}

	@Column(name = "LASTDOCUMENTNUMBER", nullable = false, precision = 14, scale = 0)

	public Long getLastdocumentnumber() {
		return this.lastdocumentnumber;
	}

	public void setLastdocumentnumber(Long lastdocumentnumber) {
		this.lastdocumentnumber = lastdocumentnumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LASTDOCUMENTDATE", nullable = false, length = 7)

	public Date getLastdocumentdate() {
		return this.lastdocumentdate;
	}

	public void setLastdocumentdate(Date lastdocumentdate) {
		this.lastdocumentdate = lastdocumentdate;
	}

	@Column(name = "FILLER1", length = 1)

	public String getFiller1() {
		return this.filler1;
	}

	public void setFiller1(String filler1) {
		this.filler1 = filler1;
	}

	@Column(name = "FILLER2", length = 1)

	public String getFiller2() {
		return this.filler2;
	}

	public void setFiller2(String filler2) {
		this.filler2 = filler2;
	}

	@Column(name = "FILLER3", length = 1)

	public String getFiller3() {
		return this.filler3;
	}

	public void setFiller3(String filler3) {
		this.filler3 = filler3;
	}

	@Column(name = "ISCLOSED", nullable = false, length = 1)

	public String getIsclosed() {
		return this.isclosed;
	}

	public void setIsclosed(String isclosed) {
		this.isclosed = isclosed;
	}

	@Column(name = "COMPANYID", nullable = false, precision = 2, scale = 0)

	public Byte getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Byte companyid) {
		this.companyid = companyid;
	}

	@Column(name = "DIVISIONID", nullable = false, precision = 2, scale = 0)

	public Byte getDivisionid() {
		return this.divisionid;
	}

	public void setDivisionid(Byte divisionid) {
		this.divisionid = divisionid;
	}

	@Column(name = "SUBDIVISIONID", nullable = false, precision = 2, scale = 0)

	public Byte getSubdivisionid() {
		return this.subdivisionid;
	}

	public void setSubdivisionid(Byte subdivisionid) {
		this.subdivisionid = subdivisionid;
	}

	@Column(name = "LOCATIONID", nullable = false, precision = 2, scale = 0)

	public Byte getLocationid() {
		return this.locationid;
	}

	public void setLocationid(Byte locationid) {
		this.locationid = locationid;
	}

	@Column(name = "CREATEDBY", nullable = false, length = 20)

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDON", nullable = false, length = 7)

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

	@Temporal(TemporalType.DATE)
	@Column(name = "EARLIESTDOCUMENTDATE", length = 7)

	public Date getEarliestdocumentdate() {
		return this.earliestdocumentdate;
	}

	public void setEarliestdocumentdate(Date earliestdocumentdate) {
		this.earliestdocumentdate = earliestdocumentdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATEOFCLOSING", length = 7)

	public Date getDateofclosing() {
		return this.dateofclosing;
	}

	public void setDateofclosing(Date dateofclosing) {
		this.dateofclosing = dateofclosing;
	}

	@Column(name = "ACCOUNTINGMONTH", precision = 2, scale = 0)

	public Byte getAccountingmonth() {
		return this.accountingmonth;
	}

	public void setAccountingmonth(Byte accountingmonth) {
		this.accountingmonth = accountingmonth;
	}

	@Column(name = "ROLEID", precision = 10, scale = 0)

	public Long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	@Column(name = "DEPTSERIES", precision = 14, scale = 0)

	public Long getDeptseries() {
		return this.deptseries;
	}

	public void setDeptseries(Long deptseries) {
		this.deptseries = deptseries;
	}

}