package com.mudra.mboss.master.services.impl.supplier;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.bean.supplier.SupplierBankDetailBean;
import com.mudra.mboss.master.bean.supplier.SupplierDetailFileBean;
import com.mudra.mboss.master.bean.supplier.SupplierDetailmasterbean;
import com.mudra.mboss.master.bean.supplier.TdsDetailBean;
import com.mudra.mboss.master.entity.client.Generalmaster;
import com.mudra.mboss.master.entity.client.GeneralmasterId;
import com.mudra.mboss.master.entity.supplier.Suppliergroupmaster;
import com.mudra.mboss.master.entity.supplier.SuppliergroupmasterId;
import com.mudra.mboss.master.entity.supplier.Suppliermaster;
import com.mudra.mboss.master.entity.supplier.SuppliermasterId;
import com.mudra.mboss.master.entity.supplier.Suppliermasterrtgsdetail;
import com.mudra.mboss.master.entity.supplier.SuppliermasterrtgsdetailId;
import com.mudra.mboss.master.entity.supplier.Suppliermastertdsdetail;
import com.mudra.mboss.master.entity.supplier.SuppliermastertdsdetailId;
import com.mudra.mboss.master.services.supplier.SupplierDetailSavaService;
import com.mudra.security.bean.UserdetailBean;

@Service
public class SupplierDetailSavaServiceImpl implements SupplierDetailSavaService {
	
	@Autowired
	EntityManagerFactory emf;
	
	@Value("${suppliermaster.uploadzipfilelocation}")
	private String uploadzipfilelocation;
	
	@Value("${suppliermaster.uploadpanfilelocation}")
	private String uploadpanfilelocation;
	
