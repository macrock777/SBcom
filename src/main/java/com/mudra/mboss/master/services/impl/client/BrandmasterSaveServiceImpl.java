package com.mudra.mboss.master.services.impl.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.BrandMasterBean;
import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.entity.client.Brandmaster;
import com.mudra.mboss.master.entity.client.BrandmasterId;
import com.mudra.mboss.master.services.client.BrandmasterSaveService;
import com.mudra.security.bean.UserdetailBean;

@Service
public class BrandmasterSaveServiceImpl implements BrandmasterSaveService {

	@Autowired
	EntityManagerFactory emf;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Map<String, Object> saveBrand(BrandMasterBean brandMasterBean) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		Transaction transaction = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("BRAND_SAVE", "FAILED");
		try {
			transaction = session.beginTransaction();
			String uniqueid = brandMasterBean.getUserdetail().getUniqueid();
			String branches = brandMasterBean.getBranches();
			String edittime = brandMasterBean.getEdittime();
			String clientid = brandMasterBean.getClientid();
			String brandid = brandMasterBean.getBrandid();
			
			if(MasterCommon.checkNullAndEmpty(uniqueid,edittime)) {
				
				Brandmaster brandmaster = saveBrandMasterDetail(brandMasterBean,session);
				if(null!=brandmaster && "NO".equals(edittime))
					session.save(brandmaster);
				else if("YES".equals(edittime))
					session.update(brandmaster);
				
				session.flush();
				
				if(null!=branches && branches.trim().length()>0) {
					String[] branchesArray = null;
					if(branches.indexOf(",")!=-1) {
						branchesArray = branches.split(",");
					}else{
						branchesArray = new String[1];
						branchesArray[0] = branches;
					}
					
					for (String branch : branchesArray) {
						if(null!=branch && branch.trim().length()>0) {
							String sqlQuery = " INSERT INTO MUDRA.BRANDMASTER SELECT "+branch+",BRANDID,PRODUCTCODE,CLIENTID, "
									+ " BRANDNAME,AGENCYTYPE,AGENCYCOMMISSION,CLIENTCOMMISSION,CACOMMISSION,CONTACTPERSON,STDCODE,TELEPHONENUMBERS, "
									+ " EMAILID,MOBILENUMBER,COMPANYID,DIVISIONID,SUBDIVISIONID,LOCATIONID,CREATEDBY,CREATEDON,MODIFIEDON,MODIFIEDBY, "
									+ " IPADDRESS,MACADDRESS,PRINTPREFIX,ISCOMMISSIONSHARING,ISCABREAKUPREQUIRED,HIDDENCOMMISSIONPERC,SUPPLIERID,ISOMSCLIENT,"
									+ " OMSCOMMISSIONPERCENT,CAAUTOPORAISED,CLIENTAUTOPORAISED,CASUPPLIERID,CLIENTSUPPLIERID,CARESPONSIBLE,CLINETRESPOSIBLE,BILLINGPERC,"
									+ " PRINTUNIQUEID,ADDRESS1,ADDRESS2,ADDRESS3,CITY,STATE,PIN,COUNTRY,CLIENTSTDCODE,CLIENTTELEPHONENUMBERS,CLIENTFAXNUMBERS,"
									+ " CLIENTEMAILID,PRNBRANDNMCLIENTNM,PASSDISCOUNT,ISACTIVE,TIMESHEETDISPLAY,BILLINGSHARINGPERCENTAGE,GROUPBRANDID,"
									+ " SECTORCODE,TMPBRANDNAME,EXCLUSIVITY,EXCLUSIVITYPARAMETER,INTERESTONUNPAIDBILLS,CLIENTFIRSTSIGNON,REMUNERATION,"
									+ " ISMEDIAREQUIRED,DDB_BRANDCODE,GST_AGENCY_COMMISSION_PER,GST_CLIENT_COMMISSION_PER,GST_CA_COMMISSION_PER,"
									+ " GST_HIDDEN_COMMISSION_PER,AGENCYCOMMISSION_NET,HAS_BARTER_DEAL,BARTER_DEAL_AGENCY_PER "
									+ " FROM MUDRA.BRANDMASTER WHERE UNIQUEID = "+uniqueid+" AND CLIENTID = '"+clientid+"' AND BRANDID = '"+brandid+"' ";
							NativeQuery<?> query = session.createNativeQuery(sqlQuery);
							query.executeUpdate();
						}
					}
				}
				
				transaction.commit();
				map.put("BRAND_SAVE", "SUCCESSFULLY");
			}
			
			
		} catch (Exception e) {
			if(null!=transaction) {
				System.out.println("Transaction Rollback");
				transaction.rollback();
			}
			map.put("REASON", e.getMessage());
			e.printStackTrace();
		}finally{
			if(null!=session) {
				session.clear();
				session.close();
			}	
		}
		return map;
	}
	
	public Brandmaster saveBrandMasterDetail(BrandMasterBean brandMasterBean,Session session) {
		try {
			
			UserdetailBean userdetailBean = brandMasterBean.getUserdetail();
			String uniqueid = userdetailBean.getUniqueid();
			String clientid = brandMasterBean.getClientid();
			String brandid = brandMasterBean.getBrandid();
			String edittime = brandMasterBean.getEdittime();
			String baddress1 = brandMasterBean.getBaddress1();
			String baddress2 = brandMasterBean.getBaddress2();
			String baddress3 = brandMasterBean.getBaddress3();
			String agencycommission = brandMasterBean.getAgencycommission();
			String agencycommissionNet = brandMasterBean.getAgencycommissionNet();
			String agencytype = brandMasterBean.getAgencytype();
			String barterDealAgencyPer = brandMasterBean.getBarterDealAgencyPer();
			String billingperc = brandMasterBean.getBillingperc();
			String brandname = brandMasterBean.getBrandname();
			String cacommission = brandMasterBean.getCacommission();
			String bcity = brandMasterBean.getBcity();
			String clientcommission = brandMasterBean.getClientcommission();
			String bfaxnumbers = brandMasterBean.getBfaxnumbers();
			String bstdcode = brandMasterBean.getBstdcode();
			String btelephonenumbers = brandMasterBean.getBtelephonenumbers();
			String bcountry = brandMasterBean.getBcountry();
			String bemailid = brandMasterBean.getBemailid();
			String exclusivity = brandMasterBean.getExclusivity();
			String exclusivityparameter = brandMasterBean.getExclusivityparameter();
			String hasBarterDeal = brandMasterBean.getHasBarterDeal();
			String interestonunpaidbills = brandMasterBean.getInterestonunpaidbills();
			String isactive = brandMasterBean.getIsactive();
			String ismediarequired = brandMasterBean.getIsmediarequired();
			String bpin = brandMasterBean.getBpin();
			String printprefix = brandMasterBean.getPrintprefix();
			String printuniqueid = brandMasterBean.getPrintuniqueid();
			String productcode	= brandMasterBean.getProductcode();
			String remuneration = brandMasterBean.getRemuneration();
			String sectorcode = brandMasterBean.getSectorcode();
			String bstate = brandMasterBean.getBstate();
			String timesheetdisplay = brandMasterBean.getTimesheetdisplay();
			String omscommissionpercent = brandMasterBean.getOmscommissionpercent();
			String clientfirstsignon = brandMasterBean.getClientfirstsignon();
			
			if(MasterCommon.checkNullAndEmpty(uniqueid,clientid,brandid)) {
				Brandmaster brandmaster = null;
				BrandmasterId brandmasterId = new BrandmasterId(Integer.parseInt(uniqueid), clientid, brandid);
				if("YES".equals(edittime)) {
					brandmaster = session.get(Brandmaster.class, brandmasterId);
				}else{
					brandmaster = new Brandmaster();
					brandmaster.setId(brandmasterId);
				}
				
				if(null!=baddress1 && baddress1.trim().length()>0)
					brandmaster.setAddress1(baddress1);
				
				if(null!=baddress2 && baddress2.trim().length()>0)
					brandmaster.setAddress2(baddress2);
				
				if(null!=baddress3 && baddress3.trim().length()>0)
					brandmaster.setAddress3(baddress3);
				
				if(MasterCommon.isNumeric(agencycommission))
					brandmaster.setAgencycommission(Double.parseDouble(agencycommission));
				else
					brandmaster.setAgencycommission(0.00);
				
				if(MasterCommon.isNumeric(agencycommissionNet))
					brandmaster.setAgencycommissionNet(Double.parseDouble(agencycommissionNet));
				else
					brandmaster.setAgencycommissionNet(0.00);
				
				if(null!=agencytype && agencytype.trim().length()>0)
					brandmaster.setAgencytype(agencytype.substring(0, 1));
				else {
					brandmaster.setAgencytype("P");
				}
				
				if(MasterCommon.isNumeric(barterDealAgencyPer))
					brandmaster.setBarterDealAgencyPer(Double.parseDouble(barterDealAgencyPer));
				
				if(MasterCommon.isNumeric(billingperc))
					brandmaster.setBillingperc(Double.parseDouble(billingperc));
				
				//brandmaster.setBillingsharingpercentage(Double.parseDouble(brandMasterBean.billingperc));
				
				if(null!=brandname && brandname.trim().length()>0)
					brandmaster.setBrandname(brandname);
				
				//brandmaster.setCaautoporaised(brandMasterBean.caautoporaised);
				
				if(MasterCommon.isNumeric(cacommission))
					brandmaster.setCacommission(Double.parseDouble(cacommission));
				
				//brandmaster.setCaresponsible(brandMasterBean.caresponsible);
				
				if(null!=bcity && bcity.trim().length()>0)
					brandmaster.setCity(bcity);
				
				//brandmaster.setClientautoporaised(clientautoporaised);
				
				if(MasterCommon.isNumeric(clientcommission))
					brandmaster.setClientcommission(Double.parseDouble(clientcommission));
				
				//brandmaster.setClientemailid(clientemailid);
				
				if(null!=bfaxnumbers && bfaxnumbers.trim().length()>0)
					brandmaster.setClientfaxnumbers(bfaxnumbers);
				
				//brandmaster.setClientfirstsignon(clientfirstsignon);
				
				if(null!=bstdcode && bstdcode.trim().length()>0)
					brandmaster.setClientstdcode(bstdcode);
				
				if(null!=btelephonenumbers && btelephonenumbers.trim().length()>0)
					brandmaster.setTelephonenumbers(btelephonenumbers);
				
				if(MasterCommon.isNumeric(userdetailBean.getCompanyid()))
					brandmaster.setCompanyid(Byte.parseByte(userdetailBean.getCompanyid()));
				
				if(null!=userdetailBean.getCreatedby() && userdetailBean.getCreatedby().trim().length()>0)
					brandmaster.setCreatedby(userdetailBean.getCreatedby());
				
				if("YES".equals(edittime)) {
					brandmaster.setModifiedon(new Date());
				}else {
					brandmaster.setCreatedon(new Date());
				}
				
				if(null!=bcountry && bcountry.trim().length()>0)
					brandmaster.setCountry(bcountry);
				
				String division = userdetailBean.getDivisionid();
				
				if(MasterCommon.isNumeric(division))
					brandmaster.setDivisionid(Byte.parseByte(division));
				
				if(null!=bemailid && bemailid.trim().length()>0)
					brandmaster.setEmailid(bemailid);
				
				if(null!=exclusivity && exclusivity.trim().length()>0)
					brandmaster.setExclusivity(exclusivity);
				
				if(null!=exclusivityparameter && exclusivityparameter.trim().length()>0)
					brandmaster.setExclusivityparameter(exclusivityparameter);
				
				/*if(MasterCommon.isNumeric(agencycommission))
					brandmaster.setGstAgencyCommissionPer(Double.parseDouble(agencycommission));*/
				
				if(null!=hasBarterDeal && hasBarterDeal.trim().length()>0)
					brandmaster.setHasBarterDeal(hasBarterDeal);
				
				if(MasterCommon.isNumeric(interestonunpaidbills))
					brandmaster.setInterestonunpaidbills(Double.parseDouble(interestonunpaidbills));
				
				String ipaddress = userdetailBean.getIpaddress();
				if(MasterCommon.isNumeric(ipaddress))
					brandmaster.setIpaddress(ipaddress );
				
				if("NO".equals(edittime))
					brandmaster.setIsactive("Y");
				else if("YES".equals(edittime))
					brandmaster.setIsactive(isactive);
				
				//brandmaster.setIscabreakuprequired(iscabreakuprequired);
				
				//brandmaster.setIscommissionsharing(iscommissionsharing);
				
				if(null!=ismediarequired && ismediarequired.trim().length()>0)
					brandmaster.setIsmediarequired(ismediarequired);
				
				if(MasterCommon.isNumeric(userdetailBean.getLocationid()))
					brandmaster.setLocationid(Byte.parseByte(userdetailBean.getLocationid()));
				
				if(null!=bpin && bpin.trim().length()>0)
					brandmaster.setPin(bpin);
				
				if(null!=printprefix && printprefix.trim().length()>0)
					brandmaster.setPrintprefix(printprefix);
				
				if(null!=printuniqueid && printuniqueid.trim().length()>0)
					brandmaster.setPrintuniqueid(Integer.parseInt(printuniqueid));
				
				if(null!=productcode && productcode.trim().length()>0)
					brandmaster.setProductcode(productcode);
				
				if(null!=remuneration && remuneration.trim().length()>0)
					brandmaster.setRemuneration(Double.parseDouble(remuneration));
				
				if(MasterCommon.isNumeric(omscommissionpercent))
					brandmaster.setOmscommissionpercent(Double.parseDouble(omscommissionpercent));
				
				if(null!=clientfirstsignon && clientfirstsignon.trim().length()>0)
					brandmaster.setClientfirstsignon(dateFormat.parse(clientfirstsignon));
				
				brandmaster.setPrnbrandnmclientnm(brandMasterBean.getPrnbrandnmclientnm());
				
				if(null!=sectorcode && sectorcode.trim().length()>0)
					brandmaster.setSectorcode(sectorcode);
				
				if(null!=bstate && bstate.trim().length()>0)
					brandmaster.setState(bstate);
				
				if(null!=bstdcode && bstdcode.trim().length()>0)
					brandmaster.setStdcode(bstdcode);
				
				String subdivisionid = userdetailBean.getSubdivisionid();
				
				if(null!=subdivisionid && subdivisionid.trim().length()>0)
					brandmaster.setSubdivisionid(Byte.parseByte(subdivisionid));
				
				if(null!=btelephonenumbers && btelephonenumbers.trim().length()>0)
					brandmaster.setTelephonenumbers(btelephonenumbers);
				
				if(null!=timesheetdisplay && timesheetdisplay.trim().length()>0)
					brandmaster.setTimesheetdisplay(timesheetdisplay);
				
				return brandmaster;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Map<String, Object> completeSaveBrand(String clientid, UserdetailBean userdetailBean) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		Transaction transaction = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("SAVE", "FAILED");
		try{
			transaction = session.beginTransaction();
			String uniqueid = userdetailBean.getUniqueid();
			if(MasterCommon.checkNullAndEmpty(clientid,uniqueid)) {
				String sqlQuery = " UPDATE MUDRA.BRANDMASTER SET ISACTIVE= 'Y' WHERE UNIQUEID = "+uniqueid+" AND CLIENTID = '"+clientid+"' AND ISACTIVE = 'T' ";
				NativeQuery<?> query = session.createNativeQuery(sqlQuery);
				query.executeUpdate();
				transaction.commit();
				map.put("SAVE", "SAVESUCCESSFULLY");
			}
		} catch (Exception e) {
			if(null!=transaction) {
				System.out.println("Transaction Rollback");
				transaction.rollback();
			}
			map.put("REASON", e.getMessage());
			e.printStackTrace();
		}finally{
			if(null!=session) {
				session.clear();
				session.close();
			}	
		}
		return map;
	}
	
	/*ConnectionProvider connection = () -> {
		SessionImpl sessionImpl = (SessionImpl) getHibernateSession();
		return sessionImpl.connection();
	}; */

}
