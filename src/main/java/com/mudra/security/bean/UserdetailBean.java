package com.mudra.security.bean;

public class UserdetailBean {

	String uniqueid, companyid, divisionid, subdivisionid, locationid, accountingyear, loginid, accstartdate,
			accenddate, createdby, sysdate, jobtypeid, ipaddress, serverurl, reporturl, formid, emailid, mobileno,
			username, branchgstn, branchname, version, usertype;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getDivisionid() {
		return divisionid;
	}

	public void setDivisionid(String divisionid) {
		this.divisionid = divisionid;
	}

	public String getSubdivisionid() {
		return subdivisionid;
	}

	public void setSubdivisionid(String subdivisionid) {
		this.subdivisionid = subdivisionid;
	}

	public String getLocationid() {
		return locationid;
	}

	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}

	public String getAccountingyear() {
		return accountingyear;
	}

	public void setAccountingyear(String accountingyear) {
		this.accountingyear = accountingyear;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getAccstartdate() {
		return accstartdate;
	}

	public void setAccstartdate(String accstartdate) {
		this.accstartdate = accstartdate;
	}

	public String getAccenddate() {
		return accenddate;
	}

	public void setAccenddate(String accenddate) {
		this.accenddate = accenddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getSysdate() {
		return sysdate;
	}

	public void setSysdate(String sysdate) {
		this.sysdate = sysdate;
	}

	public String getJobtypeid() {
		return jobtypeid;
	}

	public void setJobtypeid(String jobtypeid) {
		this.jobtypeid = jobtypeid;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getServerurl() {
		return serverurl;
	}

	public void setServerurl(String serverurl) {
		this.serverurl = serverurl;
	}

	public String getReporturl() {
		return reporturl;
	}

	public void setReporturl(String reporturl) {
		this.reporturl = reporturl;
	}

	public String getFormid() {
		return formid;
	}

	public void setFormid(String formid) {
		this.formid = formid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getBranchgstn() {
		return branchgstn;
	}

	public void setBranchgstn(String branchgstn) {
		this.branchgstn = branchgstn;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "UserdetailBean [uniqueid=" + uniqueid + ", companyid=" + companyid + ", divisionid=" + divisionid
				+ ", subdivisionid=" + subdivisionid + ", locationid=" + locationid + ", accountingyear="
				+ accountingyear + ", loginid=" + loginid + ", accstartdate=" + accstartdate + ", accenddate="
				+ accenddate + ", createdby=" + createdby + ", sysdate=" + sysdate + ", jobtypeid=" + jobtypeid
				+ ", ipaddress=" + ipaddress + ", serverurl=" + serverurl + ", reporturl=" + reporturl + ", formid="
				+ formid + ", emailid=" + emailid + ", mobileno=" + mobileno + ", username=" + username
				+ ", branchgstn=" + branchgstn + ", branchname=" + branchname + ", version=" + version + ", usertype="
				+ usertype + "]";
	}
}