	public SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	public SimpleDateFormat dateFormatSecond = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Map<String, Object>  saveSupplierDatail(SupplierDetailmasterbean bean, SupplierDetailFileBean fileBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		Transaction transaction =null;
		Session session = emf.createEntityManager().unwrap(Session.class);
		
		try{
			UserdetailBean userdetailBean = bean.getUserdetailbean();
			String uniqueid = userdetailBean.getUniqueid();
			String editflag;
			if(null!=bean.getSuppliereditflag() && bean.getSuppliereditflag().trim().length()>0) 
				editflag = bean.getSuppliereditflag();
			else
				editflag ="NO";
			if (MasterCommon.checkNullAndEmpty(bean.getSupplierid(),uniqueid)) {
					transaction = session.beginTransaction();
					Suppliermaster sm = new Suppliermaster();
					SuppliermasterId id = new SuppliermasterId();
			if(editflag.equals("YES")) {
					id.setSupplierid(bean.getSupplierid());
					id.setUniqueid(Integer.parseInt(uniqueid));
					sm = (Suppliermaster)session.get(Suppliermaster.class,id);}
			else {
					id.setSupplierid(bean.getSupplierid());
					id.setUniqueid(Integer.parseInt(uniqueid));
					sm.setId(id);
				}
			if(null!=bean.getSuppliername() && bean.getSuppliername().trim().length()>0)
					sm.setSuppliername(bean.getSuppliername());
				
			if(null!=bean.getDisplayname()&& bean.getDisplayname().trim().length()>0)
					sm.setDisplayname(bean.getDisplayname());
				
			if(null!=bean.getPaytoname() && bean.getPaytoname().trim().length()>0)
					sm.setPaytoname(bean.getPaytoname());
				
			if(null!=bean.getSupplierjobtype() && bean.getSupplierjobtype().trim().length()>0) 
					sm.setJobtypeid(Integer.parseInt(bean.getSupplierjobtype()));
				
			if(null!=bean.getGlcode() && bean.getGlcode().trim().length()>0)
					sm.setGlcode(Integer.parseInt(bean.getGlcode()));
				
			if(null!=bean.getSuppliercategory() && bean.getSuppliercategory().trim().length()>0)
					sm.setSuppliercategory(bean.getSuppliercategory());

			if(null!=bean.getCreditdays() && bean.getCreditdays().trim().length()>0)
					sm.setCreditdays(Short.parseShort(bean.getCreditdays()));
			else
				sm.setCreditdays(Short.parseShort("0"));
			if(null!=bean.getSuppliertype() && bean.getSuppliertype().trim().length()>0)
					sm.setSuppliertype(bean.getSuppliertype());
				
			if(null!=bean.getGst_vendor_type() && bean.getGst_vendor_type().trim().length()>0)
					sm.setGstVendorType(bean.getGst_vendor_type());
				
			if(null!=bean.getPannumber() && bean.getPannumber().trim().length()>0)
					sm.setPannumber(bean.getPannumber());
				
			if(null!=bean.getPan_suppliername() && bean.getPan_suppliername().trim().length()>0)
					sm.setPanSuppliername(bean.getPan_suppliername());
				
			if(null!=bean.getCommissionpercentage() && bean.getCommissionpercentage().trim().length()>0)
					sm.setCommissionpercentage(Double.parseDouble(bean.getCommissionpercentage()));
				
			if(null!=bean.getIsmsmedvendor() && bean.getIsmsmedvendor().trim().length()>0)
					sm.setIsmsmedvendor(bean.getIsmsmedvendor());
				
			if(null!=bean.getIssquarecentimeter() && bean.getIssquarecentimeter().trim().length()>0)
					sm.setIssquarecentimeter(bean.getIssquarecentimeter());
				
			if(null!=bean.getIsblacklisted() && bean.getIsblacklisted().trim().length()>0)
					sm.setIsblacklisted(bean.getIsblacklisted());
				
			if(null!=bean.getIsforeignvendor() && bean.getIsforeignvendor().trim().length()>0)
					sm.setIsforeignvendor(bean.getIsforeignvendor());
				
			if(null!=bean.getIsonlineservice() && bean.getIsonlineservice().trim().length()>0)
					sm.setIsonlineservice(bean.getIsonlineservice());
				
			if(null!=bean.getIsonlineservice() && bean.getIsonlineservice().trim().length()>0)
					sm.setIsonlineservice(bean.getIsonlineservice());
				
			if(null!=bean.getIsacknowledgement () && bean.getIsacknowledgement().trim().length()>0)
					sm.setIsacknowledgement(bean.getIsacknowledgement());
				
				
				// Supplier Address Detail
				
			if(null!=bean.getSuppliercontactperson() && bean.getSuppliercontactperson().trim().length()>0)
					sm.setContactperson(bean.getSuppliercontactperson());
				
			if(null!=bean.getSupplieraddress1() && bean.getSupplieraddress1().trim().length()>0)
					sm.setAddress1(bean.getSupplieraddress1());
				
			if(null!=bean.getSupplieraddress2() && bean.getSupplieraddress2().trim().length()>0)
					sm.setAddress2(bean.getSupplieraddress2());
				
				if(null!=bean.getSupplieraddress3() && bean.getSupplieraddress3().trim().length()>0)
					sm.setAddress3(bean.getSupplieraddress3());
				
				if(null!=bean.getSuppliercity() && bean.getSuppliercity().trim().length()>0)
					sm.setCity(bean.getSuppliercity());
				
				if(null!=bean.getState() && bean.getState().trim().length()>0)
					sm.setState(bean.getState());
				
				if(null!=bean.getSupplierphoneno() && bean.getSupplierphoneno().trim().length()>0)
					sm.setTelephonenumbers(bean.getSupplierphoneno());
				
				if(null!=bean.getSupplierfax() && bean.getSupplierfax().trim().length()>0)
					sm.setFaxnumbers(bean.getSupplierfax());
				
				if(null!=bean.getSupplierpincode() && bean.getSupplierpincode().trim().length()>0)
					sm.setPin(Integer.parseInt(bean.getSupplierpincode()));
				
				if(null!=bean.getSuppliercountry() && bean.getSuppliercountry().trim().length()>0)
					sm.setCountry(bean.getSuppliercountry());
				
				
				
				if(null!=bean.getSupplieremail() && bean.getSupplieremail().trim().length()>0)
					sm.setEmailid(bean.getSupplieremail());
				
					sm.setIsactive("Y");
				
					
					if(null!=userdetailBean.getCompanyid() && userdetailBean.getCompanyid().trim().length()>0)
						sm.setCompanyid(Byte.parseByte(userdetailBean.getCompanyid()));
					
					if(null!=userdetailBean.getDivisionid() && userdetailBean.getDivisionid().trim().length()>0)
						sm.setDivisionid(Byte.parseByte(userdetailBean.getDivisionid()));
					
					if(null!=userdetailBean.getLocationid() && userdetailBean.getLocationid().trim().length()>0)
						sm.setLocationid(Byte.parseByte(userdetailBean.getLocationid()));
					
					if(null!=userdetailBean.getSubdivisionid() && userdetailBean.getSubdivisionid().trim().length()>0)
						sm.setSubdivisionid(Byte.parseByte(userdetailBean.getSubdivisionid()));

					// SET TDS DATA
					boolean tdssaveflag = settdsdetail(bean, session);
					TdsDetailBean tdsdata = bean.getTdsdetailbean();
					
					if(tdssaveflag=true) {
						
						for(int i=0;i<tdsdata.getTdssectionid().length;i++) {
							if(tdsdata.getIsdefaulttds()[i].toString().equals("Y")) {
								sm.setTdssectionid(tdsdata.getTdssectionid()[i].toString());
								sm.setTdscompanytype(tdsdata.getTdscomptype()[i].toString());
								sm.setTdscertificaterequirement(tdsdata.getTdscertireq()[i].toString());
							}
						  }
						}
					
					if (null!=saveBankData(bean, session)) 
						map.put("bankdetail", "BankDataSaveSuccessfully");
					

				if(null!=fileBean.uploadziprarfile && null!=uploadzipfilelocation && uploadzipfilelocation.trim().length()>0) {
					File uploadziprarfile = MasterCommon.convert(fileBean.uploadziprarfile);
					
					String zipfile ;
					
					if(null!=uploadziprarfile) {
						String strpan ="select * from MUDRA.SUPPLIERMASTERDOCUMENTDETAIL where uniqueid="+uniqueid+" and SUPPLIERID='"+bean.getSupplierid()+"' AND ISACTIVE='Y' and type='ZIP' ";
				 		List<?> list2 = getDataFromQuery(strpan,session);
					if(null!=list2 && list2.size()>0) {
						zipfile = MasterCommon.uploadFile(uploadziprarfile,uploadziprarfile.getName(),uploadzipfilelocation,uniqueid+"_"+bean.getSupplierid()+"_ZIP",fileBean.servercontextpath);
						if(null!=zipfile) {
								String uploadpan = " update MUDRA.SUPPLIERMASTERDOCUMENTDETAIL set filepath='"+zipfile+"' where type='ZIP' and uniqueid="+uniqueid+" and SUPPLIERID='"+bean.getSupplierid()+"' AND ISACTIVE='Y' ";
									NativeQuery<?> query = session.createNativeQuery(uploadpan);
									query.executeUpdate();
								map.put("UPLOADZIPRARFILE", "SUCCESSFULLY");
						}else {
								map.put("UPLOADZIPRARFILE", "FAILED");
						}
					}
					else {
						zipfile = MasterCommon.uploadFile(uploadziprarfile,uploadziprarfile.getName(),uploadzipfilelocation,uniqueid+"_"+bean.getSupplierid()+"_ZIP",fileBean.servercontextpath);
						String uploadzip = "insert into mudra.SUPPLIERMASTERDOCUMENTDETAIL(uniqueid,supplierid,type,filepath,isactive)"
								+ " values("+uniqueid+",'"+bean.getSupplierid()+"','ZIP','"+zipfile+"','Y')";
								NativeQuery<?> query = session.createNativeQuery(uploadzip);
								query.executeUpdate();
								map.put("UPLOADZIPRARFILE", "SUCCESSFULLY");
						}
					}
					else{
								map.put("UPLOADZIPRARFILE", "FAILED");
					}
				}
				
				if(null!=fileBean.uploadpanfile && null!=uploadpanfilelocation && uploadpanfilelocation.trim().length()>0) {
					File uploadziprarfile = MasterCommon.convert(fileBean.uploadpanfile);
					
					String panfile ;
					
					if(null!=uploadziprarfile) {
						String str ="select * from MUDRA.SUPPLIERMASTERDOCUMENTDETAIL where uniqueid="+uniqueid+" and SUPPLIERID='"+bean.getSupplierid()+"' AND ISACTIVE='Y' and type='PAN' ";
				 		List list2 = getDataFromQuery(str,session);
					if(null!=list2 && list2.size()>0) {
						panfile = MasterCommon.uploadFile(uploadziprarfile,uploadziprarfile.getName(),uploadpanfilelocation,uniqueid+"_"+bean.getSupplierid()+"_PAN",fileBean.servercontextpath);
						if(null!=panfile) {
								String uploaddoc = " update MUDRA.SUPPLIERMASTERDOCUMENTDETAIL set filepath='"+panfile+"' where type='PAN' and uniqueid="+uniqueid+" and SUPPLIERID='"+bean.getSupplierid()+"' AND ISACTIVE='Y' ";
									NativeQuery<?> query = session.createNativeQuery(uploaddoc);
									query.executeUpdate();
								map.put("UPLOADPANFILE", "SUCCESSFULLY");
						}else {
								map.put("UPLOADPANFILE", "FAILED");
						}
					}
					else {
						panfile = MasterCommon.uploadFile(uploadziprarfile,uploadziprarfile.getName(),uploadpanfilelocation,uniqueid+"_"+bean.getSupplierid()+"_PAN",fileBean.servercontextpath);
						String uploaddoc = "insert into mudra.SUPPLIERMASTERDOCUMENTDETAIL(uniqueid,supplierid,type,filepath,isactive)"
								+ " values("+uniqueid+",'"+bean.getSupplierid()+"','PAN','"+panfile+"','Y')";
								NativeQuery<?> query = session.createNativeQuery(uploaddoc);
								query.executeUpdate();
								map.put("UPLOADZIPRARFILE", "SUCCESSFULLY");
						}
					}
					else{
								map.put("UPLOADZIPRARFILE", "FAILED");
					}
				}
				
				
				String branches[] = bean.getBranches();
				
				// ADD BRANCHES
				if(null!=bean.getGlcode() && MasterCommon.checkNullAndEmpty(bean.getGlcode()) 
						&& "NO".equals(editflag) && MasterCommon.isNumeric(bean.getGlcode()) 
						&& Integer.parseInt(bean.getGlcode()) != 0) {
					String interbranchuniqueid = "0";					
					String sqlQuery = " insert into mudra.glmaster (glcode,isactive,category,tbalcategory,INTERBRANCHUNIQUEID) values "
						+ " ("+bean.getGlcode()+",'Y','D','D',"+interbranchuniqueid+") ";
					NativeQuery<?> query = session.createNativeQuery(sqlQuery);
					query.executeUpdate();
					
				}
				
				if(null!=branches && branches.length>0 && "YES".equals(editflag)){
					for (String string : branches) {
						
						if(null!=string && string.trim().length()>0) {
						String sqlQuery = " insert into mudra.suppliermaster(UNIQUEID, SUPPLIERID, COMPANYID, DIVISIONID, SUBDIVISIONID, LOCATIONID, SUPPLIERGROUPID, GLCODE, SUPPLIERNAME, DISPLAYNAME, CLIENTID, ADDRESS1, ADDRESS2, ADDRESS3, CITY, PIN, STATE, ISACTIVE, ISBLACKLISTED, PANNUMBER, SERVICETAXNUMBER, CSTNUMBER, LSTNUMBER, EMAILID, TDSCERTIFICATEREQUIREMENT, CREDITDAYS, STDCODE, TELEPHONENUMBERS, TELEPHONEEXTENSION, COUNTRY, CONTACTPERSON, MRV, JOBTYPEID, TDSCOMPANYTYPE, SUPPLIERTYPE, CREATEDBY, CREATEDON, MODIFIEDON, MODIFIEDBY, IPADDRESS, MACADDRESS, FAXNUMBERS, OLDCODE, SUPPLIERDISPLAYNAME, SUPPLIERCATEGORY, PAYTONAME, TELEPHONEXTENSION, TDSSECTIONID, SERVICETAXEFFECTIVEDATE, SERVICETAXREGISTRATIONNO, ISREGISTRATIONCOPYRECEIVED, SERVICES, ISSQUARECENTIMETER, PRINTUNIQUEID, ISMEMBER, COMMISSIONPERCENTAGE, LANGUAGE, ISDATAVERIFIED, PAN_SUPPLIERNAME, ISPANVERIFY, ADVERTISINGTAX, COPYUNIQUEID, ISFOREIGNVENDOR, ISMSMEDVENDOR, TINNUMBER, ISACKNOWLEDGEMENT, ISONLINESERVICE, GST_VENDOR_TYPE, ISNEWLYCREATED)" + 
								"" + 
								" select "+string+", SUPPLIERID, COMPANYID, DIVISIONID, SUBDIVISIONID, LOCATIONID, SUPPLIERGROUPID, GLCODE, SUPPLIERNAME, DISPLAYNAME, CLIENTID, ADDRESS1, ADDRESS2, ADDRESS3, CITY, PIN, STATE, ISACTIVE, ISBLACKLISTED, PANNUMBER, SERVICETAXNUMBER, CSTNUMBER, LSTNUMBER, EMAILID, TDSCERTIFICATEREQUIREMENT, CREDITDAYS, STDCODE, TELEPHONENUMBERS, TELEPHONEEXTENSION, COUNTRY, CONTACTPERSON, MRV, JOBTYPEID, TDSCOMPANYTYPE, SUPPLIERTYPE, CREATEDBY, CREATEDON, MODIFIEDON, MODIFIEDBY, IPADDRESS, MACADDRESS, FAXNUMBERS, OLDCODE, SUPPLIERDISPLAYNAME, SUPPLIERCATEGORY, PAYTONAME, TELEPHONEXTENSION, TDSSECTIONID, SERVICETAXEFFECTIVEDATE, SERVICETAXREGISTRATIONNO, ISREGISTRATIONCOPYRECEIVED, SERVICES, ISSQUARECENTIMETER, PRINTUNIQUEID, ISMEMBER, COMMISSIONPERCENTAGE, LANGUAGE, ISDATAVERIFIED, PAN_SUPPLIERNAME, ISPANVERIFY, ADVERTISINGTAX, COPYUNIQUEID, ISFOREIGNVENDOR, ISMSMEDVENDOR, TINNUMBER, ISACKNOWLEDGEMENT, ISONLINESERVICE, GST_VENDOR_TYPE, ISNEWLYCREATED " + 
								" " + 
								" from mudra.suppliermaster " + 
								" " + 
								" where uniqueid ="+uniqueid+" and " + 
								" " + 
								" supplierid = '"+bean.getSupplierid()+"' ";
					
						NativeQuery<?> query = session.createNativeQuery(sqlQuery);
						query.executeUpdate();
						}
					}
				}
				
				// SUPPLIERMASTER
				
				if("NO".equals(editflag))
					updateGlcodeInGeneralMaster(bean,session);
				
				if(null!=bean.getSuppliergroupid() && bean.getSuppliergroupid().trim().length()>0 && "Y".equals(bean.getExistingrdbtn())) {
					sm.setSuppliergroupid(bean.getSuppliergroupid());
				}
				
				if("NO".equals(editflag) && "Y".equals(bean.getNewgrouprdbtn())) {
					
					if("NO".equals(editflag)) {
						String str  ="insert into mudra.suppliergroupmaster(UNIQUEID,SUPPLIERGROUPID,SUPPLIERGROUPNAME,"
								+ "SUPPLIERTYPE,JOBTYPEID,COMPANYID,DIVISIONID,SUBDIVISIONID,LOCATIONID) values("+Integer.parseInt(uniqueid)+",'"+ bean.getNewgroupid()+"','"+bean.getNewgroupname()+"','"+bean.getSuppliertype()+"','',"+userdetailBean.getCompanyid()+","+userdetailBean.getDivisionid()+","+userdetailBean.getSubdivisionid()+","+userdetailBean.getLocationid()+")";
						
						System.out.println("INSERT QUERY-->"+str);
						NativeQuery<?> query = session.createNativeQuery(str);
						query.executeUpdate();
						sm.setSuppliergroupid(bean.getNewgroupid());
				    }
				}
				
				if(null!=sm && "NO".equals(editflag)){
					session.save(sm);
					map.put("SAVE","YES");
				}
				else if(null!=sm && "YES".equals(editflag)){
					map.put("UPDATE","YES");
				}
				// PAN CODE HEARE
				session.flush();
				transaction.commit();
			}
			
		}catch (Exception e) {
			if(null!=transaction) {
				System.out.println("Transaction Rollback");
				transaction.rollback();
			}
			map.put("ERRORMASSAGE","Error Occure During save Please Contact (It)");
			e.printStackTrace();
		}finally{
			if(null!=session) {
				session.clear();
				session.close();
			}	
		}
		return map;
	}
	
