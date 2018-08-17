package com.mudra.mboss.master.services.impl.client;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.ClientMasterFileBean;
import com.mudra.mboss.master.bean.client.ClientmasterBean;
import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.entity.client.Clientgroupmaster;
import com.mudra.mboss.master.entity.client.ClientgroupmasterId;
import com.mudra.mboss.master.entity.client.Clientmaster;
import com.mudra.mboss.master.entity.client.ClientmasterId;
import com.mudra.mboss.master.entity.client.Generalmaster;
import com.mudra.mboss.master.entity.client.GeneralmasterId;
import com.mudra.mboss.master.services.client.ClientmasterSaveService;
import com.mudra.security.bean.UserdetailBean;

@Service
public class ClientMasterSaveServiceImpl implements ClientmasterSaveService{
	
	@Autowired
	EntityManagerFactory emf;

	@Value("${clientmaster.panFileLocation}")
	private String panFileLocation;
	
	@Value("${clientmaster.bankFileLocation}")
	private String bankFileLocation;
	
	@Value("${clientmaster.contractFileLocation}")
	private String contractFileLocation;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Map<String, Object> saveClient(ClientmasterBean bean,ClientMasterFileBean fileBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("SAVE", "FAILED");
		Session session = emf.createEntityManager().unwrap(Session.class);
		Transaction transaction = null;
		String clientid = bean.getClientid();
		UserdetailBean userdetailBean = bean.getUserdetail();
		String uniqueid = userdetailBean.getUniqueid();
		String companyid = userdetailBean.getCompanyid();
		String clientname = bean.getClientname();
		String gstclienttype = bean.getGstclienttype();
		String glcode = bean.getGlcode();
		String clientedit = bean.getClientedit();
		String createclientgroup = bean.getCreateclientgroup();
		String glcodename = bean.getGlcodename();
		String clienttype1 = bean.getClienttype1();
		String branches[] = bean.getBranches();
		String loginid = userdetailBean.getLoginid();
		
		try{
			transaction = session.beginTransaction();
			if(MasterCommon.checkNullAndEmpty(clientid,clientname,uniqueid,
					companyid,gstclienttype,clientedit,loginid) && MasterCommon.isNumeric(uniqueid) && MasterCommon.isNumeric(loginid)) {
				
				if(gstclienttype.indexOf("FOREIGN")!=-1 && MasterCommon.isNumeric(glcode)){
					bean.setPannumber("F"+companyid+""+String.format("%07d", Integer.parseInt(glcode)));
				}
				
				if(null!=fileBean.bankfile && null!=bankFileLocation && bankFileLocation.trim().length()>0) {
					File bankfilefile = MasterCommon.convert(fileBean.bankfile);
					if(null!=MasterCommon.uploadFile(bankfilefile,bankfilefile.getName(),bankFileLocation,uniqueid+"_"+clientid+"_BANK",fileBean.servercontextpath)) {
						map.put("BANKFILE_UPLOAD", "SUCCESSFULLY");
					}else {
						map.put("BANKFILE_UPLOAD", "FAILED");
					}
				}
				
				if(null!=fileBean.clientcontractfile && null!=contractFileLocation && contractFileLocation.trim().length()>0) {
					File clientcontractfilefile = MasterCommon.convert(fileBean.clientcontractfile);
					if(null!=MasterCommon.uploadFile(clientcontractfilefile,clientcontractfilefile.getName(),contractFileLocation,uniqueid+"_"+clientid+"_CONTRACT",fileBean.servercontextpath)) {
						map.put("CONTRACTFILE_UPLOAD", "SUCCESSFULLY");
					}else {
						map.put("CONTRACTFILE_UPLOAD", "FAILED");
					}
				}
				
				if(null!=fileBean.panfile && null!=panFileLocation && panFileLocation.trim().length()>0) {
					File panfilefile = MasterCommon.convert(fileBean.panfile);
					if(null!=MasterCommon.uploadFile(panfilefile,panfilefile.getName(),panFileLocation,uniqueid+"_"+clientid+"_PAN",fileBean.servercontextpath)) {
						map.put("PANFILE_UPLOAD", "SUCCESSFULLY");
					}else {
						map.put("PANFILE_UPLOAD", "FAILED");
					}
				}
				
				Generalmaster generalmaster = updateGlcodeInGeneralMaster(bean,session);
				if(null!=generalmaster && "NO".equals(clientedit))
					session.save(generalmaster);
				else if("YES".equals(clientedit))
					session.update(generalmaster);
				
				if("NO".equals(clientedit) && "Y".equals(createclientgroup)) {
					Clientgroupmaster clientgroupmaster = saveClientGroupMaster(bean);
					if(null!=clientgroupmaster && "NO".equals(clientedit))
						session.save(clientgroupmaster);
				}
				
				Clientmaster clientmaster = saveClientMasterData(bean);
				if(null!=clientmaster && "NO".equals(clientedit))
					session.save(clientmaster);
				else if("YES".equals(clientedit))
					session.update(clientmaster);
				
				session.flush();
				
				if(null!=glcode && MasterCommon.checkNullAndEmpty(glcodename,clienttype1) 
						&& "NO".equals(clientedit) && MasterCommon.isNumeric(glcode) 
						&& Integer.parseInt(glcode) != 0) {
					
					String interbranchuniqueid = "0";
					if("DDBNET".equals(clienttype1.trim())) {
						interbranchuniqueid = "9001";
					}
					String sqlQuery = " insert into mudra.glmaster (glcode,glname,isactive,category,tbalcategory,INTERBRANCHUNIQUEID) values "
						+ " ("+glcode+",'"+glcodename+"','Y','D','D',"+interbranchuniqueid+") ";
					
					NativeQuery<?> query = session.createNativeQuery(sqlQuery);
					query.executeUpdate();
					
				}if(null!=branches && branches.length>0 && "YES".equals(clientedit)){
					for (String string : branches) {
						if(null!=string && string.trim().length()>0) {
							String sqlQuery = " INSERT INTO MUDRA.CLIENTMASTER SELECT "+string+",CLIENTID,CLIENTNAME,CLIENTDISPLAYNAME,CLIENTGROUPID,CLIENTTYPE,GLCODE,SUPPLIERID,ADDRESS1,ADDRESS2,ADDRESS3,CITY,STATE,PIN,COUNTRY,STDCODE,TELEPHONENUMBERS,FAXNUMBERS,EMAILID,CREDITDAYS,ISACTIVE,EXPOSURELIMIT,PANNUMBER,SERVICETAXNUMBER,CSTNUMBER,LSTNUMBER,COMPANYID,DIVISIONID,SUBDIVISIONID,LOCATIONID,CREATEDBY,CREATEDON,MODIFIEDON,MODIFIEDBY,IPADDRESS,MACADDRESS,BANKGUARANTEENUMBER,BANKGUARANTEEDATE,BANKGUARANTEEAMOUNT,EXPIRYDATE,CHEQUEBANK,CHEQUEBRANCH,ISSERVICETAXREQUIRED,ISAGENCY,BUSINESSCOMMITMENT,HASCARESPONSIBILITY,UNBOOKEDLIABILITY,OLDCODE,TRIALBALANCECATEGORY,TDSACNUMBER,ISCOMMISSIONONNETAMT,ISUPDATERORATE,PRINTADDRESSFROMBRAND,PASSDISCOUNT,TIMESHEETDISPLAY,ISESTIMATERATEREQUIREDPRESS,ISESTIMATERATEREQUIREDTV,HOCLIENTGROUPID,ISNATIONALGLOBAL,ISDDBASSOCIATECLIENT,TMPCLIENTNAME,STAMPDUTYAPPLICABLE,INDUSTRY,EXCLUSIVITY,EXCLUSIVITYPARAMETER,INTERESTONUNPAIDBILLS,PRODUCTCODE,REVENUEFEES,REVENUESUPERVISION,REVENUEOTHERS,CLIENTTYPE1,WEBSITE,ISPANVERIFIED,STAMPCHARG,LTCPERCENTAGE,TINNUMBER,UNIT,OPERATING_STATE,ISCONTRACTCOPYREQUIRED,TDSSECTIONID,ISAPPROVALINSERTIONDATE,IS_LOST,DBCLIENTCODE,ISDBBANKACTINTIMATEDTOCLIENT,CLIENT_TYPE,IS_CURRENTLY_ACTIVE,CLIENT_TAN "+
							" FROM MUDRA.CLIENTMASTER WHERE CLIENTID = '"+clientid+"' AND UNIQUEID = "+uniqueid+" ";
							NativeQuery<?> query = session.createNativeQuery(sqlQuery);
							query.executeUpdate();
						}
					}
				}
				
				if("NO".equals(clientedit)) {
					NativeQuery<?> procedureQuery = 
							session.createNativeQuery(" CALL MUDRA.PROC_CLIENTMASTER_ALERT("+uniqueid+",'"+clientid+"',"+loginid+") ");
					procedureQuery.executeUpdate();
				}else if("YES".equals(clientedit)){
					NativeQuery<?> procedureQuery = 
							session.createNativeQuery(" CALL MUDRA.PROC_CLIENTMASTER_ALERT("+uniqueid+",'"+clientid+"',"+loginid+",'E') ");
					procedureQuery.executeUpdate();
				}
				
				transaction.commit();
				map.put("SAVE", "SUCCESSFULLY");
				return map;
			}else{
				map.put("REQUIRED_FIELD", "NO");
			}
		}catch (Exception e) {
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
	
	public Clientmaster saveClientMasterData(ClientmasterBean bean){
		Session session = emf.createEntityManager().unwrap(Session.class);
		try{
			UserdetailBean userdetailBean = bean.getUserdetail();
			String uniqueid = userdetailBean.getUniqueid();
			String companyid = userdetailBean.getCompanyid();
			String createdby = userdetailBean.getCreatedby();
			String divisionid = userdetailBean.getDivisionid();
			String ipaddress = userdetailBean.getIpaddress();
			String locationid = userdetailBean.getLocationid();
			String subdivisionid = userdetailBean.getSubdivisionid();
			
			String clientid = bean.getClientid();
			String clientaddress1 = bean.getClientaddress1();
			String clientaddress2 = bean.getClientaddress2();
			String clientaddress3 = bean.getClientaddress3();
			String clientcity = bean.getClientcity();
			String exposurelimit = bean.getExposurelimit();
			String clientgroupid = bean.getClientgroupid();
			String clientname = bean.getClientname();
			String clientTan = bean.getClientTan();
			String clienttype = bean.getClienttype();
			String pannumber = bean.getPannumber();
			String gstclienttype = bean.getGstclienttype();
			String clienttype1 = bean.getClienttype1();
			String clientcountry = bean.getClientcountry();
			String isdbbankactintimatedtoclient = bean.getIsdbbankactintimatedtoclient(); 
			String bankguaranteedate = bean.getBankguaranteedate();
			String bankguaranteeamount = bean.getBankguaranteeamount();
			String expirydate = bean.getExpirydate();
			String businesscommitment = bean.getBusinesscommitment();
			String unbookedliability = bean.getUnbookedliability();
			String creditdays = bean.getCreditdays();
			String dbclientcode = bean.getDbclientcode();
			String clientemailid = bean.getClientemailid();
			String glcode = bean.getGlcode();
			String ltcpercentage = bean.getLtcpercentage();
			String clientpin = bean.getClientpin();
			String clientprintaddressfrombrand = bean.getClientprintaddressfrombrand();
			String clientstate = bean.getClientstate(); 
			String clientstdcode = bean.getClientstdcode();
			String clienttelephonenumbers = bean.getClienttelephonenumbers();
			String tinnumber = bean.getTinnumber();
			String clientwebsite = bean.getClientwebsite();
			String clientdisplayname = bean.getClientdisplayname();
			String clientedit = bean.getClientedit();
			
			if(MasterCommon.checkNullAndEmpty(uniqueid,clientid)) {
				
				Clientmaster clientmaster = null;
				ClientmasterId id = new ClientmasterId(Integer.parseInt(uniqueid), clientid);
				if("YES".equals(clientedit)) {
					clientmaster = session.get(Clientmaster.class, id);
				}else {
					clientmaster = new Clientmaster();
					clientmaster.setId(id);
				}
				
				if(null!=clientaddress1 && clientaddress1.trim().length()>0)
					clientmaster.setAddress1(clientaddress1);
				
				if(null!=clientaddress2 && clientaddress2.trim().length()>0)
					clientmaster.setAddress2(clientaddress2);
				
				if(null!=clientaddress3 && clientaddress3.trim().length()>0)
					clientmaster.setAddress3(clientaddress3);
				
				if(null!=clientcity && clientcity.trim().length()>0)
					clientmaster.setCity(clientcity);
				
				if(MasterCommon.isNumeric(exposurelimit))
					clientmaster.setExposurelimit(Double.parseDouble(exposurelimit));
				
				if(null!=clientgroupid && clientgroupid.trim().length()>0)
					clientmaster.setClientgroupid(clientgroupid);
				
				if(null!=clientname && clientname.trim().length()>0)
					clientmaster.setClientname(clientname);
				
				if(null!=clientTan && clientTan.trim().length()>0)
					clientmaster.setClientTan(clientTan);	
				
				if(null!=clienttype && clienttype.trim().length()>0)
					clientmaster.setClienttype(clienttype);
				
				if(null!=pannumber && pannumber.trim().length()>0)
					clientmaster.setPannumber(pannumber);
				
				if(null!=gstclienttype && gstclienttype.trim().length()>0)
					clientmaster.setClientType(gstclienttype);
				
				if(null!=clienttype1 && clienttype1.trim().length()>0)
					clientmaster.setClienttype1(clienttype1);
				
				if(MasterCommon.isNumeric(companyid))
					clientmaster.setCompanyid(Byte.parseByte(companyid));
				
				if(null!=clientcountry && clientcountry.trim().length()>0)
					clientmaster.setCountry(clientcountry);
				
				if(null!=createdby && createdby.trim().length()>0)
					clientmaster.setCreatedby(createdby);
				
				if(null!=isdbbankactintimatedtoclient && isdbbankactintimatedtoclient.trim().length()>0) 
					clientmaster.setIsdbbankactintimatedtoclient(isdbbankactintimatedtoclient);
				
				if(null!=bankguaranteedate && bankguaranteedate.trim().length()>0)
					clientmaster.setBankguaranteedate(dateFormat.parse(bankguaranteedate));
				
				if(MasterCommon.isNumeric(bankguaranteeamount))
					clientmaster.setBankguaranteeamount(Double.parseDouble(bankguaranteeamount));
				
				if(null!=expirydate && expirydate.trim().length()>0)
					clientmaster.setExpirydate(dateFormat.parse(expirydate));
				
				if(MasterCommon.isNumeric(businesscommitment))
					clientmaster.setBusinesscommitment(Double.parseDouble(businesscommitment));
				
				if(MasterCommon.isNumeric(unbookedliability))
					clientmaster.setUnbookedliability(Double.parseDouble(unbookedliability));
				
				clientmaster.setCreatedon(new Date());
				
				if(MasterCommon.isNumeric(creditdays))
					clientmaster.setCreditdays(Short.parseShort(creditdays));
				
				if(MasterCommon.isNumeric(dbclientcode))
					clientmaster.setDbclientcode(Long.parseLong(dbclientcode));
				
				if(MasterCommon.isNumeric(divisionid))
					clientmaster.setDivisionid(Byte.parseByte(divisionid));
				
				if(null!=clientemailid && clientemailid.trim().length()>0)
					clientmaster.setEmailid(clientemailid);
				
				if(MasterCommon.isNumeric(glcode))
					clientmaster.setGlcode(Integer.parseInt(glcode));
				
				if(null!=ipaddress && ipaddress.trim().length()>0)
					clientmaster.setIpaddress(ipaddress);
				
				clientmaster.setIsactive("Y");
				
				if(MasterCommon.isNumeric(locationid))
					clientmaster.setLocationid(Byte.parseByte(locationid));
				
				if(MasterCommon.isNumeric(ltcpercentage))
					clientmaster.setLtcpercentage(Double.parseDouble(ltcpercentage));
				
				//clientmaster.setMacaddress(userdetail.macaddress);
				
				if(null!=clientpin && clientpin.trim().length()>0)
					clientmaster.setPin(clientpin);
				
				if(null!=clientprintaddressfrombrand && clientprintaddressfrombrand.trim().length()>0)
					clientmaster.setPrintaddressfrombrand(clientprintaddressfrombrand);
				
				if(null!=clientstate && clientstate.trim().length()>0)
					clientmaster.setState(clientstate);
				
				if(null!=clientstdcode && clientstdcode.trim().length()>0)
					clientmaster.setStdcode(clientstdcode);
				
				clientmaster.setSubdivisionid(Byte.parseByte(subdivisionid));
				
				if(null!=clienttelephonenumbers && clienttelephonenumbers.trim().length()>0)
					clientmaster.setTelephonenumbers(clienttelephonenumbers);
				
				if(null!=tinnumber && tinnumber.trim().length()>0)
					clientmaster.setTinnumber(tinnumber);
				
				if(null!=clientwebsite && clientwebsite.trim().length()>0)
					clientmaster.setWebsite(clientwebsite);
				
				if(null!=clientdisplayname && clientdisplayname.trim().length()>0)
					clientmaster.setClientdisplayname(clientdisplayname);
				
				//System.getProperties().setProperty("oracle.jdbc.autoCommitSpecCompliant","false");
				
				return clientmaster;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(null!=session)
				session.clear();
		}
		return null;
	}
	
	public Generalmaster updateGlcodeInGeneralMaster(ClientmasterBean bean,Session session){
		try{
			
			UserdetailBean userdetailBean = bean.getUserdetail();
			String uniqueid = userdetailBean.getUniqueid();
			String glcode = bean.getGlcode();
			
			GeneralmasterId id = new GeneralmasterId(Integer.parseInt(uniqueid), "CL_GLCODE", "CL_GLCODE");
			Generalmaster generalmaster = (Generalmaster)session.get(Generalmaster.class, id);
			if(null!=generalmaster ) {
				
				if(MasterCommon.isNumeric(glcode))
					generalmaster.setNumvalue1(Double.parseDouble(glcode));
				
				//System.getProperties().setProperty("oracle.jdbc.autoCommitSpecCompliant","false");
				/*
				String sqlQuery = " UPDATE MUDRA.GENERALMASTER Generalmaster  SET Generalmaster.NUMVALUE1 = "+bean.glcode+" "+ 
								" WHERE MASTERTYPE = 'CL_GLCODE' AND MASTERCODE = 'CL_GLCODE' AND UNIQUEID = "+userdetail.uniqueid+""; 
				
				connection.createStatement().executeUpdate(sqlQuery);
				connection.commit();
				*/
				return generalmaster;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Clientgroupmaster saveClientGroupMaster(ClientmasterBean bean){
		try {
			
			UserdetailBean userdetailBean = bean.getUserdetail();
			String uniqueid = userdetailBean.getUniqueid();
			String companyid = userdetailBean.getCompanyid();
			String clientgroupname = bean.getClientgroupname();
			String clientgroupid = null;
			String clienttype1 = bean.getClienttype1();
			if(MasterCommon.checkNullAndEmpty(clientgroupname,uniqueid)) {
				Clientgroupmaster clientgroupmaster = new Clientgroupmaster();
				if(clientgroupname.trim().length()>10) {
					bean.setClientgroupid(clientgroupname.substring(0, 10));
				}else {
					bean.setClientgroupid(clientgroupname);
				}
				clientgroupid = bean.getClientgroupid();
				ClientgroupmasterId id = new ClientgroupmasterId(Integer.parseInt(uniqueid),clientgroupid);
				
				clientgroupmaster.setId(id);
				
				if(null!=clientgroupname && clientgroupname.trim().length()>0)
					clientgroupmaster.setClientgroupname(clientgroupname);
				
				if(null!=clienttype1 && clienttype1.trim().length()>0)
					clientgroupmaster.setClienttype(clienttype1);
				
				if(null!=companyid && companyid.trim().length()>0)
					clientgroupmaster.setCompanyid(Byte.parseByte(companyid));
				
				return clientgroupmaster;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