	public Generalmaster updateGlcodeInGeneralMaster(SupplierDetailmasterbean bean,Session session){
		try{
			UserdetailBean userdetailBean = bean.getUserdetailbean();
			String uniqueid = userdetailBean.getUniqueid().substring(0, 4);
			String glcode = bean.getGlcode();
			
			GeneralmasterId id = new GeneralmasterId(Integer.parseInt(uniqueid), "SUP-GLCODE", "SUP-GLCODE");
			Generalmaster generalmaster = (Generalmaster)session.get(Generalmaster.class, id);
			if(null!=generalmaster ) {
				if(MasterCommon.isNumeric(glcode))
					generalmaster.setNumvalue1(Double.parseDouble(glcode));
				return generalmaster;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Boolean settdsdetail(SupplierDetailmasterbean bean,Session session) {
		
		try {
			String supplierid = bean.getSupplierid();
			String uniqueid = bean.getUserdetailbean().getUniqueid();
			TdsDetailBean tdsdata = bean.getTdsdetailbean();
			
			String getMax = getMaxValue("mudra.suppliermastertdsdetail", "serialno","where supplierid='" + supplierid + "' and uniqueid = " +uniqueid+ " ",session);
			int srno=1;
			int newmax = Integer.parseInt(getMax);
			for(int i=0;i<tdsdata.getTdssectionid().length;i++) {
				
				Suppliermastertdsdetail tdsdetail = new Suppliermastertdsdetail();
				SuppliermastertdsdetailId id = new SuppliermastertdsdetailId();
				
				id.setSupplierid(supplierid);
				id.setUniqueid(Integer.parseInt(uniqueid));
				
				if(null != getMax && getMax.trim().length()>0 && Integer.parseInt(getMax)==1){
						id.setSerialno(Short.parseShort(String.valueOf(srno++)));
						tdsdetail.setId(id);				
				}
				else {
					if(null!=tdsdata.getSerialno()[i] && tdsdata.getSerialno()[i].trim().length()>0 ) {
						id.setSerialno(Short.parseShort(tdsdata.getSerialno()[i]));
						tdsdetail = (Suppliermastertdsdetail)session.get(Suppliermastertdsdetail.class, id);
					}
					else {
						id.setSerialno(Short.parseShort(String.valueOf(newmax++)));
						tdsdetail.setId(id);
					}
				}
				
				
				
				if(null!=tdsdata.getServices()[i] && tdsdata.getServices()[i].trim().length()>0 ) {
					tdsdetail.setServices(tdsdata.getServices()[i]);
				}								
				
				if(null!=tdsdata.getIsdefaulttds()[i] && tdsdata.getIsdefaulttds()[i].trim().length()>0 ) {
					tdsdetail.setIsdefaulttds(tdsdata.getIsdefaulttds()[i]);
				}
				if(null!=tdsdata.getTdssectionid()[i] && tdsdata.getTdssectionid()[i].trim().length()>0 ) {
					tdsdetail.setTdssectionid(tdsdata.getTdssectionid()[i]);
				}
				
				if(null!=tdsdata.getEffectiveto()[i] && tdsdata.getEffectiveto()[i].trim().length()>0 ) {
					tdsdetail.setEffectiveto(dateFormat.parse(tdsdata.getEffectiveto()[i].toString()));
				}
				
				if(null!=tdsdata.getEffectivefrom()[i] && tdsdata.getEffectivefrom()[i].trim().length()>0 ) {
					tdsdetail.setEffectivefrom(dateFormat.parse(tdsdata.getEffectivefrom()[i].toString()));
				}

				
				if(null==tdsdata.getSerialno()[i] || tdsdata.getSerialno()[i].trim().length()==0) {
					session.save(tdsdetail);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Suppliermasterrtgsdetail saveBankData(SupplierDetailmasterbean sbean,Session session) {
	
			try{
				String supplierid = sbean.getSupplierid();
				String uniqueid = sbean.getUserdetailbean().getUniqueid();
				SupplierBankDetailBean bean = sbean.getBankDetails();
				Suppliermasterrtgsdetail suppliermasterrtgsdetail = new Suppliermasterrtgsdetail();
				SuppliermasterrtgsdetailId id = new SuppliermasterrtgsdetailId();
				if (MasterCommon.checkNullAndEmpty(supplierid,uniqueid)) {
					String strQuery = "select supplierid from MUDRA.SUPPLIERMASTERRTGSDETAIL where uniqueid ="+uniqueid+" and supplierid ='"+supplierid+"'";
					List<?> list  = getDataFromQuery(strQuery, session);
					if(null!=list && list.size()>0) {
						id.setSupplierid(supplierid);
						id.setUniqueid(Integer.parseInt(uniqueid));
						suppliermasterrtgsdetail = (Suppliermasterrtgsdetail)session.get(Suppliermasterrtgsdetail.class, id);
					}
					else {
						id.setSupplierid(supplierid);
						id.setUniqueid(Integer.parseInt(uniqueid));
						suppliermasterrtgsdetail.setId(id);
					}

					if(null!=bean.getBeneficiaryname() && bean.getBeneficiaryname().trim().length()>0)
						suppliermasterrtgsdetail.setBeneficiaryname(bean.getBeneficiaryname().trim());
					if(null!=bean.getAccountnumber() && bean.getAccountnumber().trim().length()>0)
						suppliermasterrtgsdetail.setAccountnumber(bean.getAccountnumber().trim());
					if(null!=bean.getIfsccode() && bean.getIfsccode().trim().length()>0)
						suppliermasterrtgsdetail.setIfsccode(bean.getIfsccode().trim());
					if(null!=bean.getBankname() && bean.getBankname().trim().length()>0)
						suppliermasterrtgsdetail.setBankname(bean.getBankname().trim());
					if(null!=bean.getBranchname() && bean.getBranchname().trim().length()>0)
						suppliermasterrtgsdetail.setBranchname(bean.getBranchname().trim());
					if(null!=bean.getBenedescription() && bean.getBenedescription().trim().length()>0)
						suppliermasterrtgsdetail.setBenedescription(bean.getBenedescription().trim());
						session.save(suppliermasterrtgsdetail);
					}
					
					
				return suppliermasterrtgsdetail;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			return null;
	}
	
	

	
	
	
	public List<?> getDataFromQuery(String strQuery,Session session) {
		
		try{
			//logger.error(strQuery);
			Query query = session.createNativeQuery(strQuery);
			List<?> dataList = query.getResultList();
			return dataList;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	

	public String getMaxValue(String tablename,  String columnname, String whereClause,Session session){	 //  if  where cluse is null then pass as  ->  "" or  null
		try{
		String strQuery ="SELECT  NVL(MAX("+columnname+") ,0)+1 FROM  "+tablename; 
		if(null!=whereClause &&  whereClause.trim().length()>0)
		strQuery += " "+whereClause;
		List<?> maxPlusValList = getDataFromQuery(strQuery,session);
		if(null!=maxPlusValList && !maxPlusValList.isEmpty())
		return maxPlusValList.get(0).toString();
		}catch(Exception e){
		e.printStackTrace();
		}
		return "0";
		}
	
	
	
	
	
}

